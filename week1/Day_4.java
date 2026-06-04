package week1;

import java.util.ArrayList;
import java.util.List;

public class Day_4 {
    
    public int diagonalSum(int[][] mat) {
        int l=mat.length;
        int sum=0;
        for(int i=0;i<l;i++){
            sum+=mat[i][i];
            sum+=mat[l-i-1][i];
        }
        if(l%2!=0){
            sum-=mat[l/2][l/2];
        }

        return sum;
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length * mat[0].length != r * c){
            return mat;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                list.add(mat[i][j]);
            }
        }

        int[][] ans = new int[r][c];
        int x = 0;

        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                ans[i][j] = list.get(x);
                x++;
            }
        }
        return ans;
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<>();
        int top=0, bottom=matrix.length-1;
        int left=0,right=matrix[0].length-1;

        while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                list.add(matrix[top][i]);
            }
            top++;
            for(int j=top;j<=bottom;j++){
                list.add(matrix[j][right]);
            }
            right--;
            if(top<=bottom){
                for(int k=right;k>=left;k--){
                    list.add(matrix[bottom][k]);
                }
                bottom--;
            }
            if(left<=right){
                for(int l=bottom;l>=top;l--){
                    list.add(matrix[l][left]);
                }
                left++;
            }
        }
        return list;
    }
}
