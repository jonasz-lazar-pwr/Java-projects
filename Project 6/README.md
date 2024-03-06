# Project 6

## Działanie programu:
1. Wyświetlenie okna zawierającego:
  - Pola tekstowe na liczby a1, a2 i a3,
  - Pola tekstowe na liczby b1, b2 i b3,
  - Pola tekstowe na liczby c0, c1, c2 i c3,
  - Pola tekstowe na symbol operacji: +, − lub ∗,
  - Przycisk "Rozwiąż",
  - Pole tekstowe na wynik rozwiązania.
2. Liczby ai, bi i ci mogą być dodawane wprost (np. 7) lub jako symbole (litery) (np. x).
3. Rozwiązanie polega na dodaniu wartości wszystkich użytych symboli przez obliczenie układu równań A⋆B = C ⋆ ∈ {+ − ·}, gdzie:
  - A = a1 · 10^2 + a2 · 10 + a3
  - B = b1 · 10^2 + b2 · 10 + b3
  - C = c0 · 10^3 + c1 · 10^2 + c2 · 10 + c3

## Wymagania:
- Program ma działać w trybie graficznym, wykorzystującym klasy AWT lub Swing.
- Działanie programu ma wykorzystywać obsługę zdarzeń i wyjątków.
- Zamiast pól tekstowych na liczby i znak operacji można utworzyć odpowiednią tabelę.
- Pole tekstowe na wynik ma pokazywać wartości wszystkich użytych symboli, np. x = 5.
