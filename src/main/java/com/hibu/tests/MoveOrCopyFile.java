package com.hibu.tests;

import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.apache.log4j.Logger;

public class MoveOrCopyFile extends PreRequisites{

	//public static Logger LOGS = Logger.getLogger(MoveOrCopyFile.class.getName());
	public static Logger LOGS = LogManager.getLogger(MoveOrCopyFile.class.getName());

	
	public static void moveFunction(String sourcePath,String DestinationPath,String extension) 
	{
		try{
			String timeStamp = new SimpleDateFormat("MMddHHmmss").format(new Date());
			Path FROM = Paths.get(sourcePath);
		    Path TO = Paths.get(DestinationPath+timeStamp+extension);
		    //overwrite existing file, if exists
		    
		    Files.move(FROM, TO, StandardCopyOption.REPLACE_EXISTING);
		   
		    LOGS.info("Move successful!!");
		   	
			}catch (Exception e) {
				
				System.out.println("There is some error while Moving" );
				
			}

	}
	public static void moveFunction(String sourcePath,String DestinationPath) 
	{
		try{
			String timeStamp = new SimpleDateFormat("MMddHHmmss").format(new Date());
			Path FROM = Paths.get(sourcePath);
		    Path TO = Paths.get(DestinationPath);
		    //overwrite existing file, if exists
		    
		    Files.move(FROM, TO, StandardCopyOption.REPLACE_EXISTING);
		   
		    System.out.println("Move successful!!");
		   	
			}catch (Exception e) {
				
				System.out.println("File not available" );
				
			}

	}
	public static void copyFunction(String sourcePath,String DestinationPath,String extension) 
	{
		try{
			String timeStamp = new SimpleDateFormat("MMddHHmmss").format(new Date());
			Path FROM = Paths.get(sourcePath);
		    Path TO = Paths.get(DestinationPath+timeStamp+extension);
		    //overwrite existing file, if exists
		    CopyOption[] options = new CopyOption[]{
		    StandardCopyOption.REPLACE_EXISTING,
		    StandardCopyOption.COPY_ATTRIBUTES
		    }; 
		    Files.copy(FROM, TO, options);
		    System.out.println("Copy successful!!");

	
			}catch (Exception e) {
				
				System.out.println("There is some error while copying" );
				
			}

	}

	public static void copyFunction(String sourcePath,String DestinationPath) 
	{
		try{
			String timeStamp = new SimpleDateFormat("MMddHHmmss").format(new Date());
			Path FROM = Paths.get(sourcePath);
		    Path TO = Paths.get(DestinationPath);
		    //overwrite existing file, if exists
		    CopyOption[] options = new CopyOption[]{
		    StandardCopyOption.REPLACE_EXISTING,
		    StandardCopyOption.COPY_ATTRIBUTES
		    }; 
		    Files.copy(FROM, TO, options);
		    System.out.println("Copy successful!!");

	
			}catch (Exception e) {
				
				System.out.println("There is some error while copying" );
				
			}

	}
	
}
