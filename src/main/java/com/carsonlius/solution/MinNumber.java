package com.carsonlius.solution;

import com.sun.security.jgss.GSSUtil;

public class MinNumber {
    public static String removeKDigits(String number, int k) {
        if (number.length() <= k) {
            return "0";
        }

        // 维护一个char数组用来存放最终保留下来的数字字符
        int newLength = number.length() - k;
        char[] stack = new char[number.length()];

        int stackIndex = 0;

        for (char c : number.toCharArray()) {
            // 当前值小于左值且k还未没有满的时候，
            while (k > 0 && stackIndex > 0 && stack[stackIndex - 1] > c) {
                // 弹出栈顶
                stackIndex--;

                // 要弹出的数量增加1
                k--;
            }

            stack[stackIndex++] = c;
        }

        // 计算前缀0的个数
        int zeroNumber = 0;
        for (int i = 0; i < newLength; i++) {
            if (stack[i] == '0') {
                zeroNumber++;
            } else {
                break;
            }
        }

        return zeroNumber == newLength ? "0" : new String(stack, zeroNumber, newLength - zeroNumber);
    }

    private static String removeKDigits2(String numbers, int k) {
        if (numbers.length() <= k) {
            return "0";
        }

        String strNum = numbers;
        int cutTime =0;
        for (int i = 0; i < k; i++) {
            boolean hasCut = false;
            // 每次删除逆序的前一个数值
            for (int j = 1; j < strNum.length(); j++) {
                if (strNum.charAt(j) < strNum.charAt(j - 1)) {
                    strNum = strNum.substring(0, j-1) + strNum.substring(j);
                    hasCut = true;
                    cutTime++;
                    break;
                }
            }

            // 如果没有找到删除的数字 则删除最后一个数字
            if (!hasCut) {
                // 这里不能直接跳出循环因为不知道已经删除几次且
                // 删除末尾的k-cutTime个
                int newLength = numbers.length()-(k-cutTime);
               strNum =  strNum.substring(0,newLength);
               break;
            }
        }

        // 去掉前缀0
        int zeroNumber = 0;
        for (int i = 0; i < strNum.length(); i++) {
            if (strNum.charAt(i) == '0') {
                zeroNumber ++;
            } else {
                break;
            }
        }

        return zeroNumber == strNum.length() ? "0" : strNum.substring(zeroNumber);
    }

    public static void main(String[] args) {

        System.out.println("--------------------------------------");
        System.out.println(removeKDigits("541270936", 3));
        System.out.println(removeKDigits2("541270936", 3));
        System.out.println(removeKDigits("1593212", 3));
        System.out.println(removeKDigits2("1593212", 3));
        System.out.println(removeKDigits("30200", 1));
        System.out.println(removeKDigits2("30200", 1));
        System.out.println(removeKDigits("10", 2));
        System.out.println(removeKDigits2("10", 2));
        System.out.println(removeKDigits2("1", 2));
                System.out.println(removeKDigits("1", 2));
    }
}
