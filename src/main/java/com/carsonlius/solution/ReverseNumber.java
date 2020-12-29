package com.carsonlius.solution;

/**
 * 考察： 1.int溢出的判断 2.怎么拆分int数字
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 *
 * 输入: 123
 * 输出: 321
 *  示例 2:
 *
 * 输入: -123
 * 输出: -321
 * 示例 3:
 *
 * 输入: 120
 * 输出: 21
 * 注意:
 *
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * */
public class ReverseNumber {
    public static void main(String[] args) {
        // 抄作业
        ReverseNumber reverseNumber = new ReverseNumber();

        System.out.println(reverseNumber.reverse(-123));
    }

    public int reverse(int x){
        int result = 0;
        int temp;
        while (x !=0) {
            // pop x最后一位
            int last = x%10;

            // x变动
            x /=10;

            // push到result最后一位, 但是可能溢出；溢出不会报错，但是
            temp = result;
            result = result*10 + last;
            if ((result-last)/10 != temp) {
                return 0;
            }
        }

        return result;
    }
}
