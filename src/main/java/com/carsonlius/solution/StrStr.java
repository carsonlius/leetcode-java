package com.carsonlius.solution;

/**
 * 实现 strStr() 函数。
 *
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 *
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 *
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 * 说明:
 *
 * 当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 *
 * 对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/implement-strstr
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */
public class StrStr {
    public int solution(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        if ( haystack == null || haystack.length() == 0) {
            return -1;
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }

        char[] chars = haystack.toCharArray();
        char[] charsNeedle = needle.toCharArray();
        int lengthHaystack = chars.length;
        int lengthNeedle = charsNeedle.length;
        for (int i = 0; i < lengthHaystack - lengthNeedle + 1; i++) {
            if (chars[i] == charsNeedle[0]) {
                boolean match = true;
                for (int i1 = 1; i1 < lengthNeedle; i1++) {
                    int haystackIndex = i + i1;
                    if (haystackIndex >= lengthHaystack || charsNeedle[i1] != chars[haystackIndex]) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        StrStr str = new StrStr();
        String haystack = "aaa", needle = "aaaa";
        int result = str.solution(haystack, needle);
        System.out.println(result);
    }
}
