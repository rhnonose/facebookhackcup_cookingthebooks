package facebookHackCup.problems;

import java.io.BufferedReader;

import com.google.common.collect.Lists;

public interface Solvable {

	public String getFileName();
	
	public Lists solveFor(Lists reader);
	
}
