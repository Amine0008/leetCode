package graphs.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class OpenTheLockN752 {
	public static void main(String[] args) {
		OpenTheLockN752 x = new OpenTheLockN752();
		x.openLock(new String[] {"0201","0101","0102","1212","2002"}, "0202");
	}
    
	public int openLock(String[] deadends, String target) {
		Set<String> visitedSet = new HashSet<>();
		Set<String> deadendsSet = new HashSet<>();
		Queue<String> myQ = new LinkedList<>();
		for(String s : deadends) {
			deadendsSet.add(s);
		}
		if(deadendsSet.contains("0000"))
			return -1;
		myQ.add("0000");
		
		int counter = 0;
		List<String> currentNodes;
		String adjacentNeighbor1;
		String adjacentNeighbor2;

		int val;
		while(!myQ.isEmpty()) {
			currentNodes = new ArrayList<>();	
			while(!myQ.isEmpty()) {
				String holder= myQ.poll();
				if(holder.equals(target))
					return counter;
				currentNodes.add(holder);
			}
			counter++;
			for(String currentNode: currentNodes) {
				visitedSet.add(currentNode);
				for(int i = 0; i < 4; i++) {
					val = Character.getNumericValue(currentNode.charAt(i));
					if(val == 0) {
						adjacentNeighbor1 = currentNode.substring(0, i)+"9"+currentNode.substring(i+1,4);
						adjacentNeighbor2 = currentNode.substring(0, i)+"1"+currentNode.substring(i+1,4);
					}
					else if(val == 9) {
						adjacentNeighbor1 = currentNode.substring(0, i)+"8"+currentNode.substring(i+1,4);
						adjacentNeighbor2 = currentNode.substring(0, i)+"0"+currentNode.substring(i+1,4);
					}
					else {
						adjacentNeighbor1 = currentNode.substring(0, i)+(val-1)+currentNode.substring(i+1,4);
						adjacentNeighbor2 = currentNode.substring(0, i)+(val+1)+currentNode.substring(i+1,4);
					}
					if(!visitedSet.contains(adjacentNeighbor1) && !deadendsSet.contains(adjacentNeighbor1)) {
						myQ.add(adjacentNeighbor1);
						visitedSet.add(adjacentNeighbor1);

					}
					if(!visitedSet.contains(adjacentNeighbor2) && !deadendsSet.contains(adjacentNeighbor2)) {
						myQ.add(adjacentNeighbor2);
						visitedSet.add(adjacentNeighbor2);

					}
				}
			}

		}
		return -1;
		
		
		
	}
	
	
	
	
	
}
