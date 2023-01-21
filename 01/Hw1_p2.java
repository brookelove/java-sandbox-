import java.io.IOException;
import java.io.File;
// import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hw1_p2 {
	// Descrition: Compares the user input of make to the makes of objects in the
	// cars array. Looks to see if there are any makes that are equal.
	// Input: array of objects- cars & String- user input make
	// Output: Will Print a string of the cars matching that make or will return
	// string that informs user there is matching make.
	public static void findByMake(Car[] cars, String make) {
		// implement this method
		// make a list for all of the items that you want to add in the array
		List<Object> list = new ArrayList<Object>();
		// System.out.print(make);
		for (int i = 0; i < cars.length; i++) {
			// have to include an if statement to look at the first object value in the
			// array
			String obj_make = cars[i].getMake(); // returns the private variable make from
			// System.out.println(obj_make);
			// System.out.println(obj_make.getClass().getTypeName());
			// System.out.println(obj_make.equals(make));
			// System.out.println(make.getClass().getTypeName());
			if (obj_make.equals(make)) {
				// // System.out.println(cars[i]);
				list.add(cars[i]); // adds the current car object to the list
			}

			// add the found items in the list
			// System.out.println(cars[i]);// prints each object in an array
			// System.out.println(cars[i].getMake());// returns each make
		}
		if (list.size() == 0) {
			System.out.print("There are no cars with the make " + make);
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
	}

	// Descrition:Compares the user input of year to the years of objects in the
	// cars array. Looks to see if the year is less than the year given.
	// Input: array of objects- cars & String- user input year
	// Output: Will Print a string of the cars that have the years less than the
	// given year or will return string that informs user there are no years less
	// than the year given.
	public static void olderThan(Car[] cars, int year) {
		// implement this method
		// System.out.print(year);
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < cars.length; i++) {
			// have to include an if statement to look at the second object value in the to
			// compare to the year
			// array
			int obj_year = cars[i].getYear();
			// System.out.println(obj_year);
			// System.out.println(obj_year > year);
			if (obj_year < year) { // conditional to see if there are cars makde later than the give year
				list.add(cars[i]);
			}
			// System.out.println("found");
		}
		if (list.size() == 0) {
			System.out.print("There are no cars that have a year less than " + year);
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
	}
	// Descrition:Looks for file and genereates an array objects that are used later
	// in other methods
	// Input: arguments that are in a string
	// Output: Will print strings of either a cars that meet the below critera or
	// gives user information if it does not match the below critera

	public static void main(String[] args) throws IOException {
		// complete this part
		Car[] cars = new Car[10];
		// List<String> list = new ArrayList<String>();
		// String file_make;
		// int file_price;
		// int file_year;
		Scanner fileInput = new Scanner(new File("car_input.txt")); // finds file
		int start = 0;
		while (fileInput.hasNext()) { // as long as the file has another line do this
			// System.out.println(fileInput.nextLine()); // reads each line as long as the
			// file has lines
			String line = fileInput.nextLine();
			// list.add(line);
			String[] splitLine = line.split(","); // split line by commas
			// System.out.println(splitLine[0]); // make
			// System.out.println(file_price); // price
			// System.out.println(file_year); // year
			String file_make = splitLine[0];
			int file_price = Integer.parseInt(splitLine[1].strip()); // .strip() removes white space
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
