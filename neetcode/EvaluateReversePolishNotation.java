/*
  Problem: Evaluate Reverse Polish Notation
  Link: https://neetcode.io/problems/evaluate-reverse-polish-notation, https://leetcode.com/problems/evaluate-reverse-polish-notation

  Problem Statement:
  You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

  Evaluate the expression. Return an integer that represents the value of the expression.
  
  Note that:
  
  The valid operators are '+', '-', '*', and '/'.
  Each operand may be an integer or another expression.
  The division between two integers always truncates toward zero.
  There will not be any division by zero.
  The input represents a valid arithmetic expression in a reverse polish notation.
  The answer and all the intermediate calculations can be represented in a 32-bit integer.
   
  
  Example 1:
  
  Input: tokens = ["2","1","+","3","*"]
  Output: 9
  Explanation: ((2 + 1) * 3) = 9
  Example 2:
  
  Input: tokens = ["4","13","5","/","+"]
  Output: 6
  Explanation: (4 + (13 / 5)) = 6
  Example 3:
  
  Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
  Output: 22
  Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
  = ((10 * (6 / (12 * -11))) + 17) + 5
  = ((10 * (6 / -132)) + 17) + 5
  = ((10 * 0) + 17) + 5
  = (0 + 17) + 5
  = 17 + 5
  = 22
   
  
  Constraints:
  
  1 <= tokens.length <= 104
  tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
    
*/
class Solution {

    public int evalRPN(String[] tokens) {
        // faster way
        Stack<Integer> stack = new Stack<>();
        for(String token: tokens) {
            switch(token) {
                    case "+" -> {
                        int op2 = stack.pop(), op1 = stack.pop();
                        stack.push(op1 + op2);
                    }
                    case "-" -> {
                        int op2 = stack.pop(), op1 = stack.pop();
                        stack.push(op1 - op2);
                    }
                    case "*" -> {
                        int op2 = stack.pop(), op1 = stack.pop();
                        stack.push(op1 * op2);
                    }
                    case "/" -> {
                        int op2 = stack.pop(), op1 = stack.pop();
                        stack.push(op1 / op2);
                    }
                    default -> stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
    public int evalRPN1(String[] tokens) {
        
        Stack<Integer> stack = new Stack<>();

        for(String token: tokens) {
            if(Character.isDigit(token.charAt(token.length()-1))) { // for -ve numbers 1st char will be -
                // implies number
                stack.push(Integer.parseInt(token));
            } else {
                int op2 = stack.pop(), op1 = stack.pop();
                switch(token) {
                    case "+" -> stack.push(op1 + op2);
                    case "-" -> stack.push(op1 - op2);
                    case "*" -> stack.push(op1 * op2);
                    case "/" -> stack.push(op1 / op2);
                }
            }
        }

        return stack.pop();
    }
}
