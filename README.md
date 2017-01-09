###Spring Data Couchbase integration

[Documentation](http://docs.spring.io/spring-data/couchbase/docs/current/reference/html/)

See [Spring Data Couchbase](http://projects.spring.io/spring-data-couchbase/#quick-start)


GET
```
curl -v -X GET -H "Accept-Type: application/json" http://localhost:8080/example/1
```

POST
```
curl -v -X POST -H "Content-Type: application/json" http://localhost:8080/example -d '{"id":"1","message":"Test message"}'
```

PUT
```
curl -v -X PUT -H "Content-Type: application/json" http://localhost:8080/example/1 -d '{"id":"1","message":"Test message"}'
```

PUT (invalid IDs)
```
curl -v -X PUT -H "Content-Type: application/json" http://localhost:8080/example/1 -d '{"id":"2","message":"Test message"}'
```

DELETE
```
curl -v -X DELETE -H "Content-Type: application/json" http://localhost:8080/example/1
```
