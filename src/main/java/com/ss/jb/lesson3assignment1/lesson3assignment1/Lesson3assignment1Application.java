package com.ss.jb.lesson3assignment1.lesson3assignment1;
import java.util.Scanner;
import java.io.File;

class FileLister {
	String filePath;

	public FileLister(String p) {
		filePath = p;
	};

	public void list(String indent) {
		File files = null;
		File[] fileList;
		files = new File(filePath);
		fileList = files.listFiles();
		for(File file : fileList) {
			System.out.println(indent + file.getName());
			if (file.isDirectory()) {
				System.out.println(indent + "FILES : ");
				FileLister subDirectory = new FileLister(file.getPath());
				subDirectory.list(indent + "    ");
			};
		};
	};

};

public class Lesson3assignment1Application {

	public static void main(String[] args) {
		System.out.println("Please input your directory path.");
		Scanner sc = new Scanner(System.in);
		String path = sc.nextLine();
		FileLister mainDirectory = new FileLister(path);
		mainDirectory.list("");
	};

}
