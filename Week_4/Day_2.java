import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Day_2 {
    
    class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        helper(res,root);
        return res;
    }

    void helper(List<Integer> res,TreeNode root){
        if(root==null){
            return ;
        }

        helper(res,root.left);
        res.add(root.val);
        helper(res,root.right);
    }
}

public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelsize=queue.size();
            List<Integer> currlevel=new ArrayList<>(levelsize);
            for(int i=0;i<levelsize;i++){
                TreeNode currnode=queue.poll();
                currlevel.add(currnode.val);
                if(currnode.left!=null){
                    queue.offer(currnode.left);
                }
                if(currnode.right!=null){
                    queue.offer(currnode.right);
                }
            }
            list.add(currlevel);
        }
        return list;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean reverse = false;
        
        while (!queue.isEmpty()) {
        int levelSize = queue.size();
        List<Integer> currentLevel = new ArrayList<>(levelSize);
        for (int i=0; i < levelSize; i++) {
            if (!reverse) {
            TreeNode currentNode = queue.pollFirst();
            currentLevel.add(currentNode.val);
            if (currentNode.left != null) {
                queue.addLast(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.addLast(currentNode.right);
            }
            } else {
            TreeNode currentNode = queue.pollLast();
            currentLevel.add(currentNode.val);
            if (currentNode.right != null) {
                queue.addFirst(currentNode.right);
            }
            if (currentNode.left != null) {
                queue.addFirst(currentNode.left);
            }
            }
        }
        reverse = !reverse;
        result.add(currentLevel);
        }
        return result;

    }
    
}
