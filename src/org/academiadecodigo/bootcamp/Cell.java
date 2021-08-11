package org.academiadecodigo.bootcamp;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Grid;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Cell {

    private Rectangle rectangle;

    public Cell (int col, int row) {
        rectangle = new Rectangle(col * Grid.cellSize + Grid.PADDING, row * Grid.cellSize + Grid.PADDING, Grid.cellSize, Grid.cellSize);
        rectangle.draw();
    }

    public void setColorCell() {
        if(rectangle.isFilled()){
            rectangle.setColor(Color.WHITE);
            rectangle.fill();
            rectangle.setColor(Color.BLACK);
            rectangle.draw();
            return;
        }
        rectangle.fill();
    }

    public void clearCell() {
        rectangle.setColor(Color.WHITE);
        rectangle.fill();
        rectangle.setColor(Color.BLACK);
        rectangle.draw();
    }

}
