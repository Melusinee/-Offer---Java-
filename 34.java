class Solution {
    LinkedList<List<Integer>> result = new LinkedList<>();
    LinkedList<Integer> cur = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if(root == null) return result;
        DFS(root,sum);
        return result;
    }

    public void DFS(TreeNode node, int sum){
        if(node != null){
            if(sum == node.val && node.left== null && node.right == null){
                    cur.add(node.val);
                    result.add(new LinkedList(cur));
                    cur.removeLast();
                    return;
                
            }else{
                cur.add(node.val);
                DFS(node.left,sum-node.val);
                DFS(node.right,sum-node.val);
                cur.removeLast();
            }
        }
    }
}
