# Vizsgafeladat
A feladatok megoldásához az IDEA fejlesztőeszközt használd! Bármely régebbi osztályt megnyithatsz.

Új repository-ba dolgozz! Ezen könyvtár tartalmát nyugodtan át lehet másolni (`pom.xml`, tesztek). Projekt, könyvtár,
repository neve legyen: `sv3-2022-jvjbf-masodik-reszvizsga`! GroupId: `training360`, artifactId: `sv3-2022-jvjbf-masodik-reszvizsga`.

Ha ezzel kész vagy, azonnal commitolj, a commit szövege legyen: `init`!

Az egyes feladatokat külön csomagba szervezd! A csomagneveket a feladat leírásában találod. Minden egyes
feladathoz tartoznak  előre elkészített teszt osztályok. Ezekkel a megoldásod helyességét ellenőrizheted.

A feladatra 2 órád van összesen!

Ha letelik az idő, mindenképp commitolj, akkor is, ha nem vagy kész! A commit időpontja alapján fogjuk
ellenőrizni a megoldásod. Ha nincs commitod az idő lejárta előtt, akkor sajnos nem tudjuk értékelni a megoldásod!

Csak olyan kódot commitolj, ami le is fordul! Ha nem fordul, arra a részfeladatra nem jár pont.

## Algoritmus (10 pont)

Készíts egy `Words` nevű osztályt a megfelelő csomagba, benne egy `int countWordsStartsWithUpperCase(List<String> words)` nevű metódust,
ami megszámolja azokat a szavakat a listában, amik nagybetűvel kezdődnek. 


## Filekezelés (20 pont)

Adott egy file a `test/resources/goodinput.csv` és a `badinput.csv`, amiben egy ember bevételei találhatók. Egy dátum majd egy összeg. Olvasd be a fájl tartalmát
a memóriába és dolgozd fel! Olyan osztályokat hozz ehhez létre, hogy a tesztek lefussanak. Figyelj arra, 
hogy ha a dátumok nem egymás után következnek a fájlban, akkor a feldolgozás során, dobj `IllegalArgumentException`-t a tesztnek megfelelő hibaüzenettel!


## Fájlok (25 pont)

Készíts egy `File` nevű interface-t a következő publikus absztrakt metódusokkal:  
`String getFullName()` és `double calculateSize()`! A fájl teljes neve majd mindig a címe és kiterjesztése lesz ponttal elválasztva. A méret számítást az egyes osztályoknál definiáljuk.
Legyen benne egy statikus attribútum ami a kilobyte-ból megabyte-ba történő
átváltás váltószáma, ennek értéke `0.001`!

Legyen egy `TextFile` nevű osztály mely implementálja a `File` interface-t! Az osztálynak legyen
egy cím attribútuma és egy `String` listája, ami a fájlban lévő sorokat jelképezi! Ezek közül 
példányosításkor csak a címet kapja meg. Legyen egy metódus amivel sort lehet hozzáadni a listához!
Az ilyen fájlok kiterjesztése mindig `txt`. A fájl mérete annyi kilobyte ahány sor van benne, de az
eredményt megabyte-ban várjuk.  

Legyen egy `Picture` nevű osztály, ami implemetálja a `File` interface-t! Az osztálynak legyen egy cím, egy kiterjesztés,
egy szélesség és egy magasság attribútuma, típusaik rendre szöveg, szöveg, egész szám, egész szám és ezek mindegyikét konstruktorban kapja meg!
A kép mérete annyi kilobyte mint a benne lévő pixelek száma, az értéket itt is megabyte-ban várjuk.   

Legyen még egy `ZipFile` nevű osztályt, ami implementálja a `File` interface-t! Az osztálynak
legyen egy cím attribútuma illetve `File` típusú elemek listája! Mindkettőt konstruktorban kapja meg. A kiterjesztés
itt mindig `zip`. A fájl mérete pedig a benne lévő fájlméretek összegének a 20%-a. 

## Fájlok algoritmusok (15 pont)

Bővítsd az előző osztályban található `ZipFile` osztályt egy metódussal ami visszaadja a legnagyobb méretű file-t a tömörített fájlból!
Figyelj, hogy üres könyvtárat is be lehet tömöríteni, ekkor dobjunk `IllegalStateException`-t! Ha több azonos méretű fájl van,
akkor az elsőt add vissza! 







