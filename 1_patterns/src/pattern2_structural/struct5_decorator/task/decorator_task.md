# Задание

Вы разрабатываете приложение для управления заказами в кофейне. Клиенты могут заказывать различные виды кофе и добавлять
к ним различные дополнения, такие как молоко, сахар, сиропы, взбитые сливки и т.д. Каждое дополнение увеличивает
стоимость напитка и добавляет описание.

Чтобы обеспечить гибкость и расширяемость системы, необходимо применить паттерн **Декоратор**, позволяющий динамически
добавлять новые виды дополнений без изменения существующих классов базовых напитков.

## Требования

- **Определение Базового Компонента:** Создайте интерфейс ```Beverage```, который будет определять
  методы ```getDescription()``` и ```cost()```.
- **Реализация Конкретных Компонентов:** Создайте классы конкретных напитков (
  например, ```Espresso```, ```Latte```, ```Cappuccino```), реализующих интерфейс ```Beverage```. Каждый напиток должен
  иметь своё базовое описание и стоимость.
- **Определение Абстрактного Декоратора:** Создайте абстрактный класс ```CondimentDecorator```, который также реализует
  интерфейс ```Beverage``` и содержит ссылку на объект ```Beverage```.
- **Реализация Конкретных Декораторов:** Создайте классы конкретных дополнений (
  например, ```Milk```, ```Sugar```, ```CaramelSyrup```, ```WhippedCream```), наследующиеся от ```CondimentDecorator```.
  Каждый декоратор должен добавлять своё описание и стоимость к базовому напитку.

Для проверки используйте класс [CoffeeShopMain](CoffeeShopMain.java)

### Время 10-15 минут