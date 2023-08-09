package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CarFleetN853 {
	
	
	 public int carFleet(int target, int[] position, int[] speed) {
		 Stack<Car> carsCausingFleets = new Stack<>();
		 List<Car> cars =  new ArrayList<>();
		 
		 for(int i = 0; i<position.length; i++) {
			 cars.add(new Car(position[i],speed[i]));
		 }
		 cars.sort((car1,car2)->car1.position-car2.position);
		 
		 for(int i = cars.size(); i>=0; i--) {
			 Car car = cars.get(i);
			 if(carsCausingFleets.isEmpty())
				 carsCausingFleets.push(car);
			 else {
				 if( ((float)(target-car.position)) / car.speed 
						 >
					 ((float)(target-carsCausingFleets.peek().position)) / carsCausingFleets.peek().speed ) {
					 carsCausingFleets.push(car);
				 }
			 }
		 }
		 return carsCausingFleets.size();
    }
	 
	 public static class Car{
		int position;
		int speed;
		public Car(int position, int speed) {
			this.position = position;
			this.speed = speed;
		}
	 }
}
