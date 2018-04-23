# spring-boot-microservices-async
A barebone tutorial on how to use spring boot microservices in async mode. The project uses active-mq for communication between order-management and order-fullfillment. 
Currently, there is just one way path from order-management and order-fullfillment. 
Post to /orders end point sends a transactional message to the Order-fullfillment service and also persists in the order-management database. 

## Sample input: 

{
"name" : "test_order25",
"orderNumber" : "ORD_0013",
"quantity": 10,
"orderId" : "1"
}

### Issues with the applications

Both the applications have Netflix stack bundled. These services try to use eureka for registration and discovery. Since, the discovery server and the registration server is not available, the applications throw relevant exceptions. 
However, these exceptions do not have any impact on the functionality. 
If you still need to use the netflix stack, please follow my other tutorial [spring-boot-microservices](https://github.com/sushant3k/spring-boot-microservices.git "spring boot microservices with netflix stack"). 


