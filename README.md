# OnDoor API

An API to manage the OnDoor delivery app.

## Endpoints

- Customer
    - sign in
    - find all orders by customer ID
- Restaurant
    - find by name
    - find products by name
    - find all products
    - find products by category
- Cart
    - add products by ID
    - find all products
    - delete products by id
- Order
    - create
    - delete

----

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

| Attribute | type | mandatory | desc
|-------|------|:-------------:|---
|customer_id | Long | yes | The customer id will search for the orders

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

## Find restaurant by name

'GET' ondoor/restaturant/name={restaurant_name}

| Attribute | type | mandatory | desc
|-------|------|:-------------:|---
|restaurant_name | String | yes | The name will search for the restaurants that contains the name

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

## Find products name

'GET' ondoor/restaturant/name={find products by name}

| Attribute | type | mandatory | desc
|-------|------|:-------------:|---
|product_name | String | yes | 

```js
{
  "products": [
    {
      "id": 1,
      "name": "Biscoito",
      "price": 5.80
    },
    {
      "id": 3,
      "name": "Esfiha",
      "price": 10.50
    }
  ]
}
```
**HTTP responses**

| code | desc
|-|-
| 200 | 
| 404 |
----

## Find all products

'GET' ondoor/restaturant/products?name={find all products}

| Attribute | type | mandatory | desc
|-------|------|:-------------:|---
|product_name | String | yes | Will search for the all product available contains that contains at the restaurants

```js
{
   "products": [
      {
         "id": "1",
         "name": "Hambúrguer",
         "description": "Pão, hambúrguer de carne, queijo, alface, tomate e maionese",
         "price": 15.99,
         "restaurant": "Burger King"
      },
      {
         "id": "5",
         "name": "Batata Frita",
         "description": "Batatas fritas crocantes",
         "price": 7.99,
         "restaurant": "Burger King"
      },
      {
         "id": "8",
         "name": "Refrigerante",
         "description": "Coca-Cola gelada",
         "price": 4.99,
         "restaurant": "Burger King"
      }
   ]
}
```
**HTTP responses**

| code | desc
|-|-
| 200 | 
| 404 |
----

## Find products by category

'GET' ondoor/restaurant/products?category={find products by category}

| Attribute | type | mandatory | desc
|-------|------|:-------------:|---
|product_category | String | yes | Will search for the product contains that contains at the restaurants by category

```js
    [
{
  "category": "Entradas",
  "products": [
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
```
**HTTP responses**

| code | desc
|-|-
| 200 | 
| 404 |
----

## Cart add product by id


