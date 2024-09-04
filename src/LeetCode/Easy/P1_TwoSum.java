package LeetCode.Easy;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;

public class P1_TwoSum {
    public static void main(String[] args) {
        int[] nums = {2,11,7,15};
        int target = 9;

        int[] nums2 = {3,3};
        int target2 = 6;
        P1_TwoSum solution = new P1_TwoSum();
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));

        System.out.println(Arrays.toString(solution.twoSumHashTable(nums2, target2)));
    }

    private int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }

        }

        return result;

    }


    // solution is incomplete for duplicate values
    private int[] twoSumHashTable(int[] nums, int target){
        int[] result = new int[2];
        Hashtable<Integer, Integer> table = new Hashtable<>();

        for (int i = 0; i < nums.length; i++) {
            table.put(nums[i], i);
        }


        Enumeration<Integer> keys = table.keys();
        while (keys.hasMoreElements()) {
            int key = keys.nextElement();
            System.out.println("Key: " + key + ", Value: " + table.get(key));

        }

        for (int num: nums){
            int diff = target - num;
            System.out.println(num);
            System.out.println(diff);
            System.out.println(table.get(diff));
            System.out.println("===");
            if (table.get(diff) >0) {
                result[0] = table.get(num);
                result[1] = table.get(diff);
                return result;
            }
        }

        return result;
    }
}
