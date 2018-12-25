const fdk = require('@fnproject/fdk');
const Twit = require('twit');

fdk.handle(function (input, ctx) {
  return new Promise((resolve, reject) => {
    T = new Twit({
      consumer_key: ctx.config['TWIT_CONSUMER_KEY'],
      consumer_secret: ctx.config['TWIT_CONSUMER_SECRET'],
      access_token: ctx.config['TWIT_ACCESS_TOKEN'],
      access_token_secret: ctx.config['TWIT_ACCESS_TOKEN_SECRET'],
      timeout_ms: 60 * 1000,
      strictSSL: true,     // requires SSL certificates to be valid.
    });
    
    if (input && input.tweetID) {

      const tweet = {
        id: input.tweetID
      };
      T.get('statuses/show', tweet, function (err, data, response) {
        if (err) {
          reject({ "message": "Show tweet failed." });
        }
        else {
          if (data) {

            var status = data;
            twitterObject = {
              created_at: status.created_at,
              id: status.id,
              id_str: status.id_str,
              text: status.text,
              truncated: status.truncated,
              source: status.source,

              user_id: status.user.id,
              user_id_str: status.user.id_str,
              user_name: status.user.name,
              user_screen_name: status.user.screen_name,
              user_location: status.user.location,
              user_description: status.user.description,
              user_protected: status.user.protected,
              user_followers_count: status.user.followers_count,
              user_friends_count: status.user.friends_count,
              user_listed_count: status.user.listed_count,
              user_created_at: status.user.created_at,
              user_geo_enabled: status.user.geo_enabled,
              user_verified: status.user.verified,
              user_statuses_count: status.user.statuses_count,
              user_lang: status.user.lang,
              user_contributors_enabled: status.user.contributors_enabled,
              user_is_translator: status.user.is_translator,
              user_is_translation_enabled: status.user.is_translation_enabled,
              user_profile_background_color: status.user.profile_background_color,
              user_profile_background_tile: status.user.profile_background_tile,
              user_profile_image_url: status.user.profile_image_url,
              user_profile_image_url_https: status.user.profile_image_url_https,
              user_profile_link_color: status.user.profile_link_color,
              user_profile_sidebar_border_color: status.user.profile_sidebar_border_color,
              user_profile_text_color: status.user.profile_text_color,
              user_profile_use_background_image: status.user.profile_use_background_image,
              user_has_extended_profile: status.user.has_extended_profile,
              user_default_profile: status.user.default_profile,
              user_default_profile_image: status.user.default_profile_image,
              user_following: status.user.following,
              user_follow_request_sent: status.user.follow_request_sent,
              user_notifications: status.user.notifications,
              user_translator_type: status.user.translator_type,

              is_quote_status: status.is_quote_status,
              retweet_count: status.retweet_count,
              favorite_count: status.favorite_count,
              favorited: status.favorited,
              retweeted: status.retweeted,
              lang: status.lang,

              user_favourites_count: status.user.favorites_count ? status.user.favorites_count : 0,
              user_utc_offset: status.user.offset ? status.user.offset : '',
              user_profile_sidebar_fill_color: status.user.sidebar_fill_color ? status.user.sidebar_fill_color : '',

              in_reply_to_status_id: status.in_reply_to_status_id,
              in_reply_to_status_id_str: status.in_reply_to_status_id_str,
              in_reply_to_user_id: status.in_reply_to_user_id,
              in_reply_to_user_id_str: status.in_reply_to_user_id_str,
              in_reply_to_screen_name: status.in_reply_to_screen_name,

              geo: status.geo,
              coordinates: status.coordinates,
              place: status.place,
              contributors: status.contributors,

              user_profile_background_image_url: status.user.profile_background_image_url,
              user_profile_background_image_url_https: status.user.profile_background_image_url_https,
              user_url: status.user.url,
              user_time_zone: status.user.time_zone,

            };

            resolve(twitterObject);
          }
          else {
            reject({ "message": "Show tweet, no new data." });
          }
        }
      });
    }
    else {
      reject({ "message": "Show tweet needs an input." });
    }
  })
})