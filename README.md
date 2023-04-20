# Sakila Web API using JAX-RS and JAX-WS

This project implements a web API that exposes resources using both RESTful (JAX-RS) and SOAP-based (JAX-WS) web services.


## 🏛️ Architecture
![image](project%20structure.png)


## 💾 Database Schema
You can see database Schema here: [Schema](sakila.png)


##  ⚙️ Technologies used
* JAX-RS (Jersey)
* JAX-WS (Metro)
* Maven
* Tomcat
* Lombok
* MapStruct
* JPA
* MYSQL
* Postman
* SOAP-UI

# Sample REST Endpoints
| Endpoints                               | Method |                                      Notes |
|-----------------------------------------|:-------|-------------------------------------------:|
| /actors/                                | GET    |                             Get all Actors |
| /actors/                                | POST   |                              Create  Actor |
| /actors/{actorId}                       | GET    |                         Get a single Actor |
| /actors/{actorId}                       | PUT    |                             Edit the Actor |
| /actors/{actorId}/films                 | GET    |          Get all films of a specific actor |
| /actors/{actorId}/films/{filmId}/details | GET    | GET details about film of a specific actor |



# 👨‍💻 Documentation
* 📃 [ Postman RESTful Api Docs ](https://documenter.getpostman.com/view/17178810/2s93Y2SMVz)[](https://www.postman.com/interstellar-meadow-495201/workspace/sakila-development/overview)
* 📃 [Soap-UI Docs](Sakila-soapui-project.xml)

# Requirements
* JDK 11 or higher
* Apache Tomcat 9 or higher
* Maven 3 or higher
* Sakila database


# 🛠️ Installation
### Clone Repository
`git clone https://github.com/a7med-m7md/Sakila-Web-API`
### Configure Database Connection Settings
Before you can use the Sakila Web API Services, you need to configure the database connection settings. The database connection settings are defined in the `persistence.xml` file.

```<property name="jakarta.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/sakila" />
<property name="jakarta.persistence.jdbc.user" value="username" />
<property name="jakarta.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver" />
<property name="jakarta.persistence.jdbc.password" value="password" />
```


### Maven
* You can import sample Sakila MySQL database [download](https://downloads.mysql.com/docs/sakila-db.zip)
* Change the configuration of tomcat in `pom.xml`
* Deploy the application in tomcat `mvn clean compile tomcat7:redeploy`


## ✍️ Author
* [Ahmed Mohamed El-Sherbini](https://github.com/a7med-m7md)


## License
```
Copyright 2023 Jinseong Ha

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

