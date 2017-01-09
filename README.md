###Spring Data Couchbase integration

[Documentation](http://docs.spring.io/spring-data/couchbase/docs/current/reference/html/)

See [Spring Data Couchbase](http://projects.spring.io/spring-data-couchbase/#quick-start)


GET
curl -v -X GET -H "Accept-Type: application/json" http://localhost:8080/example/1

POST
curl -v -X POST -H "Content-Type: application/json" http://localhost:8080/example -d '{"id":"1","message":"Test message"}'

PUT
curl -v -X PUT -H "Content-Type: application/json" http://localhost:8080/example/1 -d '{"id":"1","message":"Test message"}'

PUT (invalid IDs)
curl -v -X PUT -H "Content-Type: application/json" http://localhost:8080/example/1 -d '{"id":"2","message":"Test message"}'

DELETE
curl -v -X DELETE -H "Content-Type: application/json" http://localhost:8080/example/1


https://blog.couchbase.com/2016/april/spring-boot-couchbase-integration
https://blog.couchbase.com/2016/february/spring-data-couchbase-2-is-out-quick-getting-started-with-spring-initializr

https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples/spring-boot-sample-data-couchbase

https://spring.io/blog/2015/03/16/getting-started-with-couchbase-and-spring-data-couchbase
https://github.com/spring-projects/spring-data-couchbase
