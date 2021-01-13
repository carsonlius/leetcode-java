package com.carsonlius.solution;

import java.util.Arrays;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = {"c","acc","ccc"};
        LongestCommonPrefix longestPalindrome = new LongestCommonPrefix();
        System.out.println(longestPalindrome.solutions(strings));
    }

    public String solutions(String[] strs) {
        // 考虑特殊情况
        if (strs == null || strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        /**
         * 二分法解决问题效率 m*logN
         */

        int minLength = strs[0].length();
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }

        // 如果存在共同的前缀一定是在最短字符串的前N个字符
        int begin = 0, end = minLength;

        int middle = 0;
        while (begin < end) {
            middle = (end - begin + 1) / 2 + begin;

            // 中间位置
            String prefixStr = strs[0].substring(0, middle);
            System.out.println("prefixStr:" +prefixStr);

            // 移动middle
            // 包含当前字符子串的时候，向右移动
            if (allStringContainsPrefixString(strs, prefixStr)) {
                begin = middle;
                System.out.println("common :" + prefixStr);
            } else {
                end = middle - 1;
            }
        }

        System.out.println("begin:" + begin + " end:" + end + " middle:" + middle);

        return strs[0].substring(0, begin);
    }

    private boolean allStringContainsPrefixString(String[] strs, String prefixStr) {
        for (int i = 1; i < strs.length; i++) {
            // 如果不包含当前的字符 则再往前移动1/2的字符
            if (!strs[i].startsWith(prefixStr)) {
                return false;
            }
        }
        return true;
    }
}
