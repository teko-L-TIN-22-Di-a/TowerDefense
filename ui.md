# UI

## BottomBar
| **Funktion**                                         | **Beschreibung**                                                         |
|-----------------------------------------------------|--------------------------------------------------------------------------|
| `public BottomBar(int x, int y, int width, int height, Playing playing)` | Initialisiert die BottomBar mit den angegebenen Werten.                  |
| `public void removeLife()`                           | Verringert die Anzahl der Leben und überprüft, ob das Spiel zu Ende ist. |
| `private void initButtons()`                         | Initialisiert die Schaltflächen der BottomBar.                           |
| `public void draw(Graphics g)`                       | Zeichnet die BottomBar und ihre Komponenten auf dem Bildschirm.          |
| `private void drawWaveInfo(Graphics g)`             | Zeichnet Informationen über die aktuellen Wellen auf der BottomBar.      |
| `private void drawWavesLeftInfo(Graphics g)`        | Zeichnet die Anzahl der verbleibenden Wellen.                            |
| `private void drawEnemiesLeftInfo(Graphics g)`      | Zeichnet die Anzahl der verbleibenden Gegner.                            |
| `private void drawWaveTimerInfo(Graphics g)`        | Zeichnet den Countdown für die aktuelle Wave.                            |
| `private void drawDrawTimerInfo(Graphics g)`        | Zeichnet den Countdown für das Zeichnen neuer Karten.                    |
| `private void drawHand()`                            | Zeichnet die Kartenhand des Spielers.                                    |
| `private void drawButtons(Graphics g)`               | Zeichnet die Schaltflächen in der BottomBar.                             |
| `public void resetEverything()`                      | Setzt alle Attribute der BottomBar zurück.                               |
| `private void drawInfoBoxTowerTower(Graphics g)`    | Zeichnet Informationen über den ausgewählten Turm.                       |
| `private void drawInfoBoxTowerBorder(Graphics g)`   | Zeichnet den Rahmen des Informationsfeldes für den Turm.                 |
| `private void drawInfoBoxTowerRange(Graphics g)`    | Zeichnet den Angriffsbereich des ausgewählten Turms.                     |
| `private void drawCardButtons(Graphics g)`          | Zeichnet die Schaltflächen für die Karten in der BottomBar.              |
| `public void displayTower(BaseTower t)`             | Zeigt Informationen über den angegebenen Turm an.                        |
| `public void setTowerButtonDisabled(BaseTower t)`   | Deaktiviert die Schaltfläche für den angegebenen Turm.                   |
| `public void mouseClicked(int x, int y)`            | Behandelt Mausklick-Ereignisse in der BottomBar.                         |
| `public void mousePressed(int x, int y)`            | Behandelt das Drücken der Maus in der BottomBar.                         |
| `public void mouseMoved(int x, int y)`              | Behandelt die Bewegung der Maus über die BottomBar.                      |
| `public void mouseReleased(int x, int y)`           | Behandelt das Loslassen der Maus in der BottomBar.                       |

## CustomButton

| **Funktion**                                          | **Beschreibung**                                                                              |
|------------------------------------------------------|-----------------------------------------------------------------------------------------------|
| `public CustomButton(String text, int x, int y, int width, int height)` | Erstellt einen normalen Button mit dem angegebenen Text und den Dimensionen.                  |
| `public CustomButton(String text, int x, int y, int width, int height, int towerId, int id)` | Erstellt einen Button für ein Tile mit dem angegebenen Text, Dimensionen und Identifikatoren. |
| `private void initBounds()`                          | Initialisiert die Grenzen des Buttons.                                                        |
| `public void draw(Graphics g)`                       | Zeichnet den Button und seine Komponenten auf dem Bildschirm.                                 |
| `private void drawBorder(Graphics g)`                | Zeichnet den Rand des Buttons.                                                                |
| `private void drawBody(Graphics g)`                  | Zeichnet den Body des Buttons mit der entsprechenden Farbe.                                   |
| `private void drawText(Graphics g)`                  | Zeichnet den Text des Buttons in der Mitte des Buttons.                                       |
| `private void drawImage(Graphics g)`                 | Zeichnet ein Bild (derzeit nicht implementiert, verwendet Textdarstellung).                   |
| `public void setDisabled(boolean state)`              | Setzt den Status des Buttons auf aktiviert oder deaktiviert.                                  |
| `public boolean getDisabled()`                        | Gibt den aktuellen Status des Buttons zurück.                                                 |
| `public void resetStates()`                           | Setzt den Status der Mausüberprüfung zurück.                                                  |
| `public Rectangle getBounds()`                        | Gibt die Grenzen des Buttons zurück.                                                          |
| `public void setMousePressed(boolean mousePressed)`  | Setzt den Status der Maustaste (gedrückt oder nicht).                                         |
| `public void setMouseHover(boolean mouseHover)`      | Setzt den Status der Mausüberprüfung (über dem Button oder nicht).                            |
| `public boolean isMouseOver()`                        | Gibt zurück, ob sich die Maus über dem Button befindet.                                       |
| `public boolean isMousePressed()`                     | Gibt zurück, ob die Maustaste aktuell gedrückt ist.                                           |
| `public int getId()`                                  | Gibt die ID des Buttons zurück.                                                               |
| `public int getTowerId()`                             | Gibt die Tower-ID des Buttons zurück.                                                         |