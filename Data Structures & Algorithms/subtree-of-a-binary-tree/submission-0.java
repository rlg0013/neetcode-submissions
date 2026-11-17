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
    private boolean isSame = true;
    private boolean found = false;
    public boolean isSubtree(TreeNode root, TreeNode subRoot){
        if (subRoot == null) return true;
        if (root == null) return false;

        isSame = true;
        isSameTree(root, subRoot);
        if (isSame){
            found = true;
        }

        isSubtree(root.left, subRoot);
        isSubtree(root.right, subRoot);

        return found;
    }

    private void isSameTree(TreeNode root, TreeNode subRoot){
        if (root == null && subRoot == null){
            return;
        }

        if (root == null || subRoot == null || root.val != subRoot.val) {
            isSame = false;
            return;
        }

        isSameTree(root.left, subRoot.left);
        isSameTree(root.right, subRoot.right);
    }
}
