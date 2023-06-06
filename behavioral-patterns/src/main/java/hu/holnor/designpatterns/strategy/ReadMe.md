Strategy Pattern


Kicserélhető algoritmusok (nem kell a klienst is változtatni)
Függetlenné teszi az algoritmust a használójától (klienstől)
Rámutat, hogy sok esetben hasznosabb egy has-a, mint egy is-a kapcsaolat (Composition vs Inheritance)
Pl.
van egy Kacsa és van egy csomó másik kacsa, akik leszármazottai. Ez addig nem is okoz problémát, amíg a különféle leszármazottak ugyanúgy valósítják meg a szülő viselkedését. De mi a helyzet akkor, ha a leszármazottak egyre sokfélébbek lesznek és másként valósítják meg a szülő viselkedését: Másként eszik, másként repül, másféle hangot ad ki, stb. Ugyanakkor a testvérek között sokan vannak, akik ugyanúgy esznek, vagy repülnek, vagy végzik egyéb viselkedésüket.
Testvérek között nincs öröklődés, így ezeket a metódusokat egy az egyben le kell másolni: copy-paste. Vagy találunk valami más megoldást. Itt jön szóba a Strategy tervezési minta.

A leszármazottakat kliensnek hívjuk ebben a modellben, a szülő pedig a kontextus. A kontextus kompozícióban használja fel az érintett metódusokat meghatározó interfészeket (pl. repülés, evés, hápogás), amiket stratégiának hívunk. Ahelyett, hogy a legkülönfélébb kacsa osztályokat készítenénk el, amelyek implementálják a számukra megfelelő interfészeket, inkább azt mondjuk, hogy a stratégiát implementálják a legkülönfélébb viselkedési példányok.
A csavar ott van a példában, hogy a kacsa osztály, mint arra emlékszünk nem implementálja a stratégia interfészeket, hanem tartalmazza azokat. Így a kacsa példányosításakor egy konstruktoron keresztül meghatározhatjuk a viselkedési stratégiákat, amik már nem interfészek, hanem az adott stratégiát implementáló konkrét példányok lesznek.
Ezáltal úgy hozhatok létre kacsa típusú objektumokat, hogy a bennük megvalósított metódusok eltérőek lehetnek, ráadásul egy rendkívül rugalmas szerkezetet hoztunk ezzel létre, ami lehetővé teszi az algoritmusok cseréjét akár futásidő közben is anélkül, hogy a kontextus vagy a kliens osztályokhoz hozzá kéne nyúlnunk. További előny még a könnyű tesztelhetőség, mivel a konkrét stratégiák jól elkülönülnek a kontextustól.
