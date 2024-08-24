/*
  Problem: Largest Rectangle in Historgram
  Link: https://neetcode.io/problems/largest-rectangle-in-histogram, https://leetcode.com/problems/largest-rectangle-in-histogram/

  Largest Rectangle In Histogram

  You are given an array of integers heights where heights[i] represents the height of a bar. The width of each bar is 1.
  
  Return the area of the largest rectangle that can be formed among the bars.
  
  Note: This chart is known as a histogram.
  
  Example 1:
  
  Input: heights = [7,1,7,2,2,4]
  
  Output: 8
  Example 2:
  
  Input: heights = [1,3,7]
  
  Output: 7
  Constraints:
  
  1 <= heights.length <= 1000.
  0 <= heights[i] <= 1000

*/

class Solution {

    /*
        Approach 1: Initial approach
    */
    int max = 0;
	Stack<Integer> stack = new Stack<>();
    public int largestRectangleArea(int[] h) {
        Stack<Integer> stack = new Stack<>();
        stack.push(h[0]);
        for(int i=1;i<h.length;i++){
            if(h[i]>=h[i-1]){
                stack.push(h[i]);
                continue;
            } else {
                int c = findMaxAndGetCnt(stack, h[i]);
                if(h[i]!=0){
                    while(c>0) {
                        stack.push(h[i]);
                        c--;
                    }
                    stack.push(h[i]);
                }
            }
        } // for loop close
		if(!stack.isEmpty()) findMaxAndGetCnt(stack, 0);

        return max;
    }
    private int findMaxAndGetCnt(Stack<Integer> stack, int hi){
        int c=1, val=stack.pop();
        while(!stack.isEmpty() && hi<stack.peek()){
            int x = stack.pop();
            if(x==val){
                c++;
            } else {
                max = Math.max(max, val*c);
                c++;
                val=x;
            }
        }
        max = Math.max(max, val*c);
        return c;
    }
    
    /*
        Approach 2: Better time complexity then Approach 1 as internal while loop replaced with stack counter 
        To run this approach, remove 1 from below method and change Approach 1 method
    */
	Stack<Integer> prevCntStack = new Stack<>();
	public int largestRectangleArea1(int[] h) {
		stack.push(h[0]);prevCntStack.push(1);
		for (int i = 1; i < h.length; i++) {
			if (h[i] >= h[i - 1]) {
				stack.push(h[i]);
				prevCntStack.push(1);
				continue;
			} else {
				int c = findMaxAndGetCnt1(h[i]);
				if (h[i] != 0) {
					stack.push(h[i]);
					prevCntStack.push(c);
					stack.push(h[i]);
					prevCntStack.push(1);
				}
			}
		} // for loop close
		if (!stack.isEmpty())
			findMaxAndGetCnt1(0);

		return max;
	}
	private int findMaxAndGetCnt1(int hi) {
		int c = prevCntStack.pop(), val = stack.pop();
		while (!stack.isEmpty() && hi < stack.peek()) {
			int x = stack.pop();
			if (x == val) {
				c = c + prevCntStack.pop();
			} else {
				max = Math.max(max, val * c);
				c = c + prevCntStack.pop();
				val = x;
			}
		}
		max = Math.max(max, val * c);
		return c;
	}

}
