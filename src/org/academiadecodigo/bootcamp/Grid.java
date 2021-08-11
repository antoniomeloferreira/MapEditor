package org.academiadecodigo.simplegraphics.graphics;


import org.academiadecodigo.bootcamp.Cell;
import org.academiadecodigo.bootcamp.Pointer;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Grid implements KeyboardHandler {

    public static final int PADDING = 10;
    public static final int cellSize = 20;
    private int cols;
    private int rows;
    private Cell[][] rectangleArray;
    private Pointer pointer;
    private boolean isSpacePressed;

    public Grid(int cols, int rows) {
        this.cols = cols;
        this.rows = rows;
        rectangleArray = new Cell[cols][rows];
        pointer = new Pointer(rectangleArray);
        keyboardInit();
    }

    public void init() {

        for(int i = 0; i < cols; i++){
            for(int j = 0; j < rows; j++){
                rectangleArray[i][j] = new Cell(i, j);
            }
        }
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    private void keyboardInit(){
        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent rightPressed = new KeyboardEvent();
        rightPressed.setKey(KeyboardEvent.KEY_RIGHT);
        rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent leftPressed = new KeyboardEvent();
        leftPressed.setKey(KeyboardEvent.KEY_LEFT);
        leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent upPressed = new KeyboardEvent();
        upPressed.setKey(KeyboardEvent.KEY_UP);
        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent downPressed = new KeyboardEvent();
        downPressed.setKey(KeyboardEvent.KEY_DOWN);
        downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent spacePressed = new KeyboardEvent();
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent qPressed = new KeyboardEvent();
        qPressed.setKey(KeyboardEvent.KEY_Q);
        qPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        KeyboardEvent spaceReleased = new KeyboardEvent();
        spaceReleased.setKey(KeyboardEvent.KEY_SPACE);
        spaceReleased.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);

        keyboard.addEventListener(rightPressed);
        keyboard.addEventListener(leftPressed);
        keyboard.addEventListener(upPressed);
        keyboard.addEventListener(downPressed);
        keyboard.addEventListener(spacePressed);
        keyboard.addEventListener(qPressed);
        keyboard.addEventListener(spaceReleased);

    }

    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_RIGHT:
                if(pointer.getX() >= getCols() - 1){
                    break;
                }
                pointer.moveRight();
                if(isSpacePressed){
                    rectangleArray[pointer.getX()][pointer.getY()].setColorCell();
                }
                break;

            case KeyboardEvent.KEY_LEFT:
                if(pointer.getX() == 0){
                    break;
                }
                pointer.moveLeft();
                if(isSpacePressed){
                    rectangleArray[pointer.getX()][pointer.getY()].setColorCell();
                }
                break;

            case KeyboardEvent.KEY_UP:
                if(pointer.getY() == 0){
                    break;
                }
                pointer.moveUp();
                if(isSpacePressed){
                    rectangleArray[pointer.getX()][pointer.getY()].setColorCell();
                }
                break;

            case KeyboardEvent.KEY_DOWN:
                if(pointer.getY() >= getRows() -1){
                    break;
                }
                pointer.moveDown();
                if(isSpacePressed){
                    rectangleArray[pointer.getX()][pointer.getY()].setColorCell();
                }
                break;

            case KeyboardEvent.KEY_SPACE:
                isSpacePressed = true;
                rectangleArray[pointer.getX()][pointer.getY()].setColorCell();
                break;

            case KeyboardEvent.KEY_Q:
                for(int i = 0; i < rectangleArray.length; i++){
                    for(int j = 0; j < rectangleArray.length; j++){
                        rectangleArray[i][j].clearCell();
                    }
                }
                break;
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){

            case KeyboardEvent.KEY_SPACE:
                isSpacePressed = false;

        }

    }


}
