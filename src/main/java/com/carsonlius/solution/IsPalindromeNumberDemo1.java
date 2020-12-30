package com.carsonlius.solution;


public class IsPalindromeNumberDemo1 {
    public static void main(String[] args) {
        IsPalindromeNumberDemo1 demo1 = new IsPalindromeNumberDemo1();
        int x = 1001;
        System.out.println(demo1.isPalindrome(x));
    }


    public boolean isPalindrome(int x){
        if (x < 0) {
            return false;
        }

        // 余操作的分母
        int div = 1;
        while (x/div >= 10) {
            div *= 10;
        }

        // 循环比较最后一位数字和首位数字的是否相同
        while (x > 0) {
            int left = x/div;
            int right = x%10;

            System.out.println("left:" + left + " right:" + right + " x:" + x + " div:" + div);
            if (left != right) {
                return false;
            }

            // 变动div 和x
            x = (x%div)/10;
            div /= 100;
        }

        return true;
    }
}
