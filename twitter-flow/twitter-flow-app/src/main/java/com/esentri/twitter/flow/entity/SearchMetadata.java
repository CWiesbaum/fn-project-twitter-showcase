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
@JsonPropertyOrder({
    "completed_in",
    "max_id",
    "max_id_str",
    "query",
    "refresh_url",
    "count",
    "since_id",
    "since_id_str"
})
public class SearchMetadata implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @JsonProperty("completed_in")
    private Double completedIn;
    @JsonProperty("max_id")
    private Long maxId;
    @JsonProperty("max_id_str")
    private String maxIdStr;
    @JsonProperty("query")
    private String query;
    @JsonProperty("refresh_url")
    private String refreshUrl;
    @JsonProperty("count")
    private Long count;
    @JsonProperty("since_id")
    private Long sinceId;
    @JsonProperty("since_id_str")
    private String sinceIdStr;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("completed_in")
    public Double getCompletedIn() {
        return completedIn;
    }

    @JsonProperty("completed_in")
    public void setCompletedIn(Double completedIn) {
        this.completedIn = completedIn;
    }

    @JsonProperty("max_id")
    public Long getMaxId() {
        return maxId;
    }

    @JsonProperty("max_id")
    public void setMaxId(Long maxId) {
        this.maxId = maxId;
    }

    @JsonProperty("max_id_str")
    public String getMaxIdStr() {
        return maxIdStr;
    }

    @JsonProperty("max_id_str")
    public void setMaxIdStr(String maxIdStr) {
        this.maxIdStr = maxIdStr;
    }

    @JsonProperty("query")
    public String getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(String query) {
        this.query = query;
    }

    @JsonProperty("refresh_url")
    public String getRefreshUrl() {
        return refreshUrl;
    }

    @JsonProperty("refresh_url")
    public void setRefreshUrl(String refreshUrl) {
        this.refreshUrl = refreshUrl;
    }

    @JsonProperty("count")
    public Long getCount() {
        return count;
    }

    @JsonProperty("count")
    public void setCount(Long count) {
        this.count = count;
    }

    @JsonProperty("since_id")
    public Long getSinceId() {
        return sinceId;
    }

    @JsonProperty("since_id")
    public void setSinceId(Long sinceId) {
        this.sinceId = sinceId;
    }

    @JsonProperty("since_id_str")
    public String getSinceIdStr() {
        return sinceIdStr;
    }

    @JsonProperty("since_id_str")
    public void setSinceIdStr(String sinceIdStr) {
        this.sinceIdStr = sinceIdStr;
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
