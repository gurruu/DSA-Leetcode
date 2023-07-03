class Solution {
    public boolean buddyStrings(String s, String goal) {
        
        if(s.length()==1 && goal.length()==1) return false;

        if(s.length()!=goal.length()) return false;
        Set<Character>set=new HashSet<>();

        if(s.equals(goal))
        {
            for(int i=0;i<s.length();i++)
            {
                if(set.contains(s.charAt(i))) return true;

                set.add(s.charAt(i));
            }

            return false;
        }
         char t='0';
         char g='0';
         int count=0;
        for(int i=0;i<s.length();i++)
        {
          if(s.charAt(i)!=goal.charAt(i))
          {
              if(count==2) return false;

              if(count==0)
              {
                  t=s.charAt(i);
                  g=goal.charAt(i);
              }

              if(count==1)
              {
                  if(s.charAt(i)!=g || goal.charAt(i)!=t) return false;
              }

              count++;
          }
        }

        if(count==1) return false;
        
        return true;
    }
}