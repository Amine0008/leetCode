package graphs.leetcode

import java.util.HashSet
import java.util.LinkedList


fun isBipartite(graph: Array<IntArray>): Boolean {
    val sets = Array<MutableSet<Int>>(2) labl@{ _ -> return@labl HashSet<Int>() };
    val visitedNodes = HashSet<Int>();

    for(i in graph.indices){
        if(!bfs(i,sets,visitedNodes,graph))
            return false;
    }
    return true;

}

fun bfs(sourceNode:Int, sets: Array<MutableSet<Int>>, visitedNodes: MutableSet<Int>, graph:Array<IntArray>): Boolean{
    val waveNodes = LinkedList<Int>();
    var waveSize: Int;
    waveNodes.add(sourceNode);
    visitedNodes.add(sourceNode);
    var cNode:Int;

    while(!waveNodes.isEmpty()){
        waveSize = waveNodes.size;
        for(i in 0..<waveSize){
            cNode = waveNodes.removeFirst();
            for(j in graph[cNode].indices){
                if(!addNodesToSets(cNode,graph[cNode][j],sets))
                    return false;
                if(visitedNodes.contains(graph[cNode][j]))
                    continue;
                waveNodes.addLast(graph[cNode][j]);
                visitedNodes.add(graph[cNode][j]);
            }
        }

    }
    return true;
}

fun getSetId(node:Int, sets: Array<MutableSet<Int>>): Int{
    if(sets[0].contains(node))
        return 0;
    if(sets[1].contains(node))
        return 1;
    return -1
}

fun addNodesToSets(nodeA: Int, nodeB: Int, sets: Array<MutableSet<Int>>): Boolean {
    val setOfA:Int = getSetId(nodeA, sets);
    val setOfB: Int = getSetId(nodeB, sets);
    if(setOfA == setOfB){
        if(setOfA == -1){
            sets[0].add(nodeA);
            sets[1].add(nodeB);
            return true;
        }
        return false;
    }

    if(setOfA != -1 && setOfB != -1)
        return true;

    if(setOfA == -1){
        sets[1-setOfB].add(nodeA);
    }
    if(setOfB == -1){
        sets[1-setOfA].add(nodeB);
    }
    return true;
}