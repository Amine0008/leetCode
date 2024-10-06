package arraysAndHashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NamingACompany2306 {

    public long distinctNames(String[] ideas) {
        Set<String> ogIdeas = new HashSet<>();
        Set<Character> fcSet = new HashSet<>();
        for(String s: ideas) {
            ogIdeas.add(s);
            fcSet.add(s.charAt(0));
        }
        Map<String, Long> map = new HashMap<>();
        String keyHolder;
        for(String idea: ogIdeas){
            for(Character fc : fcSet){
                if(fc.equals(idea.charAt(0)))
                    continue;
                keyHolder = idea.charAt(0)+","+fc;
                if(!map.containsKey(keyHolder))
                    map.put(keyHolder,0L);
                if(!ogIdeas.contains(fc+idea.substring(1)))
                    map.put(keyHolder,map.get(keyHolder)+1);
            }
        }

        long result = 0L;
        for(String key: map.keySet()){
            result+=(map.get(key)*map.get(key.charAt(2)+","+key.charAt(0))*2);
            map.put(key,0L);
        }
        return result;

    }
}
