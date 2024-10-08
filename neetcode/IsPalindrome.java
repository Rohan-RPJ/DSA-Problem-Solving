/*
  Problem: Is Palindrome
  Link: https://neetcode.io/problems/is-palindrome, https://leetcode.com/problems/valid-palindrome
  
  Problem Statement: 
  Given a string s, return true if it is a palindrome, otherwise return false.
  
  A palindrome is a string that reads the same forward and backward. It is also case-insensitive and ignores all non-alphanumeric characters.
  
  Example 1:
  
  Input: s = "Was it a car or a cat I saw?"
  
  Output: true
  Explanation: After considering only alphanumerical characters we have "wasitacaroracatisaw", which is a palindrome.
  
  Example 2:
  
  Input: s = "tab a cat"
  
  Output: false
  Explanation: "tabacat" is not a palindrome.
  
  Constraints:
  
  1 <= s.length <= 1000
  s is made up of only printable ASCII characters.

*/
class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replace(" ", "");
        // System.out.println(s);
        for(int i=0, j=s.length()-1; i<j;) {
            char ci = s.charAt(i);
            if(!(Character.isAlphabetic(ci) || Character.isDigit(ci))) { // check if character is alphabet
                i++; 
                continue;
            }
            char cj = s.charAt(j);
            if(!(cj >= 'a' && cj <= 'z' || Character.isDigit(cj))) { // other way to check if character is alphabet
                j--; 
                continue;
            }
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
