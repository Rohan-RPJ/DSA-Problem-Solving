/*
  Problem: Generate Parentheses
  Link: https://neetcode.io/problems/generate-parentheses, https://leetcode.com/problems/generate-parentheses

  Problem Statement:
  Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

  Example 1:
  
  Input: n = 3
  Output: ["((()))","(()())","(())()","()(())","()()()"]
  Example 2:
  
  Input: n = 1
  Output: ["()"]
   
  
  Constraints:
  
  1 <= n <= 8
*/
class Solution {
    
    /*
        Using recursion. Referred solution for below approach. 
        Time complexity better then my approach
    */
    private void dfs(int openParen, int closeParen, String s, int n, List<String> op) {
        if(openParen==closeParen && openParen+closeParen == (n*2)) {
            op.add(s);
            return;
        }

        if(openParen < n) 
            dfs(openParen+1, closeParen, s + "(", n, op);

        if(closeParen < openParen)
            dfs(openParen, closeParen+1, s+")", n, op);
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(0, 0, "", n, res);
        return res;
    }

    /*
        Dynamic Programming Approach:
        For each n, find list of strings using List<String> of n-1
        for each string in n-1, insert "()" at each index in string and store it in set
        for unique strings
        finally convert set to list and return
        Time complexity not good
    */
    public List<String> generateParenthesis1(int n) {
        List<String> list = Arrays.asList("()");
        for(int i=1; i<n; i++) {
            Set<String> set = new HashSet<>();
            for(int k=0; k<list.size(); k++) {
                String s = list.get(k);
                set.add("()" + s);
                for(int j=0; j<s.length()-1;j++) {
                    set.add(s.substring(0,j+1) + "()" + s.substring(j+1,s.length()));
                }
                // set.add(s + "()"); -- not required
            }
            list = new ArrayList<>(set);
            System.out.println((i+1) + " " + list);
        }

        return list;
    }
}
