package animalchess;

/**
 * Square class.
 */
public class Square {
    private Game game;
    private int row, col;
    private Player promotesPlayer;
    private Piece piece;

    /**
     * Square constructor.
     * @param game : Game that own the square, it can be null.
     * @param row : row number.
     * @param col : col number.
     */
    public Square(Game game, int row, int col) {
        this.game = game;
        this.row = row;
        this.col = col;
        this.piece = null;
    }

    /**
     * Square constructor.
     * @param game : Game that own the square, it can be null.
     * @param row : row number.
     * @param col : col number.
     * @param promotesPlayer : every pieces owned by this player will get promotion when they move to this square.
     */
    public Square(Game game, int row, int col, Player promotesPlayer) {
        this.game = game;
        this.row = row;
        this.col = col;
        this.piece = null;
        this.promotesPlayer = promotesPlayer;
    }

    /**
     * placePiece : put a piece to this square.
     * @param piece : the piece to be put.
     */
    public void placePiece(Piece piece) {
        if (getPiece() == null) {
            this.piece = piece;
        } else {
            throw new IllegalArgumentException("Cannot place new piece to an occupied square.");
        }
    }

    /**
     * removePiece : remove piece from this square.
     */
    public void removePiece() {
        this.piece = null;
    }

    /**
     * isPromotionZone : check if the square is a promotion zone for a player.
     * @param player : player to be matched the zone.
     * @return true or false.
     */
    public boolean isPromotionZone(Player player) {
        return this.promotesPlayer != null &&  this.promotesPlayer == player;
    }

    /**
     * getGame : get the Game entity.
     * @return the game.
     */
    public Game getGame() {
        return this.game;
    }

    /**
     * getPiece : get the piece placed in the square.
     * @return the piece.
     */
    public Piece getPiece() {
        return this.piece;
    }

    /**
     * getPiece : get row position of the square.
     * @return row number.
     */
    public int getRow() {
        return this.row;
    }

    /**
     * getPiece : get column position of the square.
     * @return column number.
     */
    public int getCol() {
        return this.col;
    }
}
