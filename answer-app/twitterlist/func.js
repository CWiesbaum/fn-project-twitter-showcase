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

    var query = { q: input + "", count: 500 };

    T.get('search/tweets', query, function (err, data, response) {
      if (err) {
        reject({ "message": "Error in twitterlist." });
      }
      else if (/*data.search_metadata !== undefined && data.search_metadata != null && data.statuses.length > 0*/ data) {
        let twitterObjects = [];
        data.statuses.forEach(status => {
          twitterObject = {
            name: status.user.screen_name,
            location: status.user.location,
            description: status.user.description,
            followers_count: status.user.followers_count,
            friends_count: status.user.friends_count,
            statuses_count: status.user.statuses_count,
            lang: status.user.lang,
            profile_link_color: status.user.profile_link_color
          };
          twitterObjects = twitterObjects.filter(a => a.name !== twitterObject.name);
          twitterObjects.push(twitterObject);
        });
        resolve(twitterObjects);
      } else {
        reject({ "message": "No data found." });
      }
    });
  })
})
