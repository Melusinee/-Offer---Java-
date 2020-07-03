class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int result = 0;
        
        // 队列时用LinkedList实现的
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0,0});

        while(q.size() > 0){
            int[] temp = q.poll();
            int i = temp[0];int j = temp[1];int sumi = temp[2];int sumj = temp[3];
            if(i >= m || j >= n || sumi + sumj > k || visited[i][j] == true) continue;
            visited[i][j] = true;
            result ++;
            q.add(new int[]{i+1,j,(i+1)%10 !=0 ? sumi+1:sumi-8,sumj});
            q.add(new int[]{i,j+1,sumi,(j+1)%10 !=0 ? sumj+1:sumj-8});
        }
        return result;
    }
}
