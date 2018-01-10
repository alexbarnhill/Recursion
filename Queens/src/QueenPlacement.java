public class QueenPlacement {

    private static boolean isAttacked(int row, int column, boolean[][] board) {
        assert(row >= 0 && column >= 0);
        if(row > board.length || column > board[0].length) {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                // All in the same row
                if(i == row && board[i][j]) {
                    return true;
                    // All in the same column
                } else if(j == column && board[i][j]) {
                    return true;
                } else if((j + i == row + column) || (j - i == row - column)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean place(int height, int width, int queens) {
        boolean[][] board = new boolean[width][height];
        return placeHelper(board, queens);
    }


    static void printField(boolean[][] field) {
        for(int i = 0; i < field.length; i++) {
            for(int j = 0; j < field[i].length; j++) {
                if(j < field[i].length - 1) {
                    System.out.printf("%s | ", field[i][j] ? "X" : " " );
                } else {
                    System.out.printf("%s\n", field[i][j] ? "X" : " " );
                }

            }
            if(i < field.length - 1) {
                System.out.println("------------------");
            }

        }
        System.out.println();
    }

    private static boolean placeHelper(boolean[][] board, int queens) {
        if(queens == 0) {
            return true;
        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(!isAttacked(i, j, board)) {
                    board[i][j] = true;
                }

                if(placeHelper(board, queens - 1)) {
                    return true;
                }
                board[i][j] = false;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        System.out.println(place(5, 5, 10));
    }
}
