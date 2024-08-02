/*
  Problem: Valid Parentheses
  Link: https://neetcode.io/problems/validate-parentheses, https://leetcode.com/problems/valid-parentheses

  Problem Statement:  
  You are given a string s consisting of the following characters: '(', ')', '{', '}', '[' and ']'.
  
  The input string s is valid if and only if:
  
  Every open bracket is closed by the same type of close bracket.
  Open brackets are closed in the correct order.
  Every close bracket has a corresponding open bracket of the same type.
  Return true if s is a valid string, and false otherwise.
  
  Example 1:
  
  Input: s = "[]"
  
  Output: true
  Example 2:
  
  Input: s = "([{}])"
  
  Output: true
  Example 3:
  
  Input: s = "[(])"
  
  Output: false
  Explanation: The brackets are not closed in the correct order.
  
  Constraints:
  
  1 <= s.length <= 1000


*/
class Solution {

    Map<Character, Character> map = Map.of(')', '(', ']', '[', '}', '{');
    private boolean stackUsingListImpl(String s) {
        List<Character> stack = new ArrayList<>();
        int i=0;
        for(;i<s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case '(', '[', '{' -> {
                    // System.out.println(c);
                    stack.add(c);
                }
                case ')', ']', '}' -> {
                    // System.out.println(c + " " + map.get(c) + " " + stack.get(stack.size()-1) + " " + (map.get(c)==stack.get(stack.size()-1)));
                    if(stack.size() > 0 && map.get(c)==stack.get(stack.size()-1)) stack.remove(stack.size()-1);
                    else return false;
                }
            }
        }
        // System.out.println(i + " " + stack);
        if(i==s.length() && stack.size()==0) return true;
        return false;

    }

    private boolean stackUsingStackImpl(String s) {
        Stack<Character> stack = new Stack<>();
        int i=0;
        for(;i<s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case '(', '[', '{' -> {
                    // System.out.println(c);
                    stack.push(c);
                }
                case ')', ']', '}' -> {
                    // System.out.println(c + " " + map.get(c) + " " + stack.get(stack.size()-1) + " " + (map.get(c)==stack.get(stack.size()-1)));
                    if(stack.size() > 0 && map.get(c)==stack.peek()) stack.pop();
                    else return false;
                }
            }
        }
        // System.out.println(i + " " + stack);
        if(i==s.length() && stack.size()==0) return true;
        return false;

    }

    private boolean stackUsingArrayDequeImpl(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int i=0;
        for(;i<s.length(); i++) {
            char c = s.charAt(i);
            switch(c) {
                case '(', '[', '{' -> {
                    // System.out.println(c);
                    stack.push(c);
                }
                case ')', ']', '}' -> {
                    // System.out.println(c + " " + map.get(c) + " " + stack.get(stack.size()-1) + " " + (map.get(c)==stack.get(stack.size()-1)));
                    if(stack.size() > 0 && map.get(c)==stack.peek()) stack.pop();
                    else return false;
                }
            }
        }
        // System.out.println(i + " " + stack);
        if(i==s.length() && stack.size()==0) return true;
        return false;

    }

    public boolean isValid(String s) {
        
        // push chars to stack and pop if incoming char matches with topmost char in stack
        // return stackUsingListImpl(s);
        // return stackUsingStackImpl(s);
        return stackUsingArrayDequeImpl(s);
    }
}
