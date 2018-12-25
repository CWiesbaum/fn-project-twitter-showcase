const fdk = require('@fnproject/fdk');

fdk.handle(function (input) {
  var returnObj = new Object();
  returnObj.users = [];
  // twitterObjects.push(locations,keywords);
  if (input.users && input.users.length) {
    input.users.forEach(element => {
      // Check if account has many followers
      if (input.followers && element.followers_count > Number(input.followers)) {
        returnObj.users.push(element);
      }
    });
  }

  console.log("Users: ", returnObj.users);
  return returnObj;
})
