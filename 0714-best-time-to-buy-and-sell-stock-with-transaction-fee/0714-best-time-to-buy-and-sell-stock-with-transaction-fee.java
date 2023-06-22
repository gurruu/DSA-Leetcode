class Solution {
    Integer t[][];
    public int maxProfit(int[] prices, int fee) {
        
        t=new Integer[50005][2];
        return solve(prices,fee,0,1);

    }

    int solve(int arr[],int fee,int ind,int buy)
    {
        if(ind==arr.length) return 0;

        if(t[ind][buy]!=null) return t[ind][buy];
 
        int ans=0;
        if(buy==1)
        {
            ans=Math.max(solve(arr,fee,ind+1,1),-arr[ind]+solve(arr,fee,ind+1,0));
        }else{
            ans=Math.max(solve(arr,fee,ind+1,0),arr[ind]-fee+solve(arr,fee,ind+1,1));
        }
        t[ind][buy]=ans;
        return ans;
    }
}