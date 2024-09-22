# Controller

## CardController

|Function     | Description|
|-------------|------------|
|`initCards()`|Initialisiert das "Deck", befüllt ein Array mit Karten|
|`createHand()`|Würfelt eine neue Hand aus mit 4 zufällig ausgewählten Karten|

## MapController

| Funktion                                | Beschreibung                                                        |
|------------------------------------------|---------------------------------------------------------------------|
| `MapController()`                        | Konstruktor der Klasse ohne besondere Initialisierungen.            |
| `createLevel(TileController tileController)` | Erstellt ein Level mit zufällig generiertem Pfad zwischen Start- und Endkachel. |
| `getStartTile()`                         | Gibt die Startkachel des Pfades zurück.                             |
| `getEndTile()`                           | Gibt die Endkachel des Pfades zurück.                               |

## TileController

| Funktion                                | Beschreibung                                                               |
|------------------------------------------|----------------------------------------------------------------------------|
| `TileController()`                       | Konstruktor, der den Sprite-Atlas lädt und die Kacheln erstellt.           |
| `createTiles()`                          | Erstellt Kacheln für Gras und Straße und fügt sie der Liste hinzu.         |
| `loadTiles()`                            | Unbenutzt.                                                                 |
| `loadAtlas()`                            | Lädt den Sprite-Atlas, der die Kachelbilder enthält.                       |
| `getTile(int id)`                        | Gibt das Sprite des Tiles basierend auf der übergebenen ID zurück.  |
| `getSprite(int id)`                      | Gibt das Sprite der Kachel basierend auf der ID zurück.                    |
| `getSprite(int xCord, int yCord)`        | Gibt ein Sprite basierend auf den übergebenen Koordinaten im Atlas zurück. |

## EnemyController

| Funktion                   | Beschreibung                                                                                            |
|-----------------------------|---------------------------------------------------------------------------------------------------------|
| `EnemyController(Playing playing, PathPoint start, PathPoint end)` | Konstruktor, der den Controller mit dem Spielstatus und den Start-/Endpunkten der Gegner initialisiert. |
| `loadEnemyImgs()`            | Lädt die Bilder aus dem Sprite-Atlas.                                                                   |
| `update()`                   | Aktualisiert die Bewegung aller lebenden Gegner.                                                        |
| `updateEnemyMove(BaseEnemy e)`| Aktualisiert die Bewegung eines einzelnen Gegners und prüft, ob er das Ende erreicht hat.               |
| `setNewDirectionAndMove(BaseEnemy e)` | Bestimmt und setzt eine neue Richtung für die Bewegung des Gegners.                                     |
| `getAmountOfAliveEnemies()`  | Gibt die Anzahl der aktuell lebenden Gegner zurück.                                                     |
| `fixEnemyOffsetTile(BaseEnemy e, int dir, int xCord, int yCord)` | Passt die Position des Gegners basierend auf Richtung und Kachelkoordinaten an.                         |
| `isAtEnd(BaseEnemy e)`       | Prüft, ob der Gegner das Ende erreicht hat.                                                              |
| `getTileType(int x, int y)`  | Gibt den Kacheltyp an den angegebenen Koordinaten zurück.                                               |
| `getSpeedAndHeight(int dir, int enemyType)` | Berechnet die vertikale Bewegungsgeschwindigkeit des Gegners.                                           |
| `getSpeedAndWidth(int dir, int enemyType)` | Berechnet die horizontale Bewegungsgeschwindigkeit des Gegners.                                         |
| `spawnEnemy(int nextEnemy)`  | Erzeugt einen neuen Gegner des angegebenen Typs.                                                         |
| `addEnemy(int enemyType)`    | Fügt einen neuen Gegner basierend auf dem Typ zur Liste hinzu.                                           |
| `draw(Graphics g)`           | Zeichnet alle lebenden Gegner und ihre Lebensbalken.                                                    |
| `drawHealthBar(BaseEnemy e, Graphics g)` | Zeichnet den Lebensbalken für einen bestimmten Gegner.                                                   |
| `getNewBarWidth(BaseEnemy e)`| Gibt die Breite des Lebensbalkens basierend auf der Gesundheit des Gegners zurück.                      |
| `drawEnemy(BaseEnemy e, Graphics g)` | Zeichnet einen bestimmten Gegner unter Verwendung seines Bildes.                                         |
| `getEnemies()`               | Gibt die Liste aller Gegner zurück.                                                                     |
| `reset()`                    | Setzt die Liste der Gegner zurück und löscht sie.                                                       |

