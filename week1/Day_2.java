package week1;

import java.util.HashSet;

public class Day_2 {
    public int maxSubArray(int[] nums) {
        int sum = Integer.MIN_VALUE;
        int x=0;
        for(int i=0;i<nums.length;i++){
            x=x+nums[i];
            if(x>sum){
                sum=x;
            }
            if(x<0){
                x=0;
            }
        }
        return sum;
    }


     public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false; 
    }

    public double findMaxAverage(int[] nums, int k) {
       int max=0;
       int currsum=0;

       for(int i=0;i<k;i++){
        currsum+=nums[i];
       }
       max=currsum;

       for(int i=k;i<nums.length;i++){
        currsum+=nums[i]-nums[i-k];
        if(currsum>max){
            max=currsum;
        }
       }
       return (double)max/k;
    }
}
