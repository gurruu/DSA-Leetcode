class Solution {
    public boolean isPowerOfFour(int n) {
         long temp=1;
        if(n==1)
        {
            return true;
        }
        while(temp<=n)
        {
            temp=temp<<2;
            if(temp==n)
            {
                return true;
            }
        }
        return false;
    }
}