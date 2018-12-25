const fdk = require('@fnproject/fdk');
// Quickstart guide of google developers:
// Bookmark is set: https://developers.google.com/gmail/api/quickstart/nodejs

//http://localhost:8080/t/answer-app/gmail-trigger
const fs = require('fs');
const readline = require('readline');
const { google } = require('googleapis');

// If modifying these scopes, delete token.json.
const SCOPES = ['https://www.googleapis.com/auth/gmail.readonly'];
const TOKEN_PATH = 'token.json';

let lastMailId = "0";


fdk.handle(function (input) {
  // let name = 'World';
  // if (input.name) {
  //   name = input.name;
  // }
  return new Promise((resolve, reject) => {
    fs.readFile('credentials.json', (err, content) => {
      if (err) {
        resolve({ "message": "Error" });
        //return console.log('Error loading client secret file:', err);
      } else {
        // Authorize a client with credentials, then call the Gmail API.
        //authorize(JSON.parse(content), listLabels);
        //authorize(JSON.parse(content), listMessages);
        var credentials = JSON.parse(content);
        // authorize(JSON.parse(content), getProfileData);
        const { client_secret, client_id, redirect_uris } = credentials.installed;
        const oAuth2Client = new google.auth.OAuth2(client_id, client_secret, redirect_uris[0]);

        // Check if we have previously stored a token.
        fs.readFile(TOKEN_PATH, (err, token) => {
          if (err) {
            //resolve({ "message": "Error." });
            const authUrl = oAuth2Client.generateAuthUrl({
              access_type: 'offline',
              scope: SCOPES,
            });
            console.log('Authorize this app by visiting this url:', authUrl);
            const rl = readline.createInterface({
              input: process.stdin,
              output: process.stdout,
            });
            rl.question('Enter the code from that page here: ', (code) => {
              rl.close();
              oAuth2Client.getToken(code, (err, token) => {
                if (err) return console.error('Error retrieving access token', err);
                oAuth2Client.setCredentials(token);
                // Store the token to disk for later program executions
                fs.writeFile(TOKEN_PATH, JSON.stringify(token), (err) => {
                  if (err) return console.error(err);
                  console.log('Token stored to', TOKEN_PATH);
                });
                oAuth2Client.setCredentials(JSON.parse(token));
                //resolve(listLabels(oAuth2Client));
                const gmail = google.gmail({ version: 'v1', auth });
                gmail.users.labels.list({
                  userId: 'me',
                }, (err, res) => {
                  if (err) {
                    resolve({ "message": "Error: " + err });//console.log('The API returned an error: ' + err);
                  } else {
                    const labels = res.data.labels;

                    if (labels.length) {
                      // console.log('Labels:');
                      // labels.forEach((label) => {
                      //   console.log(`- ${label.name}`);
                      // });
                      resolve({ "message": "Labels:" + labels });
                    } else {
                      console.log('No labels found.');
                      resolve({ "message": "No labels found." });
                    }
                  }
                });
                //callback(oAuth2Client);
              });
            });
            //return getNewToken(oAuth2Client, callback);
          } else {
            oAuth2Client.setCredentials(JSON.parse(token));
            //resolve(listLabels(oAuth2Client));
            const gmail = google.gmail({ version: 'v1', auth });
            gmail.users.labels.list({
              userId: 'me',
            }, (err, res) => {
              if (err) {
                resolve({ "message": "Error: " + err });//console.log('The API returned an error: ' + err);
              } else {
                const labels = res.data.labels;

                if (labels.length) {
                  // console.log('Labels:');
                  // labels.forEach((label) => {
                  //   console.log(`- ${label.name}`);
                  // });
                  resolve({ "message": "Labels:" + labels });
                } else {
                  console.log('No labels found.');
                  resolve({ "message": "No labels found." });
                }
              }
            });
          }
        });
      }
    });
  });

  // return { 'message': 'Hello ' + name }
})




// token: 4/jADlTQ1Y66ivHUROCtIkaXT2Sf9zHEVCsW5BfToc_26vr402rz5ogMc

// Load client secrets from a local file.

