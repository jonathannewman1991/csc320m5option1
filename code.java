import java.util.ArrayList;
import java.util.Scanner;

public class TemperatureTracker {
	public static void main(String[] args) {
	    ArrayList<String> DaysOfWeek = new ArrayList<>();
	    ArrayList<Double> Temperatures = new ArrayList<>();
	    Scanner inputScanner = new Scanner(System.in);

	    // Populate arrays with data
	    PopulateArrays(DaysOfWeek, Temperatures);

	    // Prompt user for input
	    System.out.println("Please type the day (from Monday to Sunday) or 'week' to see the weekly average temperature:");
	    String userInput = inputScanner.nextLine().toLowerCase(); // Convert user input to lowercase
	    System.out.println("User input: " + userInput); // Debugging statement

	    // Convert days of the week to lowercase for comparison
	    ArrayList<String> lowercaseDaysOfWeek = new ArrayList<>();
	    for (String day : DaysOfWeek) {
	        lowercaseDaysOfWeek.add(day.toLowerCase());
	    }

	    // Display temperature data based on user input
	    if (userInput.equals("week")) {
	        DisplayWeeklyAverage(DaysOfWeek, Temperatures);
	    } else if (lowercaseDaysOfWeek.contains(userInput)) {
	        int idx = lowercaseDaysOfWeek.indexOf(userInput);
	        System.out.println("The temperature on " + DaysOfWeek.get(idx) + " is: " + Temperatures.get(idx) + " degrees Celsius");
	    } else {
	        System.out.println("Invalid input. Please enter a valid day of the week or 'week'.");
	        System.out.println("Available days: " + DaysOfWeek); // Debugging statement
	    }
	}


    // method to populate arrays with data
    public static void PopulateArrays(ArrayList<String> DaysOfWeek, ArrayList<Double> Temperatures) {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        double[] temps = {20.5, 21.2, 22.0, 23.5, 24.8, 25.3, 26.1};

        for (String day : days) {
            DaysOfWeek.add(day);
        }

        for (double temp : temps) {
            Temperatures.add(temp);
        }
    }

    //method to display weekly average temperature
    public static void DisplayWeeklyAverage(ArrayList<String> DaysOfWeek, ArrayList<Double> Temperatures) {
        double total = 0;
        for (double temp : Temperatures) {
            total += temp;
        }
        double average = total / Temperatures.size();

        System.out.println("Weekly average temperature is: " + average + " degrees Celsius");

        // show temperatures for each day
        for (int i = 0; i < DaysOfWeek.size(); i++) {
            System.out.println(DaysOfWeek.get(i) + " - Temperature: " + Temperatures.get(i) + " degrees Celsius");
        }
    }
}
