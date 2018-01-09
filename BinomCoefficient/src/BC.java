public class BC {
    public static long f(long[][] x, int y, int z) {
        if (x == null || x.length <= y || x[y].length <= z) {
            x = new long[y + 1][z + 1];
        }

        if(y < 0 || z < 0 || z > y) {
            return 0;
        } else if (z == 0 || z == y) {
            return 1;
        } else if (x[y][z] == 0) {
            x[y][z] = f(x, y - 1, z - 1) + f(x, y - 1, z);
        }

        return x[y][z];
    }

    public static void main(String[] args) {
        System.out.println(f(null, 9, 4));
    }
}
