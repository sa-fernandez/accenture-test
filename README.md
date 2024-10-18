# Accenture Test
Resultados de la prueba para el puesto de Desarrollador Backend. 

## Pasos previos

Se debe modificar la ruta y credenciales de la base de datos MySQL utilizada para que el programa se ejecute correctamente. 

Esta se encuentra en el archivo:

```sh
application.properties
```

Es importante resaltar que el modelo y los datos de prueba se encuentran en la carpeta:

```sh
/data
```

## Funcionamiento

El servidor ejecuta por medio del siguiente comando:

```sh
.\mvnw spring-boot:run
```

## Endpoints
| Request Type | Endpoints | Body | Params |
| ------ | ------ | ------ | ------ |
| POST | `/api/branch/product_to_branch` | `{ "branchId": 1, "productName": "Product A", "productStock": 50 }` |  |
| PATCH | `/api/branch/name` | `{ "id": 1, "name": "New Branch Name" }` |  |
| POST | `/api/franchise/` | `{ "name": "New Franchise" }` |  |
| POST | `/api/franchise/branch_to_franchise` | `{ "franchiseId": 1, "branchName": "New Branch" }` |  |
| GET | `/api/franchise/max_stock_per_branch/{id_franchise}` |  | `id_franchise` |
| PATCH | `/api/franchise/name` | `{ "id": 1, "name": "Updated Franchise Name" }` |  |
| PATCH | `/api/product/stock` | `{ "id": 1, "stock": 100 }` |  |
| PATCH | `/api/product/name` | `{ "id": 1, "name": "Updated Product Name" }` |  |