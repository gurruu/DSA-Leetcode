class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        
        return solve(s1,s2,s1.length()-1,s2.length()-1);
        
    }
    
    Integer t[][]=new Integer[1005][1005];
    
    int solve(String s1,String s2,int n,int m)
    {
        if(n<0 && m<0)
        {
            return 0;
        }
        if(n<0 && m>=0)
        {
            int sum=0;
            while(m>=0)
            {
                sum+=s2.charAt(m);
                m--;
            }
            return sum;
        }
         if(n>=0 && m<0)
        {
            int sum=0;
            while(n>=0)
            {
                sum+=s1.charAt(n);
                n--;
            }
            return sum;
        }
        
        if(t[n][m]!=null)
        {
            return t[n][m];
        }
        
        if(s1.charAt(n)==s2.charAt(m))
        {
            t[n][m]= solve(s1,s2,n-1,m-1);
            return t[n][m];
        }
        
        t[n][m]= Math.min(s1.charAt(n)+solve(s1,s2,n-1,m),s2.charAt(m)+solve(s1,s2,n,m-1));
        return t[n][m];
        
    }
    
}