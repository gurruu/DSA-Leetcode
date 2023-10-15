class Solution {
    Long t[][];
    public int numWays(int steps, int arrLen) {
        t=new Long[505][505];
        arrLen=Math.min(arrLen,steps);
        return (int)solve(steps,0,arrLen);
    }
    

    long solve(int steps,int i,int n)
    {
        if(i<0 || i>=n || steps<0) return 0;
        if(steps==0)
        {
            if(i==0) return 1;

            return 0;
        }
        if(t[steps][i]!=null) return t[steps][i];

        long ans=(solve(steps-1,i,n)+solve(steps-1,i+1,n)+solve(steps-1,i-1,n))%1000000007;
        t[steps][i]=ans;
        return ans;
    }
}