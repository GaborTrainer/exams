# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd! Bármely régebbi osztályt megnyithatsz.

Az `exams` repository-ba dolgozz! Ezen könyvtár tartalmát nyugodtan át lehet másolni (`pom.xml`, tesztek). Projekt, könyvtár 
neve legyen: `sv3-2022-jvjbf-masodik-reszvizsga-potvizsga`. GroupId: `training360`, artifactId: `sv3-2022-jvjbf-masodik-reszvizsga-potvizsga`.

Ha ezzel kész vagy, azonnal commitolj, a commit szövege legyen: `init`.

Az egyes feladatokat külön csomagba szervezd! A csomagneveket a feladat leírásában találod. Minden egyes
feladathoz tartoznak előre elkészített tesztosztályok. Ezekkel a megoldásod helyességét ellenőrizheted.

A feladatra 2 órád van összesen!

Ha letelik az idő, mindenképp commitolj, akkor is, ha nem vagy kész! A commit időpontja alapján fogjuk
ellenőrizni a megoldásod. Ha nincs commitod az idő lejárta előtt, akkor sajnos nem tudjuk értékelni a megoldásod!

Csak olyan kódot commitolj, ami le is fordul! Ha nem fordul, arra a részfeladatra nem jár pont.

## Algoritmus (15 pont)

Készíts egy `Numbers` nevű osztályt a megfelelő csomagba, benne egy `boolean isPairInListWithSumOf(List<Integer> numbers, int value)` 
nevű metódust, ami megmondja, hogy a paraméterül kapott listában van-e olyan számpár, aminek összege megegyezik a második paraméterrel!

## Filekezelés (20 pont)

Adott egy file, a `test/resources/input.csv`, melyben könyvek adatai találhatók szóközzel elválasztva. Minden könyvnek 
van ISBN száma, írója és címe. Beolvasás után készítsd el a `Book findBookByIsbn(String isbn)` metódust, ami visszaad
egy könyvet ISBN szám alapján. Ha könyv nem található az állományban akkor dobjunk `IllegalArgumentException`-t!

## Absztrakció (30 pont)

A feladatban egy Streaming szolgáltató működését fogjuk szimulálni.  
Hozz létre egy `Content` nevű interface-t két publikus abstract metódussal, `String getTitle()` és 
`int getLength()`, illetve egy `void addVideo(Video video)` metódussal, ami alapértelmezetten
egy `IllegalStateException`-t dob a megfelelő hibaüzenettel!  

Készíts egy `Video` osztályt! Minden videónak legyen egy címe és egy hossza, ezeket konstruktorban állítsd be!  

Készíts egy `Movie` osztályt, melynek adattagja egy video és implementálja a 
`Content` interface-t! Az interface absztract metódusait úgy írd felül, hogy
a video attribútum megfelelő adattagjaival térjenek vissza!

Készíts egy `Series` osztályt, amely szintén implementálja a `Content` interface-t!
Ennek az osztálynak legyen egy címe és videók listája attribútuma! Sorozatot kétféleképpen 
lehet létrehozni. Mindkét esetben megadom a címet, de az egyik esetben csak az első videót adom meg,
míg a második esetben az sorozathoz tartozó összes videót feltöltöm egyben. A `Series`
osztály minden `Content` interface metódust definiáljon felül a következő módon: a cím maga a sorozat címe legyen, a
hossz pedig a benne lévő videók hosszának összege. Az `addVideo(Video video)` metódussal
pedig lehessen videót hozzáadni a listához.  

Készíts egy `StreamingPlatform` nevű osztályt, amelyben tartalmak listája található
és benne egy `addContent(Content content)` metódust, amivel tartalmat lehet hozzáadni a listához! 

## Algoritmus 2 (15 pont)

Bővítsd a `StreamingPlatform` osztályt egy metódussal, ami megkeresi és visszaadja a leghosszabb tartalmat a listában!
Figyelj az üres listára!







