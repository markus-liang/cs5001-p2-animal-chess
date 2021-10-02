package animalchess;

import java.util.ArrayList;

/**
 * Player Class.
 */
public class Player {
    private String name;
    private int playerNumber;
    private boolean isWinner;
    private ArrayList<Piece> piecesInHand;

    /**
     * Player constructor.
     * @param name : player name.
     * @param playerNumber : player number.
     */
    public Player(String name, int playerNumber) {
        this.name = name;
        this.playerNumber = playerNumber;
        this.isWinner = false;
        this.piecesInHand = new ArrayList<Piece>();
    }

    /**
     * getName : get the player name.
     * @return name of the player.
     */
    public String getName() {
        return this.name;
    }

    /**
     * getPlayerNumber : get the player number.
     * @return number of the player.
     */
    public int getPlayerNumber() {
        return this.playerNumber;
    }

    /**
     * getHand : get pieces in hand.
     * @return all the pieces in player's hand.
     */
    public ArrayList<Piece> getHand() {
        return this.piecesInHand;
    }

    /**
     * addPieceToHand : add a piece to player's hand.
     * @param piece the captured piece.
     */
    public void addPieceToHand(Piece piece) {
        this.piecesInHand.add(piece);
        piece.getSquare().removePiece();
    }

    /**
     * dropPiece : put a piece in hand to destination square.
     * @param piece the captured piece.
     * @param square the destination square.
     */
    public void dropPiece(Piece piece, Square square) {
        square.placePiece(piece);
        this.piecesInHand.remove(piece);
    }

    /**
     * winGame : set a player become the winner of the game.
     */
    public void winGame() {
        this.isWinner = true;
    }

    /**
     * hasWon : check if the player has won the game.
     * @return true or false.
     */
    public boolean hasWon() {
        return this.isWinner;
    }
}
