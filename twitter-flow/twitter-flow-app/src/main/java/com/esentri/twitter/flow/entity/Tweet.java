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
    "created_at",
    "id",
    "id_str",
    "text",
    "truncated",
    "source",
    "user_id",
    "user_id_str",
    "user_name",
    "user_screen_name",
    "user_location",
    "user_description",
    "user_protected",
    "user_followers_count",
    "user_friends_count",
    "user_listed_count",
    "user_created_at",
    "user_geo_enabled",
    "user_verified",
    "user_statuses_count",
    "user_lang",
    "user_contributors_enabled",
    "user_is_translator",
    "user_is_translation_enabled",
    "user_profile_background_color",
    "user_profile_background_tile",
    "user_profile_image_url",
    "user_profile_image_url_https",
    "user_profile_link_color",
    "user_profile_sidebar_border_color",
    "user_profile_text_color",
    "user_profile_use_background_image",
    "user_has_extended_profile",
    "user_default_profile",
    "user_default_profile_image",
    "user_following",
    "user_follow_request_sent",
    "user_notifications",
    "user_translator_type",
    "is_quote_status",
    "retweet_count",
    "favorite_count",
    "favorited",
    "retweeted",
    "lang",
    "user_favourites_count",
    "user_utc_offset",
    "user_profile_sidebar_fill_color",
    "in_reply_to_status_id",
    "in_reply_to_status_id_str",
    "in_reply_to_user_id",
    "in_reply_to_user_id_str",
    "in_reply_to_screen_name",
    "geo",
    "coordinates",
    "place",
    "contributors",
    "user_profile_background_image_url",
    "user_profile_background_image_url_https",
    "user_url",
    "user_time_zone"
})
public class Tweet implements Serializable {
	private static final long serialVersionUID = 1L;
	
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("id")
    private Long id;
    @JsonProperty("id_str")
    private String idStr;
    @JsonProperty("text")
    private String text;
    @JsonProperty("truncated")
    private Boolean truncated;
    @JsonProperty("source")
    private String source;
    @JsonProperty("user_id")
    private Long userId;
    @JsonProperty("user_id_str")
    private String userIdStr;
    @JsonProperty("user_name")
    private String userName;
    @JsonProperty("user_screen_name")
    private String userScreenName;
    @JsonProperty("user_location")
    private String userLocation;
    @JsonProperty("user_description")
    private String userDescription;
    @JsonProperty("user_protected")
    private Boolean userProtected;
    @JsonProperty("user_followers_count")
    private Integer userFollowersCount;
    @JsonProperty("user_friends_count")
    private Integer userFriendsCount;
    @JsonProperty("user_listed_count")
    private Integer userListedCount;
    @JsonProperty("user_created_at")
    private String userCreatedAt;
    @JsonProperty("user_geo_enabled")
    private Boolean userGeoEnabled;
    @JsonProperty("user_verified")
    private Boolean userVerified;
    @JsonProperty("user_statuses_count")
    private Integer userStatusesCount;
    @JsonProperty("user_lang")
    private String userLang;
    @JsonProperty("user_contributors_enabled")
    private Boolean userContributorsEnabled;
    @JsonProperty("user_is_translator")
    private Boolean userIsTranslator;
    @JsonProperty("user_is_translation_enabled")
    private Boolean userIsTranslationEnabled;
    @JsonProperty("user_profile_background_color")
    private String userProfileBackgroundColor;
    @JsonProperty("user_profile_background_tile")
    private Boolean userProfileBackgroundTile;
    @JsonProperty("user_profile_image_url")
    private String userProfileImageUrl;
    @JsonProperty("user_profile_image_url_https")
    private String userProfileImageUrlHttps;
    @JsonProperty("user_profile_link_color")
    private String userProfileLinkColor;
    @JsonProperty("user_profile_sidebar_border_color")
    private String userProfileSidebarBorderColor;
    @JsonProperty("user_profile_text_color")
    private String userProfileTextColor;
    @JsonProperty("user_profile_use_background_image")
    private Boolean userProfileUseBackgroundImage;
    @JsonProperty("user_has_extended_profile")
    private Boolean userHasExtendedProfile;
    @JsonProperty("user_default_profile")
    private Boolean userDefaultProfile;
    @JsonProperty("user_default_profile_image")
    private Boolean userDefaultProfileImage;
    @JsonProperty("user_following")
    private Boolean userFollowing;
    @JsonProperty("user_follow_request_sent")
    private Boolean userFollowRequestSent;
    @JsonProperty("user_notifications")
    private Boolean userNotifications;
    @JsonProperty("user_translator_type")
    private String userTranslatorType;
    @JsonProperty("is_quote_status")
    private Boolean isQuoteStatus;
    @JsonProperty("retweet_count")
    private Integer retweetCount;
    @JsonProperty("favorite_count")
    private Integer favoriteCount;
    @JsonProperty("favorited")
    private Boolean favorited;
    @JsonProperty("retweeted")
    private Boolean retweeted;
    @JsonProperty("lang")
    private String lang;
    @JsonProperty("user_favourites_count")
    private Integer userFavouritesCount;
    @JsonProperty("user_utc_offset")
    private String userUtcOffset;
    @JsonProperty("user_profile_sidebar_fill_color")
    private String userProfileSidebarFillColor;
    @JsonProperty("in_reply_to_status_id")
    private Object inReplyToStatusId;
    @JsonProperty("in_reply_to_status_id_str")
    private Object inReplyToStatusIdStr;
    @JsonProperty("in_reply_to_user_id")
    private Object inReplyToUserId;
    @JsonProperty("in_reply_to_user_id_str")
    private Object inReplyToUserIdStr;
    @JsonProperty("in_reply_to_screen_name")
    private Object inReplyToScreenName;
    @JsonProperty("geo")
    private Object geo;
    @JsonProperty("coordinates")
    private Object coordinates;
    @JsonProperty("place")
    private Object place;
    @JsonProperty("contributors")
    private Object contributors;
    @JsonProperty("user_profile_background_image_url")
    private Object userProfileBackgroundImageUrl;
    @JsonProperty("user_profile_background_image_url_https")
    private Object userProfileBackgroundImageUrlHttps;
    @JsonProperty("user_url")
    private Object userUrl;
    @JsonProperty("user_time_zone")
    private Object userTimeZone;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("created_at")
    public String getCreatedAt() {
        return createdAt;
    }

