package leetcode.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1104_pathInZigZagTree {
    //    在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。
//    如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；
//    而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。
//    给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
//    1 <= label <= 10^6
    public List<Integer> pathInZigZagTree(int label) {
        int row = 1, rowStart = 1;
        while (rowStart * 2 <= label) {
            row++;
            rowStart *= 2;
        }
        if (row % 2 == 0) {
            label = getReverse(label, row); // 获取label对应坐标
        }
        List<Integer> path = new ArrayList<Integer>();
        while (row > 0) {
            if (row % 2 == 0) {
                path.add(getReverse(label, row)); // 根据坐标获取label
            } else {
                path.add(label);
            }
            row--;
            label >>= 1;
        }
        Collections.reverse(path);
        return path;
    }

    // 根据label获取实际坐标
    public int getReverse(int label, int row) {
        return (1 << (row - 1)) + (1 << row) - 1 - label;
    }
}
