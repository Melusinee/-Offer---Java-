class Solution {
    int m,n,k;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.m = m; this.k = k;this.n = n;
        this.visited = new boolean[m][n];

        return dfs(0,0,0,0);
    }

    // sumi为行坐标的位数之和，sumj为列坐标的位数之和
    public int dfs(int i, int j, int sumi,int sumj){
        if(i >= m || j >= n || sumi+sumj >k || visited[i][j] == true) return 0;
        visited[i][j] = true;
        return 1 + 
                dfs(i+1,j,(i+1)%10 != 0? sumi+1:sumi-8,sumj) + 
                dfs(i,j+1,sumi,(j+1)%10 != 0? sumj+1:sumj-8);
    }
}
