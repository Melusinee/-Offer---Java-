class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0) return new int[0];
        
        // Java里PriorityQueue默认为最小堆，所以我们需要更改comparator让他变成最大堆
        Queue<Integer> queue = new PriorityQueue<>(k,(i1,i2) -> Integer.compare(i2,i1));

        for(int num:arr){
            // 只有当前堆内元素的数量不足k，或当前数比堆内最大值小，才有加入堆的资格
            if(queue.isEmpty() || queue.size() < k || queue.peek() > num){
                queue.add(num);
            }
            // 堆的大小超出时，我们把最大值删除
            if(queue.size() > k){
                queue.poll();
            }
        }

        int[] result = new int[k];
        int ptr = 0;
        for(Integer num:queue){
            result[ptr] = num;
            ptr++;
        }

        return result;
    }
}
