# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd! Bármely régebbi osztályt megnyithatsz.

Az `exams` repository-ba dolgozz! Ezen könyvtár tartalmát nyugodtan át lehet másolni (`pom.xml`, tesztek). Projekt, könyvtár,
repository neve legyen: `sv3-2022-jvjbf-masodik-reszvizsga-pot-potvizsga`. GroupId: `training360`, 
artifactId: `sv3-2022-jvjbf-masodik-reszvizsga-pot-potvizsga`.

Ha ezzel kész vagy, azonnal commitolj, a commit szövege legyen: "init".

Az egyes feladatokat külön csomagba szervezd! A csomagneveket a feladat leírásában találod. Minden egyes
feladathoz tartoznak előre elkészített tesztosztályok. Ezekkel a megoldásod helyességét ellenőrizheted.

A feladatra 2 órád van összesen!

Ha letelik az idő, mindenképp commitolj, akkor is, ha nem vagy kész! A commit időpontja alapján fogjuk
ellenőrizni a megoldásod. Ha nincs commitod az idő lejárta előtt, akkor sajnos nem tudjuk értékelni a megoldásod!

Csak olyan kódot commitolj, ami le is fordul! Ha nem fordul, arra a részfeladatra nem jár pont.

## Algoritmus (15 pont)

A `Sentences` osztályban készíts egy `int countEndsWithSentenceEnding(List<String> sentences)` nevű metódust, 
ami megszámolja, hogy a listában kapott mondatok közül hány végződik mondat végi írásjellel! (".?!")


## Filekezelés (20 pont)

Adott egy file, a `test/resources/input.csv`, melyben termékek cikkszáma (id) és ára található. Van olyan sor, ahol harmadik 
értékként szerepel az eddig eladott termékek darabszáma. Olvasd be a fájl tartalmát a memóriába, de figyelj, hogy
terméket kétféleképpen lehet létrehozni: úgy, hogy van hozzá darabszám, vagy úgy, hogy nincs. Ebben az esetben a darabszám 0. 
A beolvasás után állapítsd, meg hogy melyik termék hozta a legnagyobb hasznot! Ha beolvasás előtt vizsgálódnánk, 
akkor dobj `IllegalStateException`-t!

## Absztrakció (30 pont)

A feladatban egy jármű bérlő (car/bike sharing) alkalmazás működését fogjuk szimulálni.  

Készíts egy `Rentable` interface-t, aminek publikus absztrakt metódusai: `void rent(User user, int km)`, `void closeRent()`, 
`boolean isFree()` és a `String getId()`  

A `User` osztály a felhasználót reprezentálja, akinek van egy felhasználóneve, amit konstruktorban kap meg, és egy korábbi bérlések
listája, ami kezdetben üres. Legyen egy `void addEarlierRent(Rentable rentable)` metódusa amivel hozzá lehet adni bérlést a listához!

A `RentingData` osztály egy bérlés adatait tartalmazza. Attribútumai egy `User actualUser` és egy `int actualKm`, melyek azt jelölik, hogy ki
és hány kilométerre szeretné kibérelni majd a járművet. Legyen egy `void addEarlierRentToUser(Rentable rentable)` metódusa, 
ami delegálja a hivást az `actualUser` megfelelő metódusának! 

A `Bike` osztály implementálja a `Rentable` interface-t. Adattagjai egy `String id` egy `RentingData rentingData` és egy `int sumKm`. 
Ezek közül az `id`-t kapja meg konstruktorban. A `rent(User user,int km)` metódust definiáld felül úgy, hogyha a `rentingData`
értéke nem `null`, akkor dobjon kivételt! Egyéb esetben a `rentingData` kapjon új értéket, átadva neki a paramétereket!  
A `closeRent()` metódus dobjon kivételt, ha épp nincs kibérelve a bicikli! Egyébként az összkilométerhez add hozzá a bérlés kilométer adatát,
és a bérlő listájához add hozzá az aktuális bicikli objektumot! Mindezek után töröld a bérlési adatokat! 
A `boolean isFree()` és a `getId()` metódust értelemszerűen definiáld felül!

A `Car` osztály implementálja a `Rentable` interface-t.  Adattagjai egy `String id` egy `RentingData rentingData` 
és egy `int distanceCanMake`. Utóbbi megmondja, hogy hány kilometert képes még menni az autó. Az `id` és a `distanceCanMake` 
attribútumokat konstruktorban állítsuk be, illetve utóbbihoz legyen egy metódus, ami a tankolást reprezentálja, azaz hozzáadja a
`distanceCanMake` értékhez a paraméterül kapott értéket! 
A bérlés hasonló, mint a biciklinél, azzal a különbséggel, hogy azt is vizsgálni kell, hogy képes-e ennyi kilométert megtenni az autó.
A bérlés lezárásnál ugyanaz a menet mint a bringánál, de a `distanceCanMake` attribútumot csökkenteni kell a megtett kilométerrel. 
A `boolean isFree()` és a `getId()` metódust értelemszerűen definiáld felül!

## Algoritmus 2 (15 pont)

A `User` osztályt bővítsd egy metódussal, ami megmondja, hogy a korábban bérelt járművek közül hány van, ami éppen szabad!








