class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0) return 0;
        int[] dp = new int[prices.length];
        int curMin = prices[0];
        dp[0] = 0;
        for(int i = 1; i < prices.length;i++){
            // 检查需不需要更新当前最小的prices值
            curMin = Math.min(curMin,prices[i]);
            // 如果现在卖出的钱大于前一天最大的获利，则更新，反之今天的最大获利和昨天一样
            dp[i] = Math.max(dp[i-1], prices[i] - curMin);
        }
        return dp[prices.length-1];
    }
}
