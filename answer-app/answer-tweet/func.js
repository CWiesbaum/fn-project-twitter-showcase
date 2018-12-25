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

    console.log("Payload: ", input);

    if (input && input.name && input.tweet && input.tweetID) {

      const randomNumber = Math.floor(Math.random() * 4711);
      const tweet = {
        status:  "@" + input.name + " " + input.tweet,
        in_reply_to_status_id: input.tweetID
      };
      T.post('statuses/update', tweet, function (err, data, response) {
        if (err) {
          reject({ "message": "Answer-Tweet failed." });
        }
        else {
          resolve({ "message": "Answer-Tweet succeeded!" });
        }
      });
    }
    else {
      reject({ "message": "Answer-Tweet needs an input." });
    }
  })
})
