package arraysAndHashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignUndergroundSystemN1396 {

    class UndergroundSystem {
        Map<Integer, Object[]> customerCheckinsMap;
        Map<String, List<Integer>> routeAvgTimeMap;
        public UndergroundSystem() {
            customerCheckinsMap = new HashMap<>();
            routeAvgTimeMap = new HashMap<>();
        }

        public void checkIn(int id, String stationName, int t) {
            customerCheckinsMap.put(id, new Object[]{stationName, t});
        }

        public void checkOut(int id, String stationName, int t) {
            String checkInStation = (String) customerCheckinsMap.get(id)[0];
            int checkInTime = (Integer) customerCheckinsMap.get(id)[1];
            String route = checkInStation+"->"+stationName;
            if(!routeAvgTimeMap.containsKey(route))
                routeAvgTimeMap.put(checkInStation+"->"+stationName, new ArrayList<>());

            routeAvgTimeMap.get(route).add(t-checkInTime);


        }

        public double getAverageTime(String startStation, String endStation) {
            double sum = 0;
            for(int time: routeAvgTimeMap.get(startStation+"->"+endStation)) {
                sum+=time;
            }
            return sum/routeAvgTimeMap.get(startStation+"->"+endStation).size();
        }
    }

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */

}


