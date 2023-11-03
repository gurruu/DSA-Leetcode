class Solution {
    public List<String> buildArray(int[] target, int n) {
        
        List<String>res=new ArrayList<>();
        Stack<Integer>st=new Stack<>();

        int curr=0;
        

        for(int i=1;i<=n;i++)
        {
            if(i==target[curr])
            {
                while(st.size()!=0 && (curr==0 || st.peek()!=target[curr-1])){
                    st.pop();
                    res.add("Pop");
                }
                st.push(i);
                res.add("Push");
                curr++;
                if(curr>=target.length) break;
            }else{
                res.add("Push");
                st.push(i);
            }
        }
        return res;

    }
}