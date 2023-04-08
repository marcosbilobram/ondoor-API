# OnDoor API

An API to manage the OnDoor delivery app.

# Endpoints

- Customer
    - [sign in](#customer-sign-in)
    - [find all orders by customer ID](#find-all-customer-orders-by-customer-id)
- Restaurant
    - [find by name](#find-restaurant-by-name)
    - [find all products](#find-all-products-in-restaurant)
    - [find products by name](#find-all-products-from-the-restaurant-by-their-names)
    - [find products by category](#find-restaurant-products-by-category)
- Cart
    - [add products by ID](#add-products-in-customer-cart-by-products-id)
    - [find all products](#find-all-products-in-customer-cart)
    - [delete products by id](#delete-products-by-id-in-customer-cart)
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

## Find all products from the restaurant by their names

'GET' ondoor/restaurant/{restaurant_id}/products/name="product_name"

| Attribute | type | mandatory | desc
|-------|------|:-------------:|---
|product_name | String | yes | The request will search for the products in the restaurant that contains the name

**Response body example**

```js
{
  "restaurants": [
    {
      "name": "Burger Joint",
      "address": "123 Main St",
      "image": "https://example.com/images/burger_joint.jpg",
      "rating": 4.5,
      "products": [
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
      "address": "456 Elm St",
      "image": "https://example.com/images/pizza_palace.jpg",
      "rating": 4.2,
      "products": [
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
      "address": "789 Oak St",
      "image": "https://example.com/images/sushi_house.jpg",
      "rating": 4.8,
      "products": [
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
| 404 | there is no restaurant with the given name or there is no products with the gived name
----

## Find all products in restaurant

'GET' ondoor/restaturant/{restaurant_id}/prods

**Response body example**

```js 
{
  "restaurant": {
    "name": "Restaurante do Zé",
    "products": [
      {
        "name": "Pizza de Calabresa",
        "price": 30.00,
        "category": "Pizzas"
      },
      {
        "name": "Lasanha Bolonhesa",
        "price": 25.00,
        "category": "Massas"
      },
      {
        "name": "Churrasco Misto",
        "price": 40.00,
        "category": "Carnes"
      },
      {
        "name": "Salada Caesar",
        "price": 20.00,
        "category": "Saladas"
      }
    ]
  }
}
```

**HTTP responses**

| code | desc
|-|-
| 200 | Data from restaurant returned
| 404 | There is no products in restaurant
----

## Find restaurant products by category

'GET' ondoor/restaurant/products?category={find products by category}

| Attribute | type | mandatory | desc
|-------|------|:-------------:|---
|product_category | String | yes | Will search for the product contains that contains at the restaurants by category

**Response body example**

```js
[
  {
    "category": "Entradas",
    "products": 
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
| 404 | There is no products in that category
----

# Cart Service

## Add products in customer cart by products id

'POST' ondoor/cart/{customer_id}/products/add

| Attribute | type | mandatory | desc
|-------|------|:-------------:|---
|product_ids | List | yes | Will find the products in database and add they in the customer cart

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
| 201 | Producs addedd to customer cart
| 400 | Wrong data format
----

## Find all products in customer cart

'GET' ondoor/cart/{customer_id}/products

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

## Delete products by id in customer cart

'DELETE' ondoor/cart/{customer_id}/products/{product_id}/del

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
    "address": {
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
  "products": [
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
