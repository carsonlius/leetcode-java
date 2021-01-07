package com.carsonlius.solution;

import java.util.HashMap;
import java.util.Map;
/**
 *
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "III"
 * 输出: 3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/roman-to-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * */

public class RomanToInt {
    private int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private Map<String, Integer> romansMap = new HashMap<>();

    {
        romansMap.put("M", 1000);
        romansMap.put("CM", 900);
        romansMap.put("D", 500);
        romansMap.put("CD", 400);
        romansMap.put("C", 100);
        romansMap.put("XC", 90);
        romansMap.put("L", 50);
        romansMap.put("XL", 40);
        romansMap.put("X", 10);
        romansMap.put("IX", 9);
        romansMap.put("V", 5);
        romansMap.put("IV", 4);
        romansMap.put("I", 1);
    }

    public int solution(String s) {
        // 不适合自动机,字符和状态之间没有关系
        int endIndex = s.length();
        int index = 0;
        int sum = 0;
        int first = 0;
        String substring = "";
        while (index < endIndex) {
            if (index != endIndex -1) {
                substring = s.substring(index, index + 2);
            } else {
                substring = s.substring(index, index+1);
                first = romansMap.get(substring);
                return sum + first;
            }

            // 包含2个字符 则说明遇到特殊的字符, 此时指针移动2位
            if (!romansMap.containsKey(substring)) {
                sum += romansMap.get(String.valueOf(substring.charAt(0)));
                index++;
            } else {
                sum += romansMap.get(substring);
                index += 2;
            }
        }

        return sum;
    }

    private int getValue(String roman) {

        switch (roman) {
            case "M":
                return 1000;
            case "CM":
                return 900;
            case "D":
                return 500;
            case "CD":
                return 400;
            case "C":
                return 100;
            case "XC":
                return 90;
            case "L":
                return 50;
            case "XL":
                return 40;
            case "X":
                return 10;
            case "IX":
                return 9;
            case "V":
                return 5;
            case "IV":
                return 4;
            case "I":
                return 1;
            default:
                return 0;
        }
    }

    public static void main(String[] args) throws Exception {
        RomanToInt romanToInt = new RomanToInt();
        String s = "III";
        System.out.println(romanToInt.solution(s));
    }

}

