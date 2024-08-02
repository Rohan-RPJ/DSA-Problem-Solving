/*
  Problem: Contains Duplicate
  Link: https://neetcode.io/problems/duplicate-integer, https://leetcode.com/problems/contains-duplicate
  
  Problem Statement:
  Given an integer array nums, return true if any value appears more than once in the array, otherwise return false.  
  
  Example 1:
  Input: nums = [1, 2, 3, 3]
  Output: true

  Example 2:  
  Input: nums = [1, 2, 3, 4]
  Output: false
*/

class Solution {
    public boolean hasDuplicate(int[] nums) {
        Map<Integer, Integer> m = new HashMap<>(nums.length);
        for(int n : nums) {
            if(m.containsKey(n)) m.put(n, m.get(n)+1);
            else m.put(n,1);
        }
        for(int k : m.keySet()) {
            // System.out.println(m.get(1))
            if(m.get(k) > 1) return true;
        }
        return false;
    }
}
