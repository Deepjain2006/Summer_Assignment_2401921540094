import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class Day_5 {
    
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()) {
        TreeNode left = queue.poll();
        TreeNode right = queue.poll();

        if(left == null && right == null) {
            continue;
        }
        
        if(left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        queue.add(left.left);
        queue.add(right.right);
        queue.add(left.right);
        queue.add(right.left);
        
        }
        return true;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        int rootVal = preorder[0];

        int index = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }

        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(
                Arrays.copyOfRange(preorder, 1, index + 1),
                Arrays.copyOfRange(inorder, 0, index)
        );
        root.right = buildTree(
                Arrays.copyOfRange(preorder, index + 1, preorder.length),
                Arrays.copyOfRange(inorder, index + 1, inorder.length)
        );

        return root;
    }

    public class Codec {
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            helper(root, sb);
            return sb.toString();
        }

        private void helper(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append("null,");
                return;
            }

            sb.append(node.val).append(",");
            helper(node.left, sb);
            helper(node.right, sb);
        }
        
        public TreeNode deserialize(String data) {
            List<String> list =
                    new LinkedList<>(Arrays.asList(data.split(",")));

            return buildTree(list);
        }

        private TreeNode buildTree(List<String> list) {
            String val = list.remove(0);

            if (val.equals("null")) {
                return null;
            }

            TreeNode node = new TreeNode(Integer.parseInt(val));
            node.left = buildTree(list);
            node.right = buildTree(list);

            return node;
        }
    }
}
