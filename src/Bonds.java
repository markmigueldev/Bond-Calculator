/**
 * 
 * @author Mark
 *	Calculates the effects of interest rate change in Bonds.
 *	When the interest rate drops, the price of our bond increases.
 *	When the interest rate increases, the price of our bond drops.
 *	The longer the years to maturity, the more significant is the price change.
 *	The shorter the years to maturity, the less significant is the price changes.
 */
public class Bonds {
	public double calculate(double coupon, double par, int year, double r) {
		r=r/100.0;
		double base = Math.pow(r+1, year);
		double c = coupon*((1-(1/base))/r)+par/base; 
		return c;
	}
	
	public static void main(String[] s) {
		Bonds b = new Bonds();
		System.out.println(b.calculate(1, 1, 2, 2));
	}
}
