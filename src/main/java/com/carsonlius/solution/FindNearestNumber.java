package com.carsonlius.solution;

public class FindNearestNumber {
    public int[] getNearestNumber(int[] numbers) {
        // 从后往前找出逆序的前一位，边界
        int index = findTransferPointer(numbers);

        // 数字完全逆序无法找到更大的值
        if (index == -1) {
            return null;
        }

        // 找出比边界刚好大一点的后续值
        exchangeHead(numbers, index);

        // 后续值从小到大的排序
        reverse(numbers, index+1);

        return numbers ;
    }

    /**
     * 对边界之后的值进行正序排序
     * */
    private void reverse(int[] numbers, int reverseIndex){
        for (int i = reverseIndex,  j = numbers.length-1; i < j; i++, j--) {
            int temp = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = temp;
        }
    }

    /**
     * 交换边界值和后续大值
     */
    private void exchangeHead(int[] numbers, int headIndex) {
        int head = numbers[headIndex];

        // 这里本身已经是逆序了，从后往前第一个大于head就是要找的值
        int minBigNumber = -1;

        for (int i = numbers.length-1; i > headIndex; i--) {
            if (head < numbers[i]) {
                numbers[headIndex] =numbers[i];
                numbers[i] = head;
                break;
            }

        }
    }


    /**
     * 从后往前找出逆序的前一位，边界
     */
    private int findTransferPointer(int[] numbers) {
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] > numbers[i - 1]) {
                return i - 1;
            }
        }

        return -1;
    }

    private void outputNumbers(int[] numbers){
        for (int number : numbers) {
            System.out.print(number);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        FindNearestNumber findNearestNumber = new FindNearestNumber();
        int[] numbers = new int[]{1,2,3,4,5};
        for (int i = 0; i < 10; i++) {
            findNearestNumber.getNearestNumber(numbers);
            findNearestNumber.outputNumbers(numbers);
        }
    }

}
