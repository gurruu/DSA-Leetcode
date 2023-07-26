class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        
        int i=1;
        int j=10000000;
        int res=-1;
        int n=dist.length;
        while(i<=j)
        {
            int mid=(i+(j-i)/2);
            double time=0.0;
            for(int k=0;k<n-1;k++)
            {
                int t=dist[k]/mid;
                if(dist[k]%mid!=0) t++;
                time+=(double)t;
            }
            time=time+(double)dist[n-1]/mid;

            if(time<=hour)
            {
                res=mid;
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return res;

    }
}