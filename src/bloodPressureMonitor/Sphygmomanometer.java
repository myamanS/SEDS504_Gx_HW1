package bloodPressureMonitor;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File; 
import java.io.FileWriter;
import java.io.IOException; 
import java.util.Arrays;  
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.lang.Character;
import java.lang.Integer;




public class Sphygmomanometer {
	
	
	
	

	
	public static ArrayList<PatientBloodPressure> sphygArr = new ArrayList<PatientBloodPressure>(); //Create ArrayList for PatientBloodPressure objects
	
	
	
	public static void newRecFile() {						//Create and initialize new file for records
		
		File sphygFile = new File("sphygFile.txt");
		
		try {
		
			FileWriter headerWriter = new FileWriter("sphygFile.txt",true);
			headerWriter.write("index,name,age,systolic,diastolic,pulse\n");
	    	headerWriter.close();
	        System.out.println("Successfully created new file.");
			
		}
		
		catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	     }
		
		//FileWriter sphygWriter = new FileWriter("sphygFile.txt");
	    //sphygWriter.write(PatientBloodPressure.name);
	    
	    
	    
		
		
	}
	
	
	
	public static void delRecFile() {						//Delete existing record file
		File delSphyg = new File("sphygFile.txt");
		
	    if (delSphyg.delete()) { 
	      System.out.println("Deleted the file: " + delSphyg.getName());
	    } else {
	      System.out.println("Failed to delete the file.");
	    } 
				
		
	}
	
	
	public static void addRecord(String initName, int initAge,int initSyspress, int initDiapress, int initPatpulse) {		//Add new patient object to ArrayList and add record to file
		
		sphygArr.add(new PatientBloodPressure(initName, initAge, initSyspress, initDiapress, initPatpulse));
		
		
		
		try {
	    	FileWriter sphygWriter = new FileWriter("sphygFile.txt",true);
	    	
	    	
	    	sphygWriter.write(String.valueOf((sphygArr.size()-1)));
	    	
	    	sphygWriter.write(",");
	    	sphygWriter.write(initName);
	    	
	    	sphygWriter.write(",");
	    	sphygWriter.write(String.valueOf(initAge));
	    	
	    	sphygWriter.write(",");
	    	sphygWriter.write(String.valueOf(initSyspress));
	    	
	    	sphygWriter.write(",");
	    	sphygWriter.write(String.valueOf(initDiapress));
	    	
	    	sphygWriter.write(",");
	    	sphygWriter.write(String.valueOf(initPatpulse));
	    	
	    	sphygWriter.write("\n");
	    	
	    	
	    	sphygWriter.close();
	        System.out.println("Successfully wrote to the file.");
	    } 
	    
	    catch (IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	     }
		
		
	
	}
	

	public static void lastRecord() {		//Give info for adding new record
		
		String lastRecName = sphygArr.get(sphygArr.size()-1).name;
		int lastRecAge = sphygArr.get(sphygArr.size()-1).pat_age;
		int lastRecSys = sphygArr.get(sphygArr.size()-1).sys_press;
		int lastRecDia = sphygArr.get(sphygArr.size()-1).dia_press;
		int lastRecPulse = sphygArr.get(sphygArr.size()-1).pat_pulse;
		int lastIndex = sphygArr.size()-1;
		
		System.out.println("New Record No:"+lastIndex+"\nName:"+lastRecName+"\nAge:"+lastRecAge+"\nSystolic Pressure:"+lastRecSys+"\nDiastolic Pressure:"
				+lastRecDia+"\nPulse:"+lastRecPulse);
		
	
	}
	

	public static void delNameRecord(String getName) {		//Deletes all records for a patient or deletes only the last record of a patient.
		
		System.out.println("Delete only last record or delete all records for this patient: For last record enter 1 - For all records enter 2");
		
		Scanner delOperIn = new Scanner(System.in);
		int delOper = delOperIn.nextInt();
		
		
		int lastRec = 0;
		String curName = "";
		

		
		if (delOper == 2) {
			
			
			int finder = 0;
			
			while(sphygArr.size() > 0 && finder < sphygArr.size()) {
				
				
				curName = sphygArr.get(finder).name;
				
				if (curName.equals(getName)) {
					
					
					System.out.println("Patient name: "+curName+" "+finder);
					
					sphygArr.remove(finder);
					finder = 0;
					
			
			
					}
				
				else
					finder++;
					
					
					
			}
			
			recRemoveFile();
			
			
			
		
		}	
		
		
		
		else if(delOper == 1) {
			
			
			for(int finder = 0; finder < sphygArr.size(); finder++) {
				
				
				curName = sphygArr.get(finder).name;
			
				if (curName.equals(getName)) {
					
					lastRec = sphygArr.indexOf(sphygArr.get(finder));
					
							
				
				}
				
			}
			
			System.out.println("Patient name: "+getName+" Record "+lastRec+" has been deleted");
			sphygArr.remove(lastRec);
			
			recRemoveFile();
			
		

			
			
			
				

		}
		
		
	}


	public static int checkName(String nameCheck) {			//Checks the name input if it exists in records.
		
		int findCheck = 0;
		
		for(int finder = 0; finder<sphygArr.size(); finder++) {
			
			//System.out.println(finder+(sphygArr.get(finder).name));
			
			if (nameCheck.equals(sphygArr.get(finder).name)) {
				
				findCheck = 1;
				
				break;
			
			}
			
			else 
				continue;
		
	    
		
		}
	
		return findCheck;
	
	}


	private static void recRemoveFile() {			//After record deletions, this method creates the record file again.
		
		
		try {
	    	FileWriter delConWriter = new FileWriter("sphygFile.txt");
	    	
	    	delConWriter.write("");
	    	delConWriter.close();
		}
		
		catch(IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	     }
		
		
		
		try {
	    	
			FileWriter delConWriter = new FileWriter("sphygFile.txt");
	    	delConWriter.write("index,name,age,systolic,diastolic,pulse\n");
	    	
	    	for(int write = 0; write < sphygArr.size(); write++) {
	    		
	    		
	    		delConWriter.write(String.valueOf(write));
	    		
	    		
	    		delConWriter.write(",");
	    		delConWriter.write(sphygArr.get(write).name);
	    		
	    		delConWriter.write(",");
	    		delConWriter.write(String.valueOf(sphygArr.get(write).pat_age));
	    		
	    		delConWriter.write(",");
	    		delConWriter.write(String.valueOf(sphygArr.get(write).sys_press));
	    		
	    		
	    		delConWriter.write(",");
	    		delConWriter.write(String.valueOf(sphygArr.get(write).dia_press));
	    		
	    		
	    		delConWriter.write(",");
	    		delConWriter.write(String.valueOf(sphygArr.get(write).pat_pulse));
	    		
	    		delConWriter.write("\n");
	    		
	    		
	    		
	    		
	    	
	    	}
	    	delConWriter.close();
		}
		
		catch(IOException e) {
	        System.out.println("An error occurred.");
	        e.printStackTrace();
	     }
		
		
	
	}


	public static void avgPatient(String avgName) {		//Calculates average values
		
		double sum_sys = 0;
		double sum_dia = 0;
		double sum_pulse = 0;
		
		int name_count = 0;
		
		for(int i = 0; i<sphygArr.size();i++) {
			
			if (avgName.equals(sphygArr.get(i).name)){
				
				sum_sys = sum_sys + sphygArr.get(i).sys_press;
				sum_dia = sum_dia + sphygArr.get(i).dia_press;
				sum_pulse = sum_pulse + sphygArr.get(i).pat_pulse;
				name_count++;
			
			
			
			}
			
			
		}
		
		if(name_count != 0) {
		
		
			double avgSys = sum_sys/name_count;
			double avgDia = sum_dia/name_count;
			double avgPulse = sum_pulse/name_count;
			
			System.out.println("Average values of patient "+avgName+" in "+name_count+" measurements: Systolic:"+avgSys+" Diastolic:"+avgDia+" Pulse:"+avgPulse);
		
		
		}
		
		else 
			System.out.println("Patient could not found.");
		
		
		
	}


	public static void patMinMax(String min_max_name) {		//Calculates min and max values
	
	
		Integer sys_arr[] = {};
		Integer dia_arr[] = {};
		Integer pul_arr[] = {};
		
		ArrayList<Integer> sysArr = new ArrayList<Integer>(Arrays.asList(sys_arr)); 
		ArrayList<Integer> diaArr = new ArrayList<Integer>(Arrays.asList(dia_arr)); 		
		ArrayList<Integer> pulArr = new ArrayList<Integer>(Arrays.asList(pul_arr)); 	
		
		for(int i = 0; i<sphygArr.size();i++) {
			
			
			if(min_max_name.equals(sphygArr.get(i).name)) {
				
				sysArr.add(sphygArr.get(i).sys_press);
				diaArr.add(sphygArr.get(i).dia_press);
				pulArr.add(sphygArr.get(i).pat_pulse);
			
			
			
			}
			
			
		}
		
		
		System.out.println("Maximum and minimum measurements of patient:"+min_max_name);
		System.out.println("\nMaximum systolic:"+Collections.max(sysArr));
		System.out.println("\nMinimum systolic:"+Collections.min(sysArr));
		System.out.println("\nMaximum diastolic:"+Collections.max(diaArr));
		System.out.println("\nMinimum diastolic:"+Collections.min(diaArr));
		System.out.println("\nMaximum pulse:"+Collections.max(pulArr));
		System.out.println("\nMinimum pulse:"+Collections.min(pulArr));
	
	
	
	}
	
	
	public static void patCategory(String catName) {		//Show blood pressure category
		
		for(int i = sphygArr.size()-1; i >= 0; i--) {
			
			if(catName.equals(sphygArr.get(i).name)) {
				
				int catAge = sphygArr.get(i).pat_age;
				int catSys = sphygArr.get(i).sys_press;
				int catDia = sphygArr.get(i).dia_press;
				
				
				if(catSys < 120 && catDia < 80)
					System.out.println("Blood pressure of patient "+catName+": NORMAL.");
					
				
				if(catSys+11 > 130 && catDia < 80)
					System.out.println("Blood pressure of patient "+catName+": ELEVATED.");
					
				if(catSys+11 > 140 && catDia+11 > 90 && catAge < 70)
					System.out.println("Blood pressure of patient "+catName+": STAGE 1 HIGH.");
				
				if(catSys > 140 && catDia > 89 && catAge < 70)
					System.out.println("Blood pressure of patient "+catName+": STAGE 2 HIGH.");
				
					
				if(catSys > 129 && catDia > 79 && catAge > 70)
					System.out.println("Blood pressure of patient "+catName+": URGENT! Please call 112.");
				
				
			
				
				break;
				
			}
			
		}
		
	}
	
	
	
	public static void recoverFile() {				//If a record file exists in project folder, this method creates patient arraylist using that folder
		
		
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("sphygFile.txt"));
			String line = reader.readLine();
			
			while (line != null) {
				
				if(Character.isDigit(line.charAt(0))) {
				
					String[] cell = line.split("[,]",0);
					
					ArrayList<String> cells = new ArrayList<String>();
					
					for(int cell_count = 1; cell_count<6; cell_count++) {
						
						String get_value = cell[cell_count];
						
						cells.add(get_value);
						
						
						
						
					}
					
				//System.out.println(cells.get(0)+ cells.get(1)+ cells.get(2)+ cells.get(3)+cells.get(4));
				
				
					recRecordsArr(cells.get(0), Integer.valueOf(cells.get(1)),Integer.valueOf(cells.get(2)),Integer.valueOf(cells.get(3)),
							Integer.valueOf(cells.get(4)));
				
				
				}
				
				
				//StringTokenizer st = new StringTokenizer(line);
				
				//String value = st.nextToken(delimeter);
				
				//System.out.println(value);
				
				// read next line
				line = reader.readLine();
			}

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	public static void recRecordsArr(String initName, int initAge,int initSyspress, int initDiapress, int initPatpulse) {    // Only add objects to arraylist 
		
		sphygArr.add(new PatientBloodPressure(initName, initAge, initSyspress, initDiapress, initPatpulse));
	
	
	}
	
	

}	





		
  


