# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd! Bármely régebbi osztályt megnyithatsz.

Az exams repository-ba dolgozz! Ezen könyvtár tartalmát nyugodtan át lehet másolni (pom.xml, tesztek). 
Projekt, könyvtár, repository neve legyen: `sv3-2022-jvjbf-harmadik-reszvizsga`. GroupId: `training360`, 
artifactId: `sv3-2022-jvjbf-harmadik-reszvizsga`.

Ha ezzel kész vagy, azonnal commitolj, a commit szövege legyen: "init".

Az egyes feladatokat külön csomagba szervezd! A csomagneveket a feladat leírásában találod. Minden egyes 
feladathoz tartoznak előre elkészített tesztosztályok. Ezekkel a megoldásod helyességét ellenőrizheted.

A feladatra 3 órád van összesen!

Ha letelik az idő, mindenképp commitolj, akkor is, ha nem vagy kész! A commit időpontja alapján fogjuk 
ellenőrizni a megoldásod. Ha nincs commitod az idő lejárta előtt, akkor sajnos nem tudjuk értékelni a megoldásod!

Csak olyan kódot commitolj, ami le is fordul! Ha nem fordul, arra a részfeladatra nem jár pont.

## Streamek (20 pont)

Készítsd el a `streams.Building` nevű osztályt! Minden épületnek legyen egy utcanév adata szövegként, egy alapnégyzetmétere (egész szám)
és az emeletek száma (szintén egész szám)!  
Készítsd el a `streams.City` nevű osztályt melyben épületek privát listája található! Legyen egy metódus amivel épületet
lehet hozzáadni a listához!
A `City` osztályban valósítsd meg a következő metódusokat __streamek__ használatával!

- Add vissza a legmagasabb (legtöbb emelettel rendelkező) épületet `Optional`-ként! (Feltételezheted, hogy a lista nem üres és ilyenből csak egy van.)
- Add vissza listában az épületeket utcanév alapján!
- Add vissza az utcaneveket amik szerepelnek a listában, mindegyiket egyszer!
- Add vissza, hogy van-e egy bizonyos négyzetméternél nagyobb alapterületű épület egy utcában!

## Filekezelés (20 pont)

Ebben a feladatban a Bajnokok Ligája 2022/23-as szezon csoportkörének néhány meccséből készítünk statisztikát. Adott egy file, az
`input.txt`, melyben egy sor a következőképpen néz ki: `{dátum};{egyik csapat}-{másik csapat}`. A feladatod a fájl feldolgozása 
lesz.  
Készítsd el a `files.ChampionsLeagueService` nevű osztályt, melyben definiálsz egy `Map` adatszerkezetet! Az adatszerkezet kulcsa
egy csapatnév legyen, értéke pedig az, hogy mely napokon játszott! Olvasd be a fájl tartalmát, úgy hogy az adatszerkezet 
kulcsai ABC sorrendben rendezettek legyenek!

## Műveletek kollekciókon (25 pont)

A következő feladatokat a `files.ChampionsLeagueService` osztályban kell megvalósítanod. A megvalósításhoz __nem kötelező__
streamek-et használnod. Se plusz se minuszpont nem jár érte.

- Legyen egy `collectPlayDays()` nevű metódus ami egy halmazban visszaadja azokat a napokat amin volt mérkőzés!
- Legyen egy `findTeamsByDay(LocalDate date)` nevű metódus, ami visszaadja azokat a csapatokat, akik a paraméterül kapott napon játszottak mérkőzést!
- A `findTeamWithMostPlayedMatches()` metódusban add vissza annak a csapatnak a nevét, aki a legtöbb mérkőzést játszotta! 
  Feltételezhető, hogy van ilyen és pontosan egy!
  
## Guinness Rekordok (35 pont)

A `guinness` csomagba dolgozz!  

Készíts egy `Recorder` nevű osztályt, melynek attribútuma egy egyedi azonosító és a neve! Ezeket konstruktorban állítsd be! Két 
rekordert akkor tekintünk egyenlőnek, ha az azonosítójuk megegyezik!  

Készíts egy `RecordType` nevű enumot. Kétféle rekord létezik:
- időn alapuló (TIME)
- mennyiségen alapuló (QUANTITY)

Az enumban legyen egy szöveges mértékegység attribútum, ami az időnél "s" a mennyiségnél "quantity unit"!  

Készíts egy `GuinnessRecord` nevű osztályt, aminek attribútumai a rekord neve, a rekordtípus, egész számként a legjobb eredmény, 
és egy megfelelő adatszerkezetben a próbálkozások, amiben rekordereket és a hozzájuk tartozó próbálkozás eredmények listáját tárolod! 
Az adatszerkezet kezdetben üres.

`GuinnessRecord`-ot kivételesen ne konstruktorral lehessen létrehozni, hanem statikus metódussal 
(mint ahogy például `LocalDate`-t is az `of()` metódussal hozunk létre)!
Ennek menete a következő:
- Hozd létre a `static GuinnessRecord createGuinnessRecord(String recordName, RecordType recordType)` metódust!
- Legyen az osztályban egy `privát` konstruktor ami a rekord nevét a rekordtípust és a legjobb eredményt várja!
- Ha mennyiség alapú Guinness Record-ot akarunk létrehozni, akkor a statikus metódus adjon vissza egy olyan 
  objektumot amiben a legjobb eredmény 0!
- Ha idő alapú Guinness Recordot-t akarunk létrehozni, akkor a statikus metódus adjon vissza egy olyan objektumot 
  amiben a legjobb eredmény `Integer.MAX_VALUE`!

Ha nem sikerül így megoldanod a létrehozást, készíts egy publikus konstrutort ami a rekord nevét és típusát várja, 
és a fent megfogalmazottakhoz hasonlóan állítja be a legjobb időt (-3 pont ebben az esetben).   

Készíts egy `boolean tryBeatRecord(int amount, Recorder recorder)` metódust, ami hozzáadja a próbálkozást az adatszerkezethez
és ha a paraméterül kapott eredmény jobb, mint az eddigi legjobb, akkor átállítja azt és igaz értékkel tér vissza, ha nem jobb, akkor hamissal!
Vigyázz, a legjobb eredmény mást jelent idő alapú és mást mennyiség alapú rekord esetén! Időalapúnál a kevesebb jobb, 
míg mennyiség alapúnál a több a jobb!  

Készíts még egy `Recorder findRecordHolder()` nevű metódust, ami visszaadja azt a rekordert akinél a legjobb idő található.
Ha még nem érkezett próbálkozás dobjunk `RecordHasNoAttemptsException`-t.

Készíts egy `List<String> getOrderedRecorderNames()` metódust, ami abc sorrendben rendezetten adja vissza a rekorderek neveit!

Definiáld felül a `toString()` metódust a tesztnek megfelelő formátumban! Figyelj a mértékegységre!

_Megjegyzés: A statikus (úgynevezett factory) metódusra azért van szükség jelen esetben mert nem olyan szép dolog 
logikát rakni egy konstruktorba!_

