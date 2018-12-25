// package main

// import (
// 	"context"
// 	"encoding/json"
// 	"fmt"
// 	"io"

// 	fdk "github.com/fnproject/fdk-go"
// )

// func main() {
// 	fdk.Handle(fdk.HandlerFunc(myHandler))
// }

// type Tweet struct {
// 	Created string `json:"created_at"`
// 	Text string `json:"text"`
// 	Id string `json:"id"`
// 	Username string `json:"user_name"`
// 	// Lang string `json:"lang"`
// 	// string `json:""`
// }

// func myHandler(ctx context.Context, in io.Reader, out io.Writer) {
// 	p := &Tweet{Id: ""}
// 	json.NewDecoder(in).Decode(p)
// 	msg := struct {
// 		Msg string `json:"message"`
// 	}{
// 		Msg: fmt.Sprintf("@%s Hello %s", p.Username, p.Id),
// 	}
// 	json.NewEncoder(out).Encode(&msg)
// }


package main

import (
	"context"
	"encoding/json"
	"fmt"
	"io"

	fdk "github.com/fnproject/fdk-go"
)

func main() {
	fdk.Handle(fdk.HandlerFunc(myHandler))
}

type SearchMetadata struct {
	CompletedIn float64 `json:"completed_in"`
	MaxID       int64   `json:"max_id"`
	MaxIDStr    string  `json:"max_id_str"`
	Query       string  `json:"query"`
	RefreshURL  string  `json:"refresh_url"`
	Count       int     `json:"count"`
	SinceID     int64   `json:"since_id"`
	SinceIDStr  string  `json:"since_id_str"`
}

type Description struct {
	Urls []string `json:"urls"`
}

type EntitySub struct {
	Description Description `json:"description"`
}

type User struct {
	ID          int64       `json:"id"`
	IDStr       string      `json:"id_str"`
	Name        string      `json:"name"`
	ScreenName  string      `json:"screen_name"`
	Location    string      `json:"location"`
	Description string      `json:"description"`
	URL         string		`json:"url"`
	Entities    EntitySub 	`json:"entities"`
	Protected                      bool        `json:"protected"`
	FollowersCount                 int         `json:"followers_count"`
	FriendsCount                   int         `json:"friends_count"`
	ListedCount                    int         `json:"listed_count"`
	CreatedAt                      string      `json:"created_at"`
	FavouritesCount                int         `json:"favourites_count"`
	UtcOffset                      string	   `json:"utc_offset"`
	TimeZone                       string	   `json:"time_zone"`
	GeoEnabled                     bool        `json:"geo_enabled"`
	Verified                       bool        `json:"verified"`
	StatusesCount                  int         `json:"statuses_count"`
	Lang                           string      `json:"lang"`
	ContributorsEnabled            bool        `json:"contributors_enabled"`
	IsTranslator                   bool        `json:"is_translator"`
	IsTranslationEnabled           bool        `json:"is_translation_enabled"`
	ProfileBackgroundColor         string      `json:"profile_background_color"`
	ProfileBackgroundImageURL      string	   `json:"profile_background_image_url"`
	ProfileBackgroundImageURLHTTPS string	   `json:"profile_background_image_url_https"`
	ProfileBackgroundTile          bool        `json:"profile_background_tile"`
	ProfileImageURL                string      `json:"profile_image_url"`
	ProfileImageURLHTTPS           string      `json:"profile_image_url_https"`
	ProfileLinkColor               string      `json:"profile_link_color"`
	ProfileSidebarBorderColor      string      `json:"profile_sidebar_border_color"`
	ProfileSidebarFillColor        string      `json:"profile_sidebar_fill_color"`
	ProfileTextColor               string      `json:"profile_text_color"`
	ProfileUseBackgroundImage      bool        `json:"profile_use_background_image"`
	HasExtendedProfile             bool        `json:"has_extended_profile"`
	DefaultProfile                 bool        `json:"default_profile"`
	DefaultProfileImage            bool        `json:"default_profile_image"`
	Following                      bool        `json:"following"`
	FollowRequestSent              bool        `json:"follow_request_sent"`
	Notifications                  bool        `json:"notifications"`
	TranslatorType                 string      `json:"translator_type"`
}

type Hashtag struct {
	Text    string `json:"text"`
	Indices []string `json:"indices"`
}

type UserMention struct {
	ScreenName string `json:"screen_name"`
	Name       string `json:"name"`
	ID         int64  `json:"id"`
	IDStr      string `json:"id_str"`
	Indices    []string `json:"indices"`
}

type Entity struct {
	Hashtags []Hashtag `json:"hashtags"`
	Symbols      []string `json:"symbols"`
	UserMentions []UserMention `json:"user_mentions"`
	Urls []string `json:"urls"`
}

type MetaData struct {
	IsoLanguageCode string `json:"iso_language_code"`
	ResultType      string `json:"result_type"`
}

