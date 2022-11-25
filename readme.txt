start in port 8189
для просмотра консоли бд h2 набираем
http://localhost:8189/geek/h2-console
API:
выводим все продукты:
http://localhost:8189/app/products

Получаем товар по id = 1
http://localhost:8189/app/products/1

Для добавления товара:
POST http://localhost:8189/app/products
+ json:
{
    "title": "Pen",
    "cost": "50"
}

Удаление
1 Get:
http://localhost:8189/app/products/delete/20
2 Delete query
http://localhost:8189/app/products
RequestParam(name = "id")

Search by cost between
http://localhost:8189/app/products/cost_between?min=100&max=1000

Search by cost greater than 1000
http://localhost:8189/app/products/cost_greater?cost=1000

Search by cost less than 1000
http://localhost:8189/app/products/cost_less?cost=1000

