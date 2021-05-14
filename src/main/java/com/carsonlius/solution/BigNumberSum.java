package com.carsonlius.solution;

public class BigNumberSum {

    public static String bigNumSum(String bigNumberA, String bigNumberB){
        // 以数组A,B的形式逆序存储，没有键的存储0-9之间的数字
        int maxLength = Math.max(bigNumberA.length(),bigNumberB.length());
        int[] arrayA = new int[maxLength];
        for (int i = bigNumberA.length()-1; i >=0; i--) {
            arrayA[bigNumberA.length()-1-i] = bigNumberA.charAt(i) - '0';
        }

        int[] arrayB = new int[maxLength];
        for (int i = bigNumberB.length()-1; i >=0; i--) {
            arrayB[bigNumberB.length()-1-i] = bigNumberB.charAt(i) - '0';
        }

        // 生成结果数组 (防溢出 +1位)
        int[] result = new int[maxLength+1];

        // 数组A和B各个对应的元素累加, 大与10进一位
        for (int i = 0; i < maxLength; i++) {
            int temp = result[i] + arrayA[i] + arrayB[i];
            if (temp > 10) {
                temp = temp - 10;
                result[i+1] = 1;
            }
            result[i] = temp;
        }

        // 结果数组倒叙输出结果
        StringBuilder stringBuilder = new StringBuilder();
        boolean findFirst = false;
        for (int i = maxLength; i >=0; i--) {
            if (!findFirst) {
                if (result[i] == 0) {
                    continue;
                }
                findFirst = true;
            }

            stringBuilder.append(result[i]);
        }

        return stringBuilder.toString();
    }



    public static void main(String[] args) {
        int bigNumber = 123456789;
        System.out.println(String.valueOf(bigNumber));
        System.out.println(bigNumSum("123","18"));
    }

}
