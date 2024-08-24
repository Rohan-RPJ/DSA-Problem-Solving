/*
  Problem: Search a 2D Matrix
  Link: https://neetcode.io/problems/search-2d-matrix, https://leetcode.com/problems/search-a-2d-matrix/

  Problem Statement:

  Search 2D Matrix
  You are given an m x n 2-D integer array matrix and an integer target.
  
  Each row in matrix is sorted in non-decreasing order.
  The first integer of every row is greater than the last integer of the previous row.
  Return true if target exists within matrix or false otherwise.
  
  Can you write a solution that runs in O(log(m * n)) time?
  
  Example 1:
  Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 10
  Output: true
  
  Example 2:
  Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 15
  Output: false
  Constraints:
  
  m == matrix.length
  n == matrix[i].length
  1 <= m, n <= 100
  -10000 <= matrix[i][j], target <= 10000

*/
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0, end = matrix.length-1, middle;
        int index = -1, rowLen = matrix[0].length-1;
        for(int i=0; i<matrix.length && start<=end; i++) {
            middle = (end+start)/2;
            if(target >= matrix[middle][0] && target <= matrix[middle][rowLen]) index = middle;
            else if(target > matrix[middle][0]) start = middle+1;
            else end = middle-1;
        }
        if(index==-1) return false;
        return search(matrix[index], target);
    }

    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        int middle;
        while(start<=end) {
            middle = (end+start)/2;
            if(target < nums[middle]) end = middle-1;
            else if(target > nums[middle]) start = middle+1;
            else return true;
        }
        return false;
    }
}
