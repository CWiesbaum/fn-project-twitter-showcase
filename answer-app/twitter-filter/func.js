const fdk = require('@fnproject/fdk');

fdk.handle(function (input) {
  // if (!input.keywords) {
  //   input.keywords = ["developer", "software", "architect", "esentri"];
  // }
  // if (!input.locations) {
  //   input.locations = ["Germany", "Turkey"];
  // }
  var returnObj = new Object();
  returnObj.users = [];
  // twitterObjects.push(locations,keywords);
  if (input.users && input.users.length) {
    input.users.forEach(element => {
      // Green as main color
      if (element.profile_link_color.substring(0, 2) < element.profile_link_color.substring(2, 4) && element.profile_link_color.substring(2, 4) > element.profile_link_color.substring(4)) {
        returnObj.users.push(element);
        return;
      }
      // Check if keywords in profile description
      let count = 0;
      for (var i = 0; i < input.keywords.length; i++) {
        item = input.keywords[i];
        if (element.description.toLowerCase().includes(item.toLowerCase()) || element.description.toLowerCase() === (item.toLowerCase())) {
          rreturnObj.users.push(element);
          count++;
          break;
        }
      };
      if (count > 0) {
        return;
      }
      // Account from chosen location?
      if (count === 0) {
        for (var i = 0; i < input.locations.length; i++) {
          item = input.locations[i];
          if (element.location.toLowerCase().includes(item.toLowerCase()) || element.location.toLowerCase() === (item.toLowerCase())) {
            returnObj.users.push(element);
            count++;
            return;
          }
        };
        if (count > 0) {
          return;
        }
      }
      // Check if account has many followers
      if (input.followers && element.followers_count > Number(input.followers)) {
        returnObj.users.push(element);
        return;
      }

    });
  }
  return returnObj;
})
