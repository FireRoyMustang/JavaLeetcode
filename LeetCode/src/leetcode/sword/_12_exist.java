package leetcode.sword;

public class _12_exist {
    //    给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//    例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
    public static void main(String[] args) {
        _12_exist e = new _12_exist();
        e.exist(new char[][]{{'a', 'a'}}, "aa");
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int row, int col) {
        int m = board.length, n = board[0].length;
        if (row == m || row < 0 || col == n || col < 0 || board[row][col] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        char c = board[row][col];
        board[row][col] = ' ';
        index++;
        if (dfs(board, word, index, row - 1, col) || dfs(board, word, index, row + 1, col) ||
                dfs(board, word, index, row, col - 1) || dfs(board, word, index, row, col + 1)) {
            return true;
        } else {
            board[row][col] = c;
            return false;
        }
    }
}
