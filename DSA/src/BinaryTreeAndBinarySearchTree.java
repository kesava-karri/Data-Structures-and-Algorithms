package src;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    class CountCompleteTreeNodes {
        int ans;
        public int inorderCountNodes(TreeNode root) {
            inorder(root);
            return ans;
        }
        private void inorder(TreeNode root) {
            // Inorder DFS
            if (root == null) return;
            inorder(root.left);
            ans++;
            inorder(root.right);
        }

        public int preorderCountNodes(TreeNode root) {
            preorder(root);
            return ans;
        }
        private void preorder(TreeNode root) {
            // preorder DFS
            if (root == null) return;
            // System.out.println(root.val);
            ans++;
            preorder(root.left);
            preorder(root.right);
        }

        public int postorderCountNodes(TreeNode root) {
            postorder(root);
            return ans;
        }
        private void postorder(TreeNode root) {
            // postorder DFS
            if (root == null) return;
            postorder(root.left);
            postorder(root.right);
            ans++;
        }

        public int levelOrder(TreeNode root) {
            // Also known as BFS
            // we use iterative approach for BFS as it is more intuitive
            // BFS is implemented using queue
            int ans = 0;
            if (root == null) return ans;

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while (!q.isEmpty()) {
                ans++;
                root = q.poll();
                if (root.left != null) {
                    q.add(root.left);
                }
                if (root.right != null) {
                    q.add(root.right);
                }
            }
            return ans;
        }
    }

    class MaxDepthOfBT {
        public int maxDepth(TreeNode root) {
            return dfs(root);
        }
        private int dfs(TreeNode root) {
            if (root == null) return 0;
            int left = 1 + dfs(root.left);
            int right = 1 + dfs(root.right);
            return Math.max(left, right);
        }

        public int bfs(TreeNode root) {
            // BFS
            int ans = 0;
            if (root == null) return ans;

            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()) {
                ans++;
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    root = q.poll();
                    if (root.left != null) q.add(root.left);
                    if (root.right != null) q.add(root.right);
                }
            }
            return ans;
        }
    }
}
