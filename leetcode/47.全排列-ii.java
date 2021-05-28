import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=47 lang=java
 *
 * [47] 全排列 II
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
            /**
             *  先判断给出的nums中 每个元素出现了几次 
             *  在dfs中 每次使用了一个元素，就将对应元素的次数-1
             *  可是使用两个数组   [1,1,2] ->[1,2]元素数组和 [2,1]对应的次数数组
             *  或者一个map代替两个数组
             *  
             */

             Map<Integer,Integer> map = new HashMap<>();
             for(int i=0 ;i<nums.length; i++){
                if(map.containsKey(nums[i])){
                    map.put(nums[i],map.get(nums[i])+1);
                }else{
                    map.put(nums[i], 1);
                }
             }
             List<List<Integer>> res = new ArrayList<>();

             dfs(nums, res, new ArrayList<Integer>(), map,nums.length);
             return res;
            
    }

    void dfs(int[]nums,List<List<Integer>> res ,List<Integer> temper,Map<Integer,Integer> map ,int size){

        if(nums.length == 0){
            return ;
        }
        if(temper.size() == nums.length){
            res.add(new ArrayList<>(temper));
            return ;
        }

        for(Integer c : map.keySet()){
            int count =map.get(c);
            if (count > 0){
                temper.add(c);
                map.put(c, count-1);
                dfs(nums, res, temper, map,size);
                temper.remove(temper.size()-1);
                map.put(c, count);
            }
        }
        
    }
}
// @lc code=end

