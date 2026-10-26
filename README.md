# Decorator Design Pattern

Lernprojekt zum **Decorator-Entwurfsmuster**. Das Muster wird an einem Café-Beispiel mit Kaffeegetränken und frei kombinierbaren Zusätzen erklärt.

## Beispiel: Kaffee mit Zusätzen

Das Café bietet Espresso und Filterkaffee an. Zu einem Getränk können Zusätze wie Milch, Sirup oder Sahne hinzugefügt werden. Jeder Zusatz ist ein Dekorierer: Er enthält ein anderes `Getraenk`, ergänzt dessen Preis und erweitert seine Beschreibung.

Eine Bestellung wird durch Verschachteln der Objekte zusammengestellt:

```python
bestellung = Sirup(Milch(Espresso()))
```

Das bedeutet: Ein Espresso wird zuerst mit Milch und anschließend mit Sirup umhüllt.

| Bestandteil | Preis |
|---|---:|
| Espresso | 2,00 € |
| Milch | + 0,50 € |
| Sirup | + 0,70 € |
| **Gesamtpreis** | **3,20 €** |

Die Beschreibung lautet `Espresso, Milch, Sirup`. Beim Aufruf von `get_preis()` fragt der Sirup den Preis des eingepackten Getränks ab, die Milch fragt wiederum den Preis des Espressos ab. Die Zusätze addieren ihre Preise auf dem Rückweg. `get_beschreibung()` funktioniert genauso: Jeder Dekorierer ergänzt den Namen seines Zusatzes.

## Rollen im Decorator-Muster

| Rolle | Beispiel |
|---|---|
| Component | `Getraenk` mit `get_preis()` und `get_beschreibung()` |
| Concrete Components | `Espresso`, `Filterkaffee` |
| Decorator | abstrakte Klasse `GetraenkDekorierer` mit einer Referenz auf ein `Getraenk` |
| Concrete Decorators | `Milch`, `Sirup`, `Sahne` |

Alle Bestandteile verwenden dieselbe Schnittstelle. Deshalb lassen sich Getränke und Zusätze beliebig kombinieren, ohne für jede Kombination eine eigene Klasse wie `EspressoMitMilchUndSirup` erstellen zu müssen.

## UML-Klassendiagramm

Das bearbeitbare Diagramm liegt in [Decorator_UML.drawio](Decorator_UML.drawio). Es zeigt die Schnittstelle `Getraenk`, die konkreten Getränke, die Vererbung der Dekorierer und die enthaltene Referenz auf das verpackte Getränk.

## Projektziele

- Aufbau und Funktionsweise des Decorator-Musters verstehen
- Vererbung, Komposition und Delegation am Beispiel erklären
- das Muster in einer Beispielimplementierung anwenden
- mögliche Vorteile und Nachteile des Musters vorstellen

Die Aufgabenstellung sieht Python vor. Nach Rücksprache mit der Lehrkraft sind für die Implementierung auch Java oder C# möglich.

## Quellen

- [Philipp Hauer - Decorator Pattern](https://www.philipphauer.de/study/se/design-pattern/decorator.php)
- [Decorator Pattern - Wikipedia](https://de.wikipedia.org/wiki/Decorator_(Entwurfsmuster))
- [Python Decorator Pattern Example](https://refactoring.guru/design-patterns/decorator/python/example)
- [Java Decorator Pattern Example](https://refactoring.guru/design-patterns/decorator/java/example)
- [C# Decorator Pattern Example](https://refactoring.guru/design-patterns/decorator/csharp/example)