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
        int l = 0;
        if(height(tree) == 0) {
            return 0;
        }

        int without = 0;
        for(TenTree t : tree.children) {
            
        }

        int with = 0;
        return Math.max(with, without);
    }

    public static void main(String[] args) {
        TenTree root = new TenTree();
        root.children[0] = new TenTree();
        root.children[0].children[2] = new TenTree();
        root.children[0].children[2].children[7] = new TenTree();
        root.children[1] = new TenTree();
        root.children[2] = new TenTree();

        System.out.println(longest(root));
    }
}
