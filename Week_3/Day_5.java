import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Day_5 {
    
    class MyQueue {
    private Stack<Integer> first;
    private Stack<Integer> sec;
    public MyQueue() {
        first=new Stack<>();
        sec=new Stack<>();
    }
    
    public void push(int x) {
        first.push(x);
    }
    
    public int pop() {
        while(!first.empty()){
            sec.push(first.pop());
        }

        int removed=sec.pop();

        while(!sec.empty()){
            first.push(sec.pop());
        }
        return removed;
    }
    
    public int peek() {
        while(!first.empty()){
            sec.push(first.pop());
        }

        int peeked=sec.peek();

        while(!sec.empty()){
            first.push(sec.pop());
        }
        return peeked;
    }
    
    public boolean empty() {
        return first.isEmpty();
    }
}


    class RecentCounter {
    Queue<Integer> list;
    
    public RecentCounter() {
        list=new LinkedList<>();
        
    }
    public int ping(int t) {
        
        list.add(t);
        
        while(!list.isEmpty() && t -3000 > list.peek()){
            list.poll();
        }
        return list.size();
    }
}


    class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;

        Deque<Integer> d=new ArrayDeque<>();
        int [] result=new int[n-k+1];

        for(int i=0;i<k;i++){
            while(!d.isEmpty() && nums[d.peek()]<=nums[i]){
                d.pollLast();
            }
            d.offerLast(i);
        }

        result[0]=nums[d.peekFirst()];
        for(int i=k;i<n;i++){
            if(d.peekFirst()<=i-k){
                d.pollFirst();
            }

            while(!d.isEmpty() && nums[d.peek()]<=nums[i]){
                d.pollLast();
            }

            d.offerLast(i);

             result[i-k+1]=nums[d.peekFirst()];
        }

        return result;
    }
}
}
