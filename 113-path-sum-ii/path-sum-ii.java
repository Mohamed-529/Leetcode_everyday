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
class Solution {

    public List<List<Integer>> pathSum(
        TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, 0, path, result);

        return result;
    }

    void dfs(
        TreeNode node,
        int target,
        int sum,
        List<Integer> path,
        List<List<Integer>> result) {

        if (node == null) {
            return;
        }

        // 1. Add current node
        path.add(node.val);
        sum += node.val;

        // 2. Check whether it is a leaf
        if (node.left == null && node.right == null) {

            if (sum == target) {
                result.add(new ArrayList<>(path));
            }
        }

        // 3. Explore left subtree
        dfs(node.left, target, sum, path, result);

        // 4. Explore right subtree
        dfs(node.right, target, sum, path, result);

        // 5. Backtrack
        path.remove(path.size() - 1);
    }
}