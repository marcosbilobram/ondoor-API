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
    - find products by name
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

