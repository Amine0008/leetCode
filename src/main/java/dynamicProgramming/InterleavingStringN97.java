package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class InterleavingStringN97 {
	
	class IndicesKey {
		int p1=0;
		int p2=0;
		int r = 0;
		
		
		public IndicesKey(int p1, int p2, int r) {
			super();
			this.p1 = p1;
			this.p2 = p2;
			this.r = r;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Objects.hash(p1, p2, r);
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			IndicesKey other = (IndicesKey) obj;
			return p1 == other.p1 && p2 == other.p2 && r == other.r;
		}

		
	}
	
    public boolean isInterleave(String s1, String s2, String s3) {
        Map<IndicesKey,Boolean> map = new HashMap<>();
        
        return dfs(0,0,0,map,s1,s2,s3);
    }
    
    public Boolean dfs(int p1, int p2, int r, Map<IndicesKey,Boolean> memo, String s1,String s2,String s3) {
    	IndicesKey key = new IndicesKey(p1,p2,r);
    	
    	if(memo.containsKey(key))
			return memo.get(key);

    	if(p1 == s1.length() && p2 == s2.length() && r != s3.length()) {
    	 	memo.put(key, false);
    	 	return false;
    	}
    		
    	
    	if(p1 == s1.length() && p2 == s2.length() && r == s3.length())
    	{
    	 	memo.put(key, true);
    	 	return true;
    	}    	
    	if(r == s3.length() && (p1 != s1.length() || p2 != s2.length()) )
    	{
    	 	memo.put(key, false);
    	 	return false;
    	}    	
    	if(p1 == s1.length() && p2 != s2.length())
    		if(s2.charAt(p2) != s3.charAt(r))
    		{
        	 	memo.put(key, false);
        	 	return false;
        	}    	
    	if(p2 == s2.length() && p1 != s1.length())
    		if(s1.charAt(p1) != s3.charAt(r))
    		{
        	 	memo.put(key, false);
        	 	return false;
        	}    	
    		
    	Boolean result1 = false;
    	Boolean result2 = false;
    	
    	if(p1 < s1.length() && s1.charAt(p1) == s3.charAt(r))
    		result1 = dfs(p1+1, p2, r+1, memo, s1, s2, s3);
    	
    	if(p2 < s2.length() && s2.charAt(p2) == s3.charAt(r))
    		result2 = dfs(p1, p2+1, r+1, memo, s1, s2, s3);
    	
    	
    	memo.put(key, result1 || result2);
    	
    	return result1 || result2; 
    	
    	
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
