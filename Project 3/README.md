## Project 3
### Działanie programu:
1. Liczenie wystąpień określonych imion w plikach tekstowych.
2. Wyświetlenie, ile razy dane imię występuje w danym pliku.

### Wymagania:
- Program ma działać w trybie tekstowym, wyświetlając wyniki na ekranie.
- Pliki tekstowe z przynajmniej różnymi imionami (i innymi słowami, tylko angielskie litery, spacje i przejścia do nowej linii) mają być ręcznie wykonane.
- Nazwy plików (i ich ścieżki, jeśli potrzeba) mają być przekazywane jako argumenty linii wywołania programu.
- Wyszukiwane imiona mają być zdefiniowane w enumeracji imiona.
- Metoda zliczająca imiona ma tworzyć i wykorzystywać strukturę danych, będącą listą liter, gdzie:
  - Do każdego elementu listy liter (czyli do każdej litery) dołączona jest lista znalezionych imion zaczynających się od tej litery,
  - Rozmiar listy liter ma być 26 (ilość liter w alfabecie),
  - Rozmiar każdej listy imion ma być nieograniczony,
  - Każdy element listy imion ma zawierać liczbę swoich wystąpień w danym pliku,
  - Lista imion ma być alfabetycznie posortowana.
- Dane z tych plików mają być odczytywane przez klasę EasyReader.
- Metoda ta ma wyrzucać wyjątek z komunikatem o błędzie, jeśli podano złe parametry.
