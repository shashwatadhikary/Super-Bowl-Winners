// Shashwat Adhikary

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter the file location: ");
        File file = new File(sc.nextLine());
        Scanner inputFile = new Scanner(file);

        
        HashMap<Integer, String> yearWiseWinners = new HashMap<>();
        HashMap<String, ArrayList<Integer>> teamWiseWins = new HashMap<>();

        
        int year = 1967;
        while(inputFile.hasNextLine()){
            String winnerName = inputFile.nextLine();
            yearWiseWinners.put(year, winnerName);
            teamWiseWins.putIfAbsent(winnerName, new ArrayList<>());
            teamWiseWins.get(winnerName).add(year);
            year++;
        }

        
        while(true){
            System.out.println("\nEnter the year from 1967-2022, or enter -1 to quit:");
            int input = sc.nextInt();
            if(input == -1){
                System.out.println("Thanks for using the program!");
                break;
            }
            if(input < 1967 || input > 2022){
                System.out.println("Please enter a valid year.");
                continue;
            }

            
            String teamName = yearWiseWinners.get(input);
            ArrayList<Integer> winningYears = teamWiseWins.get(teamName);

            
            System.out.printf("\n%d winner: %s\n", input, teamName);
            System.out.print("They won in the following years: ");
            for(int yearWon : winningYears){
                System.out.print(yearWon + " ");
            }
            System.out.println();
        }
    }
}
