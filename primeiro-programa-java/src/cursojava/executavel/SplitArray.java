package cursojava.executavel;

import java.util.Arrays;
import java.util.List;

public class SplitArray {

	public static void main(String[] args) {
		
		String txt = "Lorem ipsum dolor sit amet consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua";
		
		String[] valoresArray = txt.split(" ");
		
		for (int i = 0; i < valoresArray.length; i++) {
			System.out.println(valoresArray[i]);
		}

		List<String> list = Arrays.asList(valoresArray);
		
		for (String valorString : list) {
			System.out.println(valorString);
		}
		
	}
}
