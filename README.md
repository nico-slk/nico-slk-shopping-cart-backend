# Bienvenido a la aplicación CartShop en su aplicacion Backend

## Links

### Configurar DB

Para empezar, se debe configurar la base de datos utilizando MYSQL. Para eso, utiliza tu aplicación favorita para crear una base de datos utilizando "CREATE DATABASE database-name" donde podes reemplazar "database-name" por el nombre de base datos que elijas.

Luego de crear la base de datos, en el archivo "~/shopping-cart-backend\src\main\resources\application.properties" y cambia las propiedades
```
spring.datasource.username= <tu usuario de MySQL>
spring.datasource.password= <tu contraseña de MySQL>
spring.datasource.url=jdbc:mysql://localhost:<puerto de tu base de datos>/<nombre de tu DB> 
```

Una vez hecho esto, corre la aplicacion. Las tablas se crearán automaticamente.
Si tu aplicacion no genera ningun error, vas a poder crear los primeros registros.

# Entidades

1. [Entidad usuario](#entidad-usuario).
2. [Entidad producto](#entidad-product).
3. [Entidad carrito](#entidad-carrito).
4. [Entidad fecha especial](#entidad-fecha-especial).

## Entidad usuario

Utilizando POSTMAN o similar, para la entidad "User" vas a conar con 3 endpoints:

Para crear usuarios:
```
POST localhost:8090/api/user/prod
```
Te permite crear usuarios para poder hacer las pruebas que deseas.
Se recomienda crear dos registros de usuario con los siguientes BODYs:
```
{
    "username": "common",
    "vip": false
}
```
```
{
    "username": "vip",
    "vip": true
}
```
Para obtener el usuario por el nombre, el cual recibe por PARAM, el nombre del usuario solicitado:
```
GET localhost:8090/api/user/:name
```
Para obtener una lista de usuarios:
```
GET localhost:8090/api/user/prod
```



## Entidad product

Utilizando POSTMAN o similar, para la entidad "Product" vas a conar con 2 endpoints:

Para crear productos:
```
POST localhost:8090/api/product/prod
```
Te permite crear productos para poder hacer las pruebas que deseas.
El formato del registro de producto es del siguiente formato:
```
{
    "name" : "NOMBRE DEL PRODUCTO",
    "image": "https://i.ibb.co/17zs5XY/14.webp",
    "price": 400
}
```
Para obtener el listado de todos los productos
```
GET localhost:8090/api/product/all
```

## Entidad carrito

Utilizando POSTMAN o similar, para la entidad "Cart" vas a conar con 2 endpoints:

Para crear carritos:
```
POST localhost:8090/api/cart/
```
Te permite crear carritos para poder finalizar la compra.
El formato del registro de carritos es del siguiente formato:
```
{
    "date" : "13/7/2024, 02:24:50",
    "bonification": 500,
    "totalSpended": 800,
    "userId": "73a39d04-33bc-4a63-9f88-62b2e4d9f1f2",
    "productList": [
        {
            "name" : "NOMBRE DEL PRODUCTO",
            "image": "https://i.ibb.co/17zs5XY/14.webp",
            "price": 400
        },
        {
            "name" : "NOMBRE DEL PRODUCTO",
            "image": "https://i.ibb.co/17zs5XY/14.webp",
            "price": 400
        }
    ]
}
```
Para obtener el listado de todos los carritos para hacer pruebas de desarrollo:
```
GET localhost:8090/api/cart/prod
```

## Entidad Fecha Especial

Utilizando POSTMAN o similar, para la entidad "Special Date" vas a conar con 2 endpoints:

Para crear Fecha Especial:
```
POST localhost:8090/api/date/
```
Te permite crear fechas especiales para poder hacer las pruebas.
Ten en cuenta que crea la fecha especial entre el valor de "startDate" hasta 1 mes despues.
El formato del registro de carritos es del siguiente formato:
```
{
    "startDate": "17/6/2024, 01:00:00",
    "name": "Dia especial"
}
```

Para obtener el listado de todos las fechas especiales para hacer pruebas de desarrollo:
```
GET localhost:8090/api/date/
```

*Recorda que debes mantener el servidor corriendo al momento de levantar el frontend y crear entidades para hacer las pruebas en el frontend.*

[Repositorio frontend](https://github.com/nico-slk/nico-slk-shopping-cart-frontend/)


#