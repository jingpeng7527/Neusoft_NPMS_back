# Neusoft_NPMS_back

NPMS (Neusoft Profit Management System) is a comprehensive solution that facilitates end-to-end project management, enabling the tracking of sales opportunities, maintenance of customer information, and efficient monitoring of project plans, costs, and progress.

> [!NOTE]
> This is the back-end code for NPMS by Vue.js

- Our project uses MySQL database, based on distributed microservices development architecture, front-end discover service through gateway, by oauth2 for permission verification. 
- The front-end and back-end are separated, and the back-end is separated from the controller, service and mapper layers. 
- Data is design to VO and PO.

Here is the report link: https://docs.google.com/document/d/1Dk7BO98VCzDQon8uYApZlOEd6bsuBXG3/edit?usp=sharing&ouid=101884265629727065347&rtpof=true&sd=true

## Relevant Technologies![image](https://github.com/jingpeng7527/Neusoft_NPMS_back/assets/114365503/d55e2347-76d0-47db-9240-4d5517267cc0)
<img width="415" alt="image" src="https://github.com/jingpeng7527/Neusoft_NPMS_back/assets/114365503/42502f30-3176-41b6-b4fe-c2b75c571798">

<img width="416" alt="image" src="https://github.com/jingpeng7527/Neusoft_NPMS_back/assets/114365503/4d991dab-d8c0-4db4-be02-2cfcc7826014">


- Front-end: vue, vutify, axois, vuex, rabbitmq, mqtt, H5 app
- Back-end: Spring cloud, redis, spring boot, mybatis, mybatisplus, spring cloud gateway, nacos, oauth2, spring security, JWT, Mysql
- Cloud server: nginx, tomcat, docker
- Development Tools: Maven, git, intellij IDEA, vscode, xshell, postman, navicat
- Development Environment: Java 8, node.js, Mysql 8.0, deployed on cloud server
  


## We divide the system into the following 7 functional modules. 
1. **Customer management module**, in addition to the basic operation of adding, modifying, deleting and updating customers, the relationship between customers and clients can be added, such as A is the parent company of B. The customer can be handed over to A account manager to B account manager.
2. **Opportunity management module**, in addition to adding, modifying, deleting and updating the opportunity, the vice president of marketing, sales director and other people need to approve the opportunity. Client manager's modification of opportunity information may also trigger approval 
3. **Sales log management**, client manager to record sales daily, user can add, modify, delete operations 
4. **Opportunity tracking record module**, the progress of the opportunity, multi-party talks and other information to track 
5. **Nacos registration center**, used to register all the micro services started 
6. **Oauth2 permission management center**, Assign a token to the logged-in user, the front-end carries the token to request the interface, and the back-end verifies the token to determine whether the user has permission to call the interface.
7. **Gateway service**, all the front-end interfaces access the same interface through the gateway, and the gateway forwards requests for the actual service.




### API: https://shimo.im/docs/m8AZVeQ0emtplVAb
