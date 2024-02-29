package graphs.leetcode
fun findSmallestSetOfVertices(n: Int, edges: List<List<Int>>): List<Int> {
    val incEdges = IntArray(n);

    for(edge: List<Int> in edges){
        incEdges[edge[1]] = 1;
    }
    val result = ArrayList<Int>();

    for( i in incEdges.indices){
        if(incEdges[i] == 0)
            result.add(i);
    }
    return result;
}