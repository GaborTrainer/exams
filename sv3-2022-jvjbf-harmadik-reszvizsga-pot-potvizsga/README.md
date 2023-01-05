# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd! Bármely régebbi osztályt megnyithatsz.

Az exams repository-ba dolgozz! Ezen könyvtár tartalmát nyugodtan át lehet másolni (`pom.xml`, tesztek).
Projekt, könyvtár, repository neve legyen: `sv3-2022-jvjbf-harmadik-reszvizsga-pot-potvizsga`. GroupId: `training360`,
artifactId: `sv3-2022-jvjbf-harmadik-reszvizsga-pot-potvizsga`.

Ha ezzel kész vagy, azonnal commitolj, a commit szövege legyen: "init".

Az egyes feladatokat külön csomagba szervezd! A csomagneveket a feladat leírásában találod. Minden egyes
feladathoz tartoznak előre elkészített tesztosztályok. Ezekkel a megoldásod helyességét ellenőrizheted.

A feladatra 3 órád van összesen!

Ha letelik az idő, mindenképp commitolj, akkor is, ha nem vagy kész! A commit időpontja alapján fogjuk
ellenőrizni a megoldásod. Ha nincs commitod az idő lejárta előtt, akkor sajnos nem tudjuk értékelni a megoldásod!

Csak olyan kódot commitolj, ami le is fordul! Ha nem fordul, arra a részfeladatra nem jár pont.

## Streamek (20 pont)

Készítsd el a `streams.Dog` nevű osztályt! Minden kutyának legyen egy neve, egy életkora, egy mérete 
(enum `SMALL, MEDIUM, LARGE`) és fajtája! Ezeket mind konstruktorban állítsd be!
Készíts egy `DogService` nevű osztályt, melyben kutyák listája található. Készíts egy `addDog(Dog dog)`
metódust, amivel kutyát tudunk hozzáadni a listához.
Oldd meg a következő feladatokat __streamek__ segítségével:

- Készíts egy metódust, ami a paraméterül kapott méret alapján kigyűjti a kutyákat egy listába!
- Készíts egy metódust, ami visszaadja a legöregebb kutyát `Optional`-ként!
- Készíts egy metódust, ami kigyűjti azoknak a kutyáknak a neveit abc sorrendben egy listába, akik egy megadott fajtához
  tartoznak és egy megadott életkornál idősebbek!
- Készíts egy metódust, ami visszaadja egy halmazban a listában lévő fajtákat!

## Filekezelés (30 pont)

Ebben a feladatban időjárási méréseket kell feldolgoznod. Az `input.txt` állomány a következő
formátumban tartalmazza az adatokat: `{dátum};{idő} {celsius fok}`.
A feladatod a fájl feldolgozása lesz.

Hozd létre a `WeatherMeasurement` osztályt, ami a pontosvessző utáni részt reprezentálja!

Hozd létre a `WeatherService` osztályt, benne az adatok tárolására megfelelő adatszerkezettel! Az adatszerkezetet
úgy kell felépíteni, hogy a dátumhoz rendelje hozzá a mérési adatokat. Ebbe az adatszerkezetbe
olvasd be a fájl tartalmát úgy, hogy a beolvasás végére az egyes dátumokhoz tartozó mérések időrendben legyenek tárolva!

## Műveletek kollekciókon (25 pont)

**Ennek a feladatnak a helyes megoldására abban az esetben is jár a pont, ha a fájlbeolvasást nem sikerült
helyesen megoldani, és a tesztek amiatt buknak el.**

A következő feladatokat a `files.WeatherService` osztályban kell megvalósítanod. A megvalósításhoz __nem kötelező__
streamek-et használnod. Se plusz se minuszpont nem jár érte.

- Készíts egy metódust `LocalDate findDateWithMostMeasurements()` néven, ami visszaadja azt a dátumot, amihez a legtöbb mérés tartozik! 
- Készíts egy metódust `int findTemperatureByDateAndTime(LocalDate date, LocalTime time)` néven, ami visszaadja azt a hőmérsékletet,
  amit a paraméterül kapott időpontban mértek. Ha nem létezik a dátum, vagy azon belül az idő, dobj kivételt!
- Készíts egy metódust `List<LocalTime> findMeasurementsByDate(LocalDate date)` néven, ami visszaadja az adott dátumhoz
  tartozó mérési időpontokat, időrendben. Ha nem található ilyen dátum, dobj kivételt!

## Absztrakció (25 pont)

Az `abstraction` csomagba dolgozz!

A feladatban egy edzőterem foglalási rendszerét kell megvalósítanod.
Hozz létre egy `GymReservation` nevű interface-t! Az interface-nek három publikus absztrakt metódusa
van: a `String getContactName()`, az `int getReservationTime()` és az `int calculatePriceToPay()`.

Készítsd el a `TeamReservation` nevű osztályt, ami implementálja a `GymReservation` interface-t! A csapatnál mindig van egy kontakt személy
és a további csapattagok neveinek listája, illetve a dátum. Ezeket mind konstruktorban kapja meg. 
A `calculatePriceToPay()` metódus ebben az esetben a személyenkénti fizetendő összeget adja vissza. A teljes ár 9000 Ft.

Készítsd el a `SingleReservation`  nevű osztályt, ami implementálja a `GymReservation` interface-t! Itt a személy nevén és a dátumon kívül
van egy van-e bérlete attribútuma, ami kezdetben hamis. 
Bérletet a `void buySeasonTicket()` metódussal vehet. Az egyszemélyes edzés ára 4500, de ha van bérlete, akkor ennek az árnak a fele. 

Készítsd el a `Gym` nevű osztályt melyben egy adatszerkezetben tárold a foglalásokat! Foglalást az
`boolean addReservation(GymReservation reservation)` nevű metódussal lehet hozzáadni. Amire figyelni kell, 
hogy két csoportos foglalás nem érkezhet be egy időpontra. Egyszemélyes foglalásból bármennyi lehet. 
Ha már van csoportos foglalás arra az időpontra, adj vissza hamis értéket és ne kerüljön be a foglalás!
