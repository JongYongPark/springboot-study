export URL=http://localhost:8080

t:
	echo "aaa"  | grep "a"

api-post-in-browser:
	https://host4geeks.com/blog/breaking-it-down-a-beginners-guide-on-how-to-test-http-post-from-your-browser/
	https://stackoverflow.com/questions/4797534/how-to-manually-send-http-post-requests-from-firefox-or-chrome-browser


#.SILENT: check-make
check-make:
	which make
	@echo "--------"
	whereis make
	@echo "--------"
	where make
	@echo "--------"
	make --version
	@printf "..."

# make p-URL
p-%: ; @echo $*=$($*)

print-env:
	echo "${URL}"

api-examples:
	echo "${URL}"

api-club-all-get:
	curl -X GET ${URL}/club/all -H 'accept: application/json' | jq '.'
	#http GET  ${URL}/all

export CLUB_ID=9e692405-d974-48da-9642-c83e7abf279e
api-club-id-get:
	curl -X GET ${URL}/club/${CLUB_ID} -H 'accept: application/json' | jq '.'

api-club-id-put:
	curl -X PUT ${URL}/club/${CLUB_ID} -H 'accept: */*'  -H 'Content-Type: application/json'  -d '{"nameValues":[{"name":"name","value":"TravelClub-1"}, {"name":"intro","value":"Test TravelClub-1"}]}'

api-club-id-delete:
	curl -X DELETE ${URL}/club/${CLUB_ID} -H 'accept: */*'

export CLUB_NAME=TravelClub
#export CLUB_NAME=TravelClub-1
api-club-name-get:
	curl -X GET ${URL}/club?name=${CLUB_NAME} -H 'accept: application/json'  |  jq '.'
#	curl -X GET ${URL}/club?name=TravelClub -H 'accept: application/json'  |  jq '.[].id'
#	curl -X GET ${URL}/club?name=TravelClub -H 'accept: application/json' |  jq '.'
#	curl -X GET ${URL}/club?name=TravelClub -H 'accept: application/json'  | C:/nobackup/dev_tool/Anaconda3/Library/mingw-w64/bin/jq.exe '.'

# /club 에서 get mapping 되어 있는 것이 없다.
api-club-get:
	curl -X GET ${URL}/club -H 'accept: */*' | jq '.'
#	curl -X GET ${URL}/club -H 'accept: application/json'  | jq '.'
#	curl -v -X GET ${URL}/club -H 'accept: application/json'
#	curl -v -X GET "${URL}/club" -H 'accept: application/json'  | jq > cicd/.json
#	jq . cicd/.json

api-club-post:
# 	curl -v -X POST ${URL}/club -H 'accept: */*'  -d name=TravelClub&intro=TestTravelClub
	curl -v -X POST ${URL}/club -H 'accept: */*'  -H 'Content-Type: application/json'  -d '{"name":"TravelClub", "intro": "Test TravelClub"}'

