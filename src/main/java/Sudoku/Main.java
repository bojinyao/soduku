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
        } catch (NumberFormatException e) { // failed to parse num entries
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

        int[] board = {};



        Solver solver = new Solver(new SquareBoard(board, size));
        for (int i = 0; i < POOLSIZE; i++) {
            Thread curr = new Thread(solver);
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
        String arg1 = "         args[1] (-a/-f): -a for finding all valid solutions, -f for finding the first valid solution.\n";
        String arg2 = "         args[2+] (int): actual entries of the board. Use 0 to indicate entries that need to be solved.\n";
        builder.append(usage);
        builder.append(arg0);
        builder.append(arg1);
        builder.append(arg2);
        return builder.toString();
    }
}
