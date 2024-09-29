package arraysAndHashing;

public class DesignParkingSystemN1603 {

    class ParkingSystem {
        int[] parkCounter;
        public ParkingSystem(int big, int medium, int small) {
            parkCounter = new int[4];
            parkCounter[1] = big;
            parkCounter[2] = medium;
            parkCounter[3] = small;
        }

        public boolean addCar(int carType) {
            if(parkCounter[carType] == 0)
                return false;
            parkCounter[carType]--;
            return true;
        }
    }
}
