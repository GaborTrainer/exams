# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd! Bármely régebbi osztályt megnyithatsz.

Az exams repository-ba dolgozz! Ezen könyvtár tartalmát nyugodtan át lehet másolni (`pom.xml`, tesztek).
Projekt, könyvtár, repository neve legyen: `sv3-2022-jvjbf-harmadik-reszvizsga-potvizsga`. GroupId: `training360`,
artifactId: `sv3-2022-jvjbf-harmadik-reszvizsga-potvizsga`.

Ha ezzel kész vagy, azonnal commitolj, a commit szövege legyen: "init".

Az egyes feladatokat külön csomagba szervezd! A csomagneveket a feladat leírásában találod. Minden egyes
feladathoz tartoznak előre elkészített tesztosztályok. Ezekkel a megoldásod helyességét ellenőrizheted.

A feladatra 3 órád van összesen!

Ha letelik az idő, mindenképp commitolj, akkor is, ha nem vagy kész! A commit időpontja alapján fogjuk
ellenőrizni a megoldásod. Ha nincs commitod az idő lejárta előtt, akkor sajnos nem tudjuk értékelni a megoldásod!

Csak olyan kódot commitolj, ami le is fordul! Ha nem fordul, arra a részfeladatra nem jár pont.

## Streamek (20 pont)

Készítsd el a `streams.Player` nevű osztályt! Minden játékosnak legyen egy neve, egy csapata, egy születési dátuma és a
góljainak száma! Ezeket mind konstruktorban állítsd be!  
Készíts egy `PlayerService` nevű osztályt, melyben játékosok listája található! Készíts egy `addPlayer(Player player)`
metódust, amivel játékost tudunk hozzáadni a listához!
Oldd meg a következő feladatokat __streamek__ segítségével:
- Készíts egy metódust, ami kigyűjti a listában lévő csapatneveket egy halmazba!
- Készíts egy metódust, ami visszaadja a legtöbb gólt rúgott játékost `Optional`-ként!
- Készíts egy metódust, ami kigyűjti azokat a játékosokat egy listába, akik egy bizonyos dátum előtt születtek!
- Készíts egy metódust, ami visszaadja azokat a játékosokat név szerint ABC sorrendben, akik egy bizonyos
dátum után születtek és egy bizonyos gólszámnál többet rúgtak! 

## Filekezelés (24 pont)

Ebben a feladatban egy vasúti menetrendet kell feldolgoznod. Az `input.txt` állomány a következő
formátumban tartalmazza az adatokat: `{célváros};{vonat azonosító} {vonat típus} {indulási idő}`.
A feladatod a fájl feldolgozása lesz.

Hozd létre a `Train` osztályt, ami a pontosvessző utáni részt reprezentálja! A vonat típus
legyen enum: `IC, FAST, NORMAL` értékekkel! (Ha későbbiekben enummal nem sikerül feldolgozni a fájlt, akkor oldd meg `Stringgel`.)  

Hozd létre a `TrainService` osztályt, benne az adatok tárolására megfelelő adatszerkezettel! Az adatszerkezetet
úgy kell felépíteni, hogy a célvároshoz rendelje hozzá az oda tartó vonatokat. Ebbe az adatszerkezetbe
olvasd be a fájl tartalmát úgy, hogy az adatok városok szerint ABC sorrendben legyen tárolva. 

## Műveletek kollekciókon (26 pont)

**Ennek a feladatnak a helyes megoldására abban az esetben is jár a pont, ha a fájlbeolvasást nem sikerült 
helyesen megoldani, és a tesztek amiatt buknak el.**

A következő feladatokat a `files.TrainService` osztályban kell megvalósítanod. A megvalósításhoz __nem kötelező__
streamek-et használnod. Se plusz se minuszpont nem jár érte.

- Készíts egy metódust `String findCityWithMostTrains()` néven, ami visszaadja azt a várost, ahova a legtöbb vonat indul!
- Készíts egy metódust `String findDestinationByTrainId(String trainId)` néven, ami visszaadja azt a várost,
ahova a paraméterül kapott vonat megy! Ha nem létezik az azonosító, dobj kivételt!
- Készíts egy metódust `List<LocalTime> findDeparturesToCity(String city)` néven, ami visszaadja az adott városhoz tartozó indulási
időpontokat, időrendben! Ha nem található ilyen város, dobj kivételt!

## Absztrakció (30 pont)

Az `abstractions` csomagba dolgozz!

Hozz létre egy `Content` nevű interface-t! Az interface-nek két publikus absztrakt metódusa
van, a `String getTitle()` és az `int getImportance()`.  

Készítsd el az `Advertisement` nevő osztályt. ami implementálja a `Content` interface-t! A hirdetésnek csak egy cím attribútuma van,
a fontossága mindig 1.

Készítsd el a `Header` osztályt, ami egy cikk fejlécét fogja reprezentálni! A fejlécnek van egy címe és egy mérete, 
ezeket konstruktorban állítsd be!

Készítsd el az `Article` nevű osztályt, ami implementálja a `Content` interface-t! A cikknek van egy fejléce, egy írója, és egy string listája
a tartalommal. Ezeket konstruktorban kapja meg. A cikk címe a fejléc címe és fontossága a fejléc méretének és a cikkben lévő sorok számának a szorzata.

Készítsd el a `ContentService` nevű osztályt, melyben legyen egy halmaz adatszerkezet, 
ami tartalmakat tárol a tartalmak hozzáadásának sorrendjében!
A halmazban két ugyanolyan című cikk nem szerepelhet, a reklámokra ilyen megkötés nincs.   
Készíts egy `List<Content> getContentsSortedByImportance()` metódust is, ami fontosság szerint rendezetten
adja vissza a tartalmakat egy listában!
