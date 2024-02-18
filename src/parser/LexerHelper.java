package parser;

public class LexerHelper {
	
	public static int lexemeToInt(String str) {
		try {
			return Integer.parseInt(str);
		}
		catch(NumberFormatException e) {
			System.out.println(e);
		}
		return -1;
	}

	// TODO: Implement the lexemeToChar and lexemeToReal methods
	// Complete the LexerHelper class to obtain the semantic values of real and char constants

	// char constats -> 'a' '.' '~'
	// ASCII code -> '\123'
	// special char constants -> \n, \t
	public static char lexemeToChar(String str){
		try {

			// check that the first and the last character are aphostrophes ('...')
			char firstChar = str.charAt(0);
			char lastChar = str.charAt(str.length()-1);

			if (firstChar == '\'' && lastChar == '\'') {

				// option 1 - only one character
				if (str.length() == 3){
					return str.charAt(1);
				}

				// option 2 - special char constants
				if (str.charAt(1) == '\\' && str.length() == 4){
					if (str.charAt(2) == 'n') {
						return '\n';
					}
					if (str.charAt(2) == 't') {
						return '\t';
					}
				}

				// option 3 - ASCII code
				if (str.charAt(1) == '\\' && str.length() > 3 ){

					StringBuilder number = new StringBuilder();

					// Iterate over each character of str to get the number
					for (int i = 2; i < str.length()-1; i++) {
						number.append(str.charAt(i));
					}


					// convert from string to int to char
					int ret = Integer.parseInt(number.toString());
					return (char) ret;
				}
			}
		}
		catch(NumberFormatException e){
			System.out.println(e);
		}

		return '0';
	}

	// real constants -> 12.3, 2., .34
	public static double lexemeToReal(String str){
		try {
			return Double.parseDouble(str);
		}
		catch(NumberFormatException e){
			System.out.println(e);
		}

		return -1;
	}


}
