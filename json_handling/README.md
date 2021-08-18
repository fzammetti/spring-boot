A dirt-simple Spring Boot app showing handling of JSON in a POST body and JSON as output from a REST endpoint.

To test, execute from a command prompt:

`curl -X POST -H "Content-type: application/json" -d "{\"id\" : 1234 }" "http://localhost:8080/api/getAccount"`
