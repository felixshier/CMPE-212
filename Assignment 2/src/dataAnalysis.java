import java.io.*;
import java.util.*;

public class dataAnalysis {
		
	//readFile imports the CSV file and places all the data points in a 2D array
	public static double[][] readFile() {
		double[][] data = new double[1000][8];
		String[] arr = new String[8000];
		String line = "";
		String split = ",";
		int i = 0;
		int j = 0;
		Scanner sc;
		try {
			sc = new Scanner(new BufferedReader(new FileReader("Logger.csv")));
			while(sc.hasNextLine()) {
			line = sc.nextLine();
			arr = line.split(split);
			
			for(j=0; j<8;j++) {
				data[i][j] = Double.parseDouble(arr[j]);
			}
			i++;	
		}
		sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return data;
	}
	
	//motorSummary returns an array with the start time, end time, and average current for a pulse
	public static double[] motorSummary(int i, int j) {
		double[][] data = readFile();
		double start = 0;
		double finish = 0;
		double totalCurrent = 0;
		double avgCurrent = 0;
		
		//starts at first data point greater than 1
		start = data[i][0]; 
		
		//track the current while greater than 1
		while (data[i][j]>1) {
			totalCurrent += data[i][j];
			i++;
		}
		
		//finishes at last data point greater than 1
			finish = data[i-1][0];
		avgCurrent = totalCurrent/(finish - start);
		
		//stores the start time, finish time, and average current in an array
		double motorSum[] = {start, finish, avgCurrent};
		return motorSum;
	}
	
	//writeFile creates a CSV file for each motor containing the start time, finish time, and average current for each pulse
	public static void writeFile(int j) {
		String fileName = "Motor"+j+".csv";
		double[][] data = readFile();
		int timesUsed=0;
		PrintWriter outputStream;
		try {
			outputStream = new PrintWriter(new FileOutputStream(fileName));
			
			//column headers
			outputStream.println("start (sec)"+","+"finish (sec)"+","+"current (amps)");
			
			//goes trough each second and uses the motorSummary method if the current is greater than 1
			for (int i=1; i<1000; i++) {
				if (data[i][j]>1) {
					
					//tracks how many times the motor is used
					timesUsed++;
					
					//gets data from motorSummary
					double[] motorData = motorSummary(i, j);
					int start = (int)motorData[0];
					int finish = (int)motorData[1];
					double current =motorData[2];
					
					//puts data in CSV
					outputStream.print(start+","+finish+",");
					outputStream.format("%.3f", current);
					outputStream.print("\n");
					if (current>8) {
						outputStream.println("***Current Exceeded***");
					}
					
					//moves to the end of the pulse
					i = finish;
				}

			}
			//tells us if the motor was never used
			if (timesUsed == 0) {
				outputStream.println("Not Used");				
			}
			outputStream.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//tracks data for each motor
		for (int j=1; j<8;j++) {
			writeFile(j);
		}
		System.out.print("Program Complete");
	}

}
