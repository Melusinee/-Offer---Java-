class Solution {
    public int[][] findContinuousSequence(int target) {
        
        // 最开始的时候默认左边界和右边界均为1起始
        int left = 1;
        int right = 1;
        List<int[]> result = new ArrayList<>();
        // 一直储存着现在这个窗口内所有数字的和
        int sum = 0;

        while(left <= target /2){
            // 当现在的和小于目标时，我们需要把窗口向右边扩大一位
            if(sum < target){
                sum += right;
                right ++;
            // 当现在的和大于目标时，我们需要把窗口最左边一位的移除
            }else if(sum > target){
                sum -= left;
                left ++;
            // 当和等于目标时，我们把窗口的现在的数储存起来，同时把最左边的两个数移除
            }else{
                int[] temp = new int[right-left];
                for(int i = left; i < right; i++){
                    temp[i-left] = i;
                }
                result.add(temp);
                // 为什么要移除最左边的两个数呢，因为我们的目的是把整个窗口滑到最右边，
                // 下一步一定是向最右扩张，而此时我们的值已经等于target了，而最左边的
                // 第一位一定比向右扩张的小，最左边只移除一位的话，还是一定大于target，
                // 只有再移除最左边的第二位才能保证此时sum可能小于target
                sum -= left+left+1;
                left += 2;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
