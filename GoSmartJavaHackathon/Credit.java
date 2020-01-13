package Hackathon;

import java.io.IOException;

import java.util.*;

public class Credit {
	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		System.out.println("Number: ");
		String ccNum = key.next();
		try {
			if (luhnAlgo(ccNum) == true) {
				if (cardCompany(ccNum).equals("INVALID")) {
					System.out.println("INVALID");
				} else {
					System.out.println(cardCompany(ccNum));
				}

			} else {
				System.out.println("INVALID");
			}
		} catch (Exception e) {
			System.out.println("INVALID");
		}

	}

	public static boolean luhnAlgo(String ccNum) {
		String a = "";
		String b = "";
		for (int i = ccNum.length() - 1; i >= 0; i -= 2) {
			a += ccNum.charAt(i);
		}

		int[] a2 = new int[a.length()];

		for (int i = a.length() - 1; i >= 0; i--) {
			a2[i] = a.charAt(i) - 48;
		}

		int aSum = 0;
		for (int i = 0; i < a2.length; i++) {
			aSum += a2[i];
		}

		for (int i = ccNum.length() - 2; i >= 0; i -= 2) {
			b += ccNum.charAt(i);
		}

		int[] b2 = new int[b.length()];
		for (int i = 0; i <= b.length() - 1; i++) {
			b2[i] = b.charAt(i) - 48;
		}
		for (int i = 0; i <= b2.length - 1; i++) {
			b2[i] = b2[i] * 2;
		}

		int bSum = 0;
		String sNumbers = "";
		for (int num : b2) {
			sNumbers += num;
		}
		for (int i = 0; i < sNumbers.length(); i++) {
			bSum += Integer.parseInt(String.valueOf(sNumbers.charAt(i)));
		}

		int total = aSum + bSum;
		if (total % 10 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static String cardCompany(String cc) {
		if (cc.length() == 15) {
			if (cc.startsWith("34") || cc.startsWith("37")) {
				return "AMEX";
			}
		} else if (cc.length() == 16) {
			if (cc.startsWith("4")) {
				return "VISA";
			}
			if (cc.startsWith("51") || cc.startsWith("52") || cc.startsWith("53") || cc.startsWith("54")
					|| cc.startsWith("55")) {
				return "MASTERCARD";
			}
		} else if (cc.length() == 13 && cc.startsWith("4")) {
			return "VISA";
		} 
			return "INVALID";

	}
}