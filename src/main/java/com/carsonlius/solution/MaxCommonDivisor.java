package com.carsonlius.solution;

public class MaxCommonDivisor {

    public int solution(int a, int b){
        // 地轨基
        int big = Math.max(a, b);
        int small  = Math.min(a, b);

        if (big%small == 0) {
            return small;
        }
        return solution(big%small, small);
    }

    public int solution2(int a, int b){
        int big = Math.max(a,b);
        int small = Math.min(a,b);

        if (big%small == 0) {
            return small;
        }

        return solution2(big-small, small);
    }

    public static void main(String[] args) {
        MaxCommonDivisor maxCommonDivisor = new MaxCommonDivisor();
        int a = 30;
        int  b= 40;
        int result = maxCommonDivisor.solution2(a,b);

        System.out.println("a:" + a+" b:"+b + "最大公约数:" +result);
    }
}
