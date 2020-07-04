class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();
        Map<Character,Integer> dic = new HashMap<>();

        int start = -1; int result = 0;
        for(int end = 0;end < s.length();end++){
            if(dic.containsKey(s.charAt(end))){
                // 我们需要取子字符串的原开头和重复字母的位置中更大的那个
                start = Math.max(start,dic.get(s.charAt(end)));
            }
            dic.put(s.charAt(end),end);
            result = Math.max(result,end-start);
        }
        return result;
    }
}
