package stringExemples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamStrings {
	public StreamStrings() {}
	
	    private List<String> names = new ArrayList<>(List.of(
            "Maria", "João", "Ana", "Francisco", "Carlos", "Amanda", "José", "Luana", "Paulo", "Lucas",
            "Fernanda", "Rafael", "Gabriela", "Pedro", "Juliana", "Bruna", "Gabriel", "Carla", "Matheus", 
            "Larissa",  "Tiago", "Mariana", "Ricardo", "Luiz", "Beatriz", "Henrique", "Julio", "Letícia",
            "Roberta", "Fábio", "Camila", "André", "Eduarda", "Robson", "Sofia", "Gustavo", "Tatiane", 
            "Camila", "Vicente", "Marcelo", "Cláudia", "Danilo", "Fernanda", "Breno", "Tatiane", "Aline", 
            "Simone", "Daniel", "Vitoria", "Priscila"
        ));

		public List<String> getNames() {
			return names;
		}
		
		public void printNamesStream() {
			System.out.println(sortedAZ());
			System.out.println(sortedZA());
			System.out.println(namesUpperCase());
			System.out.println(namestoLowerCase());
			System.out.println(filterNameByLetter());
			System.out.println(filterNamesByUpperLimit());
			System.out.println(filterNamesByLowerLimit());
			System.out.println(containsCharacter());
		}
		
		private List<String> sortedAZ() {
			return names.stream()
					.sorted()
					.toList();
		}
		
		private List<String> sortedZA() {
			return names.stream()
					.sorted(Comparator.reverseOrder())
					.toList();
		}
	    
		private List<String> namesUpperCase(){
			return names.stream()
					.sorted()
					.map(String::toUpperCase)
					.toList();
		}
		
		private List<String> namestoLowerCase(){
			return names.stream()
					.sorted()
					.map(String::toLowerCase)
					.toList();
		}
		
		private List<String> filterNameByLetter(){
			return names.stream()
					.sorted()
					.filter(n -> n.startsWith("A"))
					.toList();
		}
		
		private List<String> filterNamesByUpperLimit(){
			return names.stream()
					.limit(3)
					.toList();
		}
		
		private List<String> filterNamesByLowerLimit(){
			return names.stream()
					.skip(Math.max(0, names.size()-3))
					.toList();
		}
		
		private List<String> containsCharacter(){
			return names.stream()
					.map(String::toLowerCase)
					.sorted()
					.filter(l -> l.contains("a") && l.contains("e") && l.contains("i"))
					.toList();
		}


}
