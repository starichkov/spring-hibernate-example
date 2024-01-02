Spring Hibernate example
=

Small example how to use Hibernate ORM in Spring application.

### Disclaimer

This project is using plain Spring Framework without Spring Boot **intentionally**.

It also shows the old way of configuring Spring Context for deployable `.war` - using XML.

## Technical information

| Piece of tech | Version |
|---------------|---------|
| Java          | 17      |
| Spring        | 6.0.x   |
| Hibernate     | 5.6.x   |
| Tomcat        | 10.0.x  |
| Wildfly       | 27.0.x  |

Spring 6 works Tomcat 10+ and with Wildfly 27+.

Spring 5 can only work with Tomcat 9 (and prior) or Wildfly 26 (and prior).

## Deploy

Examples were tested with Tomcat 10.0.xx, 10.1.xx and Wildfly 27.0.1.

### Tomcat

If you've installed Tomcat via SdkMan and observing `permission denied` error during Tomcat launch attempt,
check the permissions on catalina.sh script.

```
-rw-r--r-- 1 starichkov starichkov  23445 May  9 14:30 catalina.sh 
```

With SdkMan you must make this script executable yourself:

```shell
chmod u+x ./catalina.sh
```

```
-rwxr--r-- 1 starichkov starichkov  23445 May  9 14:30 catalina.sh
```

### Database

Even with this old-style example, I will still suggest you to use Docker to run PostgreSQL server.

#### Server

This was my container:

```shell
docker run -d --name postgres15 \
      -e POSTGRES_USER=REPLACE_WITH_ACTUAL_USER \
      -e POSTGRES_PASSWORD=REPLACE_WITH_ACTUAL_PASSWORD \
      --network=localnet \
      -p 5432:5432 \
      postgres:15-alpine
```

#### Schema and table

Pretty simple and straightforward script to create basic objects.

```postgresql
create database examples;

create schema examples.spring_hibernate;

create table if not exists examples.spring_hibernate.users
(
    id         serial  not null,
    first_name varchar not null,
    last_name  varchar not null
);

alter table examples.spring_hibernate.users
    owner to postgres;
```

## Endpoints

After deployment, see table with sample users under following endpoint:

```
http://localhost:8080/hibernate-examples-1.0.0-SNAPSHOT/
```
