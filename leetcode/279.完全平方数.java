import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/*
 * @lc app=leetcode.cn id=279 lang=java
 *
 * [279] 完全平方数
 */

// @lc code=start
class Solution {
    public int numSquares(int n) {
        // List<Integer> list = new ArrayList<>();
        // dfs(list, n, n, 0);
        // Collections.sort(list);
        // return list.get(0);

        int[] pd  = new int[n+1];
        for(int i=1 ;i*i<=n ;i++){
            pd[i*i] =1 ;
        }

        return dp(n, pd);
    }
    //dfs会超时 原因在于树深度太大，因为存在1-1-1-1-1-1..
    void dfs(List<Integer> list , int n ,int sum,int count){
        if (n == 0){
            list.add(0);
            return ;
        }
        if(sum>n){
            return ;
        }else if (sum == n){
           list.add(count);
           return ;
        }
        for(int i=1 ;i*i<= n ;i++){
            sum =sum+i*i ;
            count=count+1;
            dfs(list, n, sum, count);
            sum=sum-i*i;
            count=count-1;

        }

    }

    //dp 思路  f(n)的最小值= min(f(a)+f(n-a)) (a<m 且 a是完全平方数)
   
    int dp(int n , int[] pd){
        // 对每一个数字求最小完全平方数构成的值
        for(int i=1 ;i<=n;i++){
             int min =Integer.MAX_VALUE;
             //  求dp[i] 
             for(int j=1 ; j*j<=i ;j++){
                min = Math.min(pd[j * j] + pd[i - j * j], min);
             } 
             pd[i]=min;
        }
        return pd[n];
    }
}
// @lc code=end