type Status struct {
	CreatedAt            string      `json:"created_at"`
	ID                   int64       `json:"id"`
	IDStr                string      `json:"id_str"`
	Text                 string      `json:"text"`
	Truncated            bool        `json:"truncated"`
	Entities             Entity 	 `json:"entities"`
	Metadata             MetaData  	 `json:"metadata"`
	Source               string      `json:"source"`
	InReplyToStatusID    int		 `json:"in_reply_to_status_id"`
	InReplyToStatusIDStr string		 `json:"in_reply_to_status_id_str"`
	InReplyToUserID      int64       `json:"in_reply_to_user_id"`
	InReplyToUserIDStr   string      `json:"in_reply_to_user_id_str"`
	InReplyToScreenName  string      `json:"in_reply_to_screen_name"`
	User                 User   	 `json:"user"`
	Geo                  string		 `json:"geo"`
	Coordinates          string		 `json:"coordinates"`
	Place                string 	 `json:"place"`
	Contributors         string 	 `json:"contributors"`
	IsQuoteStatus        bool        `json:"is_quote_status"`
	RetweetCount         int         `json:"retweet_count"`
	FavoriteCount        int         `json:"favorite_count"`
	Favorited            bool        `json:"favorited"`
	Retweeted            bool        `json:"retweeted"`
	Lang                 string      `json:"lang"`
}

type TweetBall struct {
	Statuses []Status `json:"statuses"`
	SearchMetadata SearchMetadata `json:"search_metadata"`
}

type Tweet struct {
	Created string `json:"created_at"`
	Text string `json:"text"`
	Id string `json:"id"`
	Username string `json:"user_name"`
}

type TwitterObject struct {
	CreatedAt                          string      `json:"created_at"`
	ID                                 int64       `json:"id"`
	IDStr                              string      `json:"id_str"`
	Text                               string      `json:"text"`
	Truncated                          bool        `json:"truncated"`
	Source                             string      `json:"source"`
	InReplyToStatusID                  int64 `json:"in_reply_to_status_id"`
	InReplyToStatusIDStr               string `json:"in_reply_to_status_id_str"`
	InReplyToUserID                    int64 `json:"in_reply_to_user_id"`
	InReplyToUserIDStr                 string `json:"in_reply_to_user_id_str"`
	InReplyToScreenName                string `json:"in_reply_to_screen_name"`
	UserID                             int64       `json:"user_id"`
	UserIDStr                          string      `json:"user_id_str"`
	UserName                           string      `json:"user_name"`
	UserScreenName                     string      `json:"user_screen_name"`
	UserLocation                       string      `json:"user_location"`
	UserDescription                    string      `json:"user_description"`
	UserURL                            string      `json:"user_url"`
	UserProtected                      bool        `json:"user_protected"`
	UserFollowersCount                 int         `json:"user_followers_count"`
	UserFriendsCount                   int         `json:"user_friends_count"`
	UserListedCount                    int         `json:"user_listed_count"`
	UserCreatedAt                      string      `json:"user_created_at"`
	UserFavouritesCount                string      `json:"user_favourites_count"`
	UserUtcOffset                      string      `json:"user_utc_offset"`
	UserTimeZone                       string      `json:"user_time_zone"`
	UserGeoEnabled                     bool        `json:"user_geo_enabled"`
	UserVerified                       bool        `json:"user_verified"`
	UserStatusesCount                  int         `json:"user_statuses_count"`
	UserLang                           string      `json:"user_lang"`
	UserContributorsEnabled            bool        `json:"user_contributors_enabled"`
	UserIsTranslator                   bool        `json:"user_is_translator"`
	UserIsTranslationEnabled           bool        `json:"user_is_translation_enabled"`
	UserProfileBackgroundColor         string      `json:"user_profile_background_color"`
	UserProfileBackgroundImageURL      string `json:"user_profile_background_image_url"`
	UserProfileBackgroundImageURLHTTPS string `json:"user_profile_background_image_url_https"`
	UserProfileBackgroundTile          bool        `json:"user_profile_background_tile"`
	UserProfileImageURL                string      `json:"user_profile_image_url"`
	UserProfileImageURLHTTPS           string      `json:"user_profile_image_url_https"`
	UserProfileLinkColor               string      `json:"user_profile_link_color"`
	UserProfileSidebarBorderColor      string      `json:"user_profile_sidebar_border_color"`
	UserProfileSidebarFillColor        string      `json:"user_profile_sidebar_fill_color"`
	UserProfileTextColor               string      `json:"user_profile_text_color"`
	UserProfileUseBackgroundImage      bool        `json:"user_profile_use_background_image"`
	UserHasExtendedProfile             bool        `json:"user_has_extended_profile"`
	UserDefaultProfile                 bool        `json:"user_default_profile"`
	UserDefaultProfileImage            bool        `json:"user_default_profile_image"`
	UserFollowing                      bool        `json:"user_following"`
	UserFollowRequestSent              bool        `json:"user_follow_request_sent"`
	UserNotifications                  bool        `json:"user_notifications"`
	UserTranslatorType                 string      `json:"user_translator_type"`
	Geo                                string      `json:"geo"`
	Coordinates                        string      `json:"coordinates"`
	Place                              string      `json:"place"`
	Contributors                       string      `json:"contributors"`
	IsQuoteStatus                      bool        `json:"is_quote_status"`
	RetweetCount                       int         `json:"retweet_count"`
	FavoriteCount                      int         `json:"favorite_count"`
	Favorited                          bool        `json:"favorited"`
	Retweeted                          bool        `json:"retweeted"`
	Lang                               string      `json:"lang"`
}

func myHandler(ctx context.Context, in io.Reader, out io.Writer) {
	p := &TwitterObject{}
	json.NewDecoder(in).Decode(p)
	msg := struct {
		Msg string `json:"message"`
		Object string `json:"twitterObject"`
	}{
		Msg: fmt.Sprintf("@%s Hello %s, and %s", p.Text, p.ID, p.UserScreenName),
		Object: fmt.Sprintf("Here: %s",p),
	}
	fmt.Println("Hello again:")
	fmt.Println(p)
	json.NewEncoder(out).Encode(&msg)
}
