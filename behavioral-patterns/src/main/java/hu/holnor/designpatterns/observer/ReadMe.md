<h1>Observer Pattern</h1>

<p>Az Observer mintázat jellemzően az objektumok között jelenlévő one-to-many kapcsolat során használható hatékonyan. Tegyük fel, hogy van egy időjárás állomásunk, ami adatokat gyárt, és van pár eszközünk, ami hozzá csatlakozva képes megjeleníteni a kapott információkat. Az eszközöknek valahogy értesülni kell arról, hogy változás történt és az alapján frissíteni kell a kijelző tartalmát. Ezt megtehetnék akár úgy is, hogy állandóan kérdezgetnék az állomást, hogy: Na, van változás?
De ezzel több problémát teremtünk, mint amennyit megoldunk. Csupán néhány azonnal felmerülő kérdés:</p>
<ul>
    <li>Milyen gyakran kérdezzenek az eszközök?</li>
    <li>Milyen gyakran kérdezzenek az eszközök?</li>
    <li>Mi van akkor, ha a rákérdezés utáni másodpercben következik be a változás?</li>
</ul>

<p>Pusztán ebből a pár kérdésből is láthatjuk, hogy ez így nem lesz jó és valami mással kell próbálkozni. Ha megfordítanánk
az irányt, és nem az eszközök kérdezgetnék az állomást, hogy történt-e változás, hanem az állomás - aki naprakészen
ismeri a saját állapotát (pl: hőmérséklet, páratartalom, stb.) - küldene tájékoztatást az eszközöknek arról, hogy
változás történt, az nagyban leegyszerűsítené a dolgunkat.<br>
De mielőtt belevágnánk a kódolásba gondolkozzunk egy kicsit, és próbáljunk meg programozni az interfész szintjén!
Kijelenthetjük az állomásról, hogy az egy megfigyelhető dolog, míg az eszközök megfigyelők. Az „Observable” interfészünk
három metódus megvalósítását írja elő az őt implementáló osztálynak: </p>
<ol>
<li>Képesnek kell lennie felvenni egy új megfigyelőt (register)</li>
<li>Képesnek kell lennie törölni egy meglévő megfigyelőt (unregister)</li>
<li>És legfőképp képesnek kell lennie tájékoztatni a megfigyelőket, ha változás állt be az álapotában (notify)</li>
</ol>

<p>Ezzel egyidejűleg az „Observer”-t implementáló osztályoknak képesnek kell lenniük arra, hogy frissítsék a kijelző tartalmát, ha változás következik be az állomásban. Itt fontos emlékeznünk rá, hogy mindössze egy „Observable” interfészt implementáló osztályunk, de akárhány „Observer”-t implementáló osztályunk lehet.</p>

<p>Ezzel lefektettük az alap viselkedést, és máris felismerjük, hogy a példányosított állomásunknak szüksége lesz majd egy
listára, amiben gyűjtheti az őt „követő” eszközöket. Az állomásunknak persze lehetnek még saját metódusai – például,
hogy felülírja a példányváltozókat – de az interfészben meghatározott metódusokat mindenképp meg kell valósítania.
Nézzük is meg, hogyan fognak kinézni ezek az osztályok:</p>

<p>Az itteni példában az állomás privát metódusai valamilyen logika révén képesek beállítani új értékeket a hőmérsékletnek
és a páratartalomnak. Amikor ez megtörténik, akkor egyből meg is hívjuk a notify() metódust, ami végig iterál az összes
eszközön, és meghívja az update() metódusokat.
Ezen a ponton már biztos felmerül a kérdés, hogy -oké, meghívjuk a metódust, na de honnan fogja tudni az eszköz, hogy mi
változott, hiszen a jelenlegi felállásban, az eszközök nem férnek hozzá az állomás tulajdonságaihoz. Megtehetnénk, hogy
úgy hagyjuk a modellünket, ahogy fentebb vázoltuk, de akkor bele kell passzírozni a WeatherStation osztályunkba egy
metódust, ami minden eszköznek átadja az értéket és ezzel a megközelítéssel megszegjük azt az alapelvet, miszerint
minden osztály csak a saját dolgával foglalkozik.</p>
Ezért ki kell egészítenünk az ábránkat egy fontos változtatással:
Minden eszköznek lesz egy állomása, illetve a one-to-many kapcsolat miatt mondjuk inkább úgy, hogy minden eszköznek
ugyanaz az állomása lesz.

Minden alkalommal, amikor valami változás történik az állomás példányváltozóit illetően, akkor meghívjuk az állomáson a
notify() metódust.

Az állomás ugyebár egy listába szedi az összes regisztrált eszközt, így a notify() metóduson belül az állomás végig
iterálhat az eszközökön, és így képes meghívni mindegyik eszköz update() metódusát.
Az eszközök update() metódusa pedig elkéri az állomástól az adatokat annak getterein keresztül. Ezt már azért teheti
meg, mert a konstruktoron keresztül beállítjuk mindegyik eszköznek a példányosított állomást. Ez az állomás nem más mint
egy referencia az „Observable” interfészt implementáló „WeatherStation” objektumhoz és így minden egyes eszköz ugyanazt
az állomást kapja meg.

Forrás:<br>
<a>https://youtu.be/_BpmfnqjgzQ
<br>Observer Pattern – Design Patterns (ep 2)<br>
Head First Design Patterns by: Eric Freeman, Elisabeth Robson, Bert Bates, Kathy Sierra