package ljtao.algorithms.leetcode;

/**
 * @author ljtao3 on 2020/4/27
 *
 * 机器人位于m x n网格的左上角（在下图中标记为“开始”）。
 * 机器人只能在任何时间点上下移动。机器人试图到达网格的右下角（在下图中标记为“完成”）。
 * 有多少可能的唯一路径？
 *
 *  【开始】 【 】 【 】
 *   【 】 【 】 【 】
 *   【 】 【 】 【结束】
 *
 * 范例1：
 * 输入： m = 3，n = 2
 *  输出： 3
 *  说明：
 * 从左上角总共有3种到达右下角的方式：
 * 1.右->右->下
 * 2.右->下->右
 * 3.向下->右->右
 *
 * 范例2：
 * 输入： m = 7，n = 3
 *  输出： 28
 */
public class A62_UniquePaths {

    public static void main(String[] args) {
        //TODO 上中文官网检查
        System.out.println(fun1(7,3));
    }

    /*
    m : 列数，，n：行数

    解题思路：每一个的路径数，是上一行跟上一列的路径数总和。可用归并法

     */
    static int fun1(int m,int n){
        if(m<=1 || n<=1){
            return 1;
        }
        return fun1(m,n-1)+fun1(m-1,n);
    }
}
