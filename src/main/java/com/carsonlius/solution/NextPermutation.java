package com.carsonlius.solution;


/**
 * 31. 下一个排列
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 *
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 *
 * 必须 原地 修改，只允许使用额外常数空间。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 *
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 *
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 *
 * 输入：nums = [1]
 * 输出：[1]
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 * */

public class NextPermutation {
    public void solution(int[] nums) {
        if (nums == null || nums.length ==0) {
            return;
        }

        // i<j 寻找较小值i, 倒序第一个nums[i] < nums[j]; 此时i+1--nums.length为降序排列
        int i = nums.length-1;
        boolean hasReversal = false;
        for (i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i+1]) {
                hasReversal = true;
                break;
            }
        }

        if (!hasReversal) {
            return;
        }

        // todo 寻找较大值k 倒序找到第一个nums[i] < nums[k]
        int k = nums[nums.length-1];
        for (int i1 = nums.length - 1; i1 >= 0; i1--) {
            if (nums[i1] < ) {

            }

        }

        // todo 交换i,k
        // todo i+1 --- nums.length从小到大排序, 因为这部分是降序的，所以通过双指针交换就行了


    }
}
