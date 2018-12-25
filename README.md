# fn Project Twitter Flow Use Case
This repository includes some examples on serverless programming using Oracle fn Project. The use case is based on tweet processing.

## Configuration and startup
In order to start the application Twitter credentials have to be set in "scripts/configure.sh":
- TWIT_CONSUMER_KEY
- TWIT_CONSUMER_SECRET
- TWIT_ACCESS_TOKEN
- TWIT_ACCESS_TOKEN_SECRET

To start the application run start.sh:

```
$> ./start.sh --app-name somename ../
```
