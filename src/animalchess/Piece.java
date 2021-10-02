package animalchess;

import java.util.ArrayList;

/**
 * Piece Class, is a parent of other pieces.
 */
public abstract class Piece {
    private Player owner;
    private Square square;

    /**
     * Piece constructor.
     * @param owner : owner player.
     * @param square : position in the board game.
     */
    public Piece(Player owner, Square square) {
        if (square.getGame() != null && square.getGame().getSquare(square.getRow(), square.getCol()).getPiece() != null) {
            throw new IllegalArgumentException("The square has been occupied.");
        }

        this.owner = owner;
        this.square = square;
        this.square.placePiece(this);
    }

    /**
     * getLegalMoves is vary from all subclass, so it should be defined in children class.
     * @return all possible moves.
     */
    public abstract ArrayList<Square> getLegalMoves();

    /**
     * beCaptured function : the piece going to other player's hand, and removed from its square.
     * @param capturer : the player who capture the piece.
     */
    public void beCaptured(Player capturer) {
        capturer.addPieceToHand(this);

        this.owner = capturer;
        this.square.removePiece();
        this.square = null;
    }

    /**
     * getOwner : return the player who own the piece.
     * @return The owner.
     */
    public Player getOwner() {
        return this.owner;
    }

    /**
     * getSquare : return the square where the piece is placed.
     * @return The square.
     */
    public Square getSquare() {
        return this.square;
    }

    /**
     * move : move piece.
     * @param toSquare : destination square.
     */
    public void move(Square toSquare) {
        if (toSquare.getPiece() == null) {
            this.square.removePiece();
            this.square = toSquare;
            toSquare.placePiece(this);
        } else {
            if (toSquare.getPiece().getOwner() != this.owner) {
                this.square.removePiece();
                toSquare.getPiece().beCaptured(this.owner);
                this.square = toSquare;
                toSquare.placePiece(this);
            } else {
                throw new IllegalArgumentException("Cannot move to a square which has been occupied by your own piece.");
            }
        }
    }

    /**
     * getSquareLeft : get one square at the left of the piece. the posision will be opposite for player 0 and player 1.
     * @return a square.
     */
    public Square getSquareLeft() {
        if (this.owner.getPlayerNumber() == 0) {
            return this.square.getGame().getSquare(this.square.getRow(), this.square.getCol() + 1);
        } else {
            return this.square.getGame().getSquare(this.square.getRow(), this.square.getCol() - 1);
        }
    }

    /**
     * getSquareLeft : get one square at the right of the piece. the posision will be opposite for player 0 and player 1.
     * @return a square.
     */
    public Square getSquareRight() {
        if (this.owner.getPlayerNumber() == 0) {
            return this.square.getGame().getSquare(this.square.getRow(), this.square.getCol() - 1);
        } else {
            return this.square.getGame().getSquare(this.square.getRow(), this.square.getCol() + 1);
        }
    }

    /**
     * getSquareLeft : get one square in front of the piece. the posision will be opposite for player 0 and player 1.
     * @return a square.
     */
    public Square getSquareForward() {
        if (this.owner.getPlayerNumber() == 0) {
            return this.square.getGame().getSquare(this.square.getRow() + 1, this.square.getCol());
        } else {
            return this.square.getGame().getSquare(this.square.getRow() - 1, this.square.getCol());
        }
    }

    /**
     * getSquareLeft : get one square in the front left of the piece. the posision will be opposite for player 0 and player 1.
     * @return a square.
     */
    public Square getSquareForwardLeft() {
        if (this.owner.getPlayerNumber() == 0) {
            return this.square.getGame().getSquare(this.square.getRow() + 1, this.square.getCol() + 1);
        } else {
            return this.square.getGame().getSquare(this.square.getRow() - 1, this.square.getCol() - 1);
        }
    }

    /**
     * getSquareLeft : get one square in the front right of the piece. the posision will be opposite for player 0 and player 1.
     * @return a square.
     */
    public Square getSquareForwardRight() {
        if (this.owner.getPlayerNumber() == 0) {
            return this.square.getGame().getSquare(this.square.getRow() + 1, this.square.getCol() - 1);
        } else {
            return this.square.getGame().getSquare(this.square.getRow() - 1, this.square.getCol() + 1);
        }
    }

    /**
     * getSquareLeft : get one square at behind the piece. the posision will be opposite for player 0 and player 1.
     * @return a square.
     */
    public Square getSquareBackward() {
        if (this.owner.getPlayerNumber() == 0) {
            return this.square.getGame().getSquare(this.square.getRow() - 1, this.square.getCol());
        } else {
            return this.square.getGame().getSquare(this.square.getRow() + 1, this.square.getCol());
        }
    }

    /**
     * getSquareLeft : get one square at left behind of the piece. the posision will be opposite for player 0 and player 1.
     * @return a square.
     */
    public Square getSquareBackwardLeft() {
        if (this.owner.getPlayerNumber() == 0) {
            return this.square.getGame().getSquare(this.square.getRow() - 1, this.square.getCol() + 1);
        } else {
            return this.square.getGame().getSquare(this.square.getRow() + 1, this.square.getCol() - 1);
        }
    }

    /**
     * getSquareLeft : get one square at right behind of the piece. the posision will be opposite for player 0 and player 1.
     * @return a square.
     */
    public Square getSquareBackwardRight() {
        if (this.owner.getPlayerNumber() == 0) {
            return this.square.getGame().getSquare(this.square.getRow() - 1, this.square.getCol() - 1);
        } else {
            return this.square.getGame().getSquare(this.square.getRow() + 1, this.square.getCol() + 1);
        }
    }

}
