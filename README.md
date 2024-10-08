# Tower-Defense Spiel mit Kartenspiel Mechaniken EPIC

In diesem Dokument werden die einzelnen Teile des gesamten Projektes gesammelt und beschrieben.

| Dokumentation                  | Beschreibung                     |
|--------------------------------|----------------------------------|
| [ToDo-Liste](ToDo.md)          | Upcoming Tasks                   |
| [Progress](PROGRESS.md)        | Beschreibung des Projektverlaufs |
| [Controller](./controller.md)  | Übersicht aller Controller       |
| [Scenes](./scene.md)           | Übersicht aller Views            |
| [Models](./models.md)          | Übersicht aller Models           |
| [UI](./ui.md)                  | Übersicht aller UI Klassen       |
| [helpers](./helpers.md)        | Übersicht aller Helper Klasse    |

## Spielmechaniken

Das Spiel ist geplant als ein klassisches Tower-Defense, mit dem Unterschied, dass das Einkommen nicht direkt in einen gewünschten Tower umgewandelt werden kann, sondern diese aus einem Deck gezogen werden und durch Kopien aufgestuft werden können. Das Einkommen kann für Allgemeine, nicht-Tower spezifische Upgrades ausgegeben werden oder zum neu ziehen der Karten. Interest-Mechanik für Balancing Zwecke (Bonus Einkommen am Ende einer Runde gemäss dem Einkommen in Besitz des Spielers)

## User-Interface

- Hauptmenü mit Buttons für Start und Exit
- Während des Spieles die Spielerhand mit den Karten am unteren Bildschirmrand + Übersicht für den Status einer Wave und weiteren Informationen.

## Grafiken und Sounds

Einbinden eines bearbeiteten Spritesheets aus dem Internet.
Sounds werden je nach Möglichkeit aus dem Internet bezogen mit einen gültigen, freien Lizenz.

## Schwierigkeitsstufen

Nach Möglichkeit und Zeit werden Schwierigkeitsstufen eingefügt, welche jedoch der Einfachheit halber lediglich eine Skalierung der Lebenspunkte der Gegner umfasst.

## Benutzung

Umgewandelt in ein Maven Projekt.
Am einfachsten ist es, den Release herunterzuladen. Dieser enthält die Artifaktdatei.
Per Source Coude -> Projekt klonen und die main() Methode aufrufen.
