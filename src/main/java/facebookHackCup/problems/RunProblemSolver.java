package facebookHackCup.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.google.common.collect.Lists;

public class RunProblemSolver {
	
	public static void main(String[] args) {

		Solvable problem = new CookingTheBooks(); //TODO dependency injection
        String inputFileName = problem.getFileName();
        String outputFileName = problem.getOutputFileName();
        List<String> output = null;

        String line = null;

        try {
            FileReader fileReader = 
                new FileReader(inputFileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            List<String> listOfLines = Lists.newArrayList();
            while((line = bufferedReader.readLine()) != null) {
                listOfLines.add(line);
            }
            output = problem.solveFor(listOfLines);

            bufferedReader.close();            
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                		inputFileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + inputFileName + "'");                   
        }
        
        try {
            FileWriter fileWriter =
                new FileWriter(outputFileName);

            BufferedWriter bufferedWriter =
                new BufferedWriter(fileWriter);

            for (String lineToWrite : output) {
            	bufferedWriter.write(lineToWrite);
            	bufferedWriter.newLine();
			}
            bufferedWriter.close();
        }
        catch(IOException ex) {
            System.out.println(
                "Error writing to file '"
                + outputFileName + "'");
        }
        
	}

}
