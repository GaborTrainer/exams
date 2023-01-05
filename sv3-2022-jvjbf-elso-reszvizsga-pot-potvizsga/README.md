# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd! Bármely régebbi osztályt megnyithatsz.

A exams repository-ba dolgozz. Ezen könyvtár tartalmát nyugodtan át lehet másolni (`pom.xml`, `Teszt esetek`). Ha másik
Java verziót használsz, akkor ne felejtsd el a megfelelő paramétereket átírni a pom.xml-ben. A exams repository-n belül
a projekt neve legyen: `sv3-2022-jvjbf-elso-reszvizsga-pot-potvizsga`. GroupId: `training360`,
artifactId: `sv3-2022-jvjbf-elso-reszvizsga-pot-potvizsga`.

Ha ezzel kész vagy, azonnal commitolj, a commit szövege legyen: "init".

Az egyes feladatokat külön csomagba szervezd! A csomagneveket a feladat leírásában találod. Minden egyes feladathoz
tartozik egy-egy előre elkészített `XxxTest` osztály, mindegyikben több `test()` metódussal. Ezekkel a megoldásod
helyességét ellenőrizheted. Ha a tesztek nem futnak, akkor ne a
`test()` metóduson változtass, hanem a saját megoldásodat nézd át újra!

A feladatra 90 perced van összesen!

Ha letelik az idő, mindenképp commitolj, akkor is, ha nem vagy kész! A commit időpontja alapján fogjuk ellenőrizni a
megoldásod. Ha nincs commitod az idő lejárta előtt, akkor sajnos nem tudjuk értékelni a megoldásod! Fontos, hogy csak
olyan kódot tölts fel amit egyből tudunk futtatni, ha kikommentelsz részeket az nem probléma.

## Legnagyobb közös osztó (10 pont)

Az `algorithms.Algorithms` osztályban írj egy `int greatestCommonDivisor(int firstNumber, int secondNumber)` metódust, mely két számot vár paraméterül és visszaadja a két szám legnagyobb közös osztóját. 
Azaz azt a számot, ami mindkét paraméterül kapott számot osztja, és ezek közül is a legnagyobb. Vigyázz, akár az egyik szám is lehet a legnagyobb közös osztó. pl.: 3 és 9 legnagyobb közös osztója a 3. 

## Szakácskönyv

### 1. rész (20 pont)

Készíts egy `cookbook.Recipe` nevű osztályt, melynek attribútumai a recept neve, a nehézsége ami a következő értékeket
veheti fel : `EASY,MEDIUM,HARD`, a hozzávalók szövegként egy listában, és a leírás. Minden attribútumot konstruktorban
állíts be. Legyen benne még egy `boolean containsIngredient(String ingredient)` metódus, ami igazzal tér vissza, ha a recept 
tartalmazza a hozzávalót, különben hamissal. 

Készíts egy `cookbook.CookBook` nevű osztályt, amiben egy kezdetben üres receptek lista található. Legyen benne egy
`boolean addRecipe(Recipe recipe)` metódus, ami egy receptet hozzáaad a listához. Egy feltétel van, ha a recept `EASY`
vagy `MEDIUM`
akkor legfeljebb 10 hozzávalója lehet! Ha ez nem teljesül ne adjuk hozzá a receptet a listához és `false` értékkel
térjünk vissza.

### 2. rész (20 pont)

Bővítsd a `CookBook` osztályt egy `boolean isRecipeInCookbookWithDifficulty(Difficulty difficulty)` metódussal, ami igazzal tér vissza,
ha a szakácskönyvben van a paraméterül átadott nehézségű recept. Ha nincs akkor hamissal. 

Bővítsd a `CookBook` osztályt egy `int findNumberOfMaxIngredients()` metódussal, ami visszaadja a legtöbb hozzávalóval rendelkező
recept hozzávalóinak számát. Ha nincs recept a listában akkor 0-t, ha több recept is van ugyanazzal a maximumértékkel akkor az első találatot. 

Bővítsd a `CookBook` osztályt egy `int countRecipeWithIngredient(String ingredient)` metódussal, ami megszámolja, hogy hány olyan recept van,
ami tartalmazza a paraméterül átadott hozzávalót! Használd a fentebb megírt `containsIngredient()` metódust. 








