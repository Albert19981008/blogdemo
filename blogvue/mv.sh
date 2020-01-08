npm run build

rm -rf ../blogserver/src/main/resources/static/*

cp -r dist/* ../blogserver/src/main/resources/static/

rm -rf ../blogserver/src/main/webapp/css
rm -rf ../blogserver/src/main/webapp/fonts
rm -rf ../blogserver/src/main/webapp/js

cp -r dist/* ../blogserver/src/main/webapp