/**
 * Create an OAuth2 client with the given credentials, and then execute the
 * given callback function.
 * @param {Object} credentials The authorization client credentials.
 * @param {function} callback The callback to call with the authorized client.
 */
function authorize(credentials, callback) {
  const { client_secret, client_id, redirect_uris } = credentials.installed;
  const oAuth2Client = new google.auth.OAuth2(
    client_id, client_secret, redirect_uris[0]);

  // Check if we have previously stored a token.
  fs.readFile(TOKEN_PATH, (err, token) => {
    if (err) return getNewToken(oAuth2Client, callback);
    oAuth2Client.setCredentials(JSON.parse(token));
    resolve(callback(oAuth2Client));
  });
}

/**
 * Get and store new token after prompting for user authorization, and then
 * execute the given callback with the authorized OAuth2 client.
 * @param {google.auth.OAuth2} oAuth2Client The OAuth2 client to get token for.
 * @param {getEventsCallback} callback The callback for the authorized client.
 */
function getNewToken(oAuth2Client, callback) {
  const authUrl = oAuth2Client.generateAuthUrl({
    access_type: 'offline',
    scope: SCOPES,
  });
  console.log('Authorize this app by visiting this url:', authUrl);
  const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout,
  });
  rl.question('Enter the code from that page here: ', (code) => {
    rl.close();
    oAuth2Client.getToken(code, (err, token) => {
      if (err) return console.error('Error retrieving access token', err);
      oAuth2Client.setCredentials(token);
      // Store the token to disk for later program executions
      fs.writeFile(TOKEN_PATH, JSON.stringify(token), (err) => {
        if (err) return console.error(err);
        console.log('Token stored to', TOKEN_PATH);
      });
      callback(oAuth2Client);
    });
  });
}

/**
 * Lists the labels in the user's account.
 *
 * @param {google.auth.OAuth2} auth An authorized OAuth2 client.
 */
function listLabels(auth) {
  const gmail = google.gmail({ version: 'v1', auth });
  gmail.users.labels.list({
    userId: 'me',
  }, (err, res) => {
    if (err) {
      return { "message": "Error: " + err };//console.log('The API returned an error: ' + err);
    }
    const labels = res.data.labels;

    if (labels.length) {
      // console.log('Labels:');
      // labels.forEach((label) => {
      //   console.log(`- ${label.name}`);
      // });
      return { "message": "Labels:" + labels };
    } else {
      console.log('No labels found.');
      return { "message": "No labels found." };
    }
  });
}

function listMessages(auth) {
  const gmail = google.gmail({ version: 'v1', auth });
  gmail.users.messages.list({
    userId: 'me',
  }, (err, res) => {
    if (err) return console.log('The API returned an error: ' + err);
    const messages = res.data.messages;
    if (messages) {
      console.log('Messages:');
      console.log(messages);
      messages.forEach((message) => {
        if (message.id > lastMailId) {
          gmail.users.messages.get({
            userId: 'me',
            id: message.id,
            format: 'metadata'
          }, (err, res) => {
            if (err) return console.log('The API returned an error: ' + err);
            const message = res.data;
            if (message) {

              console.log(message, "\n");
              // let tempCount = 0;
              // message.payload.headers.forEach((header) => {
              //     console.log(header,"message.payload.headers at " + tempCount++);
              // })
            } else {
              console.log('Not one message found.');
            }
            // console.log(`- ${message.subject}`);
          });
        }
      });

      lastMailId = messages[0].id;
      console.log(lastMailId, "166e439734b41203");
    } else {
      console.log('No messages found.');
    }
  });
}

function getProfileData(auth) {
  const gmail = google.gmail({ version: 'v1', auth });
  gmail.users.getProfile({
    userId: 'me',
  }, (err, res) => {
    if (err) return { "message": "Error: " + err };
    const profile = res.data;
    if (profile) {
      console.log('Labels:');
      // labels.forEach((label) => {
      //     console.log(`- ${label.name}`);
      // });
      console.log(profile);
      return { "message": profile };
    } else {
      return { "message": "No labels found." };
    }
  });
}
