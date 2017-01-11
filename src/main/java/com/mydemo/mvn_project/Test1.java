package com.mydemo.mvn_project;

public class Test1 {

	public static void main(String[] args) {
		for (int i = 1; i < 9; i++) {
			String ret = abc(String.valueOf(i));
			System.out.println(ret);
		}

	}

	private static String abc(String idStr) {
		int id = Integer.valueOf(idStr);
		switch (id) {
		case 1:
			return "1";
		case 2:
			return "2";
		case 3:
			return "3";
		case 4:
			return "4";
		case 5:
			return "5";
		default:
			return "999";
		}
	}

}
