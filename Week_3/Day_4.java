import java.util.Stack;

public class Day_4 {
    
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[temperatures.length];
        for(int i=temperatures.length-1;i>=0;i--){
            while(!st.isEmpty() && temperatures[i]>=temperatures[st.peek()]){
                st.pop();
            }

           if(!st.isEmpty()){
            ans[i]=st.peek()-i;
           }

           st.push(i);
        }
        return ans;
    }



    public int EvaluateReversePolishNotation(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } 
            else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } 
            else if (token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } 
            else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } 
            else {
                
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }



    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack=new Stack<>();
        int max=0;
        stack.push(0);

        for(int i=1;i<heights.length;i++){
            while(!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                max=getmax(heights,stack,max,i);
            }
            stack.push(i);
        }
        int i=heights.length;
        while(!stack.isEmpty()){
            max=getmax(heights,stack,max,i);

        }
        return max;
    }

    public static int getmax(int [] arr ,Stack<Integer> stack,int max,int i){
        int area;
        int popped=stack.pop();
        if(stack.isEmpty()){
            area=arr[popped]*i;
        }
        else{
            area=arr[popped]*(i-1-stack.peek());

        }
        return Math.max(max,area);
    }
}
