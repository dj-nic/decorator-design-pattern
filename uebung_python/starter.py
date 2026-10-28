"""Startcode: Ergänze die beiden TODOs im Karamell-Dekorierer."""

from abc import ABC, abstractmethod
from decimal import Decimal


class Getraenk(ABC):
    @abstractmethod
    def get_preis(self) -> Decimal:
        pass

    @abstractmethod
    def get_beschreibung(self) -> str:
        pass


class Espresso(Getraenk):
    def get_preis(self) -> Decimal:
        return Decimal("2.00")

    def get_beschreibung(self) -> str:
        return "Espresso"


class GetraenkDekorierer(Getraenk):
    def __init__(self, getraenk: Getraenk) -> None:
        self._getraenk = getraenk


class Milch(GetraenkDekorierer):
    def get_preis(self) -> Decimal:
        return self._getraenk.get_preis() + Decimal("0.50")

    def get_beschreibung(self) -> str:
        return self._getraenk.get_beschreibung() + ", Milch"


class Karamell(GetraenkDekorierer):
    def get_preis(self) -> Decimal:
        # TODO 1: Preis des eingepackten Getränks abfragen und 0,40 Euro addieren.
        raise NotImplementedError("TODO 1: Preisberechnung ergänzen")

    def get_beschreibung(self) -> str:
        # TODO 2: Beschreibung des eingepackten Getränks um Karamell erweitern.
        raise NotImplementedError("TODO 2: Beschreibung ergänzen")


def main() -> None:
    bestellungen = (
        Espresso(),
        Milch(Espresso()),
        Karamell(Milch(Espresso())),
    )
    for getraenk in bestellungen:
        print(f"{getraenk.get_beschreibung()}: {getraenk.get_preis():.2f} Euro")


if __name__ == "__main__":
    main()
