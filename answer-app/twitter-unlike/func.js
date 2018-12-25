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
        id:  input.tweetID
      };
      T.post('favorites/destroy', tweet, function (err, data, response) {
        if (err) {
          reject({ "message": "Unlike failed." });
        }
        else {
          resolve({ "message": "Unlike succeeded!" });
        }
      });
    }
    else {
      reject({ "message": "Unlike needs an input." });
    }
  })
})