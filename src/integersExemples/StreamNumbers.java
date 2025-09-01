package integersExemples;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StreamNumbers {
	
	public StreamNumbers() {}
	
	private List<Integer> numbers = new Random().ints(10, 1, 15)
			.boxed() // Converte o stream de int para Integer
			.collect(Collectors.toList());
	
	public List<Integer> getNumbers() {
		return numbers;
	}
	
	public void printNumbersStream() {
		System.out.println(numbers);
		System.out.println(filterNumbers());
		System.out.println(distinctNumbers());
		
		System.out.println("Sum: " + sumNumbers());
		System.out.println("Max: " + maxNumber());
		System.out.println("Min: " + minNumber());
		System.out.println("Average: " + averageNumber());
		
		System.out.println("\n" + SummaryStatistics());
	}
	
	private List<Integer> filterNumbers(){
		return numbers.stream()
				.filter(n -> n <= 5)
				.toList();
	}
	
	private List<Integer> distinctNumbers(){
//		var nb = numbers.stream()
//		            .mapToInt(Integer::intValue)  // IntStream
//		            .distinct()                   // IntStream
//		            .boxed()                      // Converte para Stream<Integer>
//		            .collect(Collectors.toList());
		return numbers.stream().distinct().sorted().toList();
	}
	
	private int sumNumbers(){
		return numbers.stream()
				.mapToInt(Integer::intValue)
			    .sum();
	}
	
	private int maxNumber() {
		return numbers.stream()
					  .mapToInt(Integer::intValue)
					  .max()
					  .orElseGet(() ->{
							System.out.println("Stream vazia!");
							return 0;
					  });
	}
	
	private int minNumber() {
		return numbers.stream()
				      .mapToInt(Integer::intValue)
				      .min()
				      .orElse(0);
	}
	
	private double averageNumber() {
		
		double avg = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
		
		//return Math.round(average * 100.0) / 100.0;
	    return BigDecimal.valueOf(avg)
	            .setScale(2, RoundingMode.HALF_UP)
	            .doubleValue();
	}
	
	private String SummaryStatistics() {
		IntSummaryStatistics stats = numbers.stream()
											.mapToInt(Integer::intValue)
											.summaryStatistics();
		return "Stats Sum: " + stats.getSum() + 
				"\nStats Average: " + stats.getAverage() +
				"\nStats Max: " + stats.getMax() + 
				"\nStats Min: " + stats.getMin();
	}
	
	
	
}
