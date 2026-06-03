package week1;

import java.util.Arrays;

public class Day_3 {
    
    public void moveZeroes(int[] nums) {
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public int[] sortedSquares(int[] nums) {
        int a=nums.length;
        int [] arr=new int[a];
        for(int i=0;i<a;i++){
            arr[i]=nums[i]*nums[i];
        }
        Arrays.sort(arr);
        return arr;
    }

    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxArea=0, currArea=0;
        while(left<right){
            currArea=(int)(Math.min(height[left],height[right])*(right-left));
            maxArea=Math.max(currArea,maxArea);
            if(height[left]<=height[right]){
                left++;
            }
            else if(height[left]>height[right]){
                right--;
            }
        }
        return maxArea;
    }
}
