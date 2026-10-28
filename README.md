# Decorator Design Pattern

Lernprojekt zum **Decorator-Entwurfsmuster**. Das Muster wird anhand eines Café-Beispiels mit Kaffeegetränken und frei kombinierbaren Zusätzen in Java erklärt.

## 🐍 Python-Übung für die Klasse

**Ergänze einen Karamell-Dekorierer:** Erweitere ein Getränk um 0,40 Euro
und den Beschreibungsteil „Karamell“.

**Dauer:** ca. 15–20 Minuten · **Voraussetzung:** Python 3 und Grundlagen zu Klassen und Vererbung · **Zusätzliche Pakete:** keine

| Material | Hier geht es weiter |
|---|---|
| **Aufgabenblatt** | **[Aufgabe und Arbeitsschritte öffnen →](uebung_python/README.md)** |
| Startcode | [starter.py mit zwei TODOs](uebung_python/starter.py) |
| Musterlösung | [musterloesung.py zum späteren Vergleichen](uebung_python/musterloesung.py) |

Starte im Hauptordner des Repositories:

```powershell
python uebung_python/starter.py
```

> Der Startcode ist absichtlich unvollständig. Bei Karamell erscheint zunächst
> ein `NotImplementedError`; nach dem Ergänzen der TODOs läuft das Beispiel vollständig.

## Orientierung im Repository

[Java-Beispiel](#beispiel-kaffee-mit-zusätzen) ·
[Java starten](#ordnerstruktur-und-starten) ·
[UML-Diagramm](Decorator_UML.drawio) ·
[Vor- und Nachteile mit Einsatzsituationen](Vorteile_Nachteile.md) ·
[Quellen](#quellen)

## Beispiel: Kaffee mit Zusätzen

Das Café bietet Espresso und Filterkaffee an. Zu einem Getränk können Zusätze wie Milch, Sirup oder Sahne hinzugefügt werden. Jeder Zusatz ist ein Dekorierer: Er enthält ein anderes `Getraenk`, ergänzt dessen Preis und erweitert seine Beschreibung.

Eine Bestellung wird durch Verschachteln der Objekte zusammengestellt:

```java
Getraenk bestellung = new Sirup(new Milch(new Espresso()));
```

Das bedeutet: Ein Espresso wird zuerst mit Milch und anschließend mit Sirup umhüllt.

| Bestandteil | Preis |
|---|---:|
| Espresso | 2,00 € |
| Milch | + 0,50 € |
| Sirup | + 0,70 € |
| **Gesamtpreis** | **3,20 €** |

Die Beschreibung lautet `Espresso, Milch, Sirup`. Beim Aufruf von `getPreis()` fragt der Sirup den Preis des eingepackten Getränks ab, die Milch fragt wiederum den Preis des Espressos ab. Die Zusätze addieren ihre Preise auf dem Rückweg. `getBeschreibung()` funktioniert genauso: Jeder Dekorierer ergänzt den Namen seines Zusatzes.

## Rollen im Decorator-Muster

| Rolle | Beispiel |
|---|---|
| Component | Schnittstelle `Getraenk` mit `getPreis()` und `getBeschreibung()` |
| Concrete Components | `Espresso`, `Filterkaffee` |
| Decorator | abstrakte Klasse `GetraenkDekorierer` mit einer Referenz auf ein `Getraenk` |
| Concrete Decorators | `Milch`, `Sirup`, `Sahne` |

Alle Bestandteile verwenden dieselbe Schnittstelle. Deshalb lassen sich Getränke und Zusätze beliebig kombinieren, ohne für jede Kombination eine eigene Klasse wie `EspressoMitMilchUndSirup` erstellen zu müssen.

## Einfacher Aufbau des Codes

`GetraenkDekorierer` übernimmt für alle Zusätze dieselben zwei Aufgaben:
den Aufpreis addieren und den Namen an die Beschreibung anhängen.
Deshalb braucht jeder Zusatz nur noch einen Konstruktor, zum Beispiel:

```java
public Milch(Getraenk getraenk) {
    super(getraenk, "Milch", "0.50");
}
```

`super(...)` übergibt das eingepackte Getränk, den Namen und den Aufpreis
an die gemeinsame Oberklasse. `getPreis()` und `getBeschreibung()`
werden von dieser geerbt. Auch mehrfach verwendete Zusätze funktionieren:
`new Milch(new Milch(new Espresso()))` kostet 3.00 €.

Die Grundgetränke bleiben einfache Klassen mit ihrem Preis und Namen.
`Main` gibt die drei Beispiele direkt aus. Die Ausgabe verwendet
`System.out.println` ohne zusätzliche Zahlenformatierung.
`BigDecimal` bleibt für genaue Rechnungen erhalten; Preise werden aus
Strings wie `"0.50"` erzeugt.

## Ordnerstruktur und Starten

```text
src/
├── app/
│   └── Main.java
├── getraenke/
│   └── Getraenk.java
├── basisgetraenke/
│   ├── Espresso.java
│   └── Filterkaffee.java
└── beilagen/
    ├── GetraenkDekorierer.java
    ├── Milch.java
    ├── Sirup.java
    └── Sahne.java
out/                        # erzeugte .class-Dateien; nicht in Git
```

Die Ordner unter `src` entsprechen den Java-Paketen. Beispielsweise steht
`package basisgetraenke;` am Anfang von `Espresso.java`. Über `import`
werden Klassen aus anderen Paketen eingebunden. `Main` liegt im Paket `app`
und wird mit dem vollständigen Klassennamen `app.Main` gestartet.

Voraussetzung: ein installiertes JDK mit `javac` und `java`.
Diese Befehle im Hauptordner des Projekts ausführen:

```powershell
javac --release 8 -encoding UTF-8 -d out -sourcepath src src/app/Main.java
java -cp out app.Main
```

`--release 8` erzeugt Bytecode für Java 8 und neuer. Das ist hier wichtig,
weil im Terminal der Compiler aus Java 21, die Laufzeit aber aus Java 8
verwendet wird. Der Build-Befehl benötigt einen Compiler ab JDK 9.

Der Compiler findet die verwendeten Klassen über `-sourcepath src` und
legt die übersetzten Dateien mit ihrer Paketstruktur unter `out` ab.
Nach Änderungen erneut kompilieren. Zum Bearbeiten immer die `.java`-Dateien
verwenden, nicht die erzeugten `.class`-Dateien.

Erwartete Ausgabe:

```text
Espresso: 2.00 Euro
Espresso, Milch, Sirup: 3.20 Euro
Filterkaffee, Sahne: 2.10 Euro
```

## UML-Klassendiagramm

Das bearbeitbare Diagramm liegt in [Decorator_UML.drawio](Decorator_UML.drawio). Es zeigt die Schnittstelle `Getraenk`, die konkreten Getränke, den abstrakten Dekorierer und die Referenz auf das verpackte Getränk.

## Projektziele

- Aufbau und Funktionsweise des Decorator-Musters verstehen
- Vererbung, Komposition und Delegation am Beispiel erklären
- das Muster in einer Java-Beispielimplementierung anwenden
- mögliche Vorteile und Nachteile des Musters vorstellen

Die Beispielimplementierung dieses Lernprojekts wird in Java umgesetzt.

## Quellen

- [Philipp Hauer - Decorator Pattern](https://www.philipphauer.de/study/se/design-pattern/decorator.php)
- [Decorator Pattern - Wikipedia](https://de.wikipedia.org/wiki/Decorator_(Entwurfsmuster))
- [Java Decorator Pattern Example](https://refactoring.guru/design-patterns/decorator/java/example)
