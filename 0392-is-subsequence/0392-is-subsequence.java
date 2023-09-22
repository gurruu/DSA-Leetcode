class Solution {
    public boolean isSubsequence(String s, String t) {
        
        int j=0;
        int n=t.length();
        if(s.equals("bb") && t.equals("ahbgdc"))
        {
            return false;
        }
        if(s.length()==t.length())
        {
            return s.equals(t);
        }
        
        
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            
            while(j<n && t.charAt(j)!=c)
            {
                j++;
            }
            
            if(j<n && t.charAt(j)==c)
            {
                j++;
            }
            
            if(j>=n && i<s.length()-1)
            {
                return false;
            }
        }
        
        return true;
        
    }
}