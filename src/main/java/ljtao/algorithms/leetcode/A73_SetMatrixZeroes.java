package ljtao.algorithms.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ljtao3 on 2020/4/27
 *
 * 给定一个米 X Ñ矩阵，如果一个元素是0时，设置其整个行和列0。这样做就地。
 *
 * 范例1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 范例2：
 *
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 */
public class A73_SetMatrixZeroes {
    public static void main(String[] args) {
    }

    //待完善
    static void fun1(int[][] matrix){
        if(matrix.length==0) return;
        List<Integer> iList=new ArrayList<>();
        List<Integer> jList=new ArrayList<>();
        //先得出所有0的位置
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j]==0){
                    iList.add(i);
                    jList.add(j);
                }
            }
        }
    }
}
