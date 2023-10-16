class Solution {
    public List<Integer> getRow(int rowIndex) {
        int numRows=rowIndex+1;
           List<List<Integer>>res=new ArrayList<>();
        List<Integer>b=new ArrayList<>();
        b.add(1);
        res.add(b);
        // res.add(new ArrayList<>(1,1));
        if(numRows==1)
        {
            return res.get(0);
        }
        List<Integer>a=new ArrayList<>();
        a.add(1);a.add(1);
        res.add(a);
        if(numRows==2)
        {
            return res.get(1);
        }
        for(int i=2;i<numRows;i++)
        {
            List<Integer>temp=new ArrayList<>();
            temp.add(1);
            List<Integer>l=res.get(i-1);
            for(int j=1;j<l.size();j++)
            {
                temp.add(l.get(j)+l.get(j-1));
            }
            temp.add(1);
            res.add(temp);
        }
        return res.get(rowIndex);
    }
}