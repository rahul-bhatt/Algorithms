package searching;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author rahulbhatt
 *
 * Problem: COMPLETION SEARCH
 * **************************
 * 
 * 
 * 
 */
public class SearchProblem7 {

	public static void main(String[] args) {
	    List<Double> A = Arrays.asList(20.0, 30.0, 40.0, 90.0, 100.0);
	    double T = 210;
	    System.out.println(findSalaryCap(T, A));
	}

	public static double findSalaryCap(double targetPayroll, List<Double> currentSalaries) {
		Collections.sort(currentSalaries);
		
		double unadjustedSalarySum = 0;
		
		for (int i = 0; i < currentSalaries.size(); ++i) {
			final double adjustedSalarySum = currentSalaries.get(i) * (currentSalaries.size() - i);
			
			if (unadjustedSalarySum + adjustedSalarySum >= targetPayroll) {
				return (targetPayroll - unadjustedSalarySum) / (currentSalaries.size() - i);
			}
			
			unadjustedSalarySum += currentSalaries.get(i);
		}
		
		// No solution, since targetPayroll > existing payroll.
		return -1.0;
	}
}
