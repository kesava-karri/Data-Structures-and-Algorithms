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

    class BTLevelOrderTraversal {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            if (root == null) return ans;

            q.add(root);
            while(!q.isEmpty()) {
                int size = q.size();
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    root = q.poll();

                    if (root != null) temp.add(root.val);
                    if (root.left != null) q.add(root.left);
                    if (root.right != null) q.add(root.right);
                }
                ans.add(temp);
            }
            return ans;
        }
    }

    class BTZigZagLevelOrderTraversal {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();
            int height = 1;
            if (root == null) return ans;

            q.add(root);
            while(!q.isEmpty()) {
                int size = q.size();
                List<Integer> temp = new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    root = q.poll();

                    if (root != null) temp.add(root.val);
                    if (root.left != null) q.add(root.left);
                    if (root.right != null) q.add(root.right);
                }
                if (height % 2 == 0) { // reverse the order for even height
                    int j = temp.size() - 1;
                    for (int i = 0; i < temp.size() / 2; i++) {
                        swap(temp, i, j - i);
                    }
                }
                ans.add(temp);
                height++;
            }
            return ans;
        }
        private void swap(List<Integer> arr, int idx1, int idx2) {
            int temp = arr.get(idx1);
            arr.set(idx1, arr.get(idx2));
            arr.set(idx2, temp);
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

    class AvgOfLevelsInBT {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> ans = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList();
            q.add(root);
            while(!q.isEmpty()) {
                int size = q.size(), counter = 0;
                double sum = 0;
                for (int i = 0; i < size; i++) {
                    root = q.poll();
                    sum += root.val;
                    counter++;
                    if (root.left != null) q.add(root.left);
                    if (root.right != null) q.add(root.right);
                }
                ans.add(sum / counter);
            }
            return ans;
        }
    }

    class DiameterOfBT {
        int ans = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            // the diameter could be finding the deepest node on both left & right branches and summing the depth of them.
            // find max depth on left and right
            // return the sum
            f(root);
            return ans;
        }

        private int f(TreeNode root) {
            if (root == null) return 0;
            int leftDepth = f(root.left);
            int rightDepth = f(root.right);
            ans = Math.max(ans, leftDepth + rightDepth);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    class PathSum {
        public boolean hasPathSum(TreeNode root, int targetSum) {
            if (root == null) return false;
            return f(root, targetSum, 0);

        }
        public boolean f(TreeNode root, int target, int sum) {
            if (root == null) return false;
            sum += root.val;
            // check if leaf node & path needed
            if (root.left == null && root.right == null && sum == target) {
                return true;
            }
            boolean left = f(root.left, target, sum);
            if (left) return left;
            boolean right = f(root.right, target, sum);
            if (right) return right;
            // at some point subtract the excess sum if any
            if (sum > target) sum -= root.val;
            return false;
        }
    }

    class PathSumII {
        List<List<Integer>> ans = new ArrayList<>();
        public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            f(root, targetSum, new ArrayList());
            return ans;
        }

        private void f(TreeNode root, int remainingSum, List<Integer> arr) {
            if (root == null) return;
            arr.add(root.val);

            if (remainingSum - root.val == 0 && root.left == null && root.right == null) {
                ans.add(new ArrayList(arr));
            }

            f(root.left, remainingSum - root.val, arr);
            f(root.right, remainingSum - root.val, arr);
            arr.remove(arr.size() - 1);
        }
    }

    class PathSumIII {
        int ans;
        public int pathSum(TreeNode root, int targetSum) {
            if (root == null) return ans;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            // Since the path can start from any node, combining a BFS w DFS
            while (!q.isEmpty()) {
                root = q.poll();
                f(root, targetSum);
                if (root.left != null) q.add(root.left);
                if (root.right != null) q.add(root.right);
            }
            return ans;
        }

        private void f(TreeNode root, long remainingSum) {
            if (root == null) return;
            if (remainingSum - root.val == 0) { // indicates the sum upto current node is equal to target
                ans++;
            }

            f(root.left, remainingSum - root.val);
            f(root.right, remainingSum - root.val);
        }
    }
}
