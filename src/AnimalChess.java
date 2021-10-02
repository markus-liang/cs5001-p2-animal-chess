import animalchess.Cat;
import animalchess.Chick;
import animalchess.Dog;
import animalchess.Game;
import animalchess.Lion;
import animalchess.Piece;
import animalchess.Player;
import animalchess.PromotablePiece;
import animalchess.Square;

import java.util.ArrayList;
import java.util.List;

/**
 * AnimalChess Class for debugging purpose only.
 */
public class AnimalChess {
    /**
     * Main Methods.
     * @param args : arguments.
     */
    public static void main(String[] args) {
        // call the test here
        full();
    }

    /**
     * Full game test.
     */
    public static void full() {
        Game myGame;
        Player p0;
        Player p1;

        p0 = new Player("Michael", 0);
        p1 = new Player("Oz", 1);
        myGame = new Game(p0, p1);

        printState(myGame, p0, p1);

        Chick chick0r = (Chick) myGame.getSquare(2, 3).getPiece();
        chick0r.move(myGame.getSquare(3, 3));
        printState(myGame, p0, p1);

        // P1 moves right-side cat diagonally forward to (4,3)
        Piece cat1r = myGame.getSquare(5, 4).getPiece();
        cat1r.move(myGame.getSquare(4, 3));
        printState(myGame, p0, p1);

        // P0 moves his lion forward to (1,2)
        Piece lion0 = myGame.getSquare(0, 2).getPiece();
        lion0.move(myGame.getSquare(1, 2));
        printState(myGame, p0, p1);

        // P1 moves his right-hand dog sideways
        Dog dog1r = (Dog) myGame.getSquare(5, 3).getPiece();
        dog1r.move(myGame.getSquare(5, 4));
        printState(myGame, p0, p1);

        // P0's right-hand chick takes P1's cat, and promotes
        chick0r.move(cat1r.getSquare());
        printState(myGame, p0, p1);

        dog1r.move(myGame.getSquare(4, 3));
        printState(myGame, p0, p1);

        p0.dropPiece(cat1r, myGame.getSquare(4, 2));
        printState(myGame, p0, p1);

        Chick chick1c = (Chick) myGame.getSquare(3, 2).getPiece();
        List<Square> moves = chick1c.getLegalMoves();
        Square toSquare = moves.get(0);
        chick1c.move(toSquare);  // take P0's chick
        printState(myGame, p0, p1);

        Square square12 = myGame.getSquare(1, 2);
        lion0.move(myGame.getSquare(1, 3));
        printState(myGame, p0, p1);

        chick1c.move(square12);
        printState(myGame, p0, p1);

        // P0 drops a chick on the centre file
        Piece chick0new = p0.getHand().get(0);
        p0.dropPiece(chick0new, myGame.getSquare(3, 2));
        printState(myGame, p0, p1);

        // P1's promoted chick takes P0's lion!
        chick1c.move(lion0.getSquare());
        printState(myGame, p0, p1);

        System.out.println("Winner = " + myGame.getWinner().getName());
    }

    /**
     * printState method : display the game state.
     * @param myGame : the game instance
     * @param p0 : player 0
     * @param p1 : player 1
     */
    public static void printState(Game myGame, Player p0, Player p1) {
        System.out.println("");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                if (myGame.getSquare(i, j).getPiece() == null) {
                    System.out.print("-  ");
                } else if (myGame.getSquare(i, j).getPiece() instanceof Cat) {
                    System.out.print("C" + myGame.getSquare(i, j).getPiece().getOwner().getPlayerNumber() + " ");
                } else if (myGame.getSquare(i, j).getPiece() instanceof Dog) {
                    System.out.print("D" + myGame.getSquare(i, j).getPiece().getOwner().getPlayerNumber() + " ");
                } else if (myGame.getSquare(i, j).getPiece() instanceof Lion) {
                    System.out.print("L" + myGame.getSquare(i, j).getPiece().getOwner().getPlayerNumber() + " ");
                } else if (myGame.getSquare(i, j).getPiece() instanceof Chick) {
                    System.out.print("A" + myGame.getSquare(i, j).getPiece().getOwner().getPlayerNumber() + " ");
                }
            }
            System.out.println("");
        }
        System.out.println("P0 : " + p0.getHand().size());
        for (Piece p: p0.getHand()) {
            System.out.print(p.getClass().getName() + " ");
        }
        System.out.println("");

        System.out.println("P1 : " + p1.getHand().size());
        for (Piece p: p1.getHand()) {
            System.out.print(p.getClass().getName() + " ");
        }

        System.out.println("");
    }
}
