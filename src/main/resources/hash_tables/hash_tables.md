## Hash Tables

- Хеш-таблицей называется структура данных, обеспечивающая очень быструю вставку и поиск.
- Независимо от количества элементов данных `вставка и поиск (а иногда и удаление)` выполняются за время, близкое к постоянному: O(1) в O-синтаксисе.
- Хеш-таблицы по скорости значительно превосходят деревья.
- У хеш-таблиц также имеются свои недостатки. Они реализуются на базе массивов, а массивы трудно расширить после создания.

<h3>Хеширование</h3>

`Хеш-функции` — функции, преобразующей число из большего диапазона в число из меньшего диапазона. Меньший диапазон
соответствует индексам массива. Массив, в который вставляются данные с использованием хеш-функции, называется `хеш-таблицей`.

<h2>Коллизии</h2>

Предположим, в массив вставляется слово melioration. Слово хешируется, вы вычисляете его индекс — и тут выясняется, что ячейка с этим индексом уже занята
словом demystify, которое имеет точно такой же хеш-код.

Может показаться, что из-за возможности коллизий вся схема хеширования теряет смысл, но у проблемы существует несколько обходных решений.
При определении массива количество зарезервированных ячеек вдвое превышало количество элементов данных. Таким образом, приблизительно
половина ячеек остается пустой. Одно из возможных решений при возникновении коллизии заключается в систематизированном поиске пустой ячейки и вставке
нового элемента в нее (вместо индекса, полученного в результате примененияхеш-функции). 
Такое решение называется `открытой адресацией`. Если слово cats хешируется в индекс 5421, а эта ячейка уже занята словом parsnip, можно попы-
таться вставить cats в другую ячейку, например 5422.

Во втором решении создается массив, содержащий связанные списки слов вместо самих слов. При возникновении коллизии новый
элемент просто вставляется в список с соответствующим индексом. Этот метод называется `методом цепочек`.

<h3>Открытая адресация</h3>

Если элемент данных не удается разместить в ячейке с индексом, вычисленным по-
средством хеш-функции, метод открытой адресации ищет в массиве другую ячейку.

Способы поиска следующей свободной ячейки: 
- линейное пробирование
- квадратичное пробирование
- двойное хеширование

<h4>Линейное пробирование</h4>

Алгоритм линейного пробирования последовательно ищет пустые ячейки. Если при попытке вставки элемента выясняется, что ячейка 5421 занята, мы переходим
к ячейке 5422, затем к ячейке 5423 и т. д. Индекс последовательно увеличивается до тех пор, пока не будет найдена пустая ячейка. Процедура поиска называется
«линейным пробированием», потому что она основана на линейной проверке последовательности ячеек.
