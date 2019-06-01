package Sudoku;


/**
 * A Board is represented using a single list.
 * Since each board is a square, simple algebra is used to
 * calculate and find each entry.
 *
 *   x --->
 * y
 * |
 * |
 * v
 *
 * ----------------------------
 * | (0, 0) | (0, 1) | (0, 2) |
 * |    0   |    1   |    2   |
 * ----------------------------
 * | (1, 0) | (1, 1) | (1, 2) |
 * |    3   |    4   |    5   |
 * ----------------------------
 * | (2, 0) | (2, 1) | (2, 2) |
 * |    6   |    7   |    8   |
 * ----------------------------
 *
 * In the above example, a 3 x 3 Board takes in an array of
 * 9 elements, and size = 3
 *
 * For 9 x 9 Boards, it takes in an array of 81 elements, and size = 9.
 *
 * As far as a Board is defined, ** 0 ** is treated as none
 */

public class SquareBoard {

    /** Elements in the Board */
    private int[] entries;

    /** Board is of size x size */
    private int size;

    SquareBoard (int[] entries, int size) {
        assert size > 0
                && size * size == entries.length;
        this.entries = entries;
        this.size = size;
    }

    int yVal(int index) {
        assert index > 0 && index < entries.length;
        return index / size;
    }

    int xVal(int index) {
        assert index > 0 && index < entries.length;
        return index % size;
    }

    int coordinateToIndex(int x, int y) {
        assert x > 0 && y > 0 && x < size && y < size;
        return x * size + y;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\n---\n");
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                builder.append(String.format(" %d", entries[x * y]));
            }
            builder.append("\n");
        }
        builder.append("\n---\n");
        return builder.toString();
    }
}
