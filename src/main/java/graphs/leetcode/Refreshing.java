package graphs.leetcode;

import java.util.*;

public class Refreshing {
    public class CollapsedUnionFind {

        int[] parents;

        public CollapsedUnionFind(int numberOfNodes) {
            parents = new int[numberOfNodes];
            Arrays.fill(parents, -1);
        }

        public int find(int nodeIndex) {
            //will return the index for the root node of this node's set
            return parents[nodeIndex] < 0 ? nodeIndex : parents[nodeIndex];
        }
        public void union(int firstNodeIndex, int secondNodeIndex) {
            if(parents[firstNodeIndex] == parents[secondNodeIndex] && parents[secondNodeIndex] > 0)
                return;
            int firstSetParent;
            int secondSetParent;
            if(parents[firstNodeIndex] < 0)
                firstSetParent = firstNodeIndex;
            else
                firstSetParent = parents[firstNodeIndex];
            if(parents[secondNodeIndex] < 0)
                secondSetParent = secondNodeIndex;
            else
                secondSetParent = parents[secondNodeIndex];
            for(int i = 0; i < parents.length; i++) {
                if(parents[i] == secondSetParent)
                    parents[i] = firstSetParent;
            }
            parents[firstSetParent] += parents[secondSetParent] ;
            parents[secondSetParent] = firstSetParent;


        }
    }

    //#463

