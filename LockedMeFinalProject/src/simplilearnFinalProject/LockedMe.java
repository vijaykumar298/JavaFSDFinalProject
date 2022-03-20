package simplilearnFinalProject;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LockedMe 
{
	static final String projectFilesPath = "D:\\LockedMeFinalProject\\src\\simplilearnFinalProject";
	/**
	 * This method will display the menu for End User
	 */
	public static void displayMenu(){
		System.out.println("**********************************************");
		System.out.println("\tWelcome to LockedMe.com secure app");
		System.out.println("\tDeveloped by : Vijay Kumar Reddy CH");
		System.out.println("**********************************************");
		System.out.println("\t1. Display all files");
		System.out.println("\t2. Add a new file");
		System.out.println("\t3. Delete a file");
		System.out.println("\t4. Search a file");
		System.out.println("\t5. Exit");
		System.out.println("**********************************************");
	}
	/**
	 * This method will display the Files for End User
	 */
	public static void getAllFiles()
	{
		File folder = new File(projectFilesPath);
		File[] listOfFiles = folder.listFiles();
		if(listOfFiles.length>0) {
			System.out.println("Files List is below:\n");
			for(var l:listOfFiles) {
			System.out.println(l.getName());
		}
		}
		else{
			System.out.println("The folder is empty");
		}
			
		
		
	}
	/**
	 * This method will Add Files by End User
	 */
	public static void createFiles() {
		try {
			Scanner obj = new Scanner(System.in);
			String fileName;
			System.out.println("Enter the file name");
			fileName = obj.nextLine();
		
			int linesCount;
			System.out.println("Enter how many lines in the file:");
			linesCount = Integer.parseInt(obj.nextLine());
			FileWriter fw = new FileWriter(projectFilesPath+"\\"+fileName);
			
			//Read line by line from user
			for(int i=1;i<=linesCount;i++) {
				System.out.println("Enter file line:");
				fw.write(obj.nextLine()+"\n");
			}
			System.out.println("File Created Successfully");
			fw.close();
			}
		catch(Exception Ex)
		{
			
		}
		
	}
	/**
	 * This method will check for File Exist
	 * @param fileName String
	 * @return boolean
	 */
	public static boolean checkFileExixts(String fileName)
	{
		ArrayList<String> allFilesNames = new ArrayList<String> ();
		
		File folder = new File(projectFilesPath);
		
		File[] listOfFiles = folder.listFiles();
		
		if(listOfFiles.length>0) {
			for(var l:listOfFiles)
			{
				allFilesNames.add(l.getName());
			}
		}
			
		
		return allFilesNames.contains(fileName);
	}
	/**
	 * This method will Delete the Files by End User
	 */
	public static void deleteFiles() {
		try {
			Scanner obj = new Scanner(System.in);
			String fileName;
			System.out.println("Enter the file name to be deleted");
			fileName = obj.nextLine();
			File f = new File(projectFilesPath+"\\"+fileName);
			if(checkFileExixts(fileName))
			{
				f.delete();
			System.out.println("File deleted Successfully");
		}
		else {
			System.out.println("File does not exist");
		}
		}
		catch(Exception Ex) {
			System.out.println("Unable to delete File. Please contact Admin");
		}
	}
	/**
	 * This method will Search Files by End User
	 */
	public static void searchFiles() {
		try {
			Scanner obj = new Scanner(System.in);
			String fileName;
			System.out.println("Enter the file name to be searched");
			fileName = obj.nextLine();
			
			
			if (checkFileExixts(fileName)) {
				System.out.println("File is available");
			}
			else {
				System.out.println("File is not available");
			}
	


	}
		catch(Exception Ex) {
			System.out.println("Unable to Search File. Please contact Admin");
		}
    }
    }
