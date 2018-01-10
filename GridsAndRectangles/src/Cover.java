import java.util.LinkedList;
import java.util.List;

public class Cover {

    boolean[][] field;
    int width;
    int height;

    public Cover(int width, int height) {
        this.width = width;
        this.height = height;
        this.field = new boolean[width][height];
    }
    static boolean isSolved(boolean[][] used) {
        for(int i = 0; i < used.length; i++) {
            for(int j = 0; j < used[i].length; j++) {
                if(used[i][j] == false) {
                    return false;
                }
            }
        }

        return true;
    }

    static void toggleRectangle(boolean[][] used, int row, int column, Rectangle r) {
        for(int i = 0; i < r.height; i++) {
            for(int j = 0; j < r.width; j++) {
                used[row + i][column + j] = used[row+i][column+j] ? false : true;
            }
        }
    }

    static boolean fits(boolean[][] used, int row, int column, Rectangle r) {
        assert(row >= 0 && column >= 0);
        if(((row + r.height) > used.length) || ((column + r.width) > used[0].length)) return false;
        for(int i = row; i < r.height + row; i++) {
            for(int j = column; j < r.width + column; j++) {
                if(used[i][j]) {
                    return false;
                }
            }
        }

        return true;
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

    static boolean solve(int width, int height, LinkedList<Rectangle> rects) {
        boolean[][] used = new boolean[width][height];
        return solveHelper(used, rects);

    }

    static boolean solveHelper(boolean[][] used, LinkedList<Rectangle> rects) {
        if(isSolved(used)) {
            return true;
        } else if (rects.size() == 0 && !isSolved(used)) {
            return false;
        }

        boolean result;
        Rectangle r = rects.remove(0);

        result = solveHelper(used, rects);
        if(result) {
            return true;
        }
        rects.add(0, r);



        for(int row = 0; row < used.length; row++) {
            for(int column = 0; column < used[row].length; column++) {
                if(fits(used, row, column, r)) {
                    toggleRectangle(used, row, column, r);
                    rects.remove(r);
                    if(!solveHelper(used, rects)) {
                        toggleRectangle(used, row, column, r);
                        rects.add(0, r);
                    }
                }
            }
        }

        printField(used);
        return isSolved(used);
    }

    public static void main(String[] args) {

        Cover c = new Cover(5, 5);

        Rectangle r1 = new Rectangle(5, 1);
        Rectangle r2 = new Rectangle(5, 1);
        Rectangle r3 = new Rectangle(5, 1);
        Rectangle r4 = new Rectangle(5, 1);
        Rectangle r5 = new Rectangle(5, 1);

        LinkedList<Rectangle> rects = new LinkedList<>();
        rects.add(r1);
        rects.add(r2);
        rects.add(r3);
        rects.add(r4);
        rects.add(r5);

        System.out.println(solve(5, 5, rects));



    }
}
