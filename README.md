# Minio Console API
Easy to use Java Client for the Minio Console API, allowing to manage buckets, users, groups and policies

## Usage
```java
MinioConsoleAPI api = new MinioConsoleAPI("http://localhost:9090");
api.login("YOUR_ACCESS_KEY", "YOUR_SECRET_KEY");
for(User user : api.getUsers())
    System.out.println(user.getAccessKey());
```

## Maven
```xml
<repositories>
    <repository>
        <id>bebendorf</id>
        <url>https://repo.bebendorf.eu</url>
    </repository>
</repositories>
```
```xml
<dependency>
    <groupId>eu.bebendorf</groupId>
    <artifactId>MinioConsoleAPI</artifactId>
    <version>1.0.0</version>
</dependency>
```

## About MinIO
*This project isn't affiliated with MinIO in any way.*  
  
[MinIO](https://github.com/minio/minio) is an open source s3 compatible object storage server  
[MinIO Console](https://github.com/minio/console) is a web ui for managing minio server and provides a http management api