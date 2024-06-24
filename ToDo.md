# ToDo Liste

## T1 - Basis fertigstellen

- Limiter fertigstellen
- Layout des Projektes umgestalten und diverse Vererbungen einbinden

## T2 - Scenes erstellen

- Scene erstellen für den **Playing** State und diese Initialisieren
- Generierung des Pfades nur bei der Initialisierung ausführen
- Controller für die Initialisierung der Map sowie für den späteren Spielverlauf erstellen
(**MapController** + **TileController**)

## T3 - Custom Buttons für das Hauptmenü erstellen

- Eigene Komponenten Library erstellen für die Erstellung von Buttons
- Button **Play** erstellen und Funktionalität hinzufügen (Scene wechseln zu **Playing**)
- Button **Exit** erstellen und Funktionalität hinzufügen (Programm beenden)

## T4 - BottomBar einfügen

- Generierung des Pfades beschränken in der Höhe
- Spielbereich einfügen für die Interaktion des Spielers

## T5 - BottomBar mit Buttons befüllen

- Platzhalter erstellen für die Karten in der BottomBar
- Draw Funktion erstellen für erste Interaktion
- **CardController** erstellen für die *Draw* Funktion

## T5 - Gegner

- Klasse für Gegner erstellen und deren Attribute
- Controller für die Interaktion mit den Gegnern
- Zeichnen der Formen für die Gegner. Geplant sind Geometrische Formen, mit unterschiedlichen Farben für unterschiedliche Attribute
  - Gelb - schnelle Gegner
  - Rot - Viele Lebenspunkte
  - Blau - Teilt sich in kleinere Gegner
- Gegner generieren auf der Playing-Scene
- Bewegung auf dem generierten Pfad

## T6 - Tower

- Klasse für Tower erstellen
- Controller für das Bauen, Aufwerten und Verkaufen von Towern
- Attribute der Tower zuweisen und auslesen
- Tower platzieren auf dem Grid über MouseListener mithilfe des **TileController**

## T7 - Gameplay

- Anvisieren von Towern auf Gegner
- Interaktion zwischen Tower und Gegner (Schadensberechnung)
- Sieg und Niederlage implementieren (Leben werden abgezogen, sobald Gegner das Ende berühren. Keine Gegner mehr vorhanden = Sieg)
