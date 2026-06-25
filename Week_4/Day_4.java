import javax.swing.tree.TreeNode;

public class Day_4 {
    
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;
        }
        if(root.val==targetSum && root.left==null && root.right==null){
            return true;
        }
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);
    }

    class Solution {
        int diameter=0;
        public int diameterOfBinaryTree(TreeNode root) {
            height(root);
            return diameter-1;
        }
        int height(TreeNode node){
            if(node==null){
                return 0;
            }
            int leftheight=height(node.left);
            int rightheight=height(node.right);
            int dia=leftheight+rightheight+1;
            diameter=Math.max(diameter,dia);

            return Math.max(leftheight,rightheight)+1;
        }
    }


    class Solution {
        int ans=Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            helper(root);
            return ans;
        }

        public int helper(TreeNode node){
            if(node==null){
                return 0;
            }

            int left=helper(node.left);
            int right=helper(node.right);

            left=Math.max(0,left);
            right=Math.max(0,right);

            int pathsum=left+right+node.val;
            ans=Math.max(ans,pathsum);
            return Math.max(left,right)+node.val;

        }
    }
}
