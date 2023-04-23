package bloodPressureMonitor;


public class PatientBloodPressure {
	
    String name;
	int pat_age;
	int sys_press;
	int dia_press;
	int pat_pulse;
	
	public PatientBloodPressure(String initName, int initAge,int initSyspress, int initDiapress, int initPatpulse) {
		
		name = initName;
		pat_age = initAge;
		sys_press = initSyspress;
		dia_press = initDiapress;
		pat_pulse = initPatpulse;



	}
	
}
