package leetcode.algorithm;

/**
 *@Description
 *@Author ShenYubo
 *@Date 2021/4/14 9:10
 *@Version V1.0
 **/
//Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
//请你实现 Trie 类：
//Trie() 初始化前缀树对象。
//void insert(String word) 向前缀树中插入字符串 word 。
//boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
//boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。

public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.search("a");
    }

    Trie[] nodes;
    boolean isEnd; // 是否为最后一个字符

    /** Initialize your data structure here. */
    public Trie() {
        nodes = new Trie[26];
        isEnd = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            int deviation = word.charAt(i) - 'a';
            if (trie.nodes[deviation] == null) {
                trie.nodes[deviation] = new Trie();
            }
            trie = trie.nodes[deviation];
        }
        trie.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            int deviation = word.charAt(i) - 'a';
            trie = trie.nodes[deviation];
            if (trie == null) {
                return false;
            }
        }
        return trie.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie trie = this;
        for (int i = 0; i < prefix.length(); i++) {
            int deviation = prefix.charAt(i) - 'a';
            trie = trie.nodes[deviation];
            if (trie == null) {
                return false;
            }
        }
        return true;
    }
}
