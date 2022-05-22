# SyncCache
Sync local cache with RabbitMq pub/sub mechanism

## Usage

- Start RabbitMq and Spring Boot app with 3 instances
 
 ~~~
 compose up --scale app=3
 ~~~
 
- Invalidate (evict) static data cache

~~~
  curl http://localhost:8080/invalidate
~~~

