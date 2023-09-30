package backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations2N47 {
	
	
	public static void main(String[] ar) {
		Permutations2N47 s =new Permutations2N47();
		System.out.println(
				s.permuteUnique(new int[] {1,2,3}));
	}
	
    public List<List<Integer>> permuteUnique(int[] nums) {
    	if(nums.length == 1) {
    		List<List<Integer>> result = new ArrayList<>();
    		result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    		return result;
    	}
    	Arrays.sort(nums);
    	return backtracking(new LinkedList<>(Arrays.stream(nums).boxed().collect(Collectors.toList())))
    			.stream()
    			.map(ll->new ArrayList<>(ll)).collect(Collectors.toList());
    }
    
    public List<LinkedList<Integer>> backtracking(LinkedList<Integer> list){
    	List<LinkedList<Integer>> result = new ArrayList<>();
    	if(list.size() == 2) {
    		int first = list.get(0);
    		int second = list.get(1);
    		LinkedList<Integer> l = new LinkedList<>();
    		if(first == second) {
    			l.add(first);
    			l.add(first);
    			result.add(l);
    		}
    		else {
    			l.add(first);
    			l.add(second);
    			result.add(l);
    			l = new LinkedList<>();
    			l.add(second);
    			l.add(first);
    			result.add(l);
    		}
    		return result;
    	}
    	int iterations = list.size();
    	Integer lastRemovedElement = -11;
    	while(iterations > 0) {
    		if(list.getFirst() == lastRemovedElement) {
    			lastRemovedElement = list.remove();
    			list.addLast(lastRemovedElement);
    			
    		}
    		else {
    			lastRemovedElement = list.remove();
    			List<LinkedList<Integer>> perms = backtracking(list);
    			for(LinkedList<Integer> l : perms) {
    				l.addFirst(lastRemovedElement);
    				result.add(l);
    			}
    			list.addLast(lastRemovedElement);
    		}
    		iterations--;
    	}
    	return result;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
