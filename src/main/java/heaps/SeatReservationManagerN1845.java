package heaps;

import java.util.PriorityQueue;

public class SeatReservationManagerN1845 {

    class SeatManager {
        PriorityQueue<Integer> minHeap;
        public SeatManager(int n) {
            minHeap = new PriorityQueue<>();
                for(int i = 1; i <= n; i++){
                minHeap.add(i);
            }
        }
        public int reserve() {
            return minHeap.remove();
        }
        public void unreserve(int seatNumber) {
            minHeap.add(seatNumber);
        }
    }
}
