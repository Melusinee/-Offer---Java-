class Solution {
    List<String> result = new ArrayList<String>();
    char[] candidates;

    public String[] permutation(String s) {
        candidates = s.toCharArray();
        dfs(0);
        return result.toArray(new String[result.size()]);        
    }

    public void dfs(int index){
        // 当到最后一层只剩一个时，把candidates化成string给加入result
        if(index == candidates.length-1){
            result.add(String.valueOf(candidates));
        }
        
        // 记录一下出现过的char，防止重复使用
        HashSet<Character> set = new HashSet<Character>();
        for(int i = index; i < candidates.length;i++){
            if(set.contains(candidates[i])) continue;
            // 把每个index后面的数，都换到index的位置来形成新的组合
            swap(index,i);
            dfs(index+1);
            // 向下回溯后再换回来
            swap(index,i);
        }
    }

    public void swap(int a,int b){
        char temp = candidates[a];
        candidates[a] = candidates[b];
        candidates[b] = temp;
    }
}
