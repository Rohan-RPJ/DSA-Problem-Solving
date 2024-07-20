/*
  Problem: Top K Elements in List
  Link: https://neetcode.io/problems/top-k-elements-in-list

  Problem Statement:
  Given an integer array nums and an integer k, return the k most frequent elements within the array.

  The test cases are generated such that the answer is always unique.
  
  You may return the output in any order.
  
  Example 1:
  
  Input: nums = [1,2,2,3,3,3], k = 2
  
  Output: [2,3]
  Example 2:
  
  Input: nums = [7,7], k = 1
  
  Output: [7]
  Constraints:
  
  1 <= nums.length <= 10^4.
  -1000 <= nums[i] <= 1000
  1 <= k <= number of distinct elements in nums.

*/
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Time complexity: O(nlogn), Space Complexity: O(n) 
        /*
            1. create frequency map and store frequency of each element 
            of nums[] in map
        */
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    
        /*
            2. create new TreeMap map2 and store key of map as value of map2
            and value of map as key of map2, value of map2 will be List<Integer> as there can be multiple keys having same frequency
        */
        Map<Integer, List<Integer>> map2 = new TreeMap<>((k1,k2)->k2-k1); // keys will be in sorted desc order
        for(int key : map.keySet()) {
            int v = map.get(key);
            List<Integer> l = map2.get(v);
            if(l == null) map2.put(v, new ArrayList<>(Arrays.asList(key)));
            else map2.get(v).add(key);
        }    

        /*
            3. parse map2 till k index and fetch map2.get(key).get(i) and store in output
        */
        int[] output = new int[k];
        for(int key : map2.keySet()) {
            List<Integer> l = map2.get(key);
            for(int i=0; i<l.size() && k>0; i++)
                output[--k] = l.get(i);
        }
        
        return output;

    }
}
