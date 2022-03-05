package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * You are looking to move into a new aartment on specific street, and you are given
 * a list of contiguous blocks on that street where each block contains an apartment that you could move into.
 * 
 * You also have a list of requirements: a list of buildings that are important to you.
 * For instance, you might value having a school and a gym near your apartment.
 * The list of blocks that you have contains information at every block about all of the
 * buildings that are present and absent at the block in question. 
 * For instance, for every block, you might know whether a school, a pool, an office,
 * and a gym are present.
 * 
 * On order to optimize your life, you want to pick an apartment block such that you minimize the farthest
 * distance you would have to walk from your apartment to reach any of your required buildings.
 * 
 * Write a function that takes in alist of contiguous blocks on a specific street and a list of your
 * required buildings and that returns the location (the index) of the block that's most optimal for you.
 * 
 * If there are multiple most optimal blocks, your function can return the index of any one of them.
 * 
 * @author rahulbhatt
 *
 */
public class ApartmentHunting {

	public static void main(String[] args) {
		String[] reqs = new String[] {"gym", "school", "store"};
		List<Map<String, Boolean>> blocks = new ArrayList<Map<String, Boolean>>();
		
		Map<String, Boolean> block1 = new HashMap<String, Boolean>();
		block1.put("gym", false);
		block1.put("school", true);
		block1.put("store", false);
		blocks.add(block1);
		
		Map<String, Boolean> block2 = new HashMap<String, Boolean>();
		block2.put("gym", true);
		block2.put("school", false);
		block2.put("store", false);
		blocks.add(block2);
		
		Map<String, Boolean> block3 = new HashMap<String, Boolean>();
		block3.put("gym", true);
		block3.put("school", true);
		block3.put("store", false);
		blocks.add(block3);
		
		Map<String, Boolean> block4 = new HashMap<String, Boolean>();
		block4.put("gym", false);
		block4.put("school", true);
		block4.put("store", false);
		blocks.add(block4);
		
		Map<String, Boolean> block5 = new HashMap<String, Boolean>();
		block5.put("gym", false);
		block5.put("school", true);
		block5.put("store", true);
		blocks.add(block5);
		
		System.out.println("Block with min cost is at index " + apartmentHunting(blocks, reqs));
	}

	//Time: O(b * r) | space: O(b * r)
	//b - the number of bloacks
	//r - number of requirements
	public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
		// Write your code here.
		int[][] minDistancesFromBlocks = new int[reqs.length][];

		for(int i = 0; i < reqs.length; i++) {
			minDistancesFromBlocks[i] = getMinDistances(blocks, reqs[i]);
		}

		int[] maxDistancesAtBlocks = getMaxDistancesAtBlocks(blocks, minDistancesFromBlocks);
		return getIdxAtMinValue(maxDistancesAtBlocks);
	}

	public static int[] getMinDistances(
			List<Map<String, Boolean>> blocks, String req) {
		int[] minDistances = new int[blocks.size()];
		int closestReqIdx = Integer.MAX_VALUE;

		for(int i = 0; i < blocks.size(); i++) {
			if(blocks.get(i).get(req)) {
				closestReqIdx = i;
			}
			minDistances[i] = distanceBetween(i, closestReqIdx);
		}

		for(int i = blocks.size() - 1; i >= 0; i--) {
			if(blocks.get(i).get(req)) {
				closestReqIdx = i;
			}
			minDistances[i] = Math.min(minDistances[i], distanceBetween(i, closestReqIdx));
		}

		return minDistances;
	}

	public static int[] getMaxDistancesAtBlocks(
			List<Map<String, Boolean>> blocks,
			int[][] minDistancesFromBlocks) {

		int[] maxDistancesAtBlocks = new int[blocks.size()];
		for(int i = 0; i < blocks.size(); i++) {
			int[] minDistancesAtBlock = new int[minDistancesFromBlocks.length];

			for(int j = 0; j < minDistancesFromBlocks.length; j++) {
				minDistancesAtBlock[j] = minDistancesFromBlocks[j][i];
			}

			maxDistancesAtBlocks[i] = arrayMax(minDistancesAtBlock);
		}

		return maxDistancesAtBlocks;
	}

	public static int getIdxAtMinValue(int[] array) {
		int idxAtMinValue = 0;
		int minValue = Integer.MAX_VALUE;
		for(int i = 0; i < array.length; i++) {
			int currentValue = array[i];
			if(currentValue < minValue) {
				minValue = currentValue;
				idxAtMinValue = i;
			}
		}

		return idxAtMinValue;
	}

	public static int distanceBetween(int a, int b) {
		return Math.abs(a - b);
	}

	public static int arrayMax(int[] array) {
		int max = array[0];
		for(int a : array) {
			if(a > max) {
				max = a;
			}
		}

		return max;
	}

}
