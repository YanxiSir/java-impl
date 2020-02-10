package com.yanxisir.leetcode.simple;

import com.yanxisir.leetcode.AbstractQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://leetcode-cn.com/problems/fizz-buzz/
 *
 * @author: YanxiSir
 * @Date: 2020/2/10
 * @Sign: 心中田间，木行水上
 */
public class Q412 extends AbstractQ {

    @Override
    protected Object run(Object... args) {
        int n = (int) args[0];
//        return solution1(n);
//        return solution2(n);
        return solution3(n);
    }

    protected Object solution1(int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            result.add(i % 15 == 0 ? "FizzBuzz" : i % 3 == 0 ? "Fizz" : i % 5 == 0 ? "Buzz" : String.valueOf(i));
        }
        return result;
    }

    protected Object solution2(int n) {
        return IntStream.range(1, n + 1).mapToObj(i -> i % 15 == 0 ? "FizzBuzz" : i % 3 == 0 ? "Fizz" : i % 5 == 0 ? "Buzz" : String.valueOf(i))
                .collect(Collectors.toList());
    }

    protected Object solution3(int n) {
        Integer THREE = 3;
        Integer FIVE = 5;
        Map<Integer, String> map = new HashMap<Integer, String>() {
            {
                put(THREE, "Fizz");
                put(FIVE, "Buzz");
            }
        };
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String s = i % THREE == 0 ? map.get(THREE) : "";
            s += i % FIVE == 0 ? map.get(FIVE) : "";
            result.add("".equals(s) ? String.valueOf(i) : s);
        }
        return result;
    }
}
