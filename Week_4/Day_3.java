import javax.swing.tree.TreeNode;

public class Day_3 {
    
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null || root.val==val) return root;

        while(root!=null){
            if(root.val==val){
                return root;
            }
            if(root.val>val){
                root=root.left;
            }
            else if(root.val<val){
                root=root.right;
            }

        }
        return root;
    }

    class Solution {
        public boolean isValidBST(TreeNode root) {
            return helper(root,null,null);
        }
        public boolean helper(TreeNode node,Integer low,Integer high){
            if(node==null){
                return true;
            }

            if(low!=null && node.val<=low){
                return false;
            }

            if(high!=null && node.val>=high){
                return false;
            }

            boolean lefttree=helper(node.left,low,node.val);
            boolean righttree=helper(node.right,node.val,high);

            return lefttree && righttree;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || root==p || root==q){
            return root;
        }

        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);

        if(left==null){
            return right;
        }
        else if(right==null){
            return left;
        }
        else{
            return root;
        }
    }
}
