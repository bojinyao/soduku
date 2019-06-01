import Sudoku.SquareBoard;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SquareBoardTest {


    @Test
    void testSquareBoardBasic() {

        int[] entries = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        SquareBoard board = new SquareBoard(entries, 3);

        /* yVal tests */
        assertEquals(0, board.yVal(0));
        assertEquals(0, board.yVal(1));
        assertEquals(0, board.yVal(2));

        assertEquals(1, board.yVal(3));
        assertEquals(1, board.yVal(4));
        assertEquals(1, board.yVal(5));

        assertEquals(2, board.yVal(6));
        assertEquals(2, board.yVal(7));
        assertEquals(2, board.yVal(8));

        /* xVal tests */
        assertEquals(0, board.xVal(0));
        assertEquals(1, board.xVal(1));
        assertEquals(2, board.xVal(2));

        assertEquals(0, board.xVal(3));
        assertEquals(1, board.xVal(4));
        assertEquals(2, board.xVal(5));

        assertEquals(0, board.xVal(6));
        assertEquals(1, board.xVal(7));
        assertEquals(2, board.xVal(8));

        /* coordinateToIndex tests */
        int index = 0;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                assertEquals(index, board.coordinateToIndex(x, y));
                index++;
            }
        }

    }

    @Test
    void testSquareBoardPrint() {
        int[] entries = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        SquareBoard board = new SquareBoard(entries, 3);

        assertEquals("\n---\n 0 1 2\n 3 4 5\n 6 7 8\n\n---\n", board.toString());

    }
}
