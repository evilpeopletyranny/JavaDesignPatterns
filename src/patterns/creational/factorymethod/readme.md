Фабричный метод — это порождающий паттерн
проектирования, который определяет общий интерфейс для
создания объектов в суперклассе, позволяя подклассам
изменять тип создаваемых объектов.

Паттерн Фабричный метод предлагает создавать объекты
не напрямую, используя оператор new , а через вызов
особого фабричного метода.

На первый взгляд, это может показаться бессмысленным
— мы просто переместили вызов из одного конца
программы в другой. Но теперь вы сможете
переопределить фабричный метод в подклассе, чтобы
изменить тип создаваемого продукта.
Чтобы эта система работала, все возвращаемые объекты
должны иметь общий интерфейс. Подклассы смогут
производить объекты различных классов, следующих
одному и тому же интерфейсу

см. diagram.png

Плюсы:
- Избавляет класс от привязки к конкретным классам
  продуктов.
- Выделяет код производства продуктов в одно место,
  упрощая поддержку кода.
- Упрощает добавление новых продуктов в программу.
- Реализует принцип открытости/закрытости.

Минусы:
- Приводит к раздутию кода.
- Зачастную содержит 2 паралелльные растущие иерархии.
- Требует реализации класс создателя для каждого нового типа продукта.

Сравнение с Абстракной фабрикой:

абстрактная фабрика создает унифицированные семейства продуктов, в то время как метод фабрики создает только один продукт

Абстрактная фабрика основана на композиции объектов, фабричный метод - на наследовании

Устранение if'ов / switch'ей, необходимо лишь выбрать нужнный подкласс для реализации

Фабричный метод проще Абстрактной фабрики. Зачастую всю начинается с фабричного метода, а затем перерастает в абстрактную фабрику