    @JsonProperty("created_at")
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
    }

    @JsonProperty("id_str")
    public String getIdStr() {
        return idStr;
    }

    @JsonProperty("id_str")
    public void setIdStr(String idStr) {
        this.idStr = idStr;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("truncated")
    public Boolean getTruncated() {
        return truncated;
    }

    @JsonProperty("truncated")
    public void setTruncated(Boolean truncated) {
        this.truncated = truncated;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("user_id")
    public Long getUserId() {
        return userId;
    }

    @JsonProperty("user_id")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @JsonProperty("user_id_str")
    public String getUserIdStr() {
        return userIdStr;
    }

    @JsonProperty("user_id_str")
    public void setUserIdStr(String userIdStr) {
        this.userIdStr = userIdStr;
    }

    @JsonProperty("user_name")
    public String getUserName() {
        return userName;
    }

    @JsonProperty("user_name")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @JsonProperty("user_screen_name")
    public String getUserScreenName() {
        return userScreenName;
    }

    @JsonProperty("user_screen_name")
    public void setUserScreenName(String userScreenName) {
        this.userScreenName = userScreenName;
    }

    @JsonProperty("user_location")
    public String getUserLocation() {
        return userLocation;
    }

    @JsonProperty("user_location")
    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    @JsonProperty("user_description")
    public String getUserDescription() {
        return userDescription;
    }

    @JsonProperty("user_description")
    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    @JsonProperty("user_protected")
    public Boolean getUserProtected() {
        return userProtected;
    }

    @JsonProperty("user_protected")
    public void setUserProtected(Boolean userProtected) {
        this.userProtected = userProtected;
    }

    @JsonProperty("user_followers_count")
    public Integer getUserFollowersCount() {
        return userFollowersCount;
    }

    @JsonProperty("user_followers_count")
    public void setUserFollowersCount(Integer userFollowersCount) {
        this.userFollowersCount = userFollowersCount;
    }

    @JsonProperty("user_friends_count")
    public Integer getUserFriendsCount() {
        return userFriendsCount;
    }

    @JsonProperty("user_friends_count")
    public void setUserFriendsCount(Integer userFriendsCount) {
        this.userFriendsCount = userFriendsCount;
    }

    @JsonProperty("user_listed_count")
    public Integer getUserListedCount() {
        return userListedCount;
    }

    @JsonProperty("user_listed_count")
    public void setUserListedCount(Integer userListedCount) {
        this.userListedCount = userListedCount;
    }

    @JsonProperty("user_created_at")
    public String getUserCreatedAt() {
        return userCreatedAt;
    }

    @JsonProperty("user_created_at")
    public void setUserCreatedAt(String userCreatedAt) {
        this.userCreatedAt = userCreatedAt;
    }

    @JsonProperty("user_geo_enabled")
    public Boolean getUserGeoEnabled() {
        return userGeoEnabled;
    }

    @JsonProperty("user_geo_enabled")
    public void setUserGeoEnabled(Boolean userGeoEnabled) {
        this.userGeoEnabled = userGeoEnabled;
    }

    @JsonProperty("user_verified")
    public Boolean getUserVerified() {
        return userVerified;
    }

    @JsonProperty("user_verified")
    public void setUserVerified(Boolean userVerified) {
        this.userVerified = userVerified;
    }

    @JsonProperty("user_statuses_count")
    public Integer getUserStatusesCount() {
        return userStatusesCount;
    }

    @JsonProperty("user_statuses_count")
    public void setUserStatusesCount(Integer userStatusesCount) {
        this.userStatusesCount = userStatusesCount;
    }

    @JsonProperty("user_lang")
    public String getUserLang() {
        return userLang;
    }

    @JsonProperty("user_lang")
    public void setUserLang(String userLang) {
        this.userLang = userLang;
    }

    @JsonProperty("user_contributors_enabled")
    public Boolean getUserContributorsEnabled() {
        return userContributorsEnabled;
    }

    @JsonProperty("user_contributors_enabled")
    public void setUserContributorsEnabled(Boolean userContributorsEnabled) {
        this.userContributorsEnabled = userContributorsEnabled;
    }

    @JsonProperty("user_is_translator")
    public Boolean getUserIsTranslator() {
        return userIsTranslator;
    }

    @JsonProperty("user_is_translator")
    public void setUserIsTranslator(Boolean userIsTranslator) {
        this.userIsTranslator = userIsTranslator;
    }

    @JsonProperty("user_is_translation_enabled")
    public Boolean getUserIsTranslationEnabled() {
        return userIsTranslationEnabled;
    }

    @JsonProperty("user_is_translation_enabled")
    public void setUserIsTranslationEnabled(Boolean userIsTranslationEnabled) {
        this.userIsTranslationEnabled = userIsTranslationEnabled;
    }

    @JsonProperty("user_profile_background_color")
    public String getUserProfileBackgroundColor() {
        return userProfileBackgroundColor;
    }

    @JsonProperty("user_profile_background_color")
    public void setUserProfileBackgroundColor(String userProfileBackgroundColor) {
        this.userProfileBackgroundColor = userProfileBackgroundColor;
    }

    @JsonProperty("user_profile_background_tile")
    public Boolean getUserProfileBackgroundTile() {
        return userProfileBackgroundTile;
    }

    @JsonProperty("user_profile_background_tile")
    public void setUserProfileBackgroundTile(Boolean userProfileBackgroundTile) {
        this.userProfileBackgroundTile = userProfileBackgroundTile;
    }

    @JsonProperty("user_profile_image_url")
    public String getUserProfileImageUrl() {
        return userProfileImageUrl;
    }

    @JsonProperty("user_profile_image_url")
    public void setUserProfileImageUrl(String userProfileImageUrl) {
        this.userProfileImageUrl = userProfileImageUrl;
    }

    @JsonProperty("user_profile_image_url_https")
    public String getUserProfileImageUrlHttps() {
        return userProfileImageUrlHttps;
    }

    @JsonProperty("user_profile_image_url_https")
    public void setUserProfileImageUrlHttps(String userProfileImageUrlHttps) {
        this.userProfileImageUrlHttps = userProfileImageUrlHttps;
    }

    @JsonProperty("user_profile_link_color")
    public String getUserProfileLinkColor() {
        return userProfileLinkColor;
    }

    @JsonProperty("user_profile_link_color")
    public void setUserProfileLinkColor(String userProfileLinkColor) {
        this.userProfileLinkColor = userProfileLinkColor;
    }

    @JsonProperty("user_profile_sidebar_border_color")
    public String getUserProfileSidebarBorderColor() {
        return userProfileSidebarBorderColor;
    }

    @JsonProperty("user_profile_sidebar_border_color")
    public void setUserProfileSidebarBorderColor(String userProfileSidebarBorderColor) {
        this.userProfileSidebarBorderColor = userProfileSidebarBorderColor;
    }

    @JsonProperty("user_profile_text_color")
    public String getUserProfileTextColor() {
        return userProfileTextColor;
    }

    @JsonProperty("user_profile_text_color")
    public void setUserProfileTextColor(String userProfileTextColor) {
        this.userProfileTextColor = userProfileTextColor;
    }

    @JsonProperty("user_profile_use_background_image")
    public Boolean getUserProfileUseBackgroundImage() {
        return userProfileUseBackgroundImage;
    }

    @JsonProperty("user_profile_use_background_image")
    public void setUserProfileUseBackgroundImage(Boolean userProfileUseBackgroundImage) {
        this.userProfileUseBackgroundImage = userProfileUseBackgroundImage;
    }

    @JsonProperty("user_has_extended_profile")
    public Boolean getUserHasExtendedProfile() {
        return userHasExtendedProfile;
    }

    @JsonProperty("user_has_extended_profile")
    public void setUserHasExtendedProfile(Boolean userHasExtendedProfile) {
        this.userHasExtendedProfile = userHasExtendedProfile;
    }

    @JsonProperty("user_default_profile")
    public Boolean getUserDefaultProfile() {
        return userDefaultProfile;
    }

    @JsonProperty("user_default_profile")
    public void setUserDefaultProfile(Boolean userDefaultProfile) {
        this.userDefaultProfile = userDefaultProfile;
    }

    @JsonProperty("user_default_profile_image")
    public Boolean getUserDefaultProfileImage() {
        return userDefaultProfileImage;
    }

    @JsonProperty("user_default_profile_image")
    public void setUserDefaultProfileImage(Boolean userDefaultProfileImage) {
        this.userDefaultProfileImage = userDefaultProfileImage;
    }

    @JsonProperty("user_following")
    public Boolean getUserFollowing() {
        return userFollowing;
    }

    @JsonProperty("user_following")
    public void setUserFollowing(Boolean userFollowing) {
        this.userFollowing = userFollowing;
    }

    @JsonProperty("user_follow_request_sent")
    public Boolean getUserFollowRequestSent() {
        return userFollowRequestSent;
    }

    @JsonProperty("user_follow_request_sent")
    public void setUserFollowRequestSent(Boolean userFollowRequestSent) {
        this.userFollowRequestSent = userFollowRequestSent;
    }

    @JsonProperty("user_notifications")
    public Boolean getUserNotifications() {
        return userNotifications;
    }

    @JsonProperty("user_notifications")
    public void setUserNotifications(Boolean userNotifications) {
        this.userNotifications = userNotifications;
    }

    @JsonProperty("user_translator_type")
    public String getUserTranslatorType() {
        return userTranslatorType;
    }

    @JsonProperty("user_translator_type")
    public void setUserTranslatorType(String userTranslatorType) {
        this.userTranslatorType = userTranslatorType;
    }

    @JsonProperty("is_quote_status")
    public Boolean getIsQuoteStatus() {
        return isQuoteStatus;
    }

    @JsonProperty("is_quote_status")
    public void setIsQuoteStatus(Boolean isQuoteStatus) {
        this.isQuoteStatus = isQuoteStatus;
    }

    @JsonProperty("retweet_count")
    public Integer getRetweetCount() {
        return retweetCount;
    }

    @JsonProperty("retweet_count")
    public void setRetweetCount(Integer retweetCount) {
        this.retweetCount = retweetCount;
    }

    @JsonProperty("favorite_count")
    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    @JsonProperty("favorite_count")
    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    @JsonProperty("favorited")
    public Boolean getFavorited() {
        return favorited;
    }

    @JsonProperty("favorited")
    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }

    @JsonProperty("retweeted")
    public Boolean getRetweeted() {
        return retweeted;
    }

    @JsonProperty("retweeted")
    public void setRetweeted(Boolean retweeted) {
        this.retweeted = retweeted;
    }

    @JsonProperty("lang")
    public String getLang() {
        return lang;
    }

    @JsonProperty("lang")
    public void setLang(String lang) {
        this.lang = lang;
    }

    @JsonProperty("user_favourites_count")
    public Integer getUserFavouritesCount() {
        return userFavouritesCount;
    }

    @JsonProperty("user_favourites_count")
    public void setUserFavouritesCount(Integer userFavouritesCount) {
        this.userFavouritesCount = userFavouritesCount;
    }

    @JsonProperty("user_utc_offset")
    public String getUserUtcOffset() {
        return userUtcOffset;
    }

    @JsonProperty("user_utc_offset")
    public void setUserUtcOffset(String userUtcOffset) {
        this.userUtcOffset = userUtcOffset;
    }

    @JsonProperty("user_profile_sidebar_fill_color")
    public String getUserProfileSidebarFillColor() {
        return userProfileSidebarFillColor;
    }

    @JsonProperty("user_profile_sidebar_fill_color")
    public void setUserProfileSidebarFillColor(String userProfileSidebarFillColor) {
        this.userProfileSidebarFillColor = userProfileSidebarFillColor;
    }

    @JsonProperty("in_reply_to_status_id")
    public Object getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    @JsonProperty("in_reply_to_status_id")
    public void setInReplyToStatusId(Object inReplyToStatusId) {
        this.inReplyToStatusId = inReplyToStatusId;
    }

    @JsonProperty("in_reply_to_status_id_str")
    public Object getInReplyToStatusIdStr() {
        return inReplyToStatusIdStr;
    }

    @JsonProperty("in_reply_to_status_id_str")
    public void setInReplyToStatusIdStr(Object inReplyToStatusIdStr) {
        this.inReplyToStatusIdStr = inReplyToStatusIdStr;
    }

    @JsonProperty("in_reply_to_user_id")
    public Object getInReplyToUserId() {
        return inReplyToUserId;
    }

    @JsonProperty("in_reply_to_user_id")
    public void setInReplyToUserId(Object inReplyToUserId) {
        this.inReplyToUserId = inReplyToUserId;
    }

    @JsonProperty("in_reply_to_user_id_str")
    public Object getInReplyToUserIdStr() {
        return inReplyToUserIdStr;
    }

    @JsonProperty("in_reply_to_user_id_str")
    public void setInReplyToUserIdStr(Object inReplyToUserIdStr) {
        this.inReplyToUserIdStr = inReplyToUserIdStr;
    }

    @JsonProperty("in_reply_to_screen_name")
    public Object getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    @JsonProperty("in_reply_to_screen_name")
    public void setInReplyToScreenName(Object inReplyToScreenName) {
        this.inReplyToScreenName = inReplyToScreenName;
    }

    @JsonProperty("geo")
    public Object getGeo() {
        return geo;
    }

    @JsonProperty("geo")
    public void setGeo(Object geo) {
        this.geo = geo;
    }

    @JsonProperty("coordinates")
    public Object getCoordinates() {
        return coordinates;
    }

    @JsonProperty("coordinates")
    public void setCoordinates(Object coordinates) {
        this.coordinates = coordinates;
    }

    @JsonProperty("place")
    public Object getPlace() {
        return place;
    }

    @JsonProperty("place")
    public void setPlace(Object place) {
        this.place = place;
    }

    @JsonProperty("contributors")
    public Object getContributors() {
        return contributors;
    }

    @JsonProperty("contributors")
    public void setContributors(Object contributors) {
        this.contributors = contributors;
    }

    @JsonProperty("user_profile_background_image_url")
    public Object getUserProfileBackgroundImageUrl() {
        return userProfileBackgroundImageUrl;
    }

    @JsonProperty("user_profile_background_image_url")
    public void setUserProfileBackgroundImageUrl(Object userProfileBackgroundImageUrl) {
        this.userProfileBackgroundImageUrl = userProfileBackgroundImageUrl;
    }

    @JsonProperty("user_profile_background_image_url_https")
    public Object getUserProfileBackgroundImageUrlHttps() {
        return userProfileBackgroundImageUrlHttps;
    }

    @JsonProperty("user_profile_background_image_url_https")
    public void setUserProfileBackgroundImageUrlHttps(Object userProfileBackgroundImageUrlHttps) {
        this.userProfileBackgroundImageUrlHttps = userProfileBackgroundImageUrlHttps;
    }

    @JsonProperty("user_url")
    public Object getUserUrl() {
        return userUrl;
    }

    @JsonProperty("user_url")
    public void setUserUrl(Object userUrl) {
        this.userUrl = userUrl;
    }

    @JsonProperty("user_time_zone")
    public Object getUserTimeZone() {
        return userTimeZone;
    }

    @JsonProperty("user_time_zone")
    public void setUserTimeZone(Object userTimeZone) {
        this.userTimeZone = userTimeZone;
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
		return "Tweet [createdAt=" + createdAt + ", id=" + id + ", idStr=" + idStr + ", text=" + text + ", truncated="
				+ truncated + ", source=" + source + ", userId=" + userId + ", userIdStr=" + userIdStr + ", userName="
				+ userName + ", userScreenName=" + userScreenName + ", userLocation=" + userLocation
				+ ", userDescription=" + userDescription + ", userProtected=" + userProtected + ", userFollowersCount="
				+ userFollowersCount + ", userFriendsCount=" + userFriendsCount + ", userListedCount=" + userListedCount
				+ ", userCreatedAt=" + userCreatedAt + ", userGeoEnabled=" + userGeoEnabled + ", userVerified="
				+ userVerified + ", userStatusesCount=" + userStatusesCount + ", userLang=" + userLang
				+ ", userContributorsEnabled=" + userContributorsEnabled + ", userIsTranslator=" + userIsTranslator
				+ ", userIsTranslationEnabled=" + userIsTranslationEnabled + ", userProfileBackgroundColor="
				+ userProfileBackgroundColor + ", userProfileBackgroundTile=" + userProfileBackgroundTile
				+ ", userProfileImageUrl=" + userProfileImageUrl + ", userProfileImageUrlHttps="
				+ userProfileImageUrlHttps + ", userProfileLinkColor=" + userProfileLinkColor
				+ ", userProfileSidebarBorderColor=" + userProfileSidebarBorderColor + ", userProfileTextColor="
				+ userProfileTextColor + ", userProfileUseBackgroundImage=" + userProfileUseBackgroundImage
				+ ", userHasExtendedProfile=" + userHasExtendedProfile + ", userDefaultProfile=" + userDefaultProfile
				+ ", userDefaultProfileImage=" + userDefaultProfileImage + ", userFollowing=" + userFollowing
				+ ", userFollowRequestSent=" + userFollowRequestSent + ", userNotifications=" + userNotifications
				+ ", userTranslatorType=" + userTranslatorType + ", isQuoteStatus=" + isQuoteStatus + ", retweetCount="
				+ retweetCount + ", favoriteCount=" + favoriteCount + ", favorited=" + favorited + ", retweeted="
				+ retweeted + ", lang=" + lang + ", userFavouritesCount=" + userFavouritesCount + ", userUtcOffset="
				+ userUtcOffset + ", userProfileSidebarFillColor=" + userProfileSidebarFillColor
				+ ", inReplyToStatusId=" + inReplyToStatusId + ", inReplyToStatusIdStr=" + inReplyToStatusIdStr
				+ ", inReplyToUserId=" + inReplyToUserId + ", inReplyToUserIdStr=" + inReplyToUserIdStr
				+ ", inReplyToScreenName=" + inReplyToScreenName + ", geo=" + geo + ", coordinates=" + coordinates
				+ ", place=" + place + ", contributors=" + contributors + ", userProfileBackgroundImageUrl="
				+ userProfileBackgroundImageUrl + ", userProfileBackgroundImageUrlHttps="
				+ userProfileBackgroundImageUrlHttps + ", userUrl=" + userUrl + ", userTimeZone=" + userTimeZone
				+ ", additionalProperties=" + additionalProperties + "]";
	}

}
