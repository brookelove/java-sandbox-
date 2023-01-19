import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class Hw1_p2 {

	public static void findByMake(Car[] cars, String make) {
		// implement this method
	}
	
	public static void olderThan(Car[] cars, int year) {
		// implement this method
	}
	
	public static void main(String[] args) throws IOException {

		// complete this part
		// create an array of Car objects, cars, of size 10
		// read input file and store 10 car Objects in the array
		
		
		System.out.println("\nAll cars:");
		for (int i=0; i<cars.length; i++) {
			System.out.println(cars[i]);
		}
		
		String make = "Honda";
		int year = 2017;
		
		System.out.println("\nAll cars made by " + make);
		findByMake(cars, make);
		System.out.println("\nAll cars made before " + year);
		olderThan(cars, year);
	}

}
