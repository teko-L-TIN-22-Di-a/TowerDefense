# Constants Übersicht

| Klasse             | Beschreibung                                                                                                                                 |
|--------------------|---------------------------------------------------------------------------------------------------------------------------------------------|
| **Projectiles**     | Enthält Konstanten und Methoden, die sich auf Projektiltypen und ihre Eigenschaften beziehen.                                               |
| **Towers**          | Enthält Konstanten und Methoden, die sich auf Turmtypen, deren Kosten, Schaden, Reichweite und Abklingzeit beziehen.                        |
| **Direction**       | Enthält Konstanten, die Richtungen für Bewegungen definieren (Links, Oben, Rechts, Unten).                                                  |
| **Enemies**         | Enthält Konstanten und Methoden für Feindtypen und deren Belohnungen, Geschwindigkeit und Startgesundheit.                                  |
| **Tiles**           | Enthält Konstanten für verschiedene Kacheltypen im Spiel (Gras, Straße).                                                                   |

## Projectiles
| Konstante/Methoden  | Beschreibung                                                                            |
|---------------------|----------------------------------------------------------------------------------------|
| `ARROW = 0`         | Projektiltyp Pfeil.                                                                    |
| `CHAINS = 1`        | Projektiltyp Ketten.                                                                   |
| `BOMB = 2`          | Projektiltyp Bombe.                                                                    |
| `GetSpeed(int type)`| Gibt die Geschwindigkeit eines Projektils basierend auf seinem Typ zurück (Pfeil: 8f, Bombe: 4f, Ketten: 6f). |

## Towers
| Konstante/Methoden     | Beschreibung                                                                             |
|------------------------|-----------------------------------------------------------------------------------------|
| `CANNON = 0`           | Turmtyp Kanone.                                                                          |
| `ARCHER = 1`           | Turmtyp Bogenschütze.                                                                    |
| `WIZARD = 2`           | Turmtyp Zauberer.                                                                        |
| `GetTowerCost(int type)`| Gibt die Baukosten für den jeweiligen Turmtyp zurück (Kanone: 65, Bogenschütze: 35, Zauberer: 50). |
| `GetName(int type)`    | Gibt den Namen des Turms basierend auf dem Typ zurück.                                    |
| `GetStartDmg(int type)`| Gibt den Startschaden eines Turms zurück (Kanone: 15, Bogenschütze: 5, Zauberer: 0).      |
| `GetDefaultRange(int type)`| Gibt die Standardreichweite des Turms zurück (Kanone: 75, Bogenschütze: 120, Zauberer: 100).  |
| `GetDefaultCooldown(int type)`| Gibt die Standard-Abklingzeit des Turms zurück (Kanone: 120, Bogenschütze: 35, Zauberer: 50). |

## Direction
| Konstante  | Beschreibung                                                                 |
|------------|-----------------------------------------------------------------------------|
| `LEFT = 0` | Richtung Links.                                                             |
| `UP = 1`   | Richtung Oben.                                                              |
| `RIGHT = 2`| Richtung Rechts.                                                            |
| `DOWN = 3` | Richtung Unten.                                                             |

## Enemies
| Konstante/Methoden         | Beschreibung                                                                         |
|----------------------------|--------------------------------------------------------------------------------------|
| `SLIME = 0`                | Feindtyp Slime.                                                                      |
| `BAT = 1`                  | Feindtyp Bat.                                                                        |
| `SNAKE = 2`                | Feindtyp Snake.                                                                      |
| `TURTLE = 3`               | Feindtyp Turtle.                                                                     |
| `GetReward(int type)`      | Gibt die Belohnung für das Besiegen des jeweiligen Feindes zurück (z. B. Snake: 25). |
| `GetSpeed(int type)`       | Gibt die Geschwindigkeit des jeweiligen Feindes zurück (z. B. Slime: 0,5f).          |
| `GetStartHealth(int type)` | Gibt die Startgesundheit des Feindes zurück (z. B. Snake: 400).                      |

## Tiles
| Konstante  | Beschreibung                    |
|------------|--------------------------------|
| `GRASS_TILE = 1` | Kacheltyp Gras.          |
| `ROAD_TILE = 2`  | Kacheltyp Straße.        |

## SpriteHelper

Lädt das Spritesheet.

## Utilities

Funktion für Hypothenuse berechnen.