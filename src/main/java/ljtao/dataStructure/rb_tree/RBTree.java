package ljtao.dataStructure.rb_tree;
/*
说明图
https://www.cnblogs.com/skywang12345/p/3624343.html
 */
public class RBTree<T extends Comparable<T>> {
    private RBNode<T> mRoot;
    private static final boolean RED = false;
    private static final boolean BLACK = true;

    public class RBNode<T extends Comparable<T>> {
        T key;
        boolean color;
        RBNode<T> left;
        RBNode<T> right;
        RBNode<T> parent;

        public RBNode(T key, boolean color, RBNode left, RBNode right, RBNode parent) {
            this.key = key;
            this.color = color;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }
    }
    /*
     * 对红黑树的节点(x)进行左旋转
     *
     * 左旋示意图(对节点x进行左旋)：
     *      px                              px
     *     /                               /
     *    x                               y
     *   /  \      --(左旋)-.           / \                #
     *  lx   y                          x  ry
     *     /   \                       /  \
     *    ly   ry                     lx  ly
     *
     *
     */
    public void leftRotate(RBNode<T> x){
        RBNode<T> y=x.right;
        x.right=y.left;
        //将y的左孩子的“父节点”设置为x
        if(y.left!=null){
            y.left.parent=x;
        }
        y.parent=x.parent;
        if(x.parent==null){
            this.mRoot=y;
        }
        else{
            //设置y为“x的父节点”的左节点或者是右节点
            if(x.parent.left==x){
                x.parent.left=y;
            }
            else{
                x.parent.right=y;
            }
        }
        y.left=x;
        x.parent=y;
    }
    /*
     * 对红黑树的节点(y)进行右旋转
     *
     * 右旋示意图(对节点y进行左旋)：
     *            py                               py
     *           /                                /
     *          y                                x
     *         /  \      --(右旋)-.            /  \                     #
     *        x   ry                           lx   y
     *       / \                                   / \                   #
     *      lx  rx                                rx  ry
     *
     */
    public void rightRotate(RBNode<T> y){
        RBNode<T> x=y.left;
        y.left=x.right;
        if(x.right!=null){
            x.right.parent=y;
        }
        x.parent=y.parent;
        if(y.parent==null){
            this.mRoot=x;
        }
        else{
            if(y.parent.left==y){
                y.parent.left=x;
            }
            else{
                y.parent.right=x;
            }
        }
        // 将 “y” 设为 “x的右孩子”
        x.right=y;
        y.parent=x;
    }
}
