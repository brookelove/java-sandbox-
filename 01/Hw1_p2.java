import java.io.IOException;
import java.io.File;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hw1_p2 {

	public static void findByMake(Car[] cars, String make) {
		// implement this method
		System.out.print(make);
		for (int i = 0; i < cars.length; i++) {
			// have to include an if statement to look at the first object value in the
			// array to compare to the make
			// arrray
			System.out.println(cars[i]);
		}
	}

	public static void olderThan(Car[] cars, int year) {
		// implement this method
		System.out.print(year);
		for (int i = 0; i < cars.length; i++) {
			// have to include an if statement to look at the second object value in the to
			// compare to the year
			// array
			System.out.println(cars[i]);
		}
	}

	public static void main(String[] args) throws IOException {
		// complete this part
		Car[] cars = new Car[10];
		// List<String> list = new ArrayList<String>();
		// String file_make;
		// int file_price;
		// int file_year;
		Scanner fileInput = new Scanner(new File("car_input.txt"));
		int start = 0;
		while (fileInput.hasNext()) {
			// System.out.println(fileInput.nextLine()); // reads each line as long as the
			// file has lines
			String line = fileInput.nextLine();
			// list.add(line);
			String[] splitLine = line.split(",");
			// System.out.println(splitLine[0]); // make
			// System.out.println(file_price); // price
			// System.out.println(file_year); // year
			String file_make = splitLine[0];
			int file_price = Integer.parseInt(splitLine[1].strip());
			int file_year = Integer.parseInt(splitLine[2].strip());
			Car new_car = new Car(file_make, file_year, file_price);
			cars[start] = new_car;
			// System.out.println(new_car);
			// System.out.println(start);
			start++;

			// String[] splitLine = line.split(","); // splits each line by each comma
			// start += 1;
			// System.out.println(Arrays.toString(splitLine));
			// System.out.println(splitLine[0]);
			// System.out.println(splitLine[1]);
			// System.out.println(splitLine[2]);
			// Car new_car = new Car(splitLine[0]);
			// System.out.println(start);

		}
		fileInput.close();
		// System.out.println(cars);
		// for (int i = 0; i < list.size(); i++) {
		// System.out.println(i);
		// System.out.println(Arrays.toString(splitLine));
		// String file_make = Arrays.toString(splitLine[0]);

		// Car new_car = new Car(splitLine[0], splitLine[1], splitLine[2]);
		// cars[i] = new_car;

		// }
		// create an array of Car objects, cars, of size 10
		// read input file and store 10 car Objects in the array

		System.out.println("\nAll cars:");
		for (int i = 0; i < cars.length; i++) {
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
