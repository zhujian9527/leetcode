import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(res, candidates, target, new ArrayList<>());
        return res ;
    }
    
    void dfs(List<List<Integer>> res , int[] candidates ,int target , List<Integer> temper  ){
       /**  终止条件 取得的几个数和大于等于targe
        大于表示这一条分支不能满足条件
        等于表示这一条分支满足条件，将这条分支加入到结果中
        这里有两个坑  
        1: list.add() 不能传入原始的temper，引用传递，temper会在其他分支搜索
        的过程中改变，导致存入结果中的值最后全为空数组，通过new ArrayList(temper) 将原来的分支传入进去
        进行深拷贝得到的结果存到结果集中
        2. 分支 2-2-3 和 分支 2-3-2其实是同一个解，这里要排序
        **/
        if (sum(temper) == target){
            List<Integer> list =new ArrayList<>(temper);
            Collections.sort(list);
            if(!res.contains(list)){
                res.add(list);
            }
            return ;
        }
        if (sum(temper) > target){
            return ;
        }

        for(int i : candidates){
            temper.add(i);
            dfs(res,candidates,target,temper);
            temper.remove(temper.size()-1);
        }


    }

    int sum(List<Integer> list){
        int result = 0;
        for(Integer i : list){
            result += i ;
        }
        return result ;
    }
}
// @lc code=end

