package arraysAndHashing;

import java.util.*;

public class FindAllAnagramsInAStringN438 {

    /*
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        int pSize = p.length();
        int[][] charCounterMap = new int[25][2];
        for(int[] row: charCounterMap){
            Arrays.fill(row,-1);
        }
        for( int i = 0; i < p.length(); i++){
            if(charCounterMap[p.charAt(i)-97][0] == -1){
                charCounterMap[p.charAt(i)-97][0] = 0;
                charCounterMap[p.charAt(i)-97][1] = 0;
            }
            charCounterMap[p.charAt(i)-97][0]+=1;
            charCounterMap[p.charAt(i)-97][1]+=1;
        }
        for(int i = 0; i < s.length(); i++){
            if(i+pSize-1 >= s.length())
                return result;
            if(isAnagram(i,i+pSize-1,charCounterMap, s))
                result.add(i);
            for(int[] row: charCounterMap){
                row[1] = row[0];
            }
        }
        return result;

    }

    public boolean isAnagram(int f, int l,  int[][] charCounterMap, String s) {
        for(int i = f; i <= l; i++){
            if(charCounterMap[s.charAt(i)-97][0] == -1)
                return false;
            if(charCounterMap[s.charAt(i)-97][1] == 0)
                return false;
            charCounterMap[s.charAt(i)-97][1]-=1;
        }
        return true;
    }*/

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result  = new ArrayList<>();
        if(s.length() < p.length())
            return result;
        int[] sMap = new int[26];
        int[] pMap = new int[26];
        for(int i = 0; i < p.length(); i++){
            pMap[p.charAt(i)-97]+=1;
        }
        int l = 0;
        int r = p.length()-1;
        for(int i = l; i <=r; i++){
            sMap[s.charAt(i)-97]+=1;
        }
        while(r < s.length()){
            if(l != 0){
                sMap[s.charAt(l-1)-97] -=1;
                sMap[s.charAt(r)-97] +=1;
            }
            if(isAnagram(sMap,pMap))
                result.add(l);
            l++;
            r++;
        }
        return result;
    }

    public boolean isAnagram(int[] map1, int[] map2){
        for(int i = 0; i < map1.length; i++){
            if(map1[i] != map2[i])
                return false;
        }
        return true;
    }

}
