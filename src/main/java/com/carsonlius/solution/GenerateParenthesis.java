package com.carsonlius.solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/generate-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class GenerateParenthesis {
    public static void main(String[] args) {
        int n = 3;
        GenerateParenthesis generateParenthesis = new GenerateParenthesis();

        System.out.println(generateParenthesis.solution(n));
    }

    public List<String> solution(int n) {
        // copy 暴力官解
        List<String> container = new LinkedList<>();

        genAllAnswer(container, new char[n * 2], 0);

        return container;
    }

    /**
     * 递归在char[2n]实验每种可能性
     *
     * @param container 存放合法的括号集合
     * @param brackets  存放当前枚举的字符集合
     * @param pos       brackets存放字符的个数
     */
    public void genAllAnswer(List<String> container, char[] brackets, int pos) {

        // 递归基
        if (brackets.length == pos) {
            // 长度满足检查字符集合是否合法
            if (isValid(brackets)) {
                container.add(new String(brackets));
            }
            return;
        }

        brackets[pos] = '(';
        genAllAnswer(container, brackets, pos + 1);

        brackets[pos] = ')';
        genAllAnswer(container, brackets, pos + 1);
    }

    /**
     * 判断是否是闭合的字符集合
     *
     * @param brackets 字符集合
     */
    private boolean isValid(char[] brackets) {
        int balance = 0;
        for (char bracket : brackets) {
            if (bracket == '(') {
                balance++;
            } else {
                balance--;
            }

            // )一旦出现了左边比右边多的情况，一定会导致无法闭合
            if (balance < 0) {
                return false;
            }
        }


        return balance == 0;
    }
}
