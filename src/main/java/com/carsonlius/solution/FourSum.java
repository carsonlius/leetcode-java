package com.carsonlius.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 */
public class FourSum {

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        int[] nums = {-1,-5,-5,-3,2,5,0,4};
        int target = -7;
        System.out.println(fourSum.solution(nums, target));
    }

    public List<List<Integer>> solution(int[] nums, int target) {
        // copy 排序双指针的算法
        List<List<Integer>> lists = new ArrayList<>();

        // 考虑特殊情况
        if (nums == null || nums.length < 4) {
            return lists;
        }

        // 排序 双指针
        Arrays.sort(nums);
        System.out.println("nums:" + Arrays.toString(nums));

        //  双循环定位前两个数字
        //  双指针锁定后面的两个指针
        for (int i = 0; i < nums.length; i++) {
            // 第一个数 + 第二个数 + 第三 + 第四 > target  则第二轮循环可以结束了
            if (i < nums.length -4 && nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) {
                return lists;
            }

            for (int j = i + 1; j < nums.length; j++) {


                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        System.out.println("i:" + i + " j:" + j + " left:" + left + " right:" + right);

                        // left向右移动,right向左移动
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        left++;

                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        right--;
                    } else if (sum > target) {
                        right--;
                    } else {
                        left++;
                    }
                }

                // 第二个数去重
                while (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    j++;
                }
            }

            // 第一个数去重
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }

        }

        return lists;
    }
}
