package src;

import java.util.ArrayList;
import java.util.List;

import util.MyUtilityClass.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class BinaryTreeAndBinarySearchTree {
    class BTPostorderTraversal {
        List<Integer> ans = new ArrayList<>();
        public List<Integer> postorderTraversal(TreeNode root) {
            // Postorder traversal -> L R Root
            f(root);
            return ans;
        }
        public void f(TreeNode root) {
            if (root == null) return;
            f(root.left);
            f(root.right);
            ans.add(root.val);
        }
    }

    class BTInorderTraversal {
        List<Integer> ans = new ArrayList<>();
        public List<Integer> inorderTraversal(TreeNode root) {
            // Inorder traversal -> L Root R
            f(root);
            return ans;
        }

        public void f(TreeNode root) {
            if (root == null) return;
            f(root.left);
            ans.add(root.val);
            f(root.right);
        }
    }

    class MinDepthOfBT {
        public int minDepth(TreeNode root) {
            if (root == null) return 0;
            return f(root);
        }

        private int f(TreeNode root) {
            // For this problem preorder traversal is optimal approach
            if (root.left == null && root.right == null) return 1;
            int leftDepth = Integer.MAX_VALUE, rightDepth = Integer.MAX_VALUE;
            if (root.left != null) {
                leftDepth = f(root.left);
            }
            if (root.right != null) {
                rightDepth = f(root.right);
            }
            return Math.min(leftDepth, rightDepth) + 1;
        }
    }


}
