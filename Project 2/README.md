# Project 2

## Działanie programu:
1. Wczytanie z pliku tekstowego i wyświetlenie artykułów dostępnych w sklepie.
2. Użytkownik (klient) składa zamówienie, czyli może:
        - Sprawdzić, czy dany artykuł jest dostępny,
        - Umieścić w koszyku wybrane dostępne (znalezione) artykuły,
        - Wycenić koszyk zamówienia,
        - Zrealizować zamówienie (odjąć kupowane artykuły ze stanu sklepu).
3. Wyświetlenie artykułów dostępnych w sklepie po zrealizowaniu zamówienia i aktualizacja pliku z nimi.

## Wymagania:
- Program ma działać w trybie tekstowym, wyświetlając wyniki na ekranie.
- Plik tekstowy z dostępnymi artykułami ma mieć określony format i być ręcznie wykonany.
- Dane z tego pliku mają być odczytywane przez klasę EasyReader.
- Dane do tego pliku mają być zapisywane przez klasę EasyWriter.
- Opis artykułu ma składać się z kodu, nazwy (tylko angielskie litery) i ceny.
- Stan magazynu ma być modyfikowany przez metody dodajArtykul i pobierzArtykul.
- Artykuły mają być wyszukiwane przez metodę znajdzArtykul, której parametrem ma być nazwa szukanego artykułu. W nazwie artykułu można używać znaków "?" (zastępuje jedną dowolną literę) i "*" (zastępuje dowolnej długości ciągu liter, zerowej też).
- Koszyk zamówienia ma być wyceniany przez metodę wycenaZamowienie, której parametrem ma być lista zamówionych towarów z liczbą każdego z nich.
- Metody te mają wyrzucać wyjątek z komunikatem o błędzie, jeśli podano złe parametry.
