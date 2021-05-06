package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {        //будет содержать игровую логику и хранить игровое поле
    private static final int FIELD_WIDTH = 4;
    protected Tile[][] gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];  //поменял для себя private на protected,чтобы был доступ из мэйна
    protected int score;
    protected int maxTile;
    protected Stack<Tile[][]> previousStates;
    protected Stack<Integer> previousScores;
    protected boolean isSaveNeeded;

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public Model() {
        resetGameTiles();
        score = 0;
        maxTile = 0;
        previousStates = new Stack<>();
        isSaveNeeded = true;
        previousScores = new Stack<>();
    }

    private void addTile() {
        List<Tile> emptyTileList = getEmptyTiles();
        if (!emptyTileList.isEmpty()) {
            int rand = (int) (Math.random() * emptyTileList.size());
            emptyTileList.get(rand).value = Math.random() < 0.9 ? 2 : 4;
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTileList = new ArrayList<>();
        for (Tile[] tileArray : gameTiles) {
            for (Tile tile : tileArray) {
                if (tile.isEmpty()) {
                    emptyTileList.add(tile);
                }
            }
        }
        return emptyTileList;
    }

    protected void resetGameTiles() {
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                gameTiles[i][j] = new Tile();
            }
        }
        addTile();
        addTile();
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged = false;      //если были изменения входного массива,то возвращаем true
        List<Tile> valueList = new ArrayList<>();
        List<Tile> emptyValueList = new ArrayList<>();
        for (Tile tile : tiles) {
            if (tile.isEmpty())
                emptyValueList.add(tile);
            else valueList.add(tile);
        }

        for (int i = 0; i < tiles.length; i++) {
            if (i < valueList.size()) {
                if (tiles[i] != valueList.get(i)) {
                    isChanged = true;
                }
                tiles[i] = valueList.get(i);
            } else
                tiles[i] = emptyValueList.get(i - valueList.size());
        }

        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;      //если были изменения входного массива,то возвращаем true
        int currentValue = 0;
        int nextValue = 0;
        for (int i = 0; i < tiles.length - 1; i++) {
            currentValue = tiles[i].value;
            nextValue = tiles[i + 1].value;
            if (currentValue > 0 && currentValue == nextValue) {
                tiles[i].value = currentValue + nextValue;
                isChanged = true;
                score += tiles[i].value;
                if (maxTile < tiles[i].value) {
                    maxTile = tiles[i].value;
                }
                tiles[i + 1].value = 0;
            }
        }
        this.compressTiles(tiles);
        return isChanged;
    }

    public void rotateMinus90(Tile[][] tiles) {       //метод поворачивает массив против часовой стрелки
        Tile[][] tempGameTile = new Tile[gameTiles.length][gameTiles.length];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                tempGameTile[gameTiles.length - 1 - i][j] = gameTiles[j][i];
            }
        }
        gameTiles = tempGameTile;
    }

    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean isChanged = false;
        for (Tile[] tiles : gameTiles) {
            if (compressTiles(tiles) | mergeTiles(tiles)) {
                isChanged = true;
            }
        }
        if (isChanged) {
            addTile();
        }
    }

    public void right() {
        saveState(gameTiles);
        rotateMinus90(gameTiles);
        rotateMinus90(gameTiles);
        left();
        rotateMinus90(gameTiles);
        rotateMinus90(gameTiles);
    }


    public void down() {
        saveState(gameTiles);
        rotateMinus90(gameTiles);
        rotateMinus90(gameTiles);
        rotateMinus90(gameTiles);
        left();
        rotateMinus90(gameTiles);
    }

    public void up() {
        saveState(gameTiles);
        rotateMinus90(gameTiles);
        left();
        rotateMinus90(gameTiles);
        rotateMinus90(gameTiles);
        rotateMinus90(gameTiles);
    }

    public boolean canMove() {
        for (int i = 0; i < gameTiles.length - 1; i++) {
            for (int j = 0; j < gameTiles.length - 1; j++) {
                if (gameTiles[i][j].isEmpty()
                        || gameTiles[i][j].value == gameTiles[i][j + 1].value
                        || gameTiles[i][j].value == gameTiles[i + 1][j].value) {
                    return true;
                }
            }
        }
        return false;
    }

    private void saveState(Tile[][] tiles) {
        Tile[][] tempTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                tempTiles[i][j] = new Tile(tiles[i][j].value);
            }
        }
        previousStates.push(tempTiles);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousScores.isEmpty() && !previousStates.isEmpty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0:
                right();
                break;
            case 1:
                left();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    public boolean hasBoardChanged() {
        Tile[][] previousTiles = previousStates.peek();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                if (gameTiles[i][j].value != previousTiles[i][j].value) {
                    return true;
                }
            }
        }
        return false;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        MoveEfficiency moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        if (!hasBoardChanged()) {
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }
        rollback();
        return moveEfficiency;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> priorityQueue = new PriorityQueue<>(4, Collections.reverseOrder());
        priorityQueue.offer(getMoveEfficiency(this::left));
        priorityQueue.offer(getMoveEfficiency(this::up));
        priorityQueue.offer(getMoveEfficiency(this::right));
        priorityQueue.offer(getMoveEfficiency(this::down));
        priorityQueue.peek().getMove().move();
    }
}
