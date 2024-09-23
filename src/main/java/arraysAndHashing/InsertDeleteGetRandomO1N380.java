package arraysAndHashing;

import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandomO1N380 {
    class RandomizedSet {
        HashMap<Integer, Integer> indexValMap;
        HashMap<Integer, Integer> valIndexMap;
        Random random;
        int lastIndex = -1;
        public RandomizedSet() {
            indexValMap = new HashMap<>();
            valIndexMap = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if(valIndexMap.containsKey(val))
                return false;
            lastIndex++;
            indexValMap.put(lastIndex, val);
            valIndexMap.put(val,lastIndex);
            return true;
        }

        public boolean remove(int val) {
            if(!valIndexMap.containsKey(val))
                return false;
            Integer valIndex = valIndexMap.get(val);
            if(valIndex == lastIndex){
                lastIndex--;
                valIndexMap.remove(val);
                indexValMap.remove(valIndex);
                return true;
            }
            indexValMap.put(valIndexMap.get(val), indexValMap.get(lastIndex));
            valIndexMap.put(indexValMap.get(lastIndex),valIndexMap.get(val));

            indexValMap.remove(lastIndex);
            valIndexMap.remove(val);
            lastIndex--;
            return true;
        }

        public int getRandom() {
            return indexValMap.get(random.nextInt(lastIndex+1));
        }
    }
}
