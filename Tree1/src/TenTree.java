public class TenTree {
    private TenTree[] children = new TenTree[10];

    private static int height(TenTree tree) {
        int h = 0;
        for(TenTree t : tree.children) {
            if(t != null) {
                return 1 + height(t);
            }

        }
        return h;

    }

    private static int longest(TenTree tree) {
        if(height(tree) == 0) {
            return 0;
        }

        //without root node
        int without = 0;
        for(TenTree t : tree.children) {
            if(t != null) {
                int l = longest(t);
                if(l >= without ) {
                    without = l;
                }
            }

        }

        //with root node
        int with = 0;
        int max1 = 0;
        int max2 = 0;
        for(TenTree t : tree.children) {
            if(t != null) {
                int ll = height(t);
                if(ll >= max1 && ll >= max2) {
                    max1 = ll;
                } else if(ll >= max2 && ll < max1) {
                    max2 = ll;
                }
            }
        }

        with = max1 + max2 + 2;


        return Math.max(with, without);
    }

    public static void main(String[] args) {
        TenTree root = new TenTree();
        root.children[0] = new TenTree();
        root.children[0].children[0] = new TenTree();
        root.children[0].children[1] = new TenTree();
        root.children[0].children[2] = new TenTree();
        root.children[0].children[0].children[0] = new TenTree();
        root.children[0].children[0].children[0].children[0] = new TenTree();

        root.children[1] = new TenTree();
        root.children[1].children[0] = new TenTree();


       System.out.println("Longest Path: " + longest(root));
    }
}
