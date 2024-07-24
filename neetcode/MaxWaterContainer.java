/*
  Problem: Max Water Container
  Link: https://neetcode.io/problems/max-water-container

  Problem Statement:
  You are given an integer array heights where heights[i] represents the height of the 𝑖th bar.

  You may choose any two bars to form a container. Return the maximum amount of water a container can store.
  
  Example 1:
  Input: height = [1,7,2,5,4,7,3,6]
  
  Output: 36
  Example 2:
  
  Input: height = [2,2,2]
  
  Output: 4
  Constraints:
  
  2 <= height.length <= 1000
  0 <= height[i] <= 1000

*/
class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0, area;
        for(int i=0,j=heights.length-1; i<j;) {
            if(heights[i] >= heights[j]) {
                area = heights[j]*(j-i); j--;
            } else {
                area = heights[i]*(j-i); i++;
            }
            if(area>maxArea) maxArea = area;
        }
        return maxArea;
    }
}
