npm run build

rm -rf ../blogserver/src/main/resources/static/*

cp -r dist/* ../blogserver/src/main/resources/static/
