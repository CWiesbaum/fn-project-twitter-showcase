package com.esentri.twitter.flow;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.esentri.twitter.flow.entity.FunctionReturnValue;
import com.esentri.twitter.flow.entity.TweetAnswerPayload;
import com.esentri.twitter.flow.entity.Tweets;
import com.esentri.twitter.flow.entity.TwitterSearchResult;
import com.esentri.twitter.flow.entity.User;
import com.esentri.twitter.flow.entity.UserFilterPayload;
import com.esentri.twitter.flow.entity.UserFilterResponse;
import com.esentri.twitter.flow.enumerations.TwitterFlowFunction;
import com.fnproject.fn.api.FnConfiguration;
import com.fnproject.fn.api.FnFeature;
import com.fnproject.fn.api.RuntimeContext;
import com.fnproject.fn.api.flow.Flow;
import com.fnproject.fn.api.flow.FlowFuture;
import com.fnproject.fn.api.flow.Flows;
import com.fnproject.fn.runtime.flow.FlowFeature;

@FnFeature(FlowFeature.class)
public class TwitterFlow implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = LoggerFactory.getLogger(TwitterFlow.class);
	private static final String FOLLOWER_COUNT_CONFIG = "FOLLOWER_COUNT";

	private String follower_count;

	private Map<TwitterFlowFunction, String> functionIds = new EnumMap<TwitterFlowFunction, String>(
			TwitterFlowFunction.class);

	@FnConfiguration
	public void configure(RuntimeContext ctx) {
		for (TwitterFlowFunction f : TwitterFlowFunction.values()) {
			functionIds.put(f, ctx.getConfigurationByKey(f.configName())
					.orElseThrow(() -> new RuntimeException("Missing Function ID: " + f.configName())));

			LOGGER.debug("{} Function ID: {}", f.functionName(), functionIds.get(f));
		}

		follower_count = ctx.getConfigurationByKey(FOLLOWER_COUNT_CONFIG)
				.orElseThrow(() -> new RuntimeException("Missing Config: FOLLOWER_COUNT"));
	}

	public void handleTweets(TwitterSearchResult tweetSearchResult) {
		Flow f = Flows.currentFlow();
		LOGGER.debug("Input payload: {}", tweetSearchResult);

		FlowFuture<Tweets> answerTweetsFuture = f.invokeFunction(functionIds.get(TwitterFlowFunction.TWITTER_SHORTENER),
				tweetSearchResult, Tweets.class);

		answerTweetsFuture.thenAccept(tweets -> {
			LOGGER.debug("Tweet Count: {}", tweets.getTweets().size());
			tweets.getTweets().forEach(tweet -> {
				TweetAnswerPayload answerPayload = new TweetAnswerPayload(tweet.getUserScreenName(),
						"Danke für die Unterstützung des Vortrags! ;-)", tweet.getIdStr());

				FlowFuture<FunctionReturnValue> tweetFuture = f.invokeFunction(
						functionIds.get(TwitterFlowFunction.ANSWER_TWEET), answerPayload, FunctionReturnValue.class);

				tweetFuture.thenAccept(functionResult -> {
					LOGGER.debug("Tweet answered: {}, {}", tweet.getIdStr(), functionResult.getMessage());
				});
			});
		});

		f.supply(() -> {
			UserFilterPayload payload = new UserFilterPayload();

			payload.setUsers(new ArrayList<User>());
			tweetSearchResult.getStatuses().forEach(status -> {
				payload.getUsers().add(status.getUser());
			});

			payload.setFollowers(follower_count);

			return payload;
		}).thenAccept(userFilter -> {
			f.invokeFunction(functionIds.get(TwitterFlowFunction.TWITTER_FILTER_FOLLOW), userFilter,
					UserFilterResponse.class)
					.thenAccept(userList -> userList.getUsers().forEach(user -> {
									System.out.println(user);
								})
							);
		});
	}
}
