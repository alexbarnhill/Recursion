public class Prime {

    private static long pLRHelper(int n) {

        return pLR(n, new long[n+1]);
    }

    private static long pLR(int n, long[] ps) {
        ps[1] = 2;

        if(ps[n] == 0) {
            long p = pLR(n-1, ps);
            int i = 0;
            do {
                p++;
                for(i = 1; i < n && p % ps[i] != 0; i++) {
                   ps[n] = p;
                }
            } while (i != n);
        }

        return ps[n];
    }


    public static void main(String[] args) {
        System.out.println(pLRHelper(1000));
    }
}
