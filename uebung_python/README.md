# Klassenübung: Ein Karamell-Dekorierer in Python

## Ziel

Erweitere ein Getränk um Karamell. Du übst, wie ein Dekorierer ein anderes
Objekt enthält, Methodenaufrufe an dieses weiterleitet und dessen Verhalten
ergänzt. Dafür benötigst du Grundkenntnisse zu Python-Klassen, Methoden und
Vererbung. Plane ungefähr 15–20 Minuten ein.

## Material und Start

- [starter.py](starter.py): Startcode mit zwei TODOs für deine Bearbeitung.
- [musterloesung.py](musterloesung.py): vollständige Lösung zum späteren Vergleichen.

Du benötigst Python 3.6 oder neuer. Die verwendeten Module `abc` und `decimal`
gehören zur Standardbibliothek; es müssen keine Pakete installiert werden.
Öffne ein Terminal im Hauptordner des Projekts und starte:

```powershell
python uebung_python/starter.py
```

Unter Windows kannst du bei Bedarf `py` statt `python` verwenden.
Der Startcode ist absichtlich unvollständig: Die ersten beiden Bestellungen
werden ausgegeben, bei Karamell meldet er zunächst einen `NotImplementedError`.
Er läuft erst nach dem Ergänzen der beiden TODOs vollständig durch.

## Aufgabe

Ein Espresso kostet 2,00 Euro. Milch erhöht seinen Preis um 0,50 Euro.
Implementiere die vorbereitete Klasse `Karamell`, damit sie jedes `Getraenk`
um 0,40 Euro und den Beschreibungsteil `, Karamell` erweitert.

1. Lies die Klassen `Getraenk`, `Espresso`, `GetraenkDekorierer` und `Milch`.
   `Getraenk` legt die gemeinsamen Methoden fest. Der Dekorierer speichert
   das eingepackte Getränk in `self._getraenk`.
2. Ergänze `Karamell.get_preis()`: Frage den Preis des eingepackten Getränks
   ab und addiere den Karamell-Aufpreis. Gib das Ergebnis als `Decimal` zurück.
3. Ergänze `Karamell.get_beschreibung()`: Frage die vorhandene Beschreibung
   ab und hänge den Namen des Zusatzes an. Gib den neuen Text zurück.
4. Ersetze dabei beide `raise NotImplementedError(...)`-Anweisungen.
   Verwende für den Aufpreis `Decimal("0.40")`, damit mit exakten Dezimalwerten
   gerechnet wird. Der Preis des Espressos soll im Dekorierer nicht feststehen.
5. Starte deine Datei erneut und vergleiche die Ausgabe:

```text
Espresso: 2.00 Euro
Espresso, Milch: 2.50 Euro
Espresso, Milch, Karamell: 2.90 Euro
```

## Prüfe deine Lösung

Probiere zusätzlich diese Bestellungen aus. Der Dekorierer soll sowohl ein
Grundgetränk als auch einen anderen Dekorierer umschließen können.

| Bestellung | Beschreibung | Preis |
|---|---|---:|
| `Karamell(Espresso())` | `Espresso, Karamell` | 2.40 Euro |
| `Karamell(Milch(Espresso()))` | `Espresso, Milch, Karamell` | 2.90 Euro |
| `Karamell(Karamell(Milch(Espresso())))` | `Espresso, Milch, Karamell, Karamell` | 3.30 Euro |

Deine Lösung ist fertig, wenn die TODOs ersetzt sind, die Ergebnisse stimmen
und du folgende Fragen beantworten kannst:

- Welche Klassen übernehmen die Rollen Component, Concrete Component,
  Decorator und Concrete Decorator?
- In welcher Reihenfolge werden die Objekte bei
  `Karamell(Milch(Espresso()))` nach ihrem Preis gefragt?
- Warum kann `Karamell` sowohl einen Espresso als auch ein bereits dekoriertes
  Getränk umschließen?

## Musterlösung und Erklärung

Vergleiche deine Umsetzung nach der Bearbeitung mit der separaten Musterlösung:

```powershell
python uebung_python/musterloesung.py
```

`Getraenk` ist die Component, `Espresso` die Concrete Component und
`GetraenkDekorierer` der abstrakte Decorator. `Milch` und `Karamell` sind
Concrete Decorators. Weil alle dieselbe Schnittstelle verwenden, können sie
ineinander verschachtelt werden.

Der äußere Karamell-Dekorierer fragt Milch nach ihrem Preis, Milch fragt den
Espresso. Auf dem Rückweg werden erst 0,50 Euro und dann 0,40 Euro addiert:
2,00 + 0,50 + 0,40 = 2,90 Euro. Die Beschreibung wird entsprechend ergänzt.

## Zusatzaufgabe

Entwirf einen weiteren Zusatz mit eigenem Namen und Aufpreis und kombiniere
ihn mit Milch und Karamell. Erkläre anschließend, weshalb dafür keine Klasse
für jede einzelne Getränkekombination benötigt wird.
