## Akustyk

![widokAkustyk](https://user-images.githubusercontent.com/63725366/79580495-591bd700-80c9-11ea-92b6-7206a6047fe8.JPG)

=========Opis obsługi progarmu: Akustyk=====

Program akustyk jest programem demonstracyjnym, testowym , który po dalszym rozbudowaniu 
może służyć do określania odporności stolarki okiennej i drzwiowej w oparciu  o dostarczaną dokumentację
 analiz akustycznej dla otoczenia budynku.

Wokół budynku występują strefy hałasu (np. Strefa 0 - przy autostradzie , strefa 1- przy lokalnej drodze)
By określić wymaganą odporność akustyczną stolarki okiennej trzeba poznać wyżej wymienioną strefę, 
wymiary okna oraz powierzchnia ściany oraz rodzaj pomieszczenia okna w którym będziemy badać odporność akustyczną.

======Założenia przyjęte dla potrzeb projektu======
(w skutek czego nie może służyć do faktycznego określania określania wymaganej odporności akustycznej drzwi i okien):

- przyjęta wysokosć pomieszczenia - 300cm - jest do edycji tylko z poziomu klasy kontrolera niedostępna w GUI

- Zmiana rodzaju pomieszczenia z kuchni na pokój skutkuje 
dodaniem +5 DB do stolarki względem wyniku otrzymywanej dla odporności okna zlokalizowanego w kuchni- 
-jest to założenie czysto programistyczne, w branży architektonicznej należałoby stworzyć odrębną tablicę dla różnych pomieszczeń

- przyjęto maksymalną ilość stref:5, z czego 2 pierwsze są nieusuwalne. Można zrobić było to lepiej - za pomocą list dynamicznych,
 jednak ze względów testowych została zadeklarowana zwykła tablica statyczna

======Algorytm działania programu======
1. Oblicz powierzchnie szklenia okna (wysokość * szerokość okna)
2. Oblicz powierzchnie ściany (wysokość * szerokość ściany)
3. Oblicz % powierzchni szklenia w stosunku do powierzchni ściany = X
5. Wybierz Strefe w której znajduje się okno = Y
6. Oblicz zakres w którym znajduje się dana X:
	0-25 -> X=X1
	25-50 -> X=X2
	50-75 -> X=X3
	75-100 -> X=X4
7.Wynik = Wartość [Y][X] z listy stref zawierającej rodzaje stref do których są przypisane wartości dla zakresu X1-X4
8.Jeśli rodzaj pomieszczenia jest = Pokój , to do wyniku dodaj +5.
9. Wyświetl wynik
