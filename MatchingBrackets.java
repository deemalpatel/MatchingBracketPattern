import java.util.*;
public class MatchingBrackets {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter symbols '[]', '{}', or '()'. Example {[]} or {[(]}" );
		
		String symbol = in.nextLine();
		System.out.print(symbolMatch(symbol));

	}
	
	public static boolean symbolMatch(String brackets) {
		
		if(brackets.isEmpty()) {
			return true;
		}
		
		char [] symbols = new char [brackets.length()];
		Stack<Character> st= new Stack();
		
		for(int i = 0 ; i < brackets.length(); i ++) {
			symbols[i] = brackets.charAt(i);
		}
		
		for(int i = 0; i < symbols.length;i++) {
			if(symbols[i]=='{' || symbols[i]=='[' || symbols[i]=='(' ) {
				st.push(symbols[i]);
			}
			
			if(symbols[i]=='}' || symbols[i]==']' || symbols[i]==')' ) {
				if(brackets.isEmpty()) {
					return true;
				}
				else if(!matchingPair(st.pop(),symbols[i])) {
					return false;
				}
			}
		}
		
		if(st.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean matchingPair(char ch1, char ch2) {
		if(ch1 == '(' && ch2==')') {
			return true;
		}
		else if(ch1 == '{' && ch2=='}') {
			return true;
		}
		else if(ch1 == '[' && ch2==']') {
			return true;
		}
		else {
			return false;
		}
	}

}
