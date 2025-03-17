import java.util.Scanner;
import java.io.File;

import java.io.FileWriter;
import java.io.BufferedWriter;

public class PracticeProblem {

	public static void main(String args[]) {
	}

	public static String getName(int lineNum, String fileName) {
		if (lineNum < 1) { return "";} // can only read a positive integer
		String name;
		Scanner read = null;
		try {
			read = new Scanner(new File(fileName));
			for (int i = 0; i < lineNum - 1; i++) {
				read.nextLine();
			}
			name = read.next() + " " + read.next();
		} catch (Exception e) {
			System.out.println("Exception occurred reading the file");
			return "";
		} finally {

			try {
				if (read != null) {
					read.close();
				}
			} catch (Exception e) {
				System.out.println("Exception occurred attempting to close the scanner");
			}
		}
		return name;
	}

	public static int getAge(int lineNum, String fileName) {
		if (lineNum < 1) { return -1;}
		int age;
		Scanner read = null;
		try {
			read = new Scanner(new File(fileName));
			for (int i = 0; i < lineNum - 1; i++) {
				read.nextLine();
			}
			read.next();
			read.next();
			age = read.nextInt();
		} catch (Exception e) {
			System.out.println("Exception occurred reading the file");
			return -1;
		} finally {

			try {
				if (read != null) {
					read.close();
				}
			} catch (Exception e) {
				System.out.println("Exception occurred attempting to close the scanner");
			}
		}
		return age;
	}

	public static int getNumber(int lineNum, String fileName) {
		if (lineNum < 1) { return -1;}
		int studentNum;
		Scanner read = null;
		try {
			read = new Scanner(new File(fileName));
			for (int i = 0; i < lineNum - 1; i++) {
				read.nextLine();
			}
			read.next();
			read.next();
			read.nextInt();
			studentNum = read.nextInt();
		} catch (Exception e) {
			System.out.println("Exception occurred reading the file");
			return -1;
		} finally {
		
			try {
				if (read != null) {
					read.close();
				}
			} catch (Exception e) {
				System.out.println("Exception occurred attempting to close the scanner");
			}
		}

		return studentNum;
	}

	public static String getFileSource(String fileName) {
		String result = "";
		Scanner read = null;
		try { 
			read = new Scanner(new File(fileName));
			
			while (read.hasNext()) {
				result += read.nextLine();
			}
		} catch (Exception e) {
			System.out.println("Exception occurred reading the file");

		} finally {
			try {
				if (read != null) {
					read.close();
				}
			} catch (Exception e) {
				System.out.println("Exception occured closing the scanner");
			}
		}	
		return result;
	}

	public static void fileAppend(String output, String fileName) {
		BufferedWriter writer = null;

		try {
			
			writer = new BufferedWriter(new FileWriter(fileName, true));
			// writer.newLine();
			writer.append(output);
			
		} catch (Exception e) {
			System.out.println("Exception occurred while writing to the file");
		} finally {

			try {
				if (writer != null) {
					writer.close();
				}
			} catch (Exception e) {
				System.out.println("Exception occurred attempting to close BufferedWriter writer");
			}
		}
	}
}

/*
[![Open in Codespaces](https://classroom.github.com/assets/launch-codespace-2972f46106e565e64193e422d61a12cf1da4916b45550586e14ef0a7c637dd04.svg)](https://classroom.github.com/open-in-codespaces?assignment_repo_id=18724283)
# Instructions  

  ## Questions

1. Write a function for each of the following:</br>

getName(int Line, String file)</br>
getAge(int Line, String file)</br>
getNumber(int Line, String file)</br>

Each of these functions will return the name, age or student number of student on that line in the file.</br>

The file will be setup in the following manner:</br>

Jacob Park 17 123456789</br>
Eric Lan 17 987654321</br>
Tiffany Chiu 17 123654789</br>

getName(2) would return Eric Lan.</br>
getNumber(1) would return 123456789.</br>
getAge(3) would return 17.</br>

For getName If the line number does not exist in the file return "".</br>
For getNumber and getAge If the line number does not exist in the file return -1.</br>

2. Write a function called fileAppend(String output, String filename).</br>

This will append the String you provide into the filename provided. It should return nothing.</br>
*/