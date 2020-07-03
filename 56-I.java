class Solution {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        
        // 异或得到两个数的和
        for(int i = 0; i < nums.length;i++){
            sum ^= nums[i];
        }
        
        // 寻找到和里第一个为1的位置
        int first = 1;
        while((sum & first) == 0){
            first = first << 1;
        }

        int[] result = new int[2];
        for(int i = 0; i < nums.length;i++){
            // 根据底意个为1的位置将数字们分成两部分
            if((nums[i] & first) == 0){
                // 每个部分分别异或
                result[0] ^= nums[i];
            }else{
                result[1] ^= nums[i];
            }
        }
        return result;
    }
}
