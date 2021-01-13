package com.carsonlius.solution;

import java.util.Arrays;

public class ThreeSumCloest {
    public static void main(String[] args) {
        int[] nums = {-3,-2,-5,3,-4};
        int target = -1;

        ThreeSumCloest threeSumCloest = new ThreeSumCloest();
        System.out.println(threeSumCloest.solution(nums, target));
    }

    public int solution(int[] nums,int target) {
        // 排序 单指针
        if (nums == null || nums.length < 3) {
            return Integer.MIN_VALUE;
        }

        /**
         * 一旦连续的三数的和比targe大，则后面没有必要循环，只能更大
         * */
        Arrays.sort(nums);

        long sumClosest = Integer.MAX_VALUE ;

        for (int i = 0; i < nums.length; i++) {
            if (i> 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i+1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[left] + nums[right] + nums[i];
                if (sum == target) {
                    return sum;
                } else if (sum > target) {
                    while (left < right && nums[right] == nums[right-1]) {
                        right --;
                    }

                    right --;
                } else {
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    left ++;
                }
                sumClosest = Math.abs(sum - target) < Math.abs(sumClosest - target) ? sum : sumClosest;
            }
        }

        return (int)sumClosest;
    }
}
