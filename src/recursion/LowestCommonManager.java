package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * You're given three inputs, all of which are instances of an OrgChart class
 * that have  a directReports property pointing to their reports.
 * The first input is the top manager in an organizational chart, and the
 * other two are reports in the organizational chart. The two reports are guaranteed to be distinct.
 * 
 * Write a function that returns the lowest common manager to the two reports.
 * 
 * Sample imput:
 * topManager = Node A
 * reportOne = Node E
 * report Two = Node I
 * 
 * 		 A
 * 		/ \
 * 	   B   C
 * 	  / \ / \
 *   D  E F  G
 *  / \
 * H   I
 * 
 * Output: Node B
 * 
 * Time complexity - O(n), n is the number of people in the org
 * Space complexity - O(d), d is the height og the org chart
 * 
 * @author rahulbhatt
 *
 */
public class LowestCommonManager {
	public static OrgChart getLowestCommonManager(OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
		// Write your code here.
		return getOrgInfo(topManager, reportOne, reportTwo).lowestCommonManager; // Replace this line.
	}

	public static OrgInfo getOrgInfo(OrgChart manager, OrgChart reportOne, OrgChart reportTwo) {
		int numReportsFound = 0;
		
		for(OrgChart directReport : manager.directReports) {
			OrgInfo orgInfo = getOrgInfo(directReport, reportOne, reportTwo);
			
			if(orgInfo.lowestCommonManager != null) return orgInfo;
			
			numReportsFound += orgInfo.numReportsFound;
		}
		
		if(manager.name == reportOne.name || manager.name == reportTwo.name) {
			numReportsFound++;
		}
		
		OrgChart lowestCommonManager = numReportsFound == 2 ? manager : null;
		return new OrgInfo(numReportsFound, lowestCommonManager);
	}
	
	static class OrgChart {
		public char name;
		public List<OrgChart> directReports;

		OrgChart(char name) {
			this.name = name;
			this.directReports = new ArrayList<OrgChart>();
		}

		// This method is for testing only.
		public void addDirectReports(OrgChart[] directReports) {
			for (OrgChart directReport : directReports) {
				this.directReports.add(directReport);
			}
		}
	}
	
	static class OrgInfo {
		int numReportsFound = 0;
		OrgChart lowestCommonManager;
		
		public OrgInfo(int numReportsFound, OrgChart lowestCommonManager) {
			this.numReportsFound = numReportsFound;
			this.lowestCommonManager = lowestCommonManager;
		}
	}
}
