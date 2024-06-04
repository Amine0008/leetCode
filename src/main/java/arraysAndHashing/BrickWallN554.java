package arraysAndHashing;

import java.util.*;
import java.util.List;

public class BrickWallN554 {

    public int leastBricks(List<List<Integer>> wall) {
        Map<Long, Integer> widthBricksCrossedMap = new HashMap<>();
        int result = wall.size();
        long widthHolder;
        for(List<Integer> row: wall){
            widthHolder = 0;
            for(int i = 0; i < row.size()-1; i++){
                widthHolder+=row.get(i);
                if(!widthBricksCrossedMap.containsKey(widthHolder))
                    widthBricksCrossedMap.put(widthHolder, wall.size());
                widthBricksCrossedMap.put(widthHolder, widthBricksCrossedMap.get(widthHolder) - 1);
                if(widthBricksCrossedMap.get(widthHolder) < result)
                    result = widthBricksCrossedMap.get(widthHolder);
            }
        }
        return result;
    }
}
