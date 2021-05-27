import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    char[][] m = new char[][]{
        {},{},
        {'a','b','c'},{'d','e','f'},
        {'g','h','i'},{'j','k','l'},
        {'m','n','o'},{'p','q','r','s'},
        {'t','u','v'},{'w','x','y','z'}
    };
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        dfs(digits,result,new StringBuilder(),0);
        return result ;
    
    }
    /**
     *  扫描digits，index作为扫描的字符串长度  第一次取第一个数字  第二次取第二个数字
     *  每取一个数字 for循环遍历这个数字对应的字母 进行深度搜索 同时 index加1 代表树层次加深了一层
     * @param digits 入参 
     * @param result 结果集
     * @param stringBuilder  分支
     * @param index 扫描
     * 
     * 坑 1.  char类型 - '0' 转为int  这样才能在数组中取值
     *    2.  结束条件的判断要放在边界情况的下面   不然传一个空字符串的时候,直接往结果集中添加了一个空的string  
     */
    void dfs(String digits ,List<String> result ,StringBuilder stringBuilder ,int index){
    
        // 注意边界条件   
        if (digits.length() == 0 ){
            return ;
        }
        
         // 结束条件 分支大小
         if (digits.length() == index ){
            result.add(stringBuilder.toString());
            return  ;
        }
        // 每次取当前层级的一个字母加入到分支中
        // char - '0'  -> int
        for(char c : m[digits.charAt(index) - '0']){
            stringBuilder.append(c);
            //深搜
            dfs(digits, result, stringBuilder, index+1);
            // 回溯 即返回树的上一层级 删除最后一个元素
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }
}
// @lc code=end

