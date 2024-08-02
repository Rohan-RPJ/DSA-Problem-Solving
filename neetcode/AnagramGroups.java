/*
  Problem: Anagram Groups
  Link: https://neetcode.io/problems/anagram-groups, https://leetcode.com/problems/group-anagrams

  Problem Statement:
  Given an array of strings strs, group all anagrams together into sublists. You may return the output in any order.

  An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
  
  Example 1:
  
  Input: strs = ["act","pots","tops","cat","stop","hat"]
  
  Output: [["hat"],["act", "cat"],["stop", "pots", "tops"]]
  Example 2:
  
  Input: strs = ["x"]
  
  Output: [["x"]]
  Example 3:
  
  Input: strs = [""]
  
  Output: [[""]]
  Constraints:
  
  1 <= strs.length <= 1000.
  0 <= strs[i].length <= 100
  strs[i] is made up of lowercase English letters.

*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Time complexity: O(nmlog(m)), Space complexity: O(n+m)
        /*
         1. make copy of input str[] and sort all strings in that array
         eg: str[] = ["act","pots","tops","cat","stop","hat"]
         sortedArr[] = ["act", "opst", "opst", "act", "opst", "aht"]
        */
        String[] sortedArr = new String[strs.length];
        sortedArr = strs.clone();
        char[] c;
        for(int i=0; i<strs.length; i++) {
            c = sortedArr[i].toCharArray();
            Arrays.sort(c);
            sortedArr[i] = new String(c);
        }
        //System.out.println(Arrays.asList(sortedArr));
        /*
         2. create HashMap where key = sortedArr element and 
         value = index of sublist inside list where list is object 
         to be returned, by parsing sortedArr.
         eg: map = {"act": 0, "opst": "1", "aht": "2" }

         if index present in map then store str[i] element in outputList[index] sublist
        */
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> outputList = new ArrayList<>();
        int count = 0;
        for(int i=0; i<strs.length; i++) {
            String s = sortedArr[i];
            if(map.containsKey(s)) outputList.get(map.get(s)).add(strs[i]);
            else {
                map.put(s, count++);
                outputList.add(new ArrayList<>(Arrays.asList(strs[i])));
            }
        }

        return outputList;
    }
}
