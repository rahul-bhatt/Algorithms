package dynamicprogramming;

/*
 	Given an integer n, return an array ans of length n + 1 such that for 
 	each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
 
 	Input: n = 2
	Output: [0,1,1]
	Explanation:
		0 --> 0
		1 --> 1
		2 --> 10
		
	If we see the bits in different numbers, it follows a pattern as illustrated below:
	0 - 0
	1 - 1
	--------
	2 - 10 [1 + No of 1 in 0]
	3 - 11 [1 + No of 1 in 1]
	--------
	4 - 100 [1 + No of 1 in 0]
	5 - 101 [1 + No of 1 in 1]
	6 - 110 [1 + No of 1 in 2]
	7 - 111 [1 + No of 1 in 3]
	--------
	8 - 1000 [1 + No of 1 in 0] 
	9 - 1001
	10 - 1010
	11- 1011
	12 - 1100
	13 - 1101
	14 - 1110
	15 - 1111 [1 + No of 1 in 7]
	--------
	16 - 10000

	So, first we need to know the number of buckets for given number n
	and then apply above logic to get the answer.
 */
public class CountingBits {
	public static void main(String[] args) {
		CountingBits countingBits = new CountingBits();
		int[] counts = countingBits.countBits(0);
		
		for(int count : counts) {
			System.out.print(count + ",");
		}
	}
	
    public int[] countBits(int n) {
        
    		// base case
    		if( n == 0) return new int[] {0};
    		if(n == 1) return new int[] {0,1};
    		
        int[] result = new int[n + 1];
        result[0] = 0;
        result[1] = 1;
        
        // determine the no of buckets
        int temp = n, buckets = 0;
        
        while(temp / 2 > 0) {
            buckets++;
            temp = temp / 2;
        }
        
        // do the calculation for buckets
        int index = 2;
        for(int i = 1; i <= buckets; i++) {
            int start = 0;
            
            // no of elements in a bucket would be the starting index of the bucket
            int noOfElementsInBucket = index;
            
            for(int j = 0; index <= n && j < noOfElementsInBucket; index++,j++) {
                result[index] = 1 + result[start++];
            }
        }
        
        return result;
    }
}
