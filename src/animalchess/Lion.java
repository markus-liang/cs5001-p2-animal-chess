package animalchess;

import java.util.ArrayList;

/**
 * Lion Class.
 */
public class Lion extends Piece {
    /**
     * Lion constructor.
     * @param owner : owner player.
     * @param square : position in the board game.
     */
    public Lion(Player owner, Square square) {
        super(owner, square);
    }

    /**
     * getLegalMoves : get possible move of lions.
     * @return Array List of Square, contains list of possible moves.
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
            animalMoves.add(getSquareBackwardLeft());
            animalMoves.add(getSquareBackwardRight());

            for (Square move: animalMoves) {
                if (move != null && (move.getPiece() == null || move.getPiece().getOwner() != getOwner())) {
                    legalMoves.add(move);
                }
            }
        }
        return legalMoves;
    }

    /**
     * beCaptured : if a Lion get captured, then the winner decided.
     */
    @Override
    public void beCaptured(Player capturer) {
        super.beCaptured(capturer);
        capturer.winGame();
    }
}
