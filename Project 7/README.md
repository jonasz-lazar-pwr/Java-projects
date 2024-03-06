# Project 7

## Działanie programu:
1. Wyświetlenie okna przypominającego kalkulator, zawierającego:
    - Przycisk D/M do wyboru między dużymi lub małymi literami,
    - Przyciski abc, def, ghi, jkl, mno, pqr, stuv i wxyz do wyboru liter,
    - Przycisk CE do usunięcia ostatnio wprowadzonego znaku,
    - Przycisk C do usunięcia wszystkich wprowadzonych znaków,
    - Przyciski +, −, / i = do operacji na ciągach znaków,
    - Pola tekstowe z wprowadzanymi znakami i wynikami operacji na nich.
2. Naciśnięcie przycisku D/M przełącza wielkość pisanych liter.
3. Naciśnięcie przycisku z literami wprowadza literę do pola tekstowego, zgodnie z przyciskiem i liczbą naciśnięć, np. dla abc: pierwsze naciśnięcie daje a, drugie ± b, trzecie ± c, czwarte ± a, itd.
4. Naciśnięcie przycisku CE usuwa ostatni wprowadzony znak.
5. Naciśnięcie przycisku C usuwa wszystkie wprowadzone znaki.
6. Naciśnięcie przycisku +, − lub / wprowadza ten znak.
7. Naciśnięcie przycisku = wprowadza ten znak i wyświetla wynik operacji:
    - dodawanie (+), łącząc dwa ciągi znaków, np. Ala + Ela = AlaEla,
    - odejmowanie (−), usuwając wszystkie wystąpienia drugiego ciągu znaków z pierwszego, np. AlaEla − la = AE,
    - dzielenie (/), zwracając najdłuższy wspólny podciąg znaków, np. AlaElaJola / Tola = ola.

## Wymagania:
- Program ma działać w trybie graficznym.
- Działanie programu ma wykorzystywać obsługę zdarzeń i wyjątków.
