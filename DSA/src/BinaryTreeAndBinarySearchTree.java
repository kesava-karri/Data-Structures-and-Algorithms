package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import org.apache.commons.math3.util.Pair;
import util.MyUtilityClass.TreeNode;
import util.MyUtilityClass.Node;

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

    class DistributeCoinsInBinaryTree {
        int ans;
        public int distributeCoins(TreeNode root) {
            f(root);
            return ans;
        }
        private int f(TreeNode root) {
            if (root == null) return 0;
            int left = f(root.left);
            int right = f(root.right);
            ans += Math.abs(left) + Math.abs(right);
            return (root.val - 1) + (left + right);
            // (root.val - 1) is to keep 1 coin w the node & send the rest and
            // in-case of internal nodes we should also accomodate the coins from their left & right child so (left + right)
            // when no coin(s) are present with a node it would return -1 indicating coin would come from parent to child :)
        }
    }

    public class PathSumIV {
        int ans;
        Map<Integer, Integer> mp = new HashMap<>();
        /**
         * @param nums: the list
         * @return: the sum of all paths from the root towards the leaves
         */
        public int pathSumIV(int[] nums) {
            // build the tree structure with a map, with Depth,Position as key & V as value
            for (int num : nums) {
                mp.put(num / 10, num % 10);
            }

            // each element in the array, is represented by three digits named as DPV
            // so for the first i.e., root node DP (Depth & Position) would be 11
            f(11, 0);
            return ans;
        }

        public void f(int root, int sum) {
            if (!mp.containsKey(root)) return;

            sum += mp.get(root);

            int depth = root / 10;
            int position = root % 10;

            int left = 10 * (depth + 1) + (position * 2) - 1;
            int right = left + 1;
            if (!mp.containsKey(left) && !mp.containsKey(right)) { // leaf node
                ans += sum;
                return;
            }
            f(left, sum);
            f(right, sum);
        }
    }

    class SumRootToLeafNumbers {
        int sum;
        public int sumNumbers(TreeNode root) {
            f(root, "");
            return sum;
        }
        // build a string from root to node
        // once leaf node is reached, convert to integer and add to sum
        private void f(TreeNode root, String str) {
            if (root == null) return;

            str += root.val;
            if (root.left == null && root.right == null) {
                sum += Integer.parseInt(str);
            }

            f(root.left, str);
            f(root.right, str);
        }
    }

    class LongestUnivaluePath {
        // track two paths left & right
        int ans;
        public int longestUnivaluePath(TreeNode root) {
            f(root);
            return ans;
        }

        private int f(TreeNode root) {
            if (root == null) return 0;
            int left = f(root.left);
            int right = f(root.right);
            // We need to reset left & right longest paths when they are not equal to the root, resulting in correct path calculation.
            if (root.left != null && root.left.val == root.val) {
                left++;
            } else {
                left = 0;
            }
            if (root.right != null && root.right.val == root.val) {
                right++;
            } else {
                right = 0;
            }
            // Check if the new (left + right) path is greater than earlier path & choose the longer one.
            ans = Math.max(ans, left + right);
            // when same nodes extend to both branches & we only choose the longest path to compare with its parent
            return Math.max(left, right);
        }
    }

    class SubTreeOfAnotherTree {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            f(root, sb1);
            f(subRoot, sb2);
            return sb1.toString().contains(sb2.toString());
        }
        private void f(TreeNode root, StringBuilder sb) {
            if (root == null) {
                sb.append("null");
                return;
            }
            sb.append("*" + root.val);
            f(root.left, sb);
            f(root.right, sb);
        }
    }

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

    class PopulatingNextRightPointersInEachNode {
        public Node connect(Node root) {
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            Node temp = new Node();
            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    temp = q.poll();
                    // for last element in the level, there will be no next node so let's assign null to it
                    // otherwise add the next queue value
                    if (temp != null) {
                        temp.next = i == size - 1 ? null : q.peek();
                        if (temp.left != null) q.add(temp.left);
                        if (temp.right != null) q.add(temp.right);
                    }
                }
            }
            return root;
        }
    }

    class PopulatingNextRightPointersInEachNodeII {

        public Node connect(Node root) { // The regular lvl order traversal kind of appraoch
            Queue<Node> q = new LinkedList<>();
            if (root != null) q.add(root);
            while(!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    Node temp = q.poll();
                    temp.next = q.peek();
                    // set last element of the level order traversal to null
                    if (i == size - 1) temp.next = null;
                    if (temp.left != null) q.add(temp.left);
                    if (temp.right != null) q.add(temp.right);
                }
            }
            return root;
        }
    }

    class MaxWidthOfBT {
        public int widthOfBinaryTree(TreeNode root) {
            // indexing each node during BFS and storing the index & node as a pair
            // start index with 0 for root node
            Pair<Integer, TreeNode> pair = new Pair(0, root);
            Queue<Pair<Integer, TreeNode>> q = new LinkedList<>();
            q.offer(pair);
            int maxWidth = 0;

            while(!q.isEmpty()) {
                int size = q.size();
                // left keeps a note of the start index & idx keeps updating with respect to node
                int left = q.peek().getKey(), idx = left;
                for (int i = 0; i < size; i++) {
                    pair = q.poll();
                    idx = pair.getKey();
                    root = pair.getValue();
                    // when root is zero then left child is one & right is two
                    // which implies left = 2 * idx + 1, right = 2 * idx + 2
                    // we can observe this pattern by numbering the nodes in bfs way
                    if (root.left != null) q.offer(new Pair(2 * idx + 1, root.left));
                    if (root.right != null) q.offer(new Pair(2 * idx + 2, root.right));
                }
                maxWidth = Math.max(maxWidth, idx - left + 1); // inclusive subtraction
            }
            return maxWidth;
        }
    }

    class VerticalOrderTraversalOfBT {
        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> mpp = new TreeMap<>();
        public List<List<Integer>> verticalTraversalDFS(TreeNode root) {
            List<List<Integer>> ans = new ArrayList<>();
            f(root, 0, 0);
            for (Integer col : mpp.keySet()) {
                List<Integer> arr = new ArrayList<>();
                for (Integer row : mpp.get(col).keySet()) {
                    Collections.sort(mpp.get(col).get(row));
                    arr.addAll(mpp.get(col).get(row));
                }
                ans.add(arr);
            }
            return ans;
        }
        private void f(TreeNode root, int row, int col) {
            if (root == null) return;

            ArrayList<Integer> arr = new ArrayList<>();
            TreeMap<Integer, ArrayList<Integer>> hMap = new TreeMap<>();
            if (mpp.containsKey(col)) {
                hMap = mpp.get(col);
                if (hMap.containsKey(row)) {
                    arr = hMap.get(row);
                    arr.add(root.val);
                } else {
                    arr.add(root.val);
                    hMap.put(row, arr);
                }
            } else { // col
                arr.add(root.val);
                hMap.put(row, arr);
                mpp.put(col, hMap);
            }

            f(root.left, row + 1, col - 1);
            f(root.right, row + 1, col + 1);
        }

        public List<List<Integer>> verticalTraversalBFS(TreeNode root) {
            // we need to group the nodes based on same columns & rows
            // using a map to store them like {-1 -> {1 : [9]}, 0 -> {0: [3],2: [15]}, ...}
            // Tree map is preferred to maintain order
            TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> mpp = new TreeMap<>();
            // storing row, column values as keys
            Pair<Pair<Integer, Integer>, TreeNode> pair = new Pair<>(new Pair<>(0, 0), root);
            Queue<Pair<Pair<Integer, Integer>, TreeNode>> q = new LinkedList<>();
            q.add(pair);

            while(!q.isEmpty()) {
                int size = q.size();
                int row = q.peek().getKey().getKey();
                int col = q.peek().getKey().getValue();
                root = q.poll().getValue();
                // if an element has added to same column earlier then append to it
                // otherwise create a new array
                TreeMap<Integer, ArrayList<Integer>> hMap = new TreeMap<>();
                ArrayList<Integer> arr = new ArrayList<>();
                if (mpp.containsKey(col)) {
                    hMap = mpp.get(col);
                    if (hMap.containsKey(row)) {
                        arr = hMap.get(row);
                        arr.add(root.val);
                    } else {
                        arr.add(root.val);
                        hMap.put(row, arr);
                    }
                } else { // no col
                    arr.add(root.val);
                    hMap.put(row, arr);
                    mpp.put(col, hMap);
                }

                if (root.left != null) q.add(new Pair(new Pair(row + 1, col - 1), root.left));
                if (root.right != null) q.add(new Pair(new Pair(row + 1, col + 1), root.right));
            }
            // System.out.println(mpp);
            List<List<Integer>> ans = new ArrayList<>();
            mpp.forEach((col, hMap) -> {
                List<Integer> temp = new ArrayList<>();
                hMap.forEach((row, arr) -> {
                    if (arr.size() > 1) {
                        // When on same level & same column, sort them based on the value
                        Collections.sort(arr);
                    }
                    temp.addAll(arr);
                });
                ans.add(temp);
            });
            return ans;
        }

        public List<List<Integer>> brokenApproach(TreeNode root) {
            // The values should be sorted only when both row & column
            // not only when they belong to same col

            // we need to group the nodes based on same columns
            // using a map to store them like {-1 -> [9], 0 -> [3, 15], ...}
            // Tree map is preferred to maintain order
            Map<Integer, List<Integer>> mpp = new TreeMap<>();
            // storing the column values as keys
            Pair<Integer, TreeNode> pair = new Pair(0, root);
            Queue<Pair<Integer, TreeNode>> q = new LinkedList<>();
            q.add(pair);
            while(!q.isEmpty()) {
                int size = q.size();
                int col = q.peek().getKey();
                root = q.poll().getValue();
                // if an element has added to same column earlier then append to it
                // otherwise create a new array
                if (mpp.containsKey(col)) {
                    List<Integer> arr = mpp.get(col);
                    arr.add(root.val);
                    mpp.put(col, arr);
                } else {
                    List<Integer> arr = new ArrayList<>();
                    arr.add(root.val);
                    mpp.put(col, arr);
                }

                if (root.left != null) q.add(new Pair(col - 1, root.left));
                if (root.right != null) q.add(new Pair(col + 1, root.right));
            }

            // When on same level, sort them based on the value
            List<List<Integer>> ans = new ArrayList<>(mpp.values());
            for (List<Integer> arr : ans) {
                Collections.sort(arr);
            }
            return ans;
        }
    }

    class ConstructStringfromBT {
        StringBuilder sb = new StringBuilder();
        public String tree2str(TreeNode root) {
            f(root);
            return sb.toString();
        }

        private void f(TreeNode root) {
            if (root == null) return;
            sb.append(root.val);
            if (root.left == null && root.right == null) return;
            sb.append("(");
            f(root.left);
            sb.append(")");
            // Add the parenthesis to right child if
            // 1. right child is present [the case when both children exist]
            // 2. left is null [the case when only right child exist]
            // Note: parenthesis will not be added if child doesn't exist, why? -> 'cause null wouldn't be appended to our string
            if (root.left == null || root.right != null) {
                sb.append("(");
            }
            f(root.right);
            if (root.left == null || root.right != null) {
                sb.append(")");
            }
        }
    }
}
