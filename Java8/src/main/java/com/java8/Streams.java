package com.java8;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import com.java8.domain.Car;
import com.java8.domain.Coupe;
import com.java8.domain.Sedan;

public class Streams {

	public static void main(String[] args) throws Exception {

		List<Car> cars = getSomeCars();
		
		// Print the black cars
		cars.stream().filter(car -> car.getColor() == "black")
			.forEach(System.out::println);
		
		// Print the average mph of the black cars
		OptionalDouble averageMaxMph = cars.stream().filter(car -> car.getColor() == "black")
			.mapToInt(car -> car.getMaxMph())
			.average();
		
		System.out.println("Average max MPH = " + averageMaxMph);
		
		Files.list(Paths.get("."))
			.map(Path::getFileName)
			.peek(System.out::println)
			.forEach(p -> p.toUri());
	}
	
	private static List<Car> getSomeCars() {
		List<Car> cars = new ArrayList<>();
		
		cars.add(new Coupe("Audi", "TT", "black", 145));
		cars.add(new Sedan("Audi", "A4", "red", 145));
		cars.add(new Coupe("BMW", "M3", "silver", 155));
		cars.add(new Coupe("Audi", "R8", "black", 199));
		cars.add(new Coupe("Ford", "Pinto", "green", 80));
		cars.add(new Coupe("BMW", "328", "black", 143));
		cars.add(new Coupe("Chevrolet", "Corvette", "red", 180));
		
		return cars;
	}
}
