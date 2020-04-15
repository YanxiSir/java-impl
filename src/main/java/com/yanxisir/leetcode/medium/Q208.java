package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;

import java.util.*;

/**
 * 实现 Trie (前缀树)
 * https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 *
 * @author: YanxiSir
 * @Date: 2020/2/4
 * @Sign: 心中田间，木行水上
 */
public class Q208 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        Trie trie = new Trie();

        trie.insert("apple");
        trie.search("apple");   // 返回 true
        trie.search("app");     // 返回 false
        trie.startsWith("app"); // 返回 true
        trie.insert("app");
        trie.search("app");     // 返回 true

        return null;
    }
}

class Trie {

    Map<String, Integer> map = null;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        map = new HashMap<>();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null || word == "") {
            return;
        }
        map.put(word, 1);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return map.containsKey(word);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix == "") {
            return false;
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getKey().startsWith(prefix)) {
                return true;
            }
        }
        return false;
    }
}
