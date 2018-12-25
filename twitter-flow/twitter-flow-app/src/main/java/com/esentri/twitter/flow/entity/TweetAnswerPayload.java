package com.esentri.twitter.flow.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "name", "tweet", "tweetID" })
public class TweetAnswerPayload implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("name")
	private String name;
	@JsonProperty("tweet")
	private String tweet;
	@JsonProperty("tweetID")
	private String tweetID;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	public TweetAnswerPayload(String name, String tweet, String tweetID) {
		super();
		this.name = name;
		this.tweet = tweet;
		this.tweetID = tweetID;
	}
	
	@JsonProperty("name")
	public String getName() {
		return name;
	}

	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("tweet")
	public String getTweet() {
		return tweet;
	}

	@JsonProperty("tweet")
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	@JsonProperty("tweetID")
	public String getTweetID() {
		return tweetID;
	}

	@JsonProperty("tweetID")
	public void setTweetID(String tweetID) {
		this.tweetID = tweetID;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}