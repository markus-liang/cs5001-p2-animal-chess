package animalchess;

import java.util.ArrayList;

/**
 * Game Class.
 */
public class Game {
    static final int HEIGHT = 6;
    static final int WIDTH = 5;

    private Player[] players;
    private Square[][] boards;

    /**
     * Game constructor.
     * @param p0 : player 0.
     * @param p1 : player 1.
     */
    public Game(Player p0, Player p1) {
        this.players = new Player[2];
        this.players[0] = p0;
        this.players[1] = p1;

        // board default setup
        this.boards = new Square[this.HEIGHT][this.WIDTH];
        for (int i = 0; i < this.HEIGHT; i++) {
            for (int j = 0; j < this.WIDTH; j++) {
                if (i < 2) {
                    // row 0 & 2 are promotion zone for p1
                    this.boards[i][j] = new Square(this, i, j, p1);
                } else if (i > 3) {
                    // row 4 & 5 are promotion zone for p0
                    this.boards[i][j] = new Square(this, i, j, p0);
                } else {
                    // netral area
                    this.boards[i][j] = new Square(this, i, j);
                }
            }
        }

        // p0 pieces setup
        new Cat(this.players[0], this.boards[0][0]);
        new Dog(this.players[0], this.boards[0][1]);
        new Lion(this.players[0], this.boards[0][2]);
        new Dog(this.players[0], this.boards[0][3]);
        new Cat(this.players[0], this.boards[0][4]);
        new Chick(this.players[0], this.boards[2][1]);
        new Chick(this.players[0], this.boards[2][2]);
        new Chick(this.players[0], this.boards[2][3]);

        // p1 pieces setup
        new Cat(this.players[1], this.boards[5][0]);
        new Dog(this.players[1], this.boards[5][1]);
        new Lion(this.players[1], this.boards[5][2]);
        new Dog(this.players[1], this.boards[5][3]);
        new Cat(this.players[1], this.boards[5][4]);
        new Chick(this.players[1], this.boards[3][1]);
        new Chick(this.players[1], this.boards[3][2]);
        new Chick(this.players[1], this.boards[3][3]);
    }

    /**
     * getPlayer : Get player instance.
     * @param playerNumber : requested player number.
     * @return the player requested.
     */
    public Player getPlayer(int playerNumber) {
        if (playerNumber < 0  || playerNumber > 2) {
            throw new IllegalArgumentException("Invalid array index.");
        }
        return this.players[playerNumber];
    }

    /**
     * getWinner : Get the winner. If there is no one, return null.
     * @return the player who win the game.
     */
    public Player getWinner() {
        if (this.players[0].hasWon()) {
            return this.players[0];
        } else if (this.players[1].hasWon()) {
            return this.players[1];
        } else {
            return null;
        }
    }

    /**
     * getSquare : Get one square in the game board.
     * @param row : row number.
     * @param col : column number.
     * @return a square.
     */
    public Square getSquare(int row, int col) {
        if (row < 0  || row >= this.HEIGHT || col < 0 || col >= this.WIDTH) {
            return null;
        }
        return this.boards[row][col];
    }
}
