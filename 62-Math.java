class Solution {
    public int lastRemaining(int n, int m) {
        if(n == 0) return -1; 
        int ans = 0;
        // 最后一轮剩下1个人，index即我们定义的ans的现在的值0，所以从第二轮开始反推
        for (int i = 2; i <= n; i++) {
            ans = (ans + m) % i;
        }
        return ans;
    }
}
