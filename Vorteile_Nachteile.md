## Vorteile

- **Flexibel kombinierbar:** Dekorierer können einzeln oder verschachtelt eingesetzt werden. So lässt sich das Verhalten eines Objekts gezielt und bei Bedarf zur Laufzeit erweitern. ([Refactoring.Guru](https://refactoring.guru/design-patterns/decorator/java/example), [Philipp Hauer](https://www.philipphauer.de/study/se/design-pattern/decorator.php))
- **Weniger Unterklassen:** Für jede mögliche Kombination von Erweiterungen muss keine eigene Unterklasse entstehen. Das vermeidet lange, schwer wartbare Vererbungshierarchien. ([Philipp Hauer](https://www.philipphauer.de/study/se/design-pattern/decorator.php))
- **Einfacher erweiterbar und wartbar:** Neue Funktionen können als eigene Dekorierer ergänzt werden. Bestehende Komponenten bleiben dabei unverändert und die einzelnen Klassen bleiben auf ihre jeweilige Aufgabe konzentriert. ([Philipp Hauer](https://www.philipphauer.de/study/se/design-pattern/decorator.php))

## Nachteile

- **Mehr Objekte und Verschachtelung:** Jede Erweiterung benötigt ein eigenes Dekoriererobjekt. Viele Dekorierer können die Objekterstellung und den Aufbau der Kette unübersichtlich machen. ([Philipp Hauer](https://www.philipphauer.de/study/se/design-pattern/decorator.php))
- **Schwierigere Fehlersuche:** Bei langen Aufrufketten kann es aufwendiger sein, den Dekorierer zu finden, der einen Fehler verursacht. ([Philipp Hauer](https://www.philipphauer.de/study/se/design-pattern/decorator.php))
- **Objektidentität unterscheidet sich:** Ein dekoriertes Objekt ist eine andere Instanz als die umschlossene Komponente. Vergleiche, die auf derselben Objektinstanz beruhen, können deshalb unerwartet ausfallen. ([Wikipedia](https://de.wikipedia.org/wiki/Decorator_%28Entwurfsmuster%29))

## Geeignete Einsatzsituationen

- **Sinnvoll bei optionalen, kombinierbaren Erweiterungen:** Eine Textkarte kann je nach Bedarf einen Rahmen, einen Schatten oder beides erhalten. Die Dekorierer lassen sich unabhängig kombinieren, ohne für jede Variante eine eigene Textkartenklasse anzulegen. ([Philipp Hauer](https://www.philipphauer.de/study/se/design-pattern/decorator.php))
- **Sinnvoll, wenn Funktionen zur Laufzeit hinzugefügt oder entfernt werden sollen:** Das Muster eignet sich, wenn dieselbe Komponente flexibel unterschiedlich erweitert werden soll, zum Beispiel eine Textkomponente mit Rahmen oder Scrollleiste. ([Philipp Hauer](https://www.philipphauer.de/study/se/design-pattern/decorator.php), [Wikipedia](https://de.wikipedia.org/wiki/Decorator_%28Entwurfsmuster%29))
- **Eine einfachere Lösung reicht bei wenigen festen Varianten:** Wenn Erweiterungen kaum kombiniert werden und sich nicht zur Laufzeit ändern, kann eine einfache Klassenlösung übersichtlicher sein. Die zusätzlichen Objekte und Verschachtelungen des Decorator-Musters wären dann möglicherweise unnötiger Aufwand. ([Philipp Hauer](https://www.philipphauer.de/study/se/design-pattern/decorator.php))
