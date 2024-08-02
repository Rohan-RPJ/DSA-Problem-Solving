/*
Problem: Products of Array Discluding Self
Link: https://neetcode.io/problems/products-of-array-discluding-self, https://leetcode.com/problems/product-of-array-except-self

Problem Statement:
Given an integer array nums, return an array output where output[i] is the product of all the elements of nums except nums[i].

Each product is guaranteed to fit in a 32-bit integer.

Follow-up: Could you solve it in O(n) time without using the division operation?

Example 1:

Input: nums = [1,2,4,6]

Output: [48,24,12,8]
Example 2:

Input: nums = [-1,0,1,2,3]

Output: [0,-6,0,0,0]
Constraints:

2 <= nums.length <= 1000
-20 <= nums[i] <= 20

*/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        /*
            Time Complexity: O(n), Space Complexity: O(1)
            eg: nums=[3,2,4,6]
            create list = [1, 6, 6*4, 6*4*2]
            to find output prodArr, parse list from end and multiply it with nums elements parsing from first
            output prodArr = [(6*4*2)*1, (6*4)*(1*3), (6)*(1*3*2), (1*3*2*4)]
        */
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i=nums.length-1,j=0; i>0; i--,j++)
            list.add(list.get(j)*nums[i]);

        int[] prodArr = new int[nums.length];
        int tempProd = 1;
        for(int i=0,j=nums.length-1; i<nums.length;i++,j--) {
            prodArr[i] = list.get(j)*tempProd;
            tempProd *= nums[i];
        }

        return prodArr;
    }
}  