    public int islandPerimeter(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    return bfs(i,j,grid);
            }
        }
        return -1;
    }
    public int bfs(int sourceRow, int sourceColumn, int[][] grid){
        //mark it as visited
        grid[sourceRow][sourceColumn] = -1;
        List<int[]> newLevel = new ArrayList<>();
        List<int[]> currentLevelNodes;
        newLevel.add(new int[]{sourceRow,sourceColumn});
        int perim = 0;

        while(!newLevel.isEmpty()){
            currentLevelNodes = newLevel;
            newLevel = new ArrayList<>();

            for(int[] node: currentLevelNodes){
                perim+=checkEdges(node, grid);
                int r = node[0];
                int c = node[1];

                for(int[] nb : new int[][]{{r+1,c}, {r-1,c}, {r,c+1}, {r,c-1}}){
                    if(nb[0] == grid.length || nb[1] == grid[0].length || nb[0] < 0 || nb[1] < 0)
                        continue;
                    if(grid[nb[0]][nb[1]] == 0 || grid[nb[0]][nb[1]] == -1)
                        continue;
                    //else grid[nb[0]][nb[1]] is 1
                    grid[nb[0]][nb[1]] = -1;
                    newLevel.add(nb);
                }

            }

        }

        return perim;
    }
    public int checkEdges(int[] node, int[][] grid){
        int rowLimit = grid.length;
        int columnLimit = grid[0].length;
        int waterSide = 0;
        int r = node[0];
        int c = node[1];
        for(int[] nb : new int[][]{ {r+1,c}, {r-1,c}, {r,c+1}, {r,c-1}}){
            if(nb[0] == rowLimit || nb[1] == columnLimit || nb[0] < 0 || nb[1] < 0)
                waterSide++;
            else if(grid[nb[0]][nb[1]] == 0)
                waterSide++;
        }
        return waterSide;

    }


    //#130
    public void solve(char[][] board) {

            for(int x: new int[]{0, board.length-1}){
                for(int j = 0; j < board[0].length; j++){
                    if(board[x][j] == 'O')
                        bfsTransform(new int[]{x,j},'T','O',board);
                }
            }
            for(int y: new int[]{0,board[0].length-1}){
                for(int i = 0; i < board.length; i++){
                    if(board[i][y] == 'O')
                        bfsTransform(new int[]{i,y},'T','O',board);
                }
            }

            for(int i = 1; i < board.length-1;i++){
                for(int j = 1; j < board[0].length-1; j++){
                    if(board[i][j] == 'O')
                        bfsTransform(new int[]{i,j},'X','O',board);
                }
            }
            for(int x: new int[]{0, board.length-1}){
                for(int j = 0; j < board[0].length; j++){
                    if(board[x][j] == 'T')
                        bfsTransform(new int[]{x,j},'O','T',board);
                }
            }
            for(int y: new int[]{0,board[0].length-1}){
                for(int i = 0; i < board.length; i++){
                    if(board[i][y] == 'T')
                        bfsTransform(new int[]{i,y},'O','T',board);
                }
            }



        }
    public void bfsTransform(int[] sourceCoordinates, char transformCharacter ,char charOfRegion, char[][] board){
            //transformCharacter == 'X' => capturing the region
            board[sourceCoordinates[0]][sourceCoordinates[1]] = transformCharacter;
            List<int[]> currentLevel = new ArrayList<>();
            List<int[]> nextLevel;
            int r,c,nbR,nbC;
            currentLevel.add(sourceCoordinates);
            while(!currentLevel.isEmpty()){
                nextLevel = new ArrayList<>();
                for(int[] node: currentLevel){
                    r = node[0];
                    c = node[1];
                    for(int[] nb: new int[][]{{r+1, c}, {r-1,c}, {r,c+1}, {r,c-1}}){
                        nbR = nb[0];
                        nbC = nb[1];
                        if(nbR < 0 || nbC < 0 || nbR == board.length || nbC == board[0].length )
                            continue;
                        if(board[nbR][nbC] != charOfRegion)
                            continue;
                        board[nbR][nbC] = transformCharacter;
                        nextLevel.add(nb);

                    }
                }
                currentLevel = nextLevel;
            }

        }


    //#1466
    public int minReorder(int n, int[][] connections) {

//        int[][] graph = new int[n][n];
//        for(int[] road: connections){
//            graph[road[0]][road[1]] = 1;
//            graph[road[1]][road[0]] = -1;
//        }


        Map<Integer,List<int[]>> graph = new HashMap<>();

        for(int[] road: connections){
            if(!graph.containsKey(road[0]))
                graph.put(road[0],new ArrayList<>());
            if(!graph.containsKey(road[1]))
                graph.put(road[1],new ArrayList<>());

            graph.get(road[0]).add(road);
            graph.get(road[1]).add(road);
        }




        int minReorders = 0;
        //bfs
        Set<Integer> visitedNodes = new HashSet<>();
        LinkedList<Integer> level = new LinkedList<>();
        level.add(0);
        visitedNodes.add(0);
        int currentSize = 0;
        Integer node;
        Integer nb;
        while(!level.isEmpty()){
            currentSize = level.size();
            for(int i = 0; i < currentSize; i++){
                node = level.removeFirst();
                for(int[] con: graph.get(node)){
                    nb = con[0] == node ? con[1]:con[0];
                    if(visitedNodes.contains(nb))
                        continue;
                    visitedNodes.add(nb);
                    level.addLast(nb);
                    if(con[0] == node)
                        minReorders++;
                }
            }
        }
        return minReorders;
    }

    //#994
    public int orangesRotting(int[][] grid) {

        LinkedList<int[]> levelNodes = new LinkedList<>();
        boolean allEmpty = true;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != 0)
                    allEmpty  = false;
                if(grid[i][j] == 2)
                    levelNodes.add(new int[]{i,j});
            }
        }
        if(allEmpty)
            return 0;

        int currentLevelSize = levelNodes.size();
        int munites = -1, r, c;
        int[] node;
        while(!levelNodes.isEmpty()){
            currentLevelSize = levelNodes.size();
            munites++;
            for(int i = 0; i < currentLevelSize; i++){
                node = levelNodes.removeFirst();
                r = node[0];
                c = node[1];
                for(int[] nb : new int[][]{{r+1,c}, {r-1, c}, {r,c+1}, {r,c-1}}){
                    if(nb[0]<0 || nb[1] < 0 || nb[0] == grid.length || nb[1] == grid[0].length)
                        continue;
                    if(grid[nb[0]][nb[1]] != 1)
                        continue;
                    grid[nb[0]][nb[1]] = 2;
                    levelNodes.addLast(new int[]{nb[0],nb[1]});
                }
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1)
                    return -1;
            }
        }
        return munites;

    }

    //#1091
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0] == 1 || grid[n-1][n-1] == 1)
            return -1;
        int waveCounter = 0;
        int currentWaveSize;
        LinkedList<int[]> waveNodes = new LinkedList<>();
        grid[0][0] = 1;
        waveNodes.add(new int[]{0,0});
        int[] node;
        int r,c;
        while(!waveNodes.isEmpty()){
            currentWaveSize = waveNodes.size();
            waveCounter++;
            for(int i = 0; i < currentWaveSize; i++){
                node = waveNodes.removeFirst();
                r = node[0];
                c = node[1];
                if(r == n-1 && c == n-1)
                    return waveCounter;
                for(int[] nb: new int[][]{{r+1,c},{r-1,c},{r,c+1},{r,c-1},{r-1,c+1},{r+1,c+1},{r-1,c-1},{r+1,c-1}}){
                    if(nb[0] < 0 || nb[1] < 0 || nb[0] == n || nb[1] == n)
                        continue;
                    if(grid[nb[0]][nb[1]] != 0)
                        continue;
                    grid[nb[0]][nb[1]] = 1;
                    if(nb[0] == n-1 && nb[1] == n-1)
                        return waveCounter+1;
                    waveNodes.addLast(new int[]{nb[0],nb[1]});
                }
            }
        }
        return -1;
    }

    //#684
    public int[] findRedundantConnection(int[][] edges) {
        CollapsedUnionFind unionFindDs = new CollapsedUnionFind((edges.length));
        for(int[] edge: edges){
            if(unionFindDs.find(edge[0]) == unionFindDs.find(edge[1]))
                return edge;
            unionFindDs.union(edge[0],edge[1]);
        }
        return null;

    }









}
