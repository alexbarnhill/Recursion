public class DtB {
    public static void decimalToBin(long n) {
        if(n > 0) {
            decimalToBin(n / 2);
            System.out.printf("%s", n % 2);
        }

    }

    public static void main(String[] args) {
        decimalToBin(123476546);
    }
}
