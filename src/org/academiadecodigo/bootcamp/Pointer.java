package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Grid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Pointer  {

    private Rectangle pointer;
    private Cell[][] rectangleArray;


    public Pointer (Cell[][] rectangleArray) {
        this.rectangleArray = rectangleArray;
        pointer = new Rectangle(Grid.PADDING, Grid.PADDING, Grid.cellSize, Grid.cellSize);
        pointer.setColor(Color.GREEN);
        pointer.draw();
        pointer.fill();
    }


    public void moveUp() {
        pointer.translate(0, -Grid.cellSize);
    }

    public void moveDown() {
        pointer.translate(0, Grid.cellSize);
    }

    public void moveLeft() {
        pointer.translate(-Grid.cellSize, 0);
    }

    public void moveRight() {
        pointer.translate(Grid.cellSize, 0);
    }

    public int getX() {
        return pointer.getX() / Grid.cellSize;
    }

    public int getY() {
        return pointer.getY() / Grid.cellSize;
    }



}
