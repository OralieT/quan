package Task2;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 
			'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;// shift steps (right shift)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	// Encrypt a character according to the given shif steps.
	// Encrypt: En(x) = (x + n) mod 26. x represents the index of c in the ALPHABET
	// array
	public char encryptChar(char c) {
		int index = 0;
		for (int i = 0; i < ALPHABET.length; i++) {
			if ((ALPHABET[i] + "").equals((c + ""))) {
				index += i;
			}
		}

		int newIndex = (index + n) % 26;
		if (index == 26)
			newIndex = 26;

		return ALPHABET[newIndex];
	}

	// Encrypt a text using the above function for encrypting a charater.
	public String encrypt(String input) {
		char[] ch = input.toCharArray();
		String result = new String();
		for (int i = 0; i < ch.length; i++) {
			result += encryptChar(ch[i]);
		}
		return result.toString();
	}

	// Decrypt a character according to the given shif steps.
	// Decrypt: Dn(x) = (x – n) mod 26. x represents the index of c in the ALPHABET
	// array
	public char decryptChar(char c) {
		int index1 = 0;
		for (int i = 0; i < ALPHABET.length; i++) {
			if ((ALPHABET[i] + "").equals((c + ""))) {
				index1 += i;
			}
		}

		int newIndex1 = ((index1 - n) + 26) % 26;
		if (index1 == 26)
			newIndex1 = 26;

		return ALPHABET[newIndex1];
	}

	// Decrypt a encrypted text using the above function for decrypting a charater.
	public String decrypt(String input) {
		char[] ch = input.toCharArray();
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < ch.length; i++) {
			result.append(decryptChar(ch[i]));
		}
		return result.toString();
	}

	public static void main(String[] args) {
		char c = 'B';
		MyCaesar s = new MyCaesar(1);
		char en = s.encryptChar(c);
		System.out.println(en);

		char a = 'Z';
		char de = s.decryptChar(a);
		System.out.println(de);
		
		System.out.println(s.encrypt("DLQZSCDOSQZH"));
		System.out.println(s.decrypt("EVOHLIPOHUIBZ"));
	}

}
