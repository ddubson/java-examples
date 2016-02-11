package com.ddubson.hackerrank.easy.timeconversion;

import java.io.*;

public class Solution {

	public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		String time = r.readLine();
		boolean isAM = time.substring(time.length() - 2, time.length()).equals("AM");
		int hour = Integer.valueOf(time.substring(0,2));
		int hourIn24;

		if(!isAM) {
			hourIn24 = hour + 12;
		} else {
			hourIn24 = hour;
		}

		String abbrTime = time.substring(2, time.length() - 2);
		String stdTime = hourIn24 + abbrTime;
		System.out.print(stdTime);
	}
}
