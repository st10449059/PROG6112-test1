package cricketrunsscore;

import java.util.Scanner;

interface ICricket {
    String getBatsman();
    String getStadium();
    int getRunsScored();
}

abstract class Cricket implements ICricket {
    private String batsman;
    private String stadium;
    private int runs;

    public Cricket(String batsman, String stadium, int runs) {
        this.batsman = batsman;
        this.stadium = stadium;
        this.runs = runs;
    }

    @Override
    public String getBatsman() { return batsman; }

    @Override
    public String getStadium() { return stadium; }

    @Override
    public int getRunsScored() { return runs; }
}

class CricketRunsScored extends Cricket {
    public CricketRunsScored(String batsman, String stadium, int runs) {
        super(batsman, stadium, runs);
    }

    public void printReport() {
        System.out.println();
        System.out.println("BATSMAN RUNS SCORED REPORT");
        System.out.println("**************************");
        System.out.println();
        System.out.println("CRICKET PLAYER: " + getBatsman());
        System.out.println("STADIUM: " + getStadium());
        System.out.println("TOTAL RUNS SCORED: " + getRunsScored());
    }
}

public class ICricket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("The cricketer name: ");
        String batsman = sc.nextLine().trim();

        System.out.print("Enter the stadium: ");
        String stadium = sc.nextLine().trim();

        System.out.print("Enter the total runs scored by " + batsman + " at " + stadium + ": ");
        int runs = 0;
        while (true) {
            String input = sc.nextLine().trim();
            try {
                runs = Integer.parseInt(input);
                break;
            } catch (NumberFormatException e) {
                System.out.print("Please enter a valid integer for runs: ");
            }
        }

        CricketRunsScored record = new CricketRunsScored(batsman, stadium, runs);
        record.printReport();

        sc.close();
    }
}

