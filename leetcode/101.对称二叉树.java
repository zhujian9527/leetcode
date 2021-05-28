/*
 * @lc app=leetcode.cn id=101 lang=java
 *
 * [101] 对称二叉树
 */

// @lc code=start
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
    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null){
           return true ;

        }
        if (root.left == null || root.right == null){
            return false ;
        }

        if(root.left.val == root.right.val && isSymmetric(root.left) && isSymmetric(root.right)){
            return true;
        }
        else{
            return false;
        }

    }
}
// @lc code=end

