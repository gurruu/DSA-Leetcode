class Solution {
    public long maxRunTime(int n, int[] batteries) {
        
        long avg=0;
        for(int x:batteries)
        {
            avg+=x;
        }
        
        long i=1l;
        long j=avg/n;
        while(i+1<=j)
        {
            long target=(i+j+1)/2;
            if(poss(batteries,n,target))
            {
                i=target;
            }else{
                j=target-1;
            }
        }
        return i;

    }
    boolean poss(int arr[],int n,long target)
    {
        long sum=0l;
        for(int x:arr)
        {
            sum+=Math.min(x,target);
        }
        return sum>=n*target;
    }
}

// 3
// [10,10,5,3]

// 4
// [8, 1, 4, 8]

// 2
// [31,87,85,44,47,25]