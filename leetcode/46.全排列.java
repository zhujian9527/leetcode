import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, new ArrayList<>(), nums,new boolean[nums.length]);
        return result ;
    }

    void dfs(List<List<Integer>>result ,List<Integer> res ,int[]nums,boolean[]flag){
        if (nums.length == 0){
            return ;
        }
        if (res.size() == nums.length){
            result.add(new ArrayList<Integer>(res));
            return ;
        }
       
       for(int i=0 ;i<nums.length ;i++){
           if (!flag[i]){
             res.add(nums[i]);
             flag[i]=true;
             dfs(result, res, nums, flag);
             flag[i]=false;
             res.remove(res.size()-1);
        
           }
       }
    }
}
// @lc code=end

