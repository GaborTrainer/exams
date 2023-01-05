# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd! Bármely régebbi osztályt megnyithatsz.

Az exams repository-ba dolgozz. Ezen könyvtár tartalmát nyugodtan át lehet másolni (`pom.xml`, tesztesetek). Ha másik Java verziót használsz, 
akkor ne felejtsd el a megfelelő paramétereket átírni a `pom.xml`-ben. 
Az exams repository-n belül a projekt neve legyen: `sv3-2022-jvjbf-elso-reszvizsga`. GroupId: `training360`, artifactId: `sv3-2022-jvjbf-elso-reszvizsga`.

Ha ezzel kész vagy, azonnal commitolj, a commit szövege legyen: "init".

Az egyes feladatokat külön csomagba szervezd! A csomagneveket a feladat leírásában találod. Minden egyes feladathoz tartozik
egy-egy előre elkészített `XxxTest` osztály, mindegyikben több `test()` metódussal. Ezekkel a megoldásod helyességét
ellenőrizheted. Ha a tesztek nem futnak, akkor ne a
`test()` metóduson változtass, hanem a saját megoldásodat nézd át újra!

A feladatra 90 perced van összesen!

Ha letelik az idő, mindenképp commitolj, akkor is, ha nem vagy kész! A commit időpontja alapján fogjuk ellenőrizni a megoldásod.
Ha nincs commitod az idő lejárta előtt, akkor sajnos nem tudjuk értékelni a megoldásod! Fontos, hogy csak olyan kódot tölts fel, amit egyből tudunk futtatni!
Ha a kódod egyes részei nem fordulnak le, akkor inkább tedd őket kommentbe. 

## Szavak (10 pont)

Készítsd el a `words.Words` nevű osztályt, melyben van egy `String deleteEvenCharacters(String word)` nevű metódus, ami
úgy adja vissza a szót, hogy csak a páratlan indexű karakterek szerepelnek benne. Üres szó esetén üres szót várunk vissza. 

pl.: "alma"->"la", "a"->"", "almafa"->"laa", ""->""

## Videómegosztó

### 1. rész (20 pont)
Készíts egy `videos.Video` nevű osztályt, melynek attribútumai a videó címe, a feltöltés dátuma, a videó hossza (percben), a videó típusa (`Type`), 
illetve megtekintések száma. A típus egy enum, és a következő értékekkel rendelkezhet: `MUSIC, DOCUMENTARY, INTERVIEW, VLOG`. A videó létrehozásakor
a megtekintések kivételével minden attribútumot konstruktorban állítsunk be a kapott értékekre, a megtekintések száma kezdetben 0. Legyenek az attribútumokhoz
getter metódusok és egy `void watchVideo()` metódus, ami a megtekintések számát növeli.

Készíts egy `videos.User` nevű osztályt, ő a videók feltöltője. Legyen egy felhasználóneve és a videóinak a listája, melyek közül a felhasználónevet
kapja konstruktorban, a lista kezdetben üres.  

Legyen egy `void uploadVideo(Video video)` metódusa, amivel videót lehet hozzáadni a listához, illetve getter metódusok.  

Készíts egy `videos.StreamingPlatform` nevű osztályt, aminek atribútuma a `User`-ek listája, mely kezdetben üres. Legyen egy `void addUser(User user)` metódusa,
amivel felhasználót lehet hozzáadni a listához, illetve getter metódusok. 

### 2. rész (20 pont)

Bővítsd a `User` osztályt egy `int countVideosByType(Type type)` metódussal, ami visszaadja, hogy a felhasználónak hány videója van a
paraméterül kapott típusból.<br>

Bővítsd a `User` osztályt egy `int sumOfViews()` metódussal, ami kiszámolja a felhasználó videóinak össznézettségét.

Bővítsd a `StreamingPlatform` osztályt egy `int findMaxViews()` metódussal, ami visszaadja a legnagyobb nézettségű felhasználó össznézettségi adatát. 
A metódushoz használd fel az előbb megírt `sumOfViews()` metódust!





