/*
  Problem: Binary Search
  Link: https://neetcode.io/problems/binary-search, 

  Problem Statement: 
  Binary Search
  You are given an array of distinct integers nums, sorted in ascending order, and an integer target.
  
  Implement a function to search for target within nums. If it exists, then return its index, otherwise, return -1.
  
  Your solution must run in O(logn) time.
  
  Example 1:
  
  Input: nums = [-1,0,2,4,6,8], target = 4
  
  Output: 3
  Example 2:
  
  Input: nums = [-1,0,2,4,6,8], target = 3
  
  Output: -1
  Constraints:
  
  1 <= nums.length <= 10000.
  -10000 < nums[i], target < 10000
*/

class Solution {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int middle;
        while(start<=end) {
            middle = (end+start)/2;
            if(target < nums[middle]) end = middle-1;
            else if(target > nums[middle]) start = middle+1;
            else return middle;
        }
        return -1;
    }
}
