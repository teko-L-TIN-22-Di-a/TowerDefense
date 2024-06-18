package maps;

import objects.TileType;

import java.awt.*;

public class MapTile {
    public boolean filled;
    public TileType type;
    public Color background;

    public MapTile(TileType type) {
        switch (type) {
            case ENVIRONMENT -> background = Color.white;
            case PATH -> background = Color.black;
        }
    }
}
