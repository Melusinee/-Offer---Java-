class Solution {
    public int lastRemaining(int n, int m) {
        // 处理 edge case，当圆圈里没有数字时
        if(n == 0) return -1;
        ArrayList<Integer> cycle = new ArrayList<Integer>();
        // 把所有的数字都加进这个动态数组
        for(int i = 0; i < n; i ++){
            cycle.add(i);
        } 

        // 还没remove任何一个数时，我们默认从第一个开始
        int indexToRemove = 0;
        
        // 当数组里只剩下最后一个数时，停止，这里其实条件也可以改成 cycle.size() > 1
        while(n > 1){
            // 因为每次是从上一次剔除数的地方再接着开始数，所以是indexToRemove + m
            // 然后，因为每次剔除后，都少了一个数，所以还要减去1
            indexToRemove = (indexToRemove + m - 1)%n;
            cycle.remove(indexToRemove);
            
            // 如果使用的是 cycle.size() > 1，这步可以省略
            n-- ;    
        }
         
        return cycle.get(0);
    }
