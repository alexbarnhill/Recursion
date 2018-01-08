public class Count {

    public static long c(long n) {
        if(n <= 1) {
            return 0;
        } else {
            return ((n % 10) == 7 ? 1 : 0) + c(n / 10);
        }

    }

    public static void main(String[] args) {
        System.out.println(c(712789));
        System.out.println(c(7));
        System.out.println(c(21920));
        System.out.println(c(281187));
        System.out.println(c(281187));
        System.out.println(c(77777776));
        System.out.println(c(43463456));
        System.out.println(c(1123123));
        System.out.println(c(11117));
        System.out.println(c(77770000000000L));
        System.out.println(c(9819001897L));

    }
}
