#! /bin/bash

# print_help function
function print_help {
  echo "Usage: $0 [OPTION] FN_ROOT_DIRECTORY"
  echo
  echo "Starts fn server, fn flowserver, fn project ui and flow ui. Deploys fn application at FN_ROOT_DIRECTORY"
  echo
  echo "FN_ROOT_DIRECTORY - fn application root directory containing app.yaml"
  echo
  echo "Options:"
  echo "--app-name APP_NAME - Changes the application name created in fn"
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
APP_NAME=answer-app
SCRIPT_DIR="$(cd "$(dirname "$0")"; pwd -P )"

if [ $# -eq 0 -o $# -gt 3 ]
then
  print_help
  exit 0
else
  check_args "$@"
fi

./pull-images.sh

fn start -d

FNSERVER_IP=$(docker inspect --type container -f '{{.NetworkSettings.IPAddress}}' fnserver)

docker run --rm -d \
      -p 8081:8081 \
      -e API_URL="http://$FNSERVER_IP:8080/invoke" \
      -e no_proxy=$FNSERVER_IP \
      --name flowserver \
      fnproject/flow:latest

FLOWSERVER_IP=$(docker inspect --type container -f '{{.NetworkSettings.IPAddress}}' flowserver)

docker run --rm \
       -p 3002:3000 \
       -d \
       --name flowui \
       -e API_URL=http://$FNSERVER_IP:8080 \
       -e COMPLETER_BASE_URL=http://$FLOWSERVER_IP:8081 \
       fnproject/flow:ui

docker run --rm \
       -p 4000:4000 \
       -d \
       --name fnui \
       -e FN_API_URL=http://$FNSERVER_IP:8080 \
       fnproject/ui

for directory in $( find $( cd ${@:$#}; pwd) -name app.yaml -exec dirname {} \; ); do
  cd $directory
  fn deploy --app $APP_NAME --all --local
done

$SCRIPT_DIR/configure.sh --app-name $APP_NAME
