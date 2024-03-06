# Java-projects

## Project 1
Działanie programu:
1. Utworzenie listy samochodów z losowo wybranymi parametrami: marka, cena, rocznik.
2. Użytkownik wybiera kryterium szukania samochodów: najstarszy, nie starszy niż ROK, najmłodszy, nie młodszy niż ROK i dodaje rocznik ROK (jeśli trzeba).
3. Wyświetlenie wszystkich znalezionych samochodów (pasujących do wybranego kryterium) z ich opisem.

Wymagania: 
Program ma działać w trybie tekstowym, wyświetlając wyniki na ekranie. Każdy samochód (tylko jeden) ma być zdefiniowany przez klasę Samochód. Liczbę tworzonych samochodów ma być odczytana z argumentu z linii wywołania programu. Metoda szukania samochodów ma być wybrana na podstawie argumentu z linii wywołania programu: 
- R metoda znajduje samochody i zwraca ich listę,
- W metoda znajduje samochody i wyrzuca wyjątek zawierający ich listę. 
Wyjątek, zawierający listę znalezionych samochodów, ma być zdefiniowany przez klasę Wyjątek. Enumeracja marek ma być zdefiniowana, zawierającą: POLONEZ, FIAT i SYRENA. Kryterium wyboru Szeregułądania samochodów (ewentualnie z rocznikiem) ma być zdefiniowane przez klasę EasyReader.
