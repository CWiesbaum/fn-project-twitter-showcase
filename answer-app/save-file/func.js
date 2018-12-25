const fdk = require('@fnproject/fdk');

fdk.handle(function (input, ctx) {
  return new Promise((resolve, reject) => {
      var cmd = "curl --request POST --data '"
        + JSON.stringify(input).replace('\'', '´')
        + "' http://localhost:10000/";

      //console.log(cmd, "commandlog");
      var exec = require('child_process').exec;
      var child = exec(cmd,
        function (error, stdout, stderr) {
          console.log('stdout: ' + stdout);
          var json = JSON.parse(stdout);
          resolve(json)
          console.log('stderr: ' + stderr);
          if (error !== null) {
            reject({"message": "An error occured."})
            console.log('exec error: ' + error);
          }
        });
      console.log("Function has been fired.");

      resolve({ "message": "Success" });
  })
})
