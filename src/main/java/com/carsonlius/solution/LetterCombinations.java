package com.carsonlius.solution;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinations {

    public List<String> solution(String digits) {
        List<String> list = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return list;
        }

        // copy 回溯方法
        // 存放当前的串
        StringBuilder stringBuilder = new StringBuilder();
        backRecall(list, 0, digits, stringBuilder);

        return list;
    }

    private void backRecall(List<String> list, int index, String digits, StringBuilder stringBuilder){
        // 设置递归基 index == 数字串的长度 说明已经到了最后一位
        if (index == digits.length()) {
            list.add(stringBuilder.toString());
            return;
        }
        // 记录当前的字符串
        String charString = getChars(digits.charAt(index));

        for (int i = 0; i < charString.length(); i++) {
            // 记录当前的字符
            stringBuilder.append(charString.charAt(i));

            // 递归
            backRecall(list, index +1, digits, stringBuilder);

            // 删除最后一个字符
            stringBuilder.deleteCharAt(index);
        }
    }

    private String getChars(char digit) {
        switch (digit) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        String digits = "23";
        System.out.println(letterCombinations.solution(digits));

    }

}
