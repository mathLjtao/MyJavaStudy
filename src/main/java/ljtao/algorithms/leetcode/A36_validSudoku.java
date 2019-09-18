package ljtao.algorithms.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
未完成
 */
public class A36_validSudoku {
    public static void main(String[] args) {
        char[][] board=new char[][]{
          {'5','3','.','.','7','.','.','.','.'},
          {'6','.','.','1','9','5','.','.','.'},
          {'.','9','8','.','.','.','.','6','.'},
          {'8','.','.','.','6','.','.','.','3'},
          {'4','.','.','8','.','3','.','.','1'},
          {'7','.','.','.','2','.','.','.','6'},
          {'.','6','.','.','.','.','2','8','.'},
          {'.','.','.','4','1','9','.','.','5'},
          {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(isValidSudoku(board));
    }
    //
    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character> hs=new HashSet<>();
        HashSet<Character> lhs=new HashSet<>();
        char ch,lch;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                ch=board[i][j];
                lch=board[j][i];
                if( (ch!='.'&& !hs.add(ch)) || (lch!='.'&& !lhs.add(lch)) ){
                    return false;
                }
                System.out.print(board[i][j]+",");
            }
            hs=new HashSet<>();
            lhs=new HashSet<>();
            System.out.println();
        }
        //3*3 的判断
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                for (int k = 3*i; k < 3*(i+1); k++) {
                    for (int l = 3*j; l < 3*(j+1); l++) {
                        ch=board[k][l];
                        if(ch!='.'&& !hs.add(ch))
                            return false;
                    }
                }
                hs=new HashSet<>();
            }
        }
        return  true;
    }
    /*
    网上的做法
    '4' in row 7被编码为"(4)7"。
    '4' in column 7被编码为"7(4)"。
    '4' in the top-right block被编码为"0(4)2"。
     */
    public boolean isValidSudoku2(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                if (board[i][j] != '.') {
                    String b = "(" + board[i][j] + ")";
                    if (!seen.add(b + i) || !seen.add(j + b) || !seen.add(i/3 + b + j/3))
                        return false;
                }
            }
        }
        return true;
    }
    //网上的做法
    public static boolean isValidSudoku1(char[][] board) {
        // 记录某行，某位数字是否已经被摆放
        boolean[][] row = new boolean[9][9];
        // 记录某列，某位数字是否已经被摆放
        boolean[][] col = new boolean[9][9];
        // 记录某 3x3 宫格内，某位数字是否已经被摆放
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int blockIndex = i / 3 * 3 + j / 3;
                    if (row[i][num] || col[j][num] || block[blockIndex][num]) {
                        return false;
                    } else {
                        //被摆放就记录为true
                        row[i][num] = true;
                        col[j][num] = true;
                        block[blockIndex][num] = true;
                    }
                }
            }
        }
        return true;
    }
}
