package Util;

import GameObjects.GameObject;

@FunctionalInterface
public interface Position {
    GameObject create(int posX, int posY);
}