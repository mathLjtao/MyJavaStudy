package ljtao.dataStructure.binarytree2;

import ljtao.dataStructure.binarytree2.BSTree.BSTNode;

public class BiTree {
	BiTreeNode root;
	BiTree(Integer root){
		this.root=new BiTreeNode(root);
	}
	BiTree(){
		this.root=null;
	}
	//树的节点类
	public class BiTreeNode {
		public Integer data;
		public BiTreeNode lchild,rchild,parent;
		public BiTreeNode(){}
		public BiTreeNode(Integer data){
			this();
			this.data=data;
			this.lchild=null;
			this.rchild=null;
			this.parent=null;
		}
		public BiTreeNode(Integer data,BiTreeNode lchild,BiTreeNode rchild,BiTreeNode parent){
			this(); 
			this.data=data;
			this.lchild=lchild;
			this.rchild=rchild;
			this.parent=parent;
		}
	}
	/*
	 * 查找某个节点，我们必须从根节点开始遍历。
	　　①、查找值比当前节点值大，则搜索右子树；
	　　②、查找值等于当前节点值，停止搜索（终止条件）；
	　　③、查找值小于当前节点值，则搜索左子树；
	 */
	public BiTreeNode find(Integer key){
		BiTreeNode curNode=this.root;
		while(curNode!=null){
			if((int)curNode.data>(int)key){
				curNode=curNode.lchild;
			}
			else if((int)curNode.data<(int)key){
				curNode=curNode.rchild;
			}
			else{
				return curNode;
			}
		}
		return null;	
	}
	/*
	 *  要插入节点，必须先找到插入的位置。与查找操作相似，由于二叉搜索树的特殊性，
	 *  待插入的节点也需要从根节点开始进行比较，小于根节点则与根节点左子树比较，反之则与右子树比较，直到左子树为空或右子树为空，则插入到相应为空的位置，
	 *  在比较的过程中要注意保存父节点的信息 及 待插入的位置是父节点的左子树还是右子树，才能插入到正确的位置。
	 */
	public boolean insert(BiTree bt,Integer value){
		BiTreeNode curNode=bt.root;
		BiTreeNode newNode=new BiTreeNode(value);
		BiTreeNode parentNode=null;
		//判断当前是不是空树
		if(curNode==null){
			bt.root=newNode;
			return true;
		}
		while(curNode!=null){
			parentNode=curNode;
			//这里插入比较只支持int类型的
			if((int)curNode.data>(int)value){
				curNode=curNode.lchild;
				if(curNode==null){
					parentNode.lchild=newNode;
					newNode.parent=parentNode;
					return true;
				}
			}
			else{
				curNode=curNode.rchild;
				if(curNode==null){
					parentNode.rchild=newNode;
					newNode.parent=parentNode;
					return true;
				}
			}
		}
		return false;
	}
	 /*
     * 查找最小结点：返回tree为根结点的二叉树的最小结点。
     */
    public BiTreeNode minimum(BiTreeNode tree) {
    	if(tree==null)
    		return null;
    	while(tree.lchild!=null){
    		tree=tree.lchild;
    	}
    	return tree;
    }
    /*
     * 找结点(x)的后继结点。即，查找"二叉树中数据值大于该结点"的"最小结点"。
     */
    public BiTreeNode successor(BiTreeNode x){
    	if(x.rchild!=null){
    		return minimum(x.rchild);
    	}
    	
    	BiTreeNode y=x.parent;
    	while((y!=null)&&(y.rchild==x)){
    		x=y;
    		y=y.parent;
    	}
    	return y;
    }
   
	/*
	 * 三种情况：
	 * 1、要删除节点无子节点
	 * 2、有左节点或右节点
	 * 3、左、右节点都有
	 */
	private void deleteNoChild(BiTreeNode node ){
		
		//判断是不是根节点
		if(node.parent==null)
			root=null;
		//判断是左节点还是右节点，然后将他删除
		if(node==node.parent.lchild)
			node.parent.lchild=null;
		else{
			node.parent.rchild=null;
		}
	}
	private void deleteHaveOneChild(BiTreeNode node ){
		//判断是不是根节点
		if(node.parent==null){
			if(node.lchild!=null){
				root=node.lchild;
			}
			else{
				root=node.rchild;
			}
		}
		else{
			if(node==node.parent.lchild){
				//判断有左节点，还是有右节点
				if(node.lchild!=null){
					//设置该节点的左孩子 为该节点的父节点的左孩子
					node.parent.lchild=node.lchild;
					//设置该节点的左孩子的父节点 为 该节点的父节点
					node.lchild.parent =node.parent;
				}
				else{
					node.parent.lchild=node.rchild;
					node.rchild.parent =node.parent;
				}
			}
			else{
				//判断有左节点，还是有右节点
				if(node.lchild!=null){
					//设置该节点的左孩子 为该节点的父节点的右孩子
					node.parent.rchild=node.lchild;
					//设置该节点的左孩子的父节点 为 该节点的父节点
					node.lchild.parent =node.parent;
				}
				else{
					node.parent.rchild=node.rchild;
					node.rchild.parent =node.parent;
				}
			}
		}
	}
	//查找出要删除节点的后续节点，，将后续节点的值保留，  再将后续节点删除，再将后续节点的值赋值到要删除的节点的值上。(就是将问题改变成了上面的两种情况)
	private void deleteHaveLRChild(BiTreeNode node){
		//要删除节点的后继节点
		BiTreeNode successor = successor(node);
		node.data=successor.data;
		//后续节点是否为 待删除节点的右节点
		if(successor ==node.rchild){
			//后续节点没有子节点
			if(successor.lchild==null && successor.rchild==null){
				node.rchild=null;
				return ;
			}
			else{
				//后续节点只有一个右节点
				node.rchild=successor.rchild;
				successor.rchild.parent=node;
				return;
			}
		}
		
		if(successor.lchild==null && successor.rchild==null){
			successor.parent.lchild=null;
			return;
		}
		else{
			successor.parent.lchild=successor.rchild;
			successor.rchild.parent=successor.parent;
			return;
		}
	}
	public boolean delete(Integer key){
		BiTreeNode node=find(key);
		if(node!=null){
			//1、
			if(node.lchild==null && node.rchild==null){
				deleteNoChild(node);
			}
			//2、
			else  if(node.lchild!=null && node.rchild!=null){
				deleteHaveLRChild(node);
			}
			//3、
			else{
				deleteHaveOneChild(node);
			}
			return true;
		}
		return false;
	}
	//前序遍历的递归方式
	public void preRootTraverse(BiTreeNode bt){
		if(bt==null)
			return;
		System.out.print(bt.data+" ");
		preRootTraverse(bt.lchild);
		preRootTraverse(bt.rchild);
	}
	//中序遍历：左子树——》根节点——》右子树
	public void inRootTraverse(BiTreeNode bt){
		if(bt==null)
			return;
		inRootTraverse(bt.lchild);
		System.out.print(bt.data+" ");
		inRootTraverse(bt.rchild);
	}
	//后续遍历
	public void posRootTraverse(BiTreeNode bt){
		if(bt==null)
			return;
		posRootTraverse(bt.lchild);
		posRootTraverse(bt.rchild);
		System.out.print(bt.data+" ");
	}
	
}
