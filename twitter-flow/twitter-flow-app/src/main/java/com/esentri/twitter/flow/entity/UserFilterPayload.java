package com.esentri.twitter.flow.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "users", "keywords", "locations", "followers" })
public class UserFilterPayload implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonProperty("users")
	private List<User> users = null;
	@JsonProperty("keywords")
	private List<String> keywords = null;
	@JsonProperty("locations")
	private List<String> locations = null;
	@JsonProperty("followers")
	private String followers;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("users")
	public List<User> getUsers() {
		return users;
	}

	@JsonProperty("users")
	public void setUsers(List<User> users) {
		this.users = users;
	}

	@JsonProperty("keywords")
	public List<String> getKeywords() {
		return keywords;
	}

	@JsonProperty("keywords")
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	@JsonProperty("locations")
	public List<String> getLocations() {
		return locations;
	}

	@JsonProperty("locations")
	public void setLocations(List<String> locations) {
		this.locations = locations;
	}

	@JsonProperty("followers")
	public String getFollowers() {
		return followers;
	}

	@JsonProperty("followers")
	public void setFollowers(String followers) {
		this.followers = followers;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return "UserFilterPayload [users=" + users + ", keywords=" + keywords + ", locations=" + locations
				+ ", followers=" + followers + ", additionalProperties=" + additionalProperties + "]";
	}

}