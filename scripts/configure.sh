#! /bin/bash

# print_help function
function print_help {
  echo "Usage: $0 [OPTION]"
  echo
  echo "Configures required application properties."
  echo
  echo "Options:"
  echo "--app-name APP_NAME - Changes the application name used"
  echo "--help - Print this help"
}

# Check parameters function
function check_args {
  case "$1" in
    "--help") print_help
              exit 0;;
    "--app-name") APP_NAME=$2
                 ;;
  esac
}

# Init
APP_NAME=fnapp

if [ $# -gt 2 ]
then
  print_help
  exit 0
else
  check_args "$@"
fi

FLOWSERVER_IP=$(docker inspect --type container -f '{{.NetworkSettings.IPAddress}}' flowserver)
fn config app $APP_NAME COMPLETER_BASE_URL "http://$FLOWSERVER_IP:8081"

fn config app $APP_NAME ANSWER_TWEET_ID $(fn inspect fn $APP_NAME answer-tweet | jq  -rM .id)
fn config app $APP_NAME TWITTER_SHORTENER_ID $(fn inspect fn $APP_NAME twitter-shortener | jq  -rM .id)
fn config app $APP_NAME TWITTER_FILTER_FOLLOW_ID $(fn inspect fn $APP_NAME twitter-filter-follow | jq -rM .id)
fn config app $APP_NAME SAVE_FILE_ID $(fn inspect fn $APP_NAME save-file | jq -rM .id)
fn config app $APP_NAME FOLLOWER_COUNT 5
fn config app $APP_NAME TWIT_CONSUMER_KEY <TWIT_CONSUMER_KEY>
fn config app $APP_NAME TWIT_CONSUMER_SECRET <TWIT_CONSUMER_SECRET>
fn config app $APP_NAME TWIT_ACCESS_TOKEN <TWIT_ACCESS_TOKEN>
fn config app $APP_NAME TWIT_ACCESS_TOKEN_SECRET <TWIT_ACCESS_TOKEN_SECRET>
