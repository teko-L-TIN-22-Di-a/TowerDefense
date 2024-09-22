# Models

## BaseEnemy

| Funktion                               | Beschreibung                                                                                                                |
|-----------------------------------------|-----------------------------------------------------------------------------------------------------------------------------|
| `BaseEnemy(float x, float y, int id, int enemyType)` | Konstruktor: Initialisiert die Position, den Typ, die ID und setzt die Startgesundheit.                                     |
| `setStartHealth()`                      | Setzt die Startgesundheit und die maximale Gesundheit basierend auf dem Gegnertyp.                                          |
| `hurt(int dmg)`                         | Reduziert die Gesundheit des Gegners um den gegebenen Schaden. Wenn die Gesundheit auf 0 fällt, stirbt der Gegner.          |
| `reachedEnd()`                          | Setzt die Gesundheit auf 0 und markiert den Gegner als tot, wenn er das Ende erreicht.                                      |
| `getHealthBarFloat()`                   | Gibt den Prozentsatz der verbleibenden Gesundheit zurück (als Verhältnis zur maximalen Gesundheit).                         |
| `move(float speed, int dir)`            | Bewegt den Gegner in die angegebene Richtung mit der gegebenen Geschwindigkeit und verlangsamt ihn, falls er betroffen ist. |
| `slow()`                                | Verlangsamt den Gegner für eine bestimmte Anzahl von Ticks.                                                                 |
| `updateHitbox()`                        | Aktualisiert die Position der Hitbox des Gegners entsprechend seiner aktuellen Position.                                    |
| `setPos(int x, int y)`                  | Setzt die Position des Gegners.                                                                                             |
| `getX()`                                | Gibt die aktuelle X-Position des Gegners zurück.                                                                            |
| `getY()`                                | Gibt die aktuelle Y-Position des Gegners zurück.                                                                            |
| `getBounds()`                           | Gibt die Kollisionsbox des Gegners als Rechteck zurück.                                                                     |
| `getHealth()`                           | Gibt die aktuelle Gesundheit des Gegners zurück.                                                                            |
| `getId()`                               | Gibt die ID des Gegners zurück.                                                                                             |
| `getEnemyType()`                        | Gibt den Gegnertyp zurück.                                                                                                  |
| `getLastDir()`                          | Gibt die letzte Richtung zurück, in die sich der Gegner bewegt hat.                                                         |
| `isAlive()`                             | Überprüft, ob der Gegner noch am Leben ist.                                                                                 |

## Bat, Slime, Snake, Turtle

Gegnertypen und Ihre HP.

## MapTile

|Type|Attribut|Description|
|---|---|---|
|boolean|`filled`|Befüllte Grid Zelle|
|`TileType`|`type`|Typ der Zelle von Enum|
|`Color`|`background`|Hintergrundfarbe der Zelle|

## BaseTower

| Funktion                                 | Beschreibung                                                                                                       |
|-------------------------------------------|--------------------------------------------------------------------------------------------------------------------|
| `BaseTower(int x, int y, int id, int towerType, int btnIndex)` | Konstruktor: Initialisiert die Position, ID, Typ und die zugehörigen Eigenschaften des Turms.                      |
| `setDefaultCooldown()`                    | Setzt die Standard-Abklingzeit des Turms basierend auf dem Turmtyp.                                                |
| `setDefaultRange()`                       | Setzt die Standardreichweite des Turms basierend auf dem Turmtyp.                                                  |
| `setDefaultDmg()`                         | Setzt den Standard-Schaden des Turms basierend auf dem Turmtyp.                                                    |
| `update()`                                | Erhöht den Abklingzeit-Tick des Turms pro Frame.                                                                   |
| `upgradeTower()`                          | Erhöht die Stufe des Turms und verbessert Schaden, Reichweite und Abklingzeit je nach Turmtyp (Nicht eingebunden). |
| `isCooldownOver()`                        | Überprüft, ob die Abklingzeit des Turms abgelaufen ist.                                                            |
| `resetCooldown()`                         | Setzt den Abklingzeit-Tick zurück, um den Turm wieder angreifen zu lassen.                                         |
| `getX()`                                  | Gibt die X-Position des Turms zurück.                                                                              |
| `setX(int x)`                             | Setzt die X-Position des Turms.                                                                                    |
| `getY()`                                  | Gibt die Y-Position des Turms zurück.                                                                              |
| `setY(int y)`                             | Setzt die Y-Position des Turms.                                                                                    |
| `getId()`                                 | Gibt die ID des Turms zurück.                                                                                      |
| `setId(int id)`                           | Setzt die ID des Turms.                                                                                            |
| `getTowerType()`                          | Gibt den Turmtyp zurück (z. B. Bogenschütze, Kanone, Magier).                                                      |
| `setTowerType(int towerType)`             | Setzt den Turmtyp.                                                                                                 |
| `getDmg()`                                | Gibt den aktuellen Schaden des Turms zurück.                                                                       |
| `getRange()`                              | Gibt die aktuelle Reichweite des Turms zurück.                                                                     |
| `getCooldown()`                           | Gibt die aktuelle Abklingzeit des Turms zurück.                                                                    |
| `getTier()`                               | Gibt die Stufe (Tier) des Turms zurück.                                                                            |
| `getCardIndex()`                          | Gibt den Index der zugehörigen Kartenposition zurück (Button-Index).                                               |

## Card

|Type|Attribut| Description                                           |
|---|---|-------------------------------------------------------|
|string|`label`| Text für die Karte                                    |
|int|`cost`| Kosten um die Karte spielen zu können (Nicht benutzt) |
