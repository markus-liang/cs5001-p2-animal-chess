package animalchess;

import java.util.ArrayList;

/**
 * Cat Class.
 */
public class Cat extends PromotablePiece {
    /**
     * Cat constructor.
     * @param owner : owner player.
     * @param square : position in the board game.
     */
    public Cat(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * getLegalMoves : get possible move of cats in promoted or not promoted state.
     * @return Array List of Square, contains list of possible moves .
     */
    public ArrayList<Square> getLegalMoves() {
        ArrayList<Square> legalMoves = new ArrayList<Square>();
        ArrayList<Square> animalMoves = new ArrayList<Square>();

        if (getSquare() != null) {
            if (!getIsPromoted()) {
                animalMoves.add(getSquareForward());
                animalMoves.add(getSquareForwardLeft());
                animalMoves.add(getSquareForwardRight());
                animalMoves.add(getSquareBackwardLeft());
                animalMoves.add(getSquareBackwardRight());
            } else {
                animalMoves.add(getSquareLeft());
                animalMoves.add(getSquareRight());
                animalMoves.add(getSquareForward());
                animalMoves.add(getSquareForwardLeft());
                animalMoves.add(getSquareForwardRight());
                animalMoves.add(getSquareBackward());
            }

            for (Square move: animalMoves) {
                if (move != null && (move.getPiece() == null || move.getPiece().getOwner() != getOwner())) {
                    legalMoves.add(move);
                }
            }
        }
        return legalMoves;
    }
}
