# Введение в многопоточность

# Основные понятия

## Поток

**Поток** — это наименьшая единица обработки, которая может быть запланирована операционной системой. Потоки существуют
внутри процессов и разделяют одно и то же пространство адресов и ресурсы процесса. Это позволяет потокам обмениваться
данными более эффективно, чем между процессами, но требует тщательного управления доступом к общим ресурсам для
предотвращения состояний гонки и других проблем синхронизации.

## Процесс

**Процесс** — это выполняющаяся программа, которая имеет собственное пространство адресов, системные ресурсы и
информацию о
состоянии. Каждый процесс изолирован от других процессов, что обеспечивает безопасность и стабильность операционной
системы. Процессы не могут напрямую обмениваться данными между собой без специальных механизмов межпроцессного
взаимодействия.

## Различия между процессом и потоком

### Изоляция

- **Процессы** изолированы друг от друга и имеют собственную память.
- **Потоки** внутри одного процесса разделяют память и ресурсы.

### Нагрузка на систему

- **Создание процесса** — более ресурсозатратная операция по сравнению с созданием потока.
- **Создание потока** — легче и быстрее, что позволяет эффективно использовать многопоточность для повышения
  производительности.

# Процессор

## Одноядерный процессор

**Одноядерные процессоры** Выполняют один поток управления в единицу времени. Многозадачность достигается за счёт
быстрого переключения между потоками — контекстной переключки.

## Многоядерный процессор

**Многоядерные процессоры** Имеют несколько ядер, каждое из которых может выполнять свой поток. Это позволяет выполнять
несколько потоков параллельно.

## Меанихзмы для работы в многопоточности

### Гиперпоточность (Hyper-Threading)

Некоторые процессоры поддерживают технологию **гиперпоточности**, позволяющую одному физическому ядру обрабатывать два
потока одновременно, улучшая использование ресурсов процессора и повышая производительность при многопоточных нагрузках.

### Контекстная переключка

**Контекстная переключка** — это процесс сохранения состояния текущего потока и загрузки состояния другого потока для
его выполнения. Это позволяет процессору переключаться между потоками, создавая иллюзию параллельного выполнения на
одноядерных системах.

### Планирование потоков

Процессор не управляет потоками самостоятельно; он выполняет инструкции, которые ему предоставляются. Планированием
потоков занимается операционная система, которая распределяет время процессора между доступными потоками в соответствии
с выбранным алгоритмом планирования.

# Работа ОС

## Управление процессами и потоками

Операционная система (ОС) отвечает за создание, управление и завершение процессов и потоков. Она предоставляет системные
вызовы и API для разработчиков, чтобы они могли создавать многопоточные приложения.

## Планирование потоков

ОС использует планировщик (scheduler) для распределения процессорного времени между потоками. Планировщик учитывает
приоритеты потоков, их состояние и другие факторы для принятия решения о том, какой поток выполнить следующим.

### Состояния потоков

- **NEW (Новый)**: Поток создан, но ещё не запущен.
- **RUNNABLE (Готов к выполнению)**: Поток готов к выполнению или выполняется.
- **BLOCKED (Заблокирован)**: Поток заблокирован и ожидает освобождения мониторного блокирования (
  например, ```synchronized```).
- **WAITING (Ожидание)**: Поток ожидает сигнала от другого потока (методы ```wait()```, ```join()``` или ```park()```).
- **TIMED_WAITING (Ожидание с таймаутом)**: Поток ожидает определённое время (
  методы ```sleep(long)```, ```wait(long)```, ```join(long)```).
- **TERMINATED (Завершён)**: Поток завершил выполнение.

## Алгоритмы планирования

ОС может использовать различные алгоритмы планирования:

- **Round Robin (Круговая робин)**: Потоки получают равные кванты времени по очереди.
- **Приоритетное планирование**: Потоки с более высоким приоритетом выполняются чаще.
- **Многоуровневая очередь**: Комбинация нескольких алгоритмов с различными приоритетами.

## Порядок выполнения потоков

## Отсутствие гарантий порядка

В многопоточных приложениях **нет гарантированного порядка выполнения потоков**. Планирование потоков зависит от
операционной системы и может быть разным на разных запусках программы или на разных машинах.

**_Вы никогда не сможете сказать какой именно поток и в какой момент времени выполняется._**

## Квантование времени

**Квантование времени** (**time slicing**) — это техника, используемая операционной системой для реализации
многозадачности и многопоточности. В этой модели время процессора разделяется на небольшие отрезки, называемые квантами
времени. Каждому потоку или процессу выделяется квант времени, в течение которого он может выполняться на процессоре.
После истечения кванта времени процессор переключается на выполнение другого потока или процесса.

**Квант времени** — это максимальная продолжительность, в течение которой поток может выполняться без прерывания. Если поток
не завершил работу в течение своего кванта времени, он будет приостановлен, и процессор переключится на следующий поток.

### Квантование времени в многопоточности

- **Одноядерные процессоры**: На одноядерных системах квантование времени позволяет создавать иллюзию параллельного
  выполнения нескольких потоков или процессов. Хотя физически процессор может выполнять только один поток в единицу
  времени, быстрое переключение между потоками создает впечатление одновременного выполнения.
- **Многоядерные процессоры**: Даже на многоядерных системах, где несколько потоков могут выполняться параллельно на
  разных ядрах, квантование времени используется для управления большим количеством потоков, чем доступно ядер.

### Процессор

Для нас представляет собой чёрный ящик, исполняющий код. Для нас не имеет значения, одноядерный наш процессор, или нет.

### Операционная система

В контексте многопоточности, для нас важно, что ОС:

1. Создаёт объекты потоков и передаёт их в пользование процессам.
2. Определяет порядок выделения процессорного времени для каждого потока