import java.util.ArrayList;
import java.util.List;

public class LinSearch {

    public static Item find(List<Item> list, long price) {
        if(price < 0 || list.size() == 0) {
            throw new IllegalArgumentException();
        }  else if (list.get(list.size() - 1).price == price) {
            return list.get(list.size() - 1);
        } else {
            list.remove(list.size() - 1);
            return find(list, price);
        }



    }
    public static void main(String[] args) {
        List<Item> list = new ArrayList<>();
        Item s1 = new Item("s1", 10);
        Item s2 = new Item("s2", 11);
        Item s3 = new Item("s3", 12);
        Item s4 = new Item("s4", 13);
        Item s5 = new Item("s5", 14);
        Item s6 = new Item("s6", 15);
        Item s7 = new Item("s7", 16);
        Item s8 = new Item("s8", 17);
        Item s9 = new Item("s9", 18);
        Item s10 = new Item("s10", 19);
        Item s11 = new Item("s11", 20);
        Item s12 = new Item("s12", 21);
        Item s13 = new Item("s13", 22);

        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        list.add(s6);
        list.add(s7);
        list.add(s8);
        list.add(s9);
        list.add(s10);
        list.add(s11);
        list.add(s12);
        list.add(s13);

        System.out.println(find(list, 13).name);

    }
}
