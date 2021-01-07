package com.carsonlius.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 数字转成罗马数字
 *
 * */
public class IntToRoman {
    private int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
//    private Map<Integer, String> romansMap = new HashMap<>();
//
//    {
//        romansMap.put(1000, "M");
//        romansMap.put(900, "CM");
//        romansMap.put(500, "D");
//        romansMap.put(400, "CD");
//        romansMap.put(100, "C");
//        romansMap.put(90, "XC");
//        romansMap.put(50, "L");
//        romansMap.put(40, "XL");
//        romansMap.put(10, "X");
//        romansMap.put(9, "IX");
//        romansMap.put(5, "V");
//        romansMap.put(4, "IV");
//        romansMap.put(1, "I");
//    }

    public static void main(String[] args) {
        IntToRoman intToRoman = new IntToRoman();
        System.out.println(intToRoman.romans);

        int num = 8;
        System.out.println(intToRoman.solution(num));
    }

    public String solution(int num){
        // copy 贪心算法

        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (index < nums.length) {
            // 每次都选择最大数字
            if (num >= nums[index]) {
                stringBuilder.append(romans[index]);
                num -= nums[index];
            } else {
                index ++;
            }
        }

        return stringBuilder.toString();
    }
}
