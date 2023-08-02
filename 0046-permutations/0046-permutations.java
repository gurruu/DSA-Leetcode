class Solution {
    List<List<Integer>>res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        solve(nums,0,new ArrayList<>());
        return res;
    }

    void solve(int arr[],int ind,List<Integer>t)
    {
        if(t.size()==arr.length)
        {
            res.add(new ArrayList<>(t));
        }
        for(int i=0;i<arr.length;i++)
        {
            if(t.contains(arr[i])) continue;

            t.add(arr[i]);
            solve(arr,ind+1,t);
            t.remove(t.size()-1);
        }
    }
}