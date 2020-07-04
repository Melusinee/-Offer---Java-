class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0) return new int[0];
        if(arr.length <= k) return arr;

        partitionArray(arr,0,arr.length-1,k);

        int[] result = new int[k];
        // 只需要返回前k个数
        for(int i = 0; i < k; i++){
            result[i] = arr[i];
        }
        return result;
    }

    public void partitionArray(int[] arr, int left, int right, int k){
        // 获取我们选择的基准在这次排序后在数组中的位置
        int curPtr = partition(arr,left,right);
        // 如果基准的位置正好为k，停止操作，可以返回了
        if(curPtr == k){
            return;
        // 如果基准的位置大于k，我们重排基准前的数字
        }else if(curPtr > k ){
            partitionArray(arr,left,curPtr-1,k);
        // 如果基准的位置小于k，我们重排基准后的数字
        }else{
            partitionArray(arr,curPtr+1,right,k);
        }
    }

    // 快排的固定写法
    public int partition(int[] arr, int left, int right){
        int l = left;
        int r = right + 1;
        int random = arr[left];
        while(true){
            while(arr[++l] < random){
                if(l == right){
                    break;
                }
            }

            while(arr[--r] > random){
                if(r == left){
                    break;
                }
            }
            
            if(l >= r) break;
            swap(arr,l,r);
        }
        swap(arr,left,r);
        return r;
    }

    public void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
