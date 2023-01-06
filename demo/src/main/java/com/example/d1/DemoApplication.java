package com.example.d1;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {
	@Scheduled(fixedDelay = 10000)   //cron="0 0 0 ? * *"
	public static void doScheduledTask() throws IOException
	{
		Path fileName = Path.of("C:\\Users\\FCI773\\eclipse-workspace5\\demo\\datajson.txt");
		String textfileString=  Files.readString(fileName);
		// Creating a path choosing file from local
        // directory by creating an object of Path class
        
 
        // calling Files.readString() method to
        // read the file
      //copy daily txt file to a string
		
		//remove square brackets
		if(!(textfileString.isEmpty()) ){
		textfileString =textfileString.substring(1,textfileString.length()-1);
		
		
//		       File f=new File("C:\\Users\\FCI773\\eclipse-workspace5\\demo\\Archive.txt");
	    
//		       Files.write(Paths.get("C:\\Users\\FCI773\\eclipse-workspace5\\demo\\Archive.txt"),new String(",").getBytes(),StandardOpenOption.APPEND);
//		       Files.write(Paths.get("C:\\Users\\FCI773\\eclipse-workspace5\\demo\\Archive.txt"),new String("{").getBytes(),StandardOpenOption.APPEND);
//		        Files.write(Paths.get("C:\\Users\\FCI773\\eclipse-workspace5\\demo\\Archive.txt"),new String("}").getBytes(),StandardOpenOption.APPEND);
		//date and time string to use it the archive file name
		String datestring=Calendar.getInstance().getTime().toString();
		datestring=datestring.replaceAll("\\:","_" );
		//default archive folder
		String path ="C:\\Users\\FCI773\\eclipse-workspace5\\demo\\Archive\\";
		//cobine both string and create a file
		String path2=path+datestring+".txt";
		path2=path2.replaceAll("\\ ", "_");
		System.out.println(path2);
		File myObj2=new File(path2);
		myObj2.createNewFile();
		
		//append data from daily file to archive file with current date as name
		Files.write(Paths.get(path2),new String(textfileString).getBytes(),StandardOpenOption.APPEND);
		

		//empty daily txt file
		Files.delete(fileName);
		File myObj = new File("C:\\Users\\FCI773\\eclipse-workspace5\\demo\\datajson.txt");
		myObj.createNewFile();
		
		  //System.out.println("Current time is :: " + Calendar.getInstance().getTime());
		}
	}
		
		


	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
		
	}

}
