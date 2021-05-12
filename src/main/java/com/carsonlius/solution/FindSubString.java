package com.carsonlius.solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 串联所有单词的子串
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * <p>
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSubString {

    public List<Integer> solution(String s, String[] words) {
        List<Integer> response = new ArrayList<>();

        //  判断s或者words不合法
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return response;
        }

        // words组成map，后面需要用来判断当前单词是否存在
        Map<String, Integer> sourceMap = new HashMap<>();
        for (String word : words) {
            sourceMap.put(word, sourceMap.getOrDefault(word, 0) + 1);
        }

        // 主循环 第一个单词, 这样可以包含所有的场景
        int oneLength = words[0].length();
        for (int i = 0; i < oneLength; i++) {
            //  内层循环 设置左右指针,左指针是子串起始的位置 right为子串结束的位置 初始值都是主循环i
            int left = i, right = i, count = 0;
            Map<String, Integer> subMap = new HashMap<>();

            // 右窗口不能超出主串长度
            while (right + oneLength <= s.length()) {
                // 获取当前单词且窗口右移
                String world = s.substring(right, right + oneLength);
                right += oneLength;

                //  right+oneLength的单词串如果不存在则当前子串不可能符合要求，left移动到不符合要求的位置
                if (!sourceMap.containsKey(world)) {
                    left = right;
                    subMap.clear();
                    count = 0;
                } else {
                    //  新单词串存在，则放入到subMap<String,Integer>中 (count是符合要求的单词数目)count++
                    count++;
                    subMap.put(world, subMap.getOrDefault(world, 0) + 1);

                    // 如果当前单词的数量超过words的数量 则删除从left到第一个超限单词之间的所有单词
                    while (subMap.get(world) > sourceMap.get(world)) {
                        // 通过移动left指针以及递减subMap<delWorld>来实现
                        String delWorld = s.substring(left, left + oneLength);
                        left += oneLength;
                        subMap.put(delWorld, subMap.get(delWorld) - 1);
                        count--;
                    }

                    // 如果count == words.length 则加入到response中
                    if (count == words.length) {
                        response.add(left);
                    }
                }
            }
        }

        return response;
    }

    public static void main(String[] args) {
        FindSubString findSubString = new FindSubString();
       String s =  "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};

        System.out.println(findSubString.solution(s, words));

    }
}
