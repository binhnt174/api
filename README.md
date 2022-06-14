
# Spring Boot, MySQL, JPA, Rest API

Build Restful CRUD API for a blog using Spring Boot, Mysql, JPA and Hibernate.

## Steps to Setup

**1. Clone the application**

```bash
git clone https://github.com/binhnt174/api.git
```

**2. Create Mysql database**
```bash
create database work
```

**3. Change mysql username and password as per your installation**

+ open `src/main/resources/application.properties`
+ change `spring.datasource.username` and `spring.datasource.password` as per your mysql installation

**4. Run the app using maven**

```bash
mvn spring-boot:run
```
The app will start running at <http://localhost:8080>

## Explore Rest APIs

The app defines following CRUD APIs.

### API

| Method | Url | Decription | Sample Valid Request Body | 
| ------ | --- | ---------- | --------------------------- |
| GET    | /api/list/{page} | list work |
| POST   | /api/add         | add list work |
| POST   | /api/update      | update list work |
| POST   | /api/delete      | delete work|



## Sample Valid JSON Request Bodys

##### <a id="Add">Add-> /api/add</a>
```json
{
  "listWork02Dto":
  [
    {
      "workName": "Coding",
      "status": "DOING",
      "startDt": "2022-05-31T17:00:00.000+00:00",
      "endDt": "2022-06-01T17:00:00.000+00:00"
    }
  ]
}
```

##### <a id="Update">Update-> /api/update</a>
```json
{
  "listWork01Dto":
  [
    {
      "workId": 1,
      "workName": "Coding",
      "status": "DOING",
      "startDt": "2022-05-31T17:00:00.000+00:00",
      "endDt": "2022-06-01T17:00:00.000+00:00"
    }
  ]
}
```

##### <a id="Delete">Delete -> /api/delete</a>
```json
{
  "listDel":[7,8]
}
```

