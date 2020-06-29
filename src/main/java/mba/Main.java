package mba;

import mba.model.FareySequence;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Input a length of sequence: ");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		FareySequence fareySequence = FareySequence.builder()
				.n(n)
				.build();
		fareySequence.calculate();
		System.out.println(fareySequence.toString());
	}
}
