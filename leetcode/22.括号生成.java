import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Map<Integer,Integer>map = new HashMap<>();
        map.put(1, n);
        map.put(2, n);
        dfs(map, n, new StringBuilder(), res);
        return res;
    }
/**
 * 取右括号时,已经使用的右括号数量要小于等于左括号的  
 */
    void dfs(Map<Integer,Integer> map , int n,StringBuilder sBuilder ,List<String> result ){
        if (sBuilder.length() == n*2){
            result.add(sBuilder.toString());
            return ;
        }
        
        if (map.get(1)>0){
            int count = map.get(1);
            sBuilder.append("(");
            map.put(1, count-1);
            dfs(map, n, sBuilder, result);
            sBuilder.deleteCharAt(sBuilder.length()-1);
            map.put(1, count);

        }
        if(map.get(2)>0){
            int count =map.get(1);
            int count2 =map.get(2);
            if(count2 >count){
                sBuilder.append(")");
                map.put(2, count2-1);
                dfs(map, n, sBuilder, result);
                sBuilder.deleteCharAt(sBuilder.length()-1);
                map.put(2, count2);
 
            }
        }
        // for(int i=1 ;i<=2 ;i++){
            
        //    Integer  integer =  map.get(i);
        //     if(integer>0){
        //         if (i==2 && integer>map.get(1)){
        //             sBuilder.append(")");
        //              map.put(i, integer-1);
        //              dfs(map, n, sBuilder, result);
        //              sBuilder.deleteCharAt(sBuilder.length()-1);
        //              map.put(i, integer);
        //         }else if(i==1){
        //             sBuilder.append("(");
        //             map.put(i, integer-1);
        //             dfs(map, n, sBuilder, result);
        //             map.put(i, integer);
        //         }
        //     }
        // }


    }
}
// @lc code=end

