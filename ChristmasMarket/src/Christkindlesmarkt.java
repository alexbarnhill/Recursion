import java.util.ArrayList;
import java.util.List;

public class Christkindlesmarkt {
    public static List<List<Ware>> alle(List<Ware> waren, long geld) {
        List<List<Ware>> llw = new ArrayList<>();
        if(geld == 0 || waren.get(waren.size()-1).preis > geld ) {
            return llw;
        }
        for(Ware w : waren) {
            List<Ware> wL= new ArrayList<>();
            if(geld - w.preis >= 0) {
                wL.add(w);
                List<List<Ware>> rek = alle(waren, geld - w.preis);
                llw.addAll(rek);
            }

            llw.add(wL);
        }
        return llw;
    }



    public static void main(String[] args) {

        List<Ware> waren = new ArrayList<>();
        Ware s1 = new Ware("s1", 10);
        Ware s2 = new Ware("s2", 11);
        Ware s3 = new Ware("s3", 12);
        Ware s4 = new Ware("s4", 13);
        Ware s5 = new Ware("s5", 14);
        Ware s6 = new Ware("s6", 15);
        Ware s7 = new Ware("s7", 16);
        Ware s8 = new Ware("s8", 17);
        Ware s9 = new Ware("s9", 18);
        Ware s10 = new Ware("s10", 19);
        Ware s11 = new Ware("s11", 20);
        Ware s12 = new Ware("s12", 21);
        Ware s13 = new Ware("s13", 22);

        waren.add(s13);
        waren.add(s12);
        waren.add(s11);
        waren.add(s10);
        waren.add(s9);
        waren.add(s8);
        waren.add(s7);
        waren.add(s6);
        waren.add(s5);
        waren.add(s4);
        waren.add(s3);
        waren.add(s2);
        waren.add(s1);

        System.out.println(alle(waren, 200));

    }
}