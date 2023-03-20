# OnDoor API

An API to manage the OnDoor delivery app.

# Endpoints

- Customer
    - [sign in](#customer-sign-in)
    - [find all orders by customer ID](#find-all-customer-orders-by-customer-id)
- Restaurant
    - [find by name](#find-restaurant-by-name)
    - [find all productDTOS](#find-all-productDTOS-in-restaurant)
    - [find productDTOS by name](#find-all-productDTOS-from-the-restaurant-by-their-names)
    - [find productDTOS by categoryDTO](#find-restaurant-productDTOS-by-categoryDTO)
- Cart
    - [add productDTOS by ID](#add-productDTOS-in-customer-cartDTO-by-productDTOS-id)
    - [find all productDTOS](#find-all-productDTOS-in-customer-cartDTO)
    - [delete productDTOS by id](#delete-productDTOS-by-id-in-customer-cartDTO)
- Order
    - [create](#create-order)

----

# Customer Service

## Customer sign in

'POST' ondoor/login

| Attribute | type | mandatory | desc
|-------|------|:-------------:|---
|email | String | yes | The customer email should be in the email paramethers
|password | String | yes | The customer password should have less than 11 characters

**Request body example**

```js
{
    email: 'juquinhagameplays@hotmail.com',
    password: 'gostodebolo123',
}
```

**HTTP responses**

| code | desc
|-|-
| 202 | Sign in sucessfully
| 400 | invalid data
----

## Find all customer orders by customer ID

'GET' ondoor/customer/{customer_id}/orders

**Response body example**

```js
[  
    {    
    "id": 1,    
    "data": "2023-02-11",   
     "produtos": [      
       {
        "id": 1004,
        "nome": "Produto D",
        "quantidade": 3
      },
      {
        "id": 1005,
        "nome": "Produto E",
        "quantidade": 2
      }
    ]
  },
  {
    "id": 2,
    "data": "2023-02-10",
    "produtos": [
      {
        "id": 1004,
        "nome": "Produto D",
        "quantidade": 3
      },
      {
        "id": 1005,
        "nome": "Produto E",
        "quantidade": 2
      }
    ]
  },
  {
    "id": 3,
    "data": "2023-02-09",
    "produtos": [
      {
        "id": 1006,
        "nome": "Produto F",
        "quantidade": 4
      },
      {
        "id": 1007,
        "nome": "Produto G",
        "quantidade": 1
      },
      {
        "id": 1008,
        "nome": "Produto H",
        "quantidade": 6
      }
    ]
  }
]

```

**HTTP responses**

| code | desc
|-|-
| 200 | order data returned
| 404 | there is no order with the given customer id

----

# Restaurant Service

## Find restaurant by name

'GET' ondoor/restaturant/name={restaurant_name}

| Attribute | type | mandatory | desc
|-------|------|:-------------:|---
|restaurant_name | String | yes | The request will search for the restaurants that contains the name

**Response body example**

```js
    [
  {
    "name": "Restaurante A",
    "image": "https://example.com/images/restaurant_a.jpg",
    "rating": 4.2,
    "open": true
  },
  {
    "name": "Restaurante B",
    "image": "https://example.com/images/restaurant_b.jpg",
    "rating": 3.7,
    "open": false
  },
  {
    "name": "Restaurante C",
    "image": "https://example.com/images/restaurant_c.jpg",
    "rating": 4.9,
    "open": true
  },
  {
    "name": "Restaurante D",
    "image": "https://example.com/images/restaurant_d.jpg",
    "rating": 3.5,
    "open": true
  },
  {
    "name": "Restaurante E",
    "image": "https://example.com/images/restaurant_e.jpg",
    "rating": 4.1,
    "open": false
  },
  {
    "name": "Restaurante F",
    "image": "https://example.com/images/restaurant_f.jpg",
    "rating": 4.7,
    "open": true
  }
]
```
**HTTP responses**

| code | desc
|-|-
| 200 | restaurant data returned
| 404 | there is no restaurant with the given name
----

## Find all productDTOS from the restaurant by their names

'GET' ondoor/restaurant/{restaurant_id}/productDTOS/name="product_name"

| Attribute | type | mandatory | desc
|-------|------|:-------------:|---
|product_name | String | yes | The request will search for the productDTOS in the restaurant that contains the name

**Response body example**

```js
{
  "restaurants": [
    {
      "name": "Burger Joint",
      "addressDTO": "123 Main St",
      "image": "https://example.com/images/burger_joint.jpg",
      "rating": 4.5,
      "productDTOS": [
        {
          "name": "Classic Burger",
          "price": 9.99,
          "image": "https://example.com/images/classic_burger.jpg"
        },
        {
          "name": "Fries",
          "price": 2.99,
          "image": "https://example.com/images/fries.jpg"
        }
      ]
    },
    {
      "name": "Pizza Palace",
      "addressDTO": "456 Elm St",
      "image": "https://example.com/images/pizza_palace.jpg",
      "rating": 4.2,
      "productDTOS": [
        {
          "name": "Pepperoni Pizza",
          "price": 12.99,
          "image": "https://example.com/images/pepperoni_pizza.jpg"
        },
        {
          "name": "Garlic Knots",
          "price": 4.99,
          "image": "https://example.com/images/garlic_knots.jpg"
        }
      ]
    },
    {
      "name": "Sushi House",
      "addressDTO": "789 Oak St",
      "image": "https://example.com/images/sushi_house.jpg",
      "rating": 4.8,
      "productDTOS": [
        {
          "name": "California Roll",
          "price": 8.99,
          "image": "https://example.com/images/california_roll.jpg"
        },
        {
          "name": "Edamame",
          "price": 3.99,
          "image": "https://example.com/images/edamame.jpg"
        }
      ]
    }
  ]
}

```

**HTTP responses**

| code | desc
|-|-
| 200 | restaurant data returned
| 404 | there is no restaurant with the given name or there is no productDTOS with the gived name
----

## Find all productDTOS in restaurant

'GET' ondoor/restaturant/{restaurant_id}/prods

**Response body example**

```js 
{
  "restaurant": {
    "name": "Restaurante do Zé",
    "productDTOS": [
      {
        "name": "Pizza de Calabresa",
        "price": 30.00,
        "categoryDTO": "Pizzas"
      },
      {
        "name": "Lasanha Bolonhesa",
        "price": 25.00,
        "categoryDTO": "Massas"
      },
      {
        "name": "Churrasco Misto",
        "price": 40.00,
        "categoryDTO": "Carnes"
      },
      {
        "name": "Salada Caesar",
        "price": 20.00,
        "categoryDTO": "Saladas"
      }
    ]
  }
}
```

**HTTP responses**

| code | desc
|-|-
| 200 | Data from restaurant returned
| 404 | There is no productDTOS in restaurant
----

## Find restaurant productDTOS by categoryDTO

'GET' ondoor/restaurant/productDTOS?categoryDTO={find productDTOS by categoryDTO}

| Attribute | type | mandatory | desc
|-------|------|:-------------:|---
|product_category | String | yes | Will search for the product contains that contains at the restaurants by categoryDTO

**Response body example**

```js
[
  {
    "categoryDTO": "Entradas",
    "productDTOS": 
    [
      {
        "id": 1,
        "name": "Bolinho de bacalhau",
        "price": 12.50,
        "description": "Porção com 6 bolinhos de bacalhau frito."
      },
      {
        "id": 2,
        "name": "Carpaccio de carne",
        "price": 18.90,
        "description": "Finas fatias de carne crua com molho de mostarda e alcaparras."
      }
    ]
  }
]
```
**HTTP responses**

| code | desc
|-|-
| 200 | Producs data returned
| 404 | There is no productDTOS in that categoryDTO
----

# Cart Service

## Add productDTOS in customer cartDTO by productDTOS id

'POST' ondoor/cartDTO/{customer_id}/productDTOS/add

| Attribute | type | mandatory | desc
|-------|------|:-------------:|---
|product_ids | List | yes | Will find the productDTOS in data bank and add they in the customer cartDTO

## Request body example

````js

{
  "product_ids": [
    "12345",
    "67890",
    "24680",
    "13579"
  ]
}
````
**HTTP responses**

| code | desc
|-|-
| 201 | Producs addedd to customer cartDTO
| 400 | Wrong data format
----

## Find all productDTOS in customer cartDTO

'GET' ondoor/cartDTO/{customer_id}/productDTOS

**Response body example**

````js
{
  "cart_id": "12345",
  "items": [
    {
      "name": "Product A",
      "price": 10.99,
      "quantity": 2,
      "description": "Lorem ipsum dolor sit amet"
    },
    {
      "name": "Product B",
      "price": 5.99,
      "quantity": 1,
      "description": "Consectetur adipiscing elit"
    },
    {
      "name": "Product C",
      "price": 15.99,
      "quantity": 3,
      "description": "Sed do eiusmod tempor incididunt"
    }
  ]
}
````
**HTTP responses**

| code | desc
|-|-
| 200 | Producs returned
| 404 | 
----

## Delete productDTOS by id in customer cartDTO

'DELETE' ondoor/cartDTO/{customer_id}/productDTOS/{product_id}/del

**HTTP responses**

| code | desc
|-|-
| 204 | Product deleted
| 404 | There is no product with given id
----

# Order Service

## Create order

'POST' ondoor/order/{customer_id}

**Request body example**

```js

{
  "id": 123,
  "created_at": "2022-02-15T10:30:00Z",
  "customer": {
    "id": 456,
    "name": "João da Silva",
    "email": "joao.silva@example.com",
    "addressDTO": {
      "street": "Rua dos Bobos",
      "number": "0",
      "city": "São Paulo",
      "state": "SP",
      "country": "Brasil",
      "zipcode": "01234-567"
    }
  },
  "payment_method": "credit_card",
  "total_amount": 35.75,
  "productDTOS": [
    {
      "id": 1,
      "name": "Pizza de Calabresa",
      "price": 22.50,
      "quantity": 1,
      "description": "Pizza de calabresa com mussarela"
      "image": "https://example.com/pizza-calabresa.jpg"
    },
    {
      "id": 2,
      "name": "Hambúrguer",
      "price": 8.25,
      "quantity": 2,
      "description": "Hambúrguer artesanal com queijo, alface e tomate",
      "image": "https://example.com/hamburguer.jpg"
    },
    {
      "id": 3,
      "name": "Batata Frita",
      "price": 4.00,
      "quantity": 1,
      "description": "Porção de batata frita crocante",
      "image": "https://example.com/batata-frita.jpg"
    }
  ]
}
````

**HTTP responses**

| code | desc
|-|-
| 201 | Order created
| 400 | Bad data given

----
