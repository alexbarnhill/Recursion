import java.util.ArrayList;
import java.util.List;

public class PMenge {

    static List<List<Long>> potentzmenge(long n) {
        List<List<Long>> pm = new ArrayList<>();
        if(n == 0) {
            List<Long> empty = new ArrayList<>();
            pm.add(empty);
            return pm;
        } else {
            // Rekursion
            List<List<Long>> rek = potentzmenge(n - 1);
            pm.addAll(rek);
            // Ergebnisse zusammenfuehren
            for(List<Long> ohneN : rek) {
                List<Long> mitN = new ArrayList<>(ohneN);
                mitN.add(n);
                pm.add(mitN);
            }
        }
        return pm;
    }

    public static void main(String[] args) {
        System.out.println(potentzmenge(3));
    }
}