## ProjectileController

| Funktion                                | Beschreibung                                                                                                         |
|------------------------------------------|----------------------------------------------------------------------------------------------------------------------|
| `ProjectileController(Playing playing)`  | Konstruktor, der den Spielzustand speichert und die Bilder importiert.                                               |
| `importImgs()`                           | Lädt die Bilder für die Projektile aus dem Sprite-Atlas.                                                             |
| `newProjectile(BaseTower t, BaseEnemy e)`| Erzeugt ein neues Projektil, das von einem Turm auf einen Gegner abgefeuert wird.                                    |
| `update()`                               | Aktualisiert die Bewegung der Projektile und prüft, ob sie einen Gegner treffen oder außerhalb des Spielfeldes sind. |
| `explodeOnEnemies(Projectile p)`         | Lässt ein Projektil auf mehrere Gegner explodieren, wenn es vom Bomben-Typ ist.                                      |
| `isProjectileHittingEnemy(Projectile p)` | Prüft, ob ein Projektil einen Gegner trifft und wendet gegebenenfalls Effekte wie Schaden oder Verlangsamung an.     |
| `draw(Graphics g)`                       | Zeichnet alle aktiven Projektile und rotiert sie entsprechend ihrer Bewegung.                                        |
| `isProjectileOutsideBounds(Projectile p)`| Prüft, ob ein Projektil außerhalb der Spielfeldgrenzen ist.                                                          |
| `getProjType(BaseTower t)`               | Gibt den Projektiltyp basierend auf dem Turmtyp zurück (Pfeil, Bombe, Ketten).                                       |
| `reset()`                                | Setzt alle Projektile zurück und stellt den Projektil-ID-Zähler auf 0.                                               |

## WaveController

| Funktion                                | Beschreibung                                                                                          |
|------------------------------------------|-------------------------------------------------------------------------------------------------------|
| `WaveController(Playing playing)`        | Konstruktor, der die Spielszene speichert und Waven erstellt.                                         |
| `update()`                               | Aktualisiert den Timer für den Gegner-Spawn und die Wavenzeit.                                        |
| `increaseWaveIndex()`                    | Erhöht den Wavenindex, setzt den Timer zurück und startet die nächste Wave.                           |
| `isWaveTimerOver()`                      | Überprüft, ob der Timer der aktuellen Wave abgelaufen ist.                                            |
| `startWaveTimer()`                       | Startet den Timer für die nächste Wave.                                                               |
| `getNextEnemy()`                         | Gibt den nächsten zu spawnenden Gegner aus der aktuellen Wave zurück und setzt den Spawn-Tick zurück. |
| `createWaves()`                          | Erstellt die Gegner-Waven mit festgelegten Gegnertypen.                                               |
| `getWaves()`                             | Gibt die Liste der erstellten Waven zurück.                                                           |
| `isTimeForNewEnemy()`                    | Überprüft, ob genug Zeit vergangen ist, um einen neuen Gegner zu spawnen.                             |
| `isThereMoreEnemiesInWave()`             | Überprüft, ob es in der aktuellen Wave noch mehr Gegner gibt.                                         |
| `isThereMoreWaves()`                     | Überprüft, ob noch mehr Waves vorhanden sind.                                                         |
| `resetEnemyIndex()`                      | Setzt den Index für den Gegner-Spawn auf 0 zurück.                                                    |
| `getWaveIndex()`                         | Gibt den aktuellen Wavenindex zurück.                                                                 |
| `getTimeLeft()`                          | Gibt die verbleibende Zeit (in Sekunden) für die nächste Wave zurück.                                 |
| `isWaveTimerStarted()`                   | Überprüft, ob der Timer für die nächste Wave gestartet wurde.                                         |
| `reset()`                                | Setzt alle Werte des Controllers zurück und erstellt die Waves neu.                                   |