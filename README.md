# About

Projetc to create Web Services with Spring Boot and JPA/Hibernate design by Nelio Alves in course "Java Completo" on udemy plataform

## Clone repository
Open terminal and enter the commands
```
mkdir springcourse
cd springcourse
git clone git@github.com:gui-costads/springcourse.git
```
## Run project
```
./mvnw spring-boot:run

```
## Install Postman
[Postman](https://www.postman.com/downloads/)

## Test features in Postman
### Users
localhost:8080/users

Methods: 
 - get all  
 - get by id
 - update by id
 - delete by id
```
  {
    "id": 1,
    "name": "maria",
    "email": "maria@gmail",
    "phone": "987612736273",
    "password": "12356"
  }
```

### Categories
localhost:8080/categories

Methods: 
 - get all  
 - get by id
 
```
 {
    "id": 1,
    "name": "Books"
}
```

### Products
localhost:8080/products

Methods: 
 - get all  
 - get by id
```
 {
    "id": 1,
    "name": "The Lord of the Rings",
    "description": "Lorem ipsum dolor sit amet, consectetur.",
    "price": 90.5,
    "imgUrl": "",
    "categories": [
        {
            "id": 2,
            "name": "Computers"
        }
    ]
}
```

### Orders
localhost:8080/orders

Methods: 
 - get all  
 - get by id
```
 {
   "id": 1,
    "instant": "2023-03-26T20:03:30Z",
    "orderStatus": "PAID",
    "client": {
        "id": 1,
        "name": "maria",
        "email": "maria@gmail",
        "phone": "987612736273",
        "password": "12356"
    },
    "items": [
        {
            "quantity": 2,
            "price": 90.5,
            "product": {
                "id": 1,
                "name": "The Lord of the Rings",
                "description": "Lorem ipsum dolor sit amet, consectetur.",
                "price": 90.5,
                "imgUrl": "",
                "categories": [
                    {
                        "id": 2,
                        "name": "Computers"
                    }
                ]
            },
            "subTotal": 181.0
        },
        {
            "quantity": 1,
            "price": 1250.0,
            "product": {
                "id": 3,
                "name": "Macbook Pro",
                "description": "Nam eleifend maximus tortor, at mollis.",
                "price": 1250.0,
                "imgUrl": "",
                "categories": [
                    {
                        "id": 3,
                        "name": "Eletronics"
                    }
                ]
            },
            "subTotal": 1250.0
        }
    ],
    "payment": {
        "id": 1,
        "instant": "2023-03-26T22:03:30Z"
    },
    "total": 1431.0
}
```

## Built with

[![My Skills](https://skillicons.dev/icons?i=java,spring,postman,maven&theme=light)](https://skillicons.dev)
