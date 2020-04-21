package com.yanxisir.leetcode.medium;

import com.yanxisir.leetcode.AbstractQ;
import com.yanxisir.leetcode.zannos.Tag;

import java.util.List;

/**
 * 单词拆分
 * https://leetcode-cn.com/problems/word-break/
 *
 * @author: YanxiSir
 * @Date: 2020/4/16
 * @Sign: 心中田间，木行水上
 */
@Tag({"01"})
@Deprecated
public class Q139 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        String s = (String) args[0];
        List<String> wordDict = (List<String>) args[1];
        return solution1(s, wordDict);
    }

    protected boolean solution1(String s, List<String> wordDict) {
        return false;
    }
}
