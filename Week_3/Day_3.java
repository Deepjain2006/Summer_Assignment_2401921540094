import java.util.Stack;

public class Day_3 {
    
    public boolean isValidParentheses(String s) {
        Stack<Character> stack=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch=='(' || ch=='[' || ch=='{'){
                stack.push(ch);
            }
            else{
                if(ch==')'){
                    if(stack.isEmpty() || stack.pop()!='('){
                        return false;
                    }
                }

                if(ch==']'){
                    if(stack.isEmpty() || stack.pop()!='['){
                        return false;
                    }
                }

                if(ch=='}'){
                    if(stack.isEmpty() || stack.pop()!='{'){
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

        class MinStack {
            Stack<Integer> st;
            Stack<Integer> minst;

        public MinStack() {
            st=new Stack<>();
            minst=new Stack<>();

        }
        
        public void push(int value) {

            st.push(value);
            if(minst.isEmpty() || value<=minst.peek()){
                minst.push(value);
            }
        }
        
        public void pop() {
            int x=st.pop();

            if(x==minst.peek()){
                minst.pop();
            }
        }
        
        public int top() {
            return st.peek();
        }
        
        public int getMin() {
            return minst.peek();
        }
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = -1;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums2[k] > nums1[i]) {
                            ans[i] = nums2[k];
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return ans;
    }
}
