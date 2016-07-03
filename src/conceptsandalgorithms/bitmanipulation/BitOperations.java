package conceptsandalgorithms.bitmanipulation;

/**
 * Common Bit wise operations and tricks.
 * 
 * ~       Unary bitwise complement
 * <<      Signed left shift
 * >>      Signed right shift
 * >>>     Unsigned right shift
 * &       Bitwise AND
 * ^       Bitwise exclusive OR
 * |       Bitwise inclusive OR
 *
 * @author Rahul
 */

public class BitOperations {
	public static void main(String args[]) {
		int num = 100, i = 2;
		System.out.println("Input bits: " + Integer.toBinaryString(num));
		System.out.print("Bit at position " + i + ": ");
		getBit(num, i);
		
		System.out.println("\nInput bits: " + Integer.toBinaryString(num));
		i = 3;
		System.out.print("After setting bit at position " + i + ": ");
		System.out.print(Integer.toBinaryString(setBit(num, i)));
		
		System.out.println("\nInput bits: " + Integer.toBinaryString(num));
		i = 2;
		System.out.print("After clearing bit at position " + i + ": ");
		System.out.print(Integer.toBinaryString(clearBit(num, i)));
		
		System.out.println("\nInput bits: " + Integer.toBinaryString(num));
		i = 5;
		System.out.print("After clearing bit from MSB to position " + i + ": ");
		System.out.print(Integer.toBinaryString(clearFromMSBit(num, i)));
		
		System.out.println("\nInput bits: " + Integer.toBinaryString(num));
		i = 2;
		System.out.print("After clearing bit from 0 to position " + i + ": ");
		System.out.print(Integer.toBinaryString(clearThroughI(num, i)));
	}
	
	/*
	 * To get the bit at a particular position(i) we simply left shift 1 by
	 * i so that we have 1 at ith position and all other bits set to 0. Then we
	 * perform an & operation with the give number to get the bit at i position.
	 */
	private static void getBit(int num, int i) {
		System.out.print((num & (1 << i)) != 0 ? 1 : 0);				
	}
	
	/*
	 * To set a particular bit we left shift 1 by i times and then perform an | operation
	 * with the given number.
	 */
	private static int setBit(int num, int i) {
		return num | (1 << i);
	}
	
	/*
	 * To clear a bit at a particular position we left shift 1 by i times and then negate the whole number.
	 * This gives us a number with all bits set to 1 except ith bit set to 0. Finally, we perform an & operation
	 * with the given number to clear the bit at ith position.
	 */
	private static int clearBit(int num, int i) {
		return num & ~(1 << i);
	}
	
	/*
	 * To clear all bits form MSB (right most) through ith position, we first shift 1 by i times.
	 * This gives us a number with all bits set to 0 except the bit at ith position. Now we subtract
	 * 1 from this number, which gives us a new number consisting of all 0's except the bits from 0th position to
	 * (i - 1) position. We finally perform an & operation of this number with the given number. 
	 */
	private static int clearFromMSBit(int num, int i) {
		int mask = (1 << i) - 1;
		return num & mask;
	}
	
	/*
	 * To clear all bits from 0 to ith position.
	 * create mask1 of type (i = 2) - 0000100
	 * create mask2 of type (mask 1 -1) - 0000011
	 * perform ~(mask1 | mask2) - 1111000
	 * perform & operation with the given number. 
	 */
	private static int clearThroughI(int num, int i) {
		int mask1 = (1 << i);
		int mask2 = mask1 - 1;
		int mask3 = ~(mask1 | mask2);
		
		return num & mask3;
	}
}
