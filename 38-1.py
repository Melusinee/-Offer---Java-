class Solution(object):
    def permutation(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        result = []
        self.recur(s,"",result)
        return result

    def recur(self,s,cur,result):
        if not s:
            if cur not in result:
                result.append(cur)
                return 
        
        for i in range(len(s)):
            self.recur(s[:i]+s[i+1:],cur+s[i],result)
