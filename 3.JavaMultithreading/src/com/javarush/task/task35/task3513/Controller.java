package com.javarush.task.task35.task3513;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controller extends KeyAdapter {       //будет следить за нажатием клавиш во время игры
    private Model model;
    private View view;
    private static final int WINNING_TILE = 2048;

    public View getView() {
        return view;
    }

    public Controller(Model model) {
        this.model = model;
        view = new View(this);

    }


    public Tile[][] getGameTiles() {
        return model.getGameTiles();
    }

    public int getScore() {
        return model.score;
    }

    public void resetGame() {
        model.score = 0;
        model.resetGameTiles();
        view.isGameLost = false;
        view.isGameWon = false;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            resetGame();
        }

        if (!model.canMove()) {
            view.isGameLost = true;
        }
        if (!view.isGameWon && !view.isGameLost) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    model.left();
                    break;
                case KeyEvent.VK_RIGHT:
                    model.right();
                    break;
                case KeyEvent.VK_UP:
                    model.up();
                    break;
                case KeyEvent.VK_DOWN:
                    model.down();
                    break;
                case KeyEvent.VK_Z:
                    model.rollback();
                    break;
                case KeyEvent.VK_R:
                    model.randomMove();
                    break;
                case KeyEvent.VK_A:
                    model.autoMove();
                    break;
                default:
                    break;
            }
            if (model.maxTile == WINNING_TILE) {
                view.isGameWon = true;
            }
        }
        view.repaint();
    }
}
