/**
 * 
 */
package coinchangeproblem;

/**
 * @author Rahul
 *
 */
import java.util.HashMap;
import java.util.Objects;

public class CoinChange {
	class AmountDenom {
		int amount;
		int denom;

		public AmountDenom(int amount, int denom) {
			this.amount = amount;
			this.denom = denom;
		}

		@Override
		public int hashCode()
		{
			return Objects.hash(this.amount, this.denom);
		}

		@Override
		public boolean equals(Object obj){
			if (obj instanceof AmountDenom) {
				AmountDenom keyObj = (AmountDenom) obj;
				return (keyObj.amount == this.amount && keyObj.denom == this.denom);
			} else {
				return false;
			}
		}
	}

	public int countNumberOfWays(int amount, int denom, HashMap<AmountDenom, Integer> numberOfWays) {

		if (denom == 1) {
			numberOfWays.put(new AmountDenom(amount, denom), 1);
			return 1;
		}

		int nextDenom = 0;

		if (denom == 20) {
			nextDenom = 10;
		} else if (denom == 10) {
			nextDenom = 5;
		} else if (denom == 5) {
			nextDenom = 1;
		}


		int numberOfCoins = 0, ways = 0, modifiedAmount;
		while ((numberOfCoins*denom) <= amount) {
			modifiedAmount = amount - (numberOfCoins*denom);

			if (numberOfWays.get(new AmountDenom(modifiedAmount, denom)) != null) {
				ways += numberOfWays.get(new AmountDenom(modifiedAmount, denom));
			} else {
				ways += countNumberOfWays(modifiedAmount, nextDenom, numberOfWays);
			}
			
			numberOfCoins += 1;
		}
		
		numberOfWays.put(new AmountDenom(amount, denom), ways);
		return ways;
	}

	public int countNumberOfWays(int amount, int denom) {

		if (denom == 1) {
			return 1;
		}

		int nextDenom = 0;

		if (denom == 20) {
			nextDenom = 10;
		} else if (denom == 10) {
			nextDenom = 5;
		} else if (denom == 5) {
			nextDenom = 1;
		}


		int numberOfCoins = 0, ways = 0;
		while ((numberOfCoins*denom) <= amount) {
			ways += countNumberOfWays(amount - (numberOfCoins*denom), nextDenom);
			numberOfCoins += 1;
		}

		return ways;
	}


	public static void main(String[] args) 
	{
		CoinChange solution = new CoinChange();

		int amount = 20;
		HashMap<AmountDenom, Integer> numberOfWays = new HashMap();
		System.out.println("Number of ways of making change for 20 using denominations of 20,10,5 and 1 are:\n"  + solution.countNumberOfWays(amount, 20, numberOfWays));
	}
}