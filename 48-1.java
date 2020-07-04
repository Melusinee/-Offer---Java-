class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();
        Map<Character,Integer> dic = new HashMap<>();

        int cur = 0; int result = 0;
        for(int end = 0; end < s.length();end++){
            // 如果出现过，则start为上一次出现的数组下标，没有则为1，说明我们可以从头计算
            int start = dic.getOrDefault(s.charAt(end),-1);
            dic.put(s.charAt(end),end);
            
            // 如果现在这个字母下标减去最长子序列长度，还是大于上一次出现的字母下标，
            // 说明上一次的重复并不在我们现在计算的这个子字符串里，现在的子字符串可以
            // 加上现在的这个字母，即长度+1
            if(end-cur > start){
                cur = cur+1;
            // 如果上一次的重复出现在我们现在的子字符串里，那我们最长无重复的子字符串
            // 长度只能为这两个重复字母之间的距离
            }else{
                cur = end-start;
            }
            result = Math.max(cur,result);
        }
        return result;
    }
}
