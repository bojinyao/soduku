package Sudoku;


/**
 * Program entry point
 *
 *
 * User will need to enter appropriate parameters
 *
 * arg[0] (int): number of entries. 3x3 board have 9 entries
 * arg[1] (flag):
 *      -a  find all valid solutions
 *      -f  find first valid solution
 * arg[2+] (int): actual entries of the board
 *  in the order of top to bottom, left to right
 */
public class Main {

    /** using a Thread Pool of 10 threads */
    private static final int POOLSIZE = 10;

    public static void main(String... args) {

        /*--------- args parsing -----------*/
        /* number of entries INDEX 0 */
        int size;
        try {
            size = Integer.parseInt(args[0]);
            if (size < 1) throw new NumberFormatException("board size must be at least 1 x 1"); // board size must be at least 1 x 1
        } catch (NumberFormatException e) { // failed to parse num entries
            System.out.println(e);
            System.out.println(Main.usageMessage());
            return;
        }
        /* flag INDEX 1 */
        boolean findAll;
        String arg1 = args[1];
        if (arg1.equals("-a")) {
            findAll = true;
        } else if (arg1.equals("-f")) {
            findAll = false;
        } else { // failed to parse options
            System.out.println(Main.usageMessage());
            return;
        }

        /* parse board entries */
        int[] arr = new int[size];
        try {
            if (args.length < size * size + 2)
                throw new IndexOutOfBoundsException("Not enough entries for board size");
            for (int i = 2; i < 2 + size; i++) {
                int temp = Integer.parseInt(args[i]);
                if (temp < 0) throw new NumberFormatException("board cannot contain negative numbers"); // user input cannot contain negative numbers
                arr[i - 2] = temp;
            }
        } catch (NumberFormatException e) {
            System.out.println(e);
            System.out.println(Main.usageMessage());
            return;
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e);
            return;
        }

        /** Solving the board */
        SquareBoard squareBoard;
        try {
            squareBoard = new SquareBoard(arr, size);
        } catch (AssertionError e) {
            System.out.println(e);
            System.out.println("Failed to create board");
            return;
        }

        Solver solver = new Solver(squareBoard);

        Thread[] workers = new Thread[POOLSIZE];
        for (int i = 0; i < POOLSIZE; i++) {
            Thread curr = new Thread(solver);
            workers[i] = curr;
            curr.start();
        }
    }


    /**
     * Create usage message
     * @return usage message as String
     */
    public static String usageMessage() {
        StringBuilder builder = new StringBuilder();

        String usage = "Usage:\n";
        String arg0 = "         args[0] (int): number of entries in the board (e.g. 3 x 3 board has 9).\n";
        String arg0_1 = "           arg[0] value determines how many inputs will be parsed, extra numbers won't be read.\n";
        String arg1 = "         args[1] (-a/-f): -a for finding all valid solutions, -f for finding the first valid solution.\n";
        String arg2 = "         args[2+] (int): actual entries of the board. Use 0 to indicate entries that need to be solved.\n";
        builder.append(usage);
        builder.append(arg0);
        builder.append(arg0_1);
        builder.append(arg1);
        builder.append(arg2);
        return builder.toString();
    }
}
