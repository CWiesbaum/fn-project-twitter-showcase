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
    
    if (input && input.message) {
      const tweet = {
        status: input.message
      };
      T.post('statuses/update', tweet, function (err, data, response) {
        if (err) {
          reject({ "message": "Error, Did you already tweet the same before?" });
        }
        else {
          // console.log(data);
          // console.log("Tweet Successfull: " + tweet.status);
          resolve({ "message": "Tweeting succeeded!" });
        }
      });
    }
    else {
      reject({ "message": "Tweet needs an input." });
    }
  })
})
