/*
  Problem: Two Integer Sum
  Link: https://neetcode.io/problems/two-integer-sum

  Problem Statement:
  Given an array of integers nums and an integer target, return the indices i and j such that nums[i] + nums[j] == target and i != j.

  You may assume that every input has exactly one pair of indices i and j that satisfy the condition.
  
  Return the answer with the smaller index first.
  
  Example 1:
  
  Input: 
  nums = [3,4,5,6], target = 7
  
  Output: [0,1]
  Explanation: nums[0] + nums[1] == 7, so we return [0, 1].
  
  Example 2:
  
  Input: nums = [4,5,6], target = 10
  
  Output: [0,2]
  Example 3:
  
  Input: nums = [5,5], target = 10
  
  Output: [0,1]
  Constraints:
  
  2 <= nums.length <= 1000
  -10,000,000 <= nums[i] <= 10,000,000
  -10,000,000 <= target <= 10,000,000

*/
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Time complexity: O(n), Space complexity: O(n)
        /*
         1. create map where key = nums[i] and value = i by parsing nums[] 
        */
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) map.put(nums[i], i);

        /*
         2. nums[i]+nums[j]=target => nums[j]=target-nums[i]
            hence, check if nums[j] is present inside map
        */
        for(int i=0; i<nums.length; i++) {
            int numsj = target - nums[i];
            if(map.containsKey(numsj) && map.get(numsj) != i) {
                //  indexes found 
                int j = map.get(numsj);
                if(i > j) return new int[] {j,i};
                else return new int[] {i,j};
            }
        }

        return null;
    }
}
