class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        
        int n=nums.length;
        int leftMax[]=new int[n]; leftMax[0]=nums[0];
        int leftMin[]=new int[n]; leftMin[0]=nums[0];
        int rightMax[]=new int[n]; rightMax[n-1]=nums[n-1];
        int rightMin[]=new int[n]; rightMin[n-1]=nums[n-1];

        for(int i=1;i<n;i++)
        {
            leftMax[i]=Math.max(leftMax[i-1],nums[i]);
            leftMin[i]=Math.min(leftMin[i-1],nums[i]);
        }

        for(int i=n-2;i>=0;i--)
        {
            rightMax[i]=Math.max(rightMax[i+1],nums[i]);
            rightMin[i]=Math.min(rightMin[i+1],nums[i]);
        }

        int first=-1;
        int second=-1;

        for(int i=0;i<n;i++)
        {
            int l=i-indexDifference;
            int r=i+indexDifference;

            if(l>=0)
            {
                int lmax=leftMax[l];
                int lmin=leftMin[l];
                if(Math.abs(nums[i]-lmax)>=valueDifference)
                {
                    first=i;
                    second=lmax;
                    break;
                }
                if(Math.abs(nums[i]-lmin)>=valueDifference)
                {
                    first=i;
                    second=lmin;
                    break;
                }
            }
            if(r<n)
            {
                int lmax=rightMax[r];
                int lmin=rightMin[r];
                if(Math.abs(nums[i]-lmax)>=valueDifference)
                {
                    first=i;
                    second=lmax;
                    break;
                }
                if(Math.abs(nums[i]-lmin)>=valueDifference)
                {
                    first=i;
                    second=lmin;
                    break;
                }
            }
        }

        if(first==-1 || second==-1) {
            return new int[]{-1,-1};
        }

        int l=first-indexDifference;
        int r=first+indexDifference;
        boolean flag=false;

        while(l>0)
        {
            if(nums[l]==second)
            {
                second=l;
                flag=true;
                break;
            }
            l--;
        }

        if(flag)
        {
            return new int[]{first,second};
        }

        while(r<n)
        {
            if(nums[r]==second)
            {
                second=r;
                break;
            }
            r++;
        }

        return new int[]{first,second};

    }
}