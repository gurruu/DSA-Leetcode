class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        
        Map<Integer,Long>map=new HashMap<>();
        long res=0;
        int mod=1000000007;
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++)
        {
            map.put(arr[i],1l);
            for(int j=0;j<i;j++)
            {
                if(arr[i]%arr[j]==0)
                {
                    map.put(arr[i],(map.get(arr[i])+map.get(arr[j])*map.getOrDefault(arr[i]/arr[j],0l))%mod);
                }
            }
            res=(res+map.get(arr[i]))%mod;
        }
        
        return (int)res;
    }
}