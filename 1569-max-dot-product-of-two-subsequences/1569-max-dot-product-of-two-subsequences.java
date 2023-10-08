class Solution {
    Integer t[][];
    public int maxDotProduct(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        t=new Integer[n+1][m+1];

        int res=Integer.MIN_VALUE;;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                res=Math.max(res,nums1[i]*nums2[j]);
            }
        }
        
        int ans=solve(nums1,nums2,n-1,m-1);
        if(ans==0) ans=res;

        return ans;
    }

    int solve(int arr1[],int arr2[],int i,int j)
    {
        if(i<0 || j<0) return 0;

        if(t[i][j]!=null) return t[i][j];

        int a=solve(arr1,arr2,i-1,j);
        int b=solve(arr1,arr2,i,j-1);
        int c=arr1[i]*arr2[j]+solve(arr1,arr2,i-1,j-1);

        t[i][j]= Math.max(a,Math.max(b,c));
        return t[i][j];
    }
}