## Утилита zip

### Описание
Утилита представляет собой архиватор папки. Есть возможность передать в качестве ключа расширение файлов, которые не нужно включать в архив. При архивировании также сохраняется вся структура подпапок. Исходный код проекта располагается в папке job4j_design\chapter_002\src\main\java\ru\job4j\io. Проект построен на основе четырёх классов: ArgZip, Zip, SearchFiles, ArgNames. 
##### Пример запуска:  

java -jar pack.jar -d=C:\project -e=class -o=C:\project.zip  

-d - директория, которую нужно архивировать;  
-e - исключить файлы *.txt;  
-o - расположение конечного архива.  

## Утилита find

### Описание
Утилита представляет собой поисковик файлов в заданной директории. Имя файла может задаваться целиком или маске. Результат поиска записывается в файл. Также присутствует валидация входных параметров. Исходный код проекта располагается в папке job4j_design\chapter_002\src\main\java\ru\job4j\find. Проект построен на основе четырёх классов: Arg, Find, FindFiles, Searcher.  
##### Пример запуска:  

java -jar find.jar -d C:\projects -n file_name (-m or -f) -o C:\projects\log.txt")  

-d - директория, в которой нужно начинать поиск;  
-n - имя файла, маска, либо регулярное выражение;  
-m - искать по маске, либо -f - полное совпадение имени;  
-o - расположение файла с результатами поиска.  

### Использованные технологии
* Collections Framework
* Java IO
* Java NIO
* Классы из пакета java.util.zip
* Java Functional interfaces (java.util.function)

[![Build Status](https://travis-ci.org/LukyanovSemyon/job4j_design.svg?branch=main)](https://travis-ci.org/LukyanovSemyon/job4j_design)
[![codecov](https://codecov.io/gh/LukyanovSemyon/job4j_design/branch/main/graph/badge.svg?token=MGUU9ZO7KS)](undefined)
