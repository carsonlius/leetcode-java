package com.carsonlius.solution;

/**
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 * <p>
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 * <p>
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 * 示例 2:
 * <p>
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *  
 * <p>
 * 提示：
 * <p>
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/divide-two-integers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Divide {
    public static void main(String[] args) {
        Divide divide = new Divide();
        int dividend = -2147483648, divisor = 2;
        int result = divide.solution(dividend, divisor);
        System.out.println(dividend / divisor + "=" + result);
        System.out.println("test =====>" + ((long) -dividend));
    }

    private int solution(int dividend, int divisor) {
        if (divisor == 0) {
            return 0;
        }

        if (divisor == 1) {
            return dividend;
        }

        // 考虑溢出
        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            }
        }

        // 设置正负号
        boolean sign = true;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
            sign = false;
        }

        // 除数，被除数都转换成正数字, 使用long防止溢出
        long dividendLong = dividend, divisorLong = divisor;
        dividendLong = dividendLong > 0 ? dividendLong : -dividendLong;
        divisorLong = divisorLong > 0 ? divisorLong : -divisorLong;

        int result = div(dividendLong, divisorLong);

        return sign ? result : -result;
    }

    private int div(long dividendLong, long divisorLong) {
        // 递归基
        if (dividendLong < divisorLong) {
            return 0;
        }

        long sourceDivisorLong = divisorLong;
        int result = 1;
        while ((divisorLong + divisorLong) < dividendLong) {
            result += result;
            divisorLong += divisorLong;
        }

        return result + div(dividendLong - divisorLong, sourceDivisorLong);
    }
}
