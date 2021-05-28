import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=113 lang=java
 *
 * [113] 路径总和 II
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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
            List<List<Integer>> list = new ArrayList<>();
            dfs(list, targetSum, new ArrayList<>(), root);
            return list ;
    }

    void dfs(List<List<Integer>> list , int targetSum , List<Integer> chain,TreeNode node){
        
        if (node == null || targetSum < 0){
            return ;
        }
        if(node.left == null && node.right == null){
            if (targetSum == 0){
                list.add(new ArrayList<>(chain));
            
            }
            return ;
        }
        


        chain.add(node.val);
        dfs(list, targetSum-node.val, chain, node.left);
        chain.remove(chain.size()-1);

        chain.add(node.val);
        dfs(list, targetSum-node.val, chain, node.right);
        chain.remove(chain.size()-1);

    }
}
// @lc code=end

