Строитель (Билдер) — это порождающий паттерн проектирования,
который позволяет создавать сложные объекты пошагово.
Строитель даёт возможность использовать один и тот же
код строительства для получения разных представлений
объектов.

Почему то билдер не очень любят, но на самом деле у него есть много
хороших применений:
- Разбиение гиганского конструктора на отдельные шаги.
- Вариация шагов при создани объекта.
- За счет разных версий строителя может достигаться разный набор параметров в объекте,
    как в примере с домом в книге Швеца: дом из дерева и стекла, бетона и стекла, золота и алмазов
- Использование параметров по умолчанию (т.к. Java такого не умеет)

Суть:
Выносим создание гиганского объекта в другой класс и делаем это по шагам.

В примере из книги Швеца (см. diagram.png) также указан класс директора, но это не обязательно.
Зачастую никакого директора вы не увидете.

Простой и глупый пример билдера: StringBuilder, при помощи которого мы создаем
строку по шагам - прибавляя каждый раз несколько символов.

Билдеры бывают внешние - отдельный класс во вне и внутрение - статический вложенный класс.
Внешний билдер есть в книге Швеца. Обратите там ВНИМАНИЕ на метод reset(), а также использование интерфейсов.

В книге Olaf Musch (en) есть пример использование билдера для создание деревьев, деревьев XML и HTML

В качестве примера я приведу внутренний билдер с заданием параметров по умолчанию.