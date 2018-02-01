public class Quick {
    protected static void quicksortRec(char[] a, int m, int n) {
        if (n > m) {
            int r = partition(a, m, n);
            quicksortRec(a, m, r - 1);
            quicksortRec(a, r + 1, n);
        }
    }

    public static void quicksort(char[] a) {
        quicksortRec(a, 0, a.length - 1);
    }

    protected static int partition(char[] a, int m, int n) {
        char p = a[n];
        int i = m - 1;
        int j = m;
        while (j < n) {

            if (a[j] < p) {
                i++;
                swap(a, i, j);
            }
            j++;
        }

        int r = i + 1;
        swap(a, r, n);

        return r;
    }

    public static void swap(char[] a, int r, int n) {
            char tmp = a[r];
            a[r] = a[n];
            a[n] = tmp;
    }

    public static void main(String[] args) {
        char[] liste = {'A', 'u', 'D', 'i', 's', 't', '>', 'F','u','n', '?', '?'};
        quicksort(liste);
        for (int i=0; i<liste.length; i++)
            System.out.print(liste[i]+" ");

    }
}