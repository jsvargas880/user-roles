# Java-UserRoles

## Prerequisites
- Java 17 or greater

## H2 database

### Dependencies

```xml
<dependency>
<groupId>com.h2database</groupId>
<artifactId>h2</artifactId>
<scope>runtime</scope>
</dependency>
```

### Properties
```yaml
#
# h2 database
#
spring.datasource.url= jdbc:h2:mem:test
spring.datasource.driverClassName= org.h2.Driver
spring.datasource.username= sa
spring.datasource.password=
spring.jpa.database-platform= org.hibernate.dialect.H2Dialect
spring.h2.console.enabled= true
spring.jpa.hibernate.ddl-auto=create
```
