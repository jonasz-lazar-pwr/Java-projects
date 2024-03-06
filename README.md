# Java-projects

## Project 1
### Działanie programu:
1. Utworzenie listy samochodów z losowo wybranymi parametrami: marka, cena, rocznik.
2. Użytkownik wybiera kryterium szukania samochodów: najstarszy, nie starszy niż ROK, najmłodszy, nie młodszy niż ROK i dodaje rocznik ROK (jeśli trzeba).
3. Wyświetlenie wszystkich znalezionych samochodów (pasujących do wybranego kryterium) z ich opisem.

### Wymagania:
Program ma działać w trybie tekstowym, wyświetlając wyniki na ekranie. Każdy samochód (tylko jeden) ma być zdefiniowany przez klasę Samochód. Liczbę tworzonych samochodów ma być odczytana z argumentu z linii wywołania programu. Metoda szukania samochodów ma być wybrana na podstawie argumentu z linii wywołania programu: 
- R metoda znajduje samochody i zwraca ich listę,
- W metoda znajduje samochody i wyrzuca wyjątek zawierający ich listę.

Wyjątek, zawierający listę znalezionych samochodów, ma być zdefiniowany przez klasę Wyjątek. Enumeracja marek ma być zdefiniowana, zawierającą: POLONEZ, FIAT i SYRENA. Kryterium wyboru Szeregułądania samochodów (ewentualnie z rocznikiem) ma być zdefiniowane przez klasę EasyReader.

## Project 2
### Działanie programu:
1. Wczytanie z pliku tekstowego i wyświetlenie artykułów dostępnych w sklepie.
2. Użytkownik (klient) składa zamówienie, czyli może: 
- Sprawdzić, czy dany artykuł jest dostępny,
- Umieścić w koszyku wybrane dostępne (znalezione) artykuły,
- Wycenić koszyk zamówienia,
- Zrealizować zamówienie (odjąć kupowane artykuły ze stanu sklepu).
3. Wyświetlenie artykułów dostępnych w sklepie po zrealizowaniu zamówienia i aktualizacja pliku z nimi.

### Wymagania:
Program ma działać w trybie tekstowym, wyświetlając wyniki na ekranie.
Plik tekstowy z dostępnymi artykułami ma mieć określony format i być ręcznie wykonany.
Dane z tego pliku mają być odczytywane przez klasę EasyReader.
Dane do tego pliku mają być zapisywane przez klasę EasyWriter.
Opis artykułu ma składać się z kodu, nazwy (tylko angielskie litery) i ceny.
Stan magazynu ma być modyfikowany przez metody dodajArtykul i pobierzArtykul.
Artykuły mają być wyszukiwane przez metodę znajdzArtykul, której parametrem ma być nazwa szukanego artykułu. W nazwie artykułu można używać znaków "?" (zastępuje jedną dowolną literę) i "*" (zastępuje dowolnej długości ciąg liter, zerowej też).
Koszyk zamówienia ma być wyceniany przez metodę wycenaZamowienie, której parametrem ma być lista zamówionych towarów z liczbą każdego z nich.
Metody te mają wyrzucać wyjątek z komunikatem o błędzie, jeśli podano złe parametry.

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

