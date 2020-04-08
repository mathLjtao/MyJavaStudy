package ljtao.dataStructure.binarytree2;

public class BSTreeTest {

    public static BSTree<Integer> newTree() {
        int[] array = new int[]{50, 30,60,70,80,90};
        BSTree<Integer> tree = new BSTree<>();
        for (int i = 0; i < array.length; i++) {
            tree.insert(array[i]);
        }
        return tree;
    }

    public static void main(String[] args) {
        fun2();
    }
    /*
    测试树的高度
     */
    public static void fun2(){
        BSTree<Integer> tree = newTree();
        print(tree);
        System.out.println("树的最大深度："+tree.maxHeight());
        System.out.println("树的最小深度："+tree.minHeight());
    }

    /*
    测试删除节点
     */
    public static void fun1(){
        BSTree<Integer> tree = newTree();
        System.out.println("----------初始--------");
        // print(tree);
        // tree.delete(20);
        System.out.println("----------删除 20--------");
        // print(tree);
        tree = newTree();
        // tree.delete(70);
        System.out.println("----------删除 70--------");
        print(tree);
        tree = newTree();
        tree.delete(50);
        System.out.println("----------删除 50--------");
        print(tree);
    }


    //------------下面代码是用于输出树的工具代码------------------------

    public static final String  PREFIX_BRANCH = "├";//树枝
    public static final String  PREFIX_TRUNK  = "│ ";//树干
    public static final String  PREFIX_LEAF   = "└";//叶子
    public static final String  PREFIX_EMP    = "  ";//空
    public static final String  PREFIX_LEFT   = "─L─";//左
    public static final String  PREFIX_RIGTH  = "─R─";//右

    private static boolean hasChild(BSTree.BSTNode node){
        return node.left != null || node.right != null;
    }

    public static void print(BSTree tree){
        if(tree != null && tree.mRoot != null){
            System.out.println(tree.mRoot.key);
            print(tree.mRoot, "");
        }
    }

    public static void print(BSTree.BSTNode node, String prefix){
        if(prefix == null){
            prefix = "";
        } else {
            prefix = prefix.replace(PREFIX_BRANCH, PREFIX_TRUNK);
            prefix = prefix.replace(PREFIX_LEAF, PREFIX_EMP);
        }
        if(hasChild(node)){
            if(node.right != null){
                System.out.println(prefix + PREFIX_BRANCH + PREFIX_RIGTH + node.right.key);
                if(hasChild(node.right)){
                    print(node.right, prefix + PREFIX_BRANCH);
                }
            } else {
                System.out.println(prefix + PREFIX_BRANCH + PREFIX_RIGTH);
            }

            if(node.left != null){
                System.out.println(prefix + PREFIX_LEAF + PREFIX_LEFT + node.left.key);
                if(hasChild(node.left)){
                    print(node.left, prefix + PREFIX_LEAF);
                }
            } else {
                System.out.println(prefix + PREFIX_LEAF + PREFIX_LEFT);
            }
        }
    }
}