package graphs.implementation.matrix;
public class GraphNode  {

  public String name;
  public int index;
  public boolean isVisited = false;
  public int shortestDistanceLenght = Integer.MAX_VALUE;
  public GraphNode previousNodeInPath;

  public GraphNode(String name, int index) {
    this.name = name;
    this.index = index;
  }
  
}
