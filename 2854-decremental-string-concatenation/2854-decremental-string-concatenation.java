class Solution {
    public int minimizeConcatenatedLength(String[] words) {
        int n = words.length;
        String a = words[0];
        int af = a.charAt(0) -'a', al = a.charAt(a.length() -1)-'a';
        Integer[][][] dp = new Integer[n][26][26]; // index , char af,char al  (total 27 alphabets)
        
        
        return a.length()+solve(1,af,al,words,dp);
    }
    public int solve(int i ,int af, int al ,String[] arr,Integer dp[][][]){
        if(i>arr.length-1) {
            return 0;}
        
        if(dp[i][af][al] != null) return dp[i][af][al];
        
        String b = arr[i];
        int bf = b.charAt(0)-'a',bl = b.charAt(b.length()-1)-'a';
        
        
        int join = 0 , rjoin =0;
        // normal join take place
        if(al == bf){
            
            join = b.length()-1 + solve(i+1,af,bl,arr,dp);
        }
        else {
        
            join = b.length()+solve(i+1,af,bl,arr,dp);
             }
        // reverse join 
        if(bl == af){
            
            rjoin = b.length()-1 + solve(i+1,bf,al,arr,dp);
        }
        else {

            rjoin = b.length()+solve(i+1,bf,al,arr,dp);}
        
        return dp[i][af][al] = Math.min(join,rjoin);
    }
    
    
}