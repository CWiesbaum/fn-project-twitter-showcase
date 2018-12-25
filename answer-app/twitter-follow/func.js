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
    
    if (input && input.name) {

      //const randomNumber = Math.floor(Math.random() * 4711);
      const user = {
        screen_name:  input.name
      };
      T.post('friendships/create', user, function (err, data, response) {
        if (err) {
          reject({ "message": "Following failed." });
        }
        else {
          resolve({ "message": "Following succeeded!" });
        }
      });
    }
    else {
      reject({ "message": "Follow needs an input." });
    }
  })

})
