package com.carsonlius.solution;

public class IsPalindromeNumberDemo2 {
    public static void main(String[] args) {
        int x = 151;
        IsPalindromeNumberDemo2 demo2 = new IsPalindromeNumberDemo2();
        System.out.println(demo2.isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        // 还是对比首位和末位
        String xStr = x + "";

        // 设置中间位置
        int stopStep = xStr.length()/2;
        int length = xStr.length();
        System.out.println("stopStep:" + stopStep);

        for (int i = 0; i < stopStep; i++) {
            if (xStr.charAt(i) != xStr.charAt(length-1-i)){
                return false;
            }
        }
        return true;
    }
}
