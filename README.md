# Decorator Design Pattern

Ein Lernprojekt zum **Decorator-Entwurfsmuster** im Rahmen einer Gruppenarbeit. Das Muster wird anhand von UI-Komponenten erklärt und modelliert.

## Projektidee

Eine UI-Komponente soll zur Laufzeit zusätzliche Funktionen erhalten können, ohne ihre ursprüngliche Klasse zu verändern. Dafür wird sie von einem oder mehreren Dekorierern umschlossen. Jeder Dekorierer implementiert dieselbe Schnittstelle wie die Komponente, delegiert Aufrufe an das umschlossene Element und ergänzt eigenes Verhalten.

## Beispiel: UI-Komponenten

Das Beispiel verwendet ein Textfeld als Basiskomponente. Darum können verschiedene Funktionen kombiniert werden:

- **RahmenDecorator** ergänzt einen Rahmen.
- **ScrollDecorator** ergänzt eine Scrollfunktion.
- **TooltipDecorator** ergänzt einen Tooltip.

Eine mögliche Verschachtelung ist:

```text
TooltipDecorator(
  ScrollDecorator(
    RahmenDecorator(Textfeld)
  )
)
```

Der aufrufende Code behandelt das fertige Element weiterhin als `UIComponent`. So lassen sich Funktionen flexibel kombinieren, ohne für jede Kombination eine eigene Klasse anzulegen.

## Rollen im Decorator-Muster

| Rolle | Beispiel im Projekt |
|---|---|
| Component | `UIComponent` |
| Concrete Component | `Textfeld` |
| Decorator | abstrakte Klasse `Decorator` mit einer Referenz auf `UIComponent` |
| Concrete Decorators | `RahmenDecorator`, `ScrollDecorator`, `TooltipDecorator` |

## UML-Klassendiagramm

Das bearbeitbare Diagramm liegt in [Decorator_UML.drawio](Decorator_UML.drawio) und kann mit [draw.io](https://app.diagrams.net/) geöffnet werden. Es zeigt die Schnittstelle, die konkrete Komponente, die Vererbung der Dekorierer und die Referenz auf die umschlossene UI-Komponente.

## Lernziele

- Aufbau und Funktionsweise des Decorator-Musters verstehen
- Vererbung, Komposition und Delegation im Diagramm erkennen
- das Muster auf ein konkretes UI-Beispiel übertragen
- Vorteile und mögliche Nachteile des Musters erklären
- eine Beispielimplementierung erstellen und vorstellen
