package graphs.leetcode;

import java.util.*;

public class WordLadderN127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,List<String>> graph = new HashMap<>();

        for(int i = 0; i < wordList.size(); i++){
            graph.put(wordList.get(i), new ArrayList<>());
            for(int j = 0; j < wordList.size(); j++){
                if( i == j)
                    continue;
                if(areAdjacent(wordList.get(i),wordList.get(j))){
                    if(graph.get(wordList.get(j)) == null)
                        graph.put(wordList.get(j), new ArrayList<>());
                    graph.get(wordList.get(i)).add(wordList.get(j));
                    graph.get(wordList.get(j)).add(wordList.get(i));
                }

            }
        }
        if(!graph.containsKey(beginWord)){
            graph.put(beginWord, new ArrayList<>());
            for(String s: wordList){
                if(areAdjacent(beginWord,s)){
                    graph.get(beginWord).add(s);
                }
            }
        }
        Set<String> visited = new HashSet<>();
        int waveSize;
        String node;
        LinkedList<String> waveNodes = new LinkedList<>();
        waveNodes.add(beginWord);
        visited.add(beginWord);
        int counter = 1;
        while(!waveNodes.isEmpty()){
            waveSize = waveNodes.size();
            for(int i =0; i < waveSize; i++){
                node = waveNodes.removeFirst();
                for(String adj: graph.get(node)){
                    if(adj.equals(endWord))
                        return counter+1;
                    if(visited.contains(adj))
                        continue;

                    waveNodes.addLast(adj);
                    visited.add(adj);
                }

            }
            counter++;
        }
        return 0;



    }


    boolean areAdjacent(String a, String b){
        boolean hasADifferentLetter = false;
        for(int i = 0; i < a.length(); i++){
            if(a.charAt(i) == b.charAt(i))
                continue;
            if(a.charAt(i) != b.charAt(i)){
                if(hasADifferentLetter) return false;
                hasADifferentLetter = true;
            }
        }
        return hasADifferentLetter;
    }


}
