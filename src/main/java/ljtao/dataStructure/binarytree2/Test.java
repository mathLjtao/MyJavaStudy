package ljtao.dataStructure.binarytree2;

import ljtao.dataStructure.binarytree2.BiTree.BiTreeNode;

import java.util.Collection;
import java.util.Collections;

public class Test {

	public static void main(String[] args){
		demo1();
	}

	//测试二叉树
	public  static void demo1(){
		BiTree bt=new BiTree();
		//System.out.println(bt.root);
		bt.insert(bt, 10);
		bt.insert(bt, 3);
		bt.insert(bt, 18);
//		bt.insert(bt, 15);
//		bt.insert(bt, 19);
//		bt.insert(bt, 16);
		bt.inRootTraverse(bt.root);
		System.out.println();
		System.out.println(bt.delete(10));
		bt.inRootTraverse(bt.root);
	}
}
