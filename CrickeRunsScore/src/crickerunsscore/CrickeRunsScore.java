
package crickerunsscore;


public class CrickeRunsScore {

   
    public static void main(String[] args) {
       
   // --- 1. DATA AND CONSTANTS ---
        
        // Define batsmen and stadium names
        final String[] BATSMEN = {"Jacques Kallis", "Hashim Amla", "AB de Villiers"};
        final String[] STADIUMS = {"Kingsmead", "St Georges", "Wanderers"};
        
        // Two-dimensional array to store the runs data (from the table in 2.jpg)
        // Rows represent stadiums (Kingsmead, St Georges, Wanderers)
        // Columns represent batsmen (Kallis, Amla, De Villiers)
        final int[][] RUNS_DATA = {
            // Kallis, Amla, De Villiers
            {5000, 3800, 4200}, // Kingsmead
            {3500, 3700, 3900}, // St Georges
            {6200, 5000, 5200}  // Wanderers
        };

        // Arrays to store calculated totals
        int[] totalRunsPerBatsman = new int[BATSMEN.length];
        int[] totalRunsPerStadium = new int[STADIUMS.length];

        // --- 2. INPUT SIMULATION AND DATA PROCESSING ---
        
        // Display a simulated "SA CRICKETER APPLICATION" input section 
        // as seen in the sample screenshot (1.jpg)
        System.out.println("\nSA CRICKETER APPLICATION");
        
        // Loop through stadiums and then batsmen to display the "Enter..." prompts 
        // and calculate the total runs per stadium.
        for (int i = 0; i < STADIUMS.length; i++) { // i is the row index (stadium)
            for (int j = 0; j < BATSMEN.length; j++) { // j is the column index (batsman)
                String batsmanName = BATSMEN[j];
                String stadiumName = STADIUMS[i];
                int runs = RUNS_DATA[i][j];

                // Simulate the input prompt line
                System.out.printf("Enter the number runs scored by %s at %s: %d\n", 
                                  batsmanName, stadiumName, runs);

                // Calculate Total Runs Per Batsman (by accumulating vertically/column-wise)
                totalRunsPerBatsman[j] += runs;

                // Calculate Total Runs Per Stadium (by accumulating horizontally/row-wise)
                totalRunsPerStadium[i] += runs;
            }
        }
        
        // --- 3. RUNS SCORED REPORT SECTION ---
        System.out.println("\n--------------------------------------------------");
        System.out.println("RUNS SCORED REPORT:");
        
        // Display runs per stadium for each batsman
        for (int j = 0; j < BATSMEN.length; j++) { // Iterate through batsmen (columns)
            String batsmanName = BATSMEN[j];
            System.out.println("\n" + batsmanName + " total runs scored: " + totalRunsPerBatsman[j]); // Display total per batsman
            for (int i = 0; i < STADIUMS.length; i++) { // Iterate through stadiums (rows)
                String stadiumName = STADIUMS[i];
                int runs = RUNS_DATA[i][j];
                System.out.printf("%s runs scored at %s: %d\n", batsmanName, stadiumName, runs);
            }
        }

        // --- 4. TOTAL RUNS AT STADIUMS TABLE SECTION ---
        System.out.println("\n--------------------------------------------------");
        System.out.println("TOTAL RUNS AT STADIUMS");
        
        // Find the stadium with the most runs while printing the table
        int maxRuns = -1;
        String stadiumWithMostRuns = "";
        
        // Table Header
        System.out.println("-------------------------");
        
        for (int i = 0; i < STADIUMS.length; i++) {
            String stadiumName = STADIUMS[i];
            int totalRuns = totalRunsPerStadium[i];

            // Print the stadium total line, padded to match the sample
            System.out.printf("%-10s %10d\n", stadiumName, totalRuns);

            // Check for the maximum total
            if (totalRuns > maxRuns) {
                maxRuns = totalRuns;
                stadiumWithMostRuns = stadiumName;
            }
        }
        System.out.println("-------------------------");

        // --- 5. STADIUM WITH MOST RUNS SECTION ---
        System.out.println("\nSTADIUM WITH THE MOST RUNS: " + stadiumWithMostRuns);
        System.out.println("--------------------------------------------------\n");
    }
}
