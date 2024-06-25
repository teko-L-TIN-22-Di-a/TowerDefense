# Scenes

Die verschiedenen Scenes/Views welche benutzt werden. Momentan gibt es 2 davon:

|Scene|Description|
|---|---|
|`Playing`|Hauptansicht für das Spiel|
|`Menu`|Ansicht für das Hauptmenü|
## GameScene

Initialisiert die Basisklasse für die Scenes und importiert die `Game` Klasse

## Menu

|Function     | Description|
|-------------|------------|
|`initButtons()`| Initialisiert die Position der Buttons sowie deren Inhalt mithilfe der Klasse `CustomButton`|
|`mouseClicked(int x, int y)`|MopuseClick Event mit den Koordinaten, damit der richtige Button gefunden wird|
|`mouseMoved(int x, int y)`|MouseMove Event mit den Koordinaten, damit der richtige Button gefunden wird|
|`mousePressed(int x, int y)`|MousePressed Event mit den Koordinaten, damit der richtige Button gefunden wird|
|`drawButtons(Graphics g)`|`draw()` Funktion des Buttons wird aufgerufen, um den Button zu rendern|
|`mouseReleased(int x, int y)`| `resetButtons()` wird aufgerufen wenn die Maus losgelassen wird|
|`resetButtons()`|Setzt die Attribute des Buttons zurück|
|`render(Graphics g)`|Ruft `drawButtons()` auf, damit die Buttons gerendert werden|

## Playing

|Function     | Description|
|-------------|------------|
|`Playing(Game game)`|Constructor, initialisiert den `TileController`, den `CardController`, generiert das Level über die Methode `createLevel()` des `MapController` sowie die `BottomBar`|
|`getCardController()`| getter für den `CardController`|
|`Render(Graphics g)`|Render Methode für die `BottomBar`|
|`mouseClicked(int x, int y)`|MouseClick Event für die `BottomBar`|
|`mousePressed(int x, int y)`|MousePressed Event für die `BottomBar`|
|`mouseReleased(int x, int y)`|MouseReleased Event für die `BottomBar`|
|`mouseMoved(int x, int y)`|MouseMoved Event für die `BottomBar`|
