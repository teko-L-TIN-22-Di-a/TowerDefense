# Tower-Defense Spiel mit Kartenspiel Mechaniken EPIC

In diesem Dokument werden die einzelnen Teile des gesamten Projektes gesammelt und beschrieben.

|Dokumentation|Beschreibung|
|---|---|
|[ToDo-Liste](ToDo.md)|Upcoming Tasks|
|[Progress](PROGRESS.md)|Beschreibung des Projektverlaufs|
|[Controller](./src/controllers/controller.md)|Übersicht aller Controller|
|[Scenes](./src/scenes/scene.md)|Übersicht aller Views|
|[Models](./models.md)|Übersicht aller Models|

## Spielmechaniken

Das Spiel ist geplant als ein klassisches Tower-Defense, mit dem Unterschied, dass das Einkommen nicht direkt in einen gewünschten Tower umgewandelt werden kann, sondern diese aus einem Deck gezogen werden und durch Kopien aufgestuft werden können. Das Einkommen kann für Allgemeine, nicht-Tower spezifische Upgrades ausgegeben werden oder zum neu ziehen der Karten. Interest-Mechanik für Balancing Zwecke (Bonus Einkommen am Ende einer Runde gemäss dem Einkommen in Besitz des Spielers)

## User-Interface

- Hauptmenü mit Buttons für Start und Exit
- Während des Spieles die Spielerhand mit den Karten am unteren Bildschirmrand + Übersicht an Einkommen, Geld im Besitz des Spielers und Informationen an Gegner.

## Grafiken und Sounds

Es werden geometrische Formen als Spielfiguren benutzt. Desto mehr Ecken ein Figur besitzt, umso stärker ist diese.
Sounds werden je nach Möglichkeit aus dem Internet bezogen mit einen gültigen, freien Lizenz.

## Schwierigkeitsstufen

Nach Möglichkeit und Zeit werden Schwierigkeitsstufen eingefügt, welche jedoch der Einfachheit halber lediglich eine Skalierung der Lebenspunkte der Gegner umfasst.

## Benutzung

Projekt klonen und die main() Methode aufrufen
