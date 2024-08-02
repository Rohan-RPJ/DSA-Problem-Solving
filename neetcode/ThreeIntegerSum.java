/*
  Problem: Three Integer Sum
  Link: https://neetcode.io/problems/three-integer-sum, https://leetcode.com/problems/3sum

  Problem Statement:
  Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] where nums[i] + nums[j] + nums[k] == 0, and the indices i, j and k are all distinct.
  
  The output should not contain any duplicate triplets. You may return the output and the triplets in any order.
  
  Example 1:
  
  Input: nums = [-1,0,1,2,-1,-4]
  
  Output: [[-1,-1,2],[-1,0,1]]
  Explanation:
  nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
  nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
  nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
  The distinct triplets are [-1,0,1] and [-1,-1,2].
  
  Example 2:
  
  Input: nums = [0,1,1]
  
  Output: []
  Explanation: The only possible triplet does not sum up to 0.
  
  Example 3:
  
  Input: nums = [0,0,0]
  
  Output: [[0,0,0]]
  Explanation: The only possible triplet sums up to 0.
  
  Constraints:
  
  3 <= nums.length <= 1000
  -10^5 <= nums[i] <= 10^5
    
*/
class Solution {

    /*
        Steps: 
        1. Sort array
        2. Take element i and find j and k by applying two sum algo using two pointers on sorted arr from 
        index i+1 to end
        3. Save already found triplets info in set for optimization
        4. return triplets list 
    */

    public List<List<Integer>> findTripletsForI(int[] nums, int target, int start) {
        List<List<Integer>> tripletsI = new ArrayList<>();
        for(int i=start,j=nums.length-1; i<j;) { // two sum algo
            if(nums[i] + nums[j] == target) {
                tripletsI.add(Arrays.asList(nums[start-1], nums[i], nums[j]));
                i++;j--;
                while(i<j && nums[i] == nums[i-1]) i++; // so that same value does not come twice and we get unique triplets
                while(j>i && nums[j] == nums[j+1]) j--; // similar as above from end
            }
            else if(nums[i] + nums[j] > target) {
                j--;
            }
            else{
                i++;
            }
        }
        return tripletsI;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            if(!set1.contains(nums[i])) {
                triplets.addAll(findTripletsForI(nums, -nums[i], i+1));
                set1.add(nums[i]);
            }
        }

        return triplets;
    }
}
