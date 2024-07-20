/*
  Problem: Is Anagram
  Link: https://neetcode.io/problems/is-anagram

  Problem Statement:
  Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.
  
  An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.
  
  Example 1:
  
  Input: s = "racecar", t = "carrace"
  
  Output: true
  Example 2:
  
  Input: s = "jar", t = "jam"
  
  Output: false
  Constraints:
  
  s and t consist of lowercase English letters.
*/
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Integer> m = new HashMap<>(s.length());
        for(int i=0; i< s.length(); i++) {
            Integer x = m.get(s.charAt(i));
            if(x == null) m.put(s.charAt(i), 1);
            else m.put(s.charAt(i), ++x);
        }
        // System.out.println(m);
        for(int i=0; i<t.length(); i++) {
            Integer x = m.get(t.charAt(i));
            if(x == null)   return false;
            else {
                x--;
                if(x<0) return false;
                else m.put(t.charAt(i), x);
            }
        }
        return true;

    }
}
