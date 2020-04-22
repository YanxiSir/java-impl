package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Tag;

import java.util.LinkedHashMap;

/**
 * LRU缓存机制
 * https://leetcode-cn.com/problems/lru-cache/
 *
 * @author: YanxiSir
 * @Date: 2020/4/19
 * @Sign: 心中田间，木行水上
 */
@Tag({"LRU", "HashMap + 双向联表"})
public class Q146 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        return null;
    }


    class LRUCache extends LinkedHashMap<Integer, Integer> {

        private int capacity;

        public LRUCache(int capacity) {
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.get(key);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }
    }
}
