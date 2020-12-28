package com.carsonlius.solution;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class LongestPalindrome {
    public static void main(String[] args) {
      String s = "babad";
      LongestPalindrome longestPalindrome = new LongestPalindrome();
      System.out.println(longestPalindrome.getLongestPalindrome(s));

    }
    public String getLongestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        Map<String, Integer> range = new TreeMap<>();
        range.put("left", 0);
        range.put("right", 0);

        char[] str = s.toCharArray();
        for (int i = 0; i < str.length; i++) {
            // 精彩的地方
            // 将回文看成中间的部分全是同一个字符的，左右部分相互对称，找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }

        System.out.println("range" + range + " s:" + s);
        return s.substring(range.get("left"), range.get("right") + 1);
    }

    /**
     * 获取最长的位置
     *
     * */
    private int findLongest(char[] str, int begin , Map<String, Integer> range)
    {
        // 寻找第一个和begin不同的地方, 此时end是首个非中心字符
        int end = begin;
        while (end < str.length-1 && str[end+1] == str[begin]) {
            end ++;
        }

        // 定位中间部分的最后一个字符
        int lastSameIndex = end;

        // 从中间向左右扩散
        // 左右相等则说明目前还是回文
        while (begin >0 && end < str.length -1 && str[end + 1] == str[begin -1]  ) {
            end++;
            begin--;
        }

        // 确保range记录最长的回文开始和结束位置
        int length = end - begin;
        int lengthHistory = range.get("right") - range.get("left");
        if (length > lengthHistory) {
            range.put("left", begin);
            range.put("right", end);
        }

        return lastSameIndex;
    }
}
