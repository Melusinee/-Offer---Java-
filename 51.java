public class Solution {

    public int reversePairs(int[] nums) {
        int len = nums.length;

        if(len < 2) return 0;

        int[] copy = new int[len];
        for(int i = 0; i < len; i++){
            copy[i] = nums[i];
        }
            
        int[] temp = new int[len];
        return reverse(copy,0,len-1,temp);
    }

    public int reverse(int[] nums, int left, int right, int[] temp){
        if(left == right) return 0;
        int mid = left + (right-left)/2;
        
        // 向下recur左半边
        int leftPairs = reverse(nums,left,mid,temp);
        // 向下recur右半边
        int rightPairs = reverse(nums,mid+1,right,temp);

        // 如果已经有序，则不存在会出现在左边和右边的逆序对，直接计算返回
        if(nums[mid] <= nums[mid+1]) return leftPairs + rightPairs;
        
        // 计算合并时左右两个数组内互存的逆序对
        int crossPairs = mergeAndCount(nums,left,mid,right,temp);
        return leftPairs + rightPairs + crossPairs;
    }

    public int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp){
        for(int i = left; i <= right;i++){
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid+1;
        int count = 0;

        for(int k = left;k <= right;k++){
            // 如果左边的指针已经超出，则只计算右边的数组
            if(i == mid+1){
                nums[k] = temp[j];
                j++;
            // 如果右边的指针已经超出，则只计算左边的数组
            }else if(j == right+1){
                nums[k] = temp[i];
                i++;
            // 现在的指针指向的两个数字没有形成逆序对，左边的指针进行挪动
            }else if(temp[i] <= temp[j]){
                nums[k] = temp[i];
                i++;
            // 现在的指针指向的两个数字形成逆序对，右边的指针进行挪动
            }else{
                nums[k] = temp[j];
                j++;
                // 现在所有左边的还没加进去的数字，都能和右边指针现在指向的数字形成逆序对
                count += (mid-i+1);
            }
        }
        return count;
    }
}
