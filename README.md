# BHAX-NLM

- - -

## Mi ez?

Ez egy, a DE-IK/PTI "Magas szintű programozási nyelvek 1" c. kurzusához, beadandóként elkészített programozásos könyv repója, inkább gyakorlattabb szemek számára. A könyv (`Univerzális programozás - Így neveld a programozód!`) célja, hogy fejezetein keresztül betekintést adjon a programozás számos alterületére, megismertesse az olvasót néhány neves problémával, eljárással és személlyel, valamint olyan technológiákkal és nyelvekkel mint a TensorFlow, a Lisp, az R, stb.

Ami minket, a hallgatókat érinti, az elképzelés az volt, hogy "tanuljunk meg programozni programozó könyv írása által", ismerkedjünk meg a DocBook XML formátummal, fedezzük fel ezeket a témákat saját magunktól (~személyiségfejlesztés), miközben teljesítjük a syllabusban kijelölt követelményeket is.

## Hasznos-e ez nekem?

Attól függ. Amennyiben te is DE-IK/PTI hallgató vagy, és neked is ki lett jelölve ennek a könyvnek a megírása feladatként, természetesen. Egyrészt referenciaként, másrészt hasznos tudásforrásként is (remélhetőleg).

Amennyiben nem, attól még továbbra is jól jöhet belőle pár rész. Ha van olyan témakör, kérdés vagy eljárás amit keresel, és a könyv tárgyalja (ld. az előre exportált pdf-ben a tartalomjegyzéket), úgy szintén kapóra jöhet, ha belelapozgatsz.

Minden más helyzetben a döntés a tiéd. Az egyetlen amit érdemes szemelőtt tartani az talán az, hogy ez a repó [ennek](https://gitlab.com/nbatfai/bhax) a repónak a forkja, ami azt jelenti, hogy a licenszét is viszi tovább, ami a GNU GPLv3 a forkolás idején ([0f4fd8c9](https://gitlab.com/nbatfai/bhax/commit/0f4fd8c9983b9fda8ec46f9ab3320561a7b28450)). Ennek a licensznek a tulajdonságairól [itt](https://choosealicense.com/licenses/gpl-3.0/) tájékozódhatsz.

## Hibát és/vagy halott hivatkozást találtam, mi a teendő?

A beadandó készítése közben igyekeztem ügyelni a hibák minimalizálására, és a lehető legtöbb link archiválására a [Wayback Machine](http://web.archive.org/) segítségével, elkerülendő az idő folyamán eltűnő forrásokat. Természetesen azonban egyrészt én is emberből vagyok, hibázhatok, másrészt ez a readme dokumentum élő linkeket tartalmaz, így elavulhat.

Amennyiben hibába, halott linkbe, vagy egyéb problémába ütközöl, nyiss egy ticketet a repó `Issues` oldalán. Sajnos a repó természete miatt viszont (beadandó egy egyetemi tantárgyhoz :p) nem tudom megígérni, hogy naprakészen fogom tartani, amennyiben nem reagálok a ticketre, sajnálom.

## Elég ha letöltöm a pdf-et, vagy nekem kell lefordítani? Ha az utóbbi, hogyan?

Mivel nem lőttem össze még a CI-t, a repóba feltolt pdf kézzel került fordításra és commitolásra, azaz előfordulhat, hogy megfeledkeztem commit után fordítani, így outdated pdf ment fel a repóba (valószínűtlen, de megeshet). Ezt könnyen ellenőrizheted a `Commits` oldalon.

Amennyiben saját magadnak akarod fordítani a könyv forrását, a megfelelő dependency-k telepítése után mindössze egy `make` hívására lesz szükséged. Fontos megjegyezni, hogy a dependency-k telepítésére vonatkozó parancs, és a makefile is degradálódhat az idők folyamán, az ezekkel kapcsolatos hibákat szintén az `Issues` oldalon lehet jelezni.

A dependency-k behúzásához:

```
sudo apt install -y docbook docbook-xml docbook-xsl xsltproc build-essential dblatex graphviz texlive-lang-european
```
