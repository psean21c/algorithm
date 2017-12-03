
import java.util.Scanner;

public class Permutation {

	// You may assume that 0 <= k <= n, 
	// where n is the number of string on standard input.
	public static void main(String[] args) {
		Deque<String> deque = new Deque<String>();
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String str = scanner.next();
			deque.addFirst(str);
			//System.out.println(scanner.next());
		}
		for(String s: deque){
			System.out.println(s + " ");
		}
		scanner.close();
	}
}
