class Solution {
    public List<String> letterCombinations(String digits) {
        
        String arr[]={"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String>res=new ArrayList<>();
        int n=digits.length();
        // System.out.println(n);
        if(n==0) return res;
        String s=arr[digits.charAt(0)-'0'-2];
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            solve(c,arr,1,res,digits);
        }
        return res;
    }
    void solve(char c,String arr[],int ind,List<String>res,String digits)
    {
        
        int n=digits.length();
        StringBuilder sb=new StringBuilder();
        sb.append(c);
        if(n==1)
        {
            res.add(sb.toString());
            return;
        }
        if(ind<=n)
        {
            String s1=arr[digits.charAt(ind)-'0'-2];
        for(int i=0;i<s1.length();i++)
        {
             sb=new StringBuilder();
            sb.append(s1.charAt(i));
            if(ind+1==n)
            {
                String t=sb.toString();
                              String r="";
                              r+=c;
                              r+=t;
                              res.add(r);
                              sb.deleteCharAt(sb.length()-1);
            }
            if(ind+2<=n)
            {
                String s2=arr[digits.charAt(ind+1)-'0'-2];
                for(int j=0;j<s2.length();j++)
                {
                    sb.append(s2.charAt(j));
                    // System.out.println(sb);
                    if(ind+2==n)
                          {
                              String t=sb.toString();
                              String r="";
                              r+=c;
                              r+=t;
                              res.add(r);
                              sb.deleteCharAt(sb.length()-1);
                          }
                          
                    if(ind+3<=n)
                    {
                        String s3=arr[digits.charAt(ind+2)-'0'-2];
                        for(int k=0;k<s3.length();k++)
                        {
                          sb.append(s3.charAt(k));
                          
                          if(ind+3==n)
                          {
                              String t=sb.toString();
                              String r="";
                              r+=c;
                              r+=t;
                              res.add(r);
                          }
                          sb.deleteCharAt(sb.length()-1);
                        }
                        sb.deleteCharAt(sb.length()-1);
                    }
                }
            }
            
            
        }
        }
    }
}