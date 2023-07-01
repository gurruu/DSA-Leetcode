class Solution {
    int ans=Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        
        solve(cookies,0,new int[k],k);
        return ans;

    }

    void solve(int arr[],int ind,int t[],int k)
    {
        if(ind==arr.length)
        {
            int max=Integer.MIN_VALUE;
            for(int x:t)
            {
                max=Math.max(max,x);
            }
            ans=Math.min(ans,max);
            return;
        }

        for(int i=0;i<k;i++)
        {
            t[i]+=arr[ind];
            solve(arr,ind+1,t,k);
            t[i]-=arr[ind];
        }
    }
}