package com.esentri.twitter.flow.enumerations;

public enum TwitterFlowFunction {
	ANSWER_TWEET("answer-tweet", "ANSWER_TWEET_ID"),
	TWITTER_SHORTENER("twitter-shortener", "TWITTER_SHORTENER_ID"),
	TWITTER_FILTER("twitter-filter", "TWITTER_FILTER_ID"),
	TWITTER_FILTER_FOLLOW("twitter-filter-follow", "TWITTER_FILTER_FOLLOW_ID"),
	SAVE_FILE("save-file", "SAVE_FILE_ID"),;
	
	private final String functionName;
	private final String configName;
	
	TwitterFlowFunction(String functionName, String configName) {
		this.functionName = functionName;
		this.configName = configName;
	}

	public String functionName() {
		return functionName;
	}

	public String configName() {
		return configName;
	}
	
	
}
