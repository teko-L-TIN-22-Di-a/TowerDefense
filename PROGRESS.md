# Progress

## Einsteigspunkt

In der **towerDefense.Game** Klasse werden die einzelnen Szenen, sowie das **towerDefense.GamePanel** und die **towerDefense.Render** Klasse initialisiert. Diese bekommen alle die Hauptklasse **towerDefense.Game** übergeben, um den momentanen State dessen zu teilen.

## towerDefense.GamePanel erstellen

Das **towerDefense.GamePanel** ist eine Abkapselung der Hauptklasse **towerDefense.Game** und erbt die Klasse **JPanel**.

Diese Klasse ist dafür zuständig, das Hauptpanel zu erstellen, die Listener für Maus und Tastatur Inputs zu generieren und den Renderer aufzurufen.

## TileController erstellt

Der TileController ist für die Aktualisierungen der einzelnen Grid-Tiles zuständig. Während des Spielverlaufs liegt die Verantwortung dieses Controllers darin, die einzelnen Tiles mit den korrekten Attributen zu updaten.

Momentan wird nur über ein kleines Enum gesteuert, ob es sich um ein Tile PATH handelt, welches nicht mit einem Turm besetzt werden kann, oder ENVIRONMENT, welches genau für diese Funktionalität zuständig sein wird.

## MapController erstellt

Der MapController ist dafür zuständig, einen zufälligen Pfad zu generieren, der für die Gegner bestimmt ist.

Sobald über den "Play" Button im Hauptmenü das Spiel gestartet wird, wechselt die Szene zu *Playing*. Sobald diese Szene initialisiert wird, werden die einzelnen Controller initialisiert und der Pfad generiert und in dem dafür bestimmten zweidimensionalen Array der Klasse *MapTile* abgelegt.

## Inputs in Gamepanel initialisieren wegen Bug der Position der Titelbar

Position der MouseClicks waren nicht korrekt da die TitelBar des Fensters miteinbezogen wurde. Durch das verschieben der Initialisierung der MouseListener im **towerDefense.GamePanel** (da diese Klasse **JPanel** erbt), werden die Positionen korrekt nur innerhalb des Panels ausgelesen.

## Bottombar als UI Component erstellen und anzeigen

Die Bottombar erstellen, damit die Spielelemente mit denen interagiert werden kann angezeigt werden können.

## Cards erstellt für die Weiterverwendung am GUI

Karten wurden mit einfachen Attributen erstellt, damit diese angezeigt werden können

## Cards in der BottomBar anzeigen

Draw Funktion eingefügt, welche die CustomButton Klasse verwendet, um die Karten am Unteren Bildschirmrand darzustellen

## Karten ziehen als Funktionalität einbauen

Die Karten können über einen zusätzlichen Button in der BottomBar neu gezogen werden