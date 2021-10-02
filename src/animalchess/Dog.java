package animalchess;

import java.util.ArrayList;

/**
 * Dog Class.
 */
public class Dog extends Piece {
    /**
     * Dog constructor.
     * @param owner : owner player.
     * @param square : position in the board game.
     */
    public Dog(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * getLegalMoves : get possible move of dogs.
     * @return Array List of Square, contains list of possible moves .
     */
    public ArrayList<Square> getLegalMoves() {
        ArrayList<Square> legalMoves = new ArrayList<Square>();
        ArrayList<Square> animalMoves = new ArrayList<Square>();

        if (getSquare() != null) {
            animalMoves.add(getSquareLeft());
            animalMoves.add(getSquareRight());
            animalMoves.add(getSquareForward());
            animalMoves.add(getSquareForwardLeft());
            animalMoves.add(getSquareForwardRight());
            animalMoves.add(getSquareBackward());

            for (Square move: animalMoves) {
                if (move != null && (move.getPiece() == null || move.getPiece().getOwner() != getOwner())) {
                    legalMoves.add(move);
                }
            }
        }
        return legalMoves;
    }
}
