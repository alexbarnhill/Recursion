public class Ears {
    public static int c(int n) {
        if(n <= 0) {
            return 0;
        } else {
            return 2 + (2 * (n - 1));
        }
    }

    public static void main(String[] args) {
        System.out.println(c(0));
        System.out.println(c(1));
        System.out.println(c(2));
        System.out.println(c(3));
        System.out.println(c(12));
    }
}
