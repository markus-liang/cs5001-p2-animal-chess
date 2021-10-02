package animalchess;

/**
 * PromotablePiece is an abstract class that added some functionalities for all pieces that has promotion feature.
 */
public abstract class PromotablePiece extends Piece {
    private boolean isPromoted;

    /**
     * PromotablePiece constructor.
     * @param owner : owner player.
     * @param square : position in the board game.
     */
    public PromotablePiece(Player owner, Square square) {
        super(owner, square);
        isPromoted = false;
    }

    /**
     * getIsPromoted : check if the piece has been promoted.
     * @return true or false.
     */
    public boolean getIsPromoted() {
        return this.isPromoted;
    }

    /**
     * promot: to promote the piece.
     */
    public void promote() {
        this.isPromoted = true;
    }

    /**
     * move : if promotable piece move to promotion zone, then it should get promotion.
     * @param toSquare : destination square.
     */
    @Override
    public void move(Square toSquare) {
        super.move(toSquare);
        if (toSquare.isPromotionZone(getOwner())) {
            promote();
        }
    }

    /**
     * move : if promotable piece get captured, then it get demoted.
     * @param capturer : the player who capture the piece.
     */
    @Override
    public void beCaptured(Player capturer) {
        super.beCaptured(capturer);
        this.isPromoted = false;
    }
}
