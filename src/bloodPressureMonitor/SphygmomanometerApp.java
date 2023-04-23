package bloodPressureMonitor;
import java.util.Scanner;

public class SphygmomanometerApp {

	public static void main(String[] args) {
		

		
		int progCount = 0;
		
		
		while(progCount != 999999) {
			
			System.out.println("-----------------------------------------------------------\n-Blood Pressure Monitor Menu-\n\n1-)ADD NEW RECORD\n2-)DELETE RECORD\n3-)AVERAGE OF PATIENT'S MEASUREMENTS\n"
					+ "4-)MINIMUM AND MAXIMUM VALUES OF PATIENT'S MEASUREMENTS\n5-)CATEGORY OF BLOOD PRESSURE MEASUREMENT\n6-)EXIT\n-----------------------------------------------------------");
			
			
			
			System.out.println("Please choose operation:");
			
			Scanner userInputIn = new Scanner(System.in);
			int userInput = userInputIn.nextInt();
			
			
			if (userInput == 1) {
		
				System.out.println("Please enter your name, age, pressure and pulse...");
		
				System.out.println("Name:");
				Scanner patNameIn = new Scanner(System.in);
				String patName = patNameIn.nextLine();
		
				System.out.println("Age:");
				Scanner patAgeIn = new Scanner(System.in);
				int patAge = patAgeIn.nextInt();
		
				System.out.println("Systolic Pressure:");
				Scanner sysPressIn = new Scanner(System.in);
				int sysPress = sysPressIn.nextInt();
		
				System.out.println("Diastolic Presure:");
				Scanner diaPressIn = new Scanner(System.in);
				int diaPress = diaPressIn.nextInt();
		
				System.out.println("Pulse:");
				Scanner patPulseIn = new Scanner(System.in);
				int patPulse = patPulseIn.nextInt();
		
		
				Sphygmomanometer.addRecord(patName, patAge, sysPress, diaPress, patPulse);
				Sphygmomanometer.lastRecord();
				

				progCount++;

		   }
			
			
			else if (userInput == 2) {
				
				
				
				System.out.println("Enter name:");
				Scanner findNameIn = new Scanner(System.in);
				String findName = findNameIn.nextLine();
				
				
				if(Sphygmomanometer.checkName(findName) == 1) {
					Sphygmomanometer.delNameRecord(findName);
					
				
				
					
				}
					
				else{
					
					System.out.println("Patient could not found");
					
				
				}	
				
				progCount++;
				
				
						
				
			}
			
			
			else if(userInput == 3) {
				
				
				
				System.out.println("Enter name:");
				Scanner averageNameIn = new Scanner(System.in);
				String averageName = averageNameIn.nextLine();
				
				Sphygmomanometer.avgPatient(averageName);				
				
				
				
			}
			
			
			
			
			else if(userInput == 4) {
				
				
				
				System.out.println("Enter name:");
				Scanner minMaxNameIn = new Scanner(System.in);
				String minMaxName = minMaxNameIn.nextLine();
				
				Sphygmomanometer.patMinMax(minMaxName);				
				
				
				
			}
			
			
			
			else if(userInput == 5) {
				
				
				
				System.out.println("Enter name:");
				Scanner catNameIn = new Scanner(System.in);
				String catName = catNameIn.nextLine();
				
				Sphygmomanometer.patCategory(catName);				
				
				
				
			}
			
			
				
			
			else if(userInput == 6) {
				
				userInputIn.close();
				
				
				Sphygmomanometer.delRecFile();
				
				break;
			
			}
			
			
			else{
				
				System.out.println("Wrong User Input");
				
			}
			
			
			
				
					
		}
	
	}

}
