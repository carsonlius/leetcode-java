package com.carsonlius.solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 * <p>
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：[]
 *  
 * <p>
 * 提示：
 * <p>
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ThreeSumDemo {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        ThreeSumDemo threeSumDemo = new ThreeSumDemo();
        System.out.println(threeSumDemo.solution(nums));
    }

    public List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return answer;
        }

        // copy 循环+双指针的方案
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            // 如果nums[i]和nums[i+1] 则两者的方案一定是相同的
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 如果nums[i]是大于0的 则不可能组合成等于0的数字
            if (nums[i] > 0) {
                break;
            }

            // i为循环开始的节点，但是不会向左循环，因为向左循环必然重复

            // 设置左右指针
            int left = i + 1;
            int right = nums.length - 1;
            int sum;
            while (left < right) {
                sum = nums[left] + nums[right] + nums[i];

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    answer.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // 判断下一个left，right是否跳过
                    left ++;
                    while (left < right && nums[left] == nums[left-1]) {
                        left ++;
                    }

                    right --;
                    while (left < right && nums[right] == nums[right+1]) {
                        right --;
                    }
                }
            }
        }


        return answer;
    }
}
