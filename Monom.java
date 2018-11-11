package myMath;
/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Mor Danino and Karin Aharon
 *
 */
public class Monom implements function{

	/** 
	 * This function calculates the value of Y at the point X
	 * @param x the point at which the Y value is calculated
	 * @return the function returns the value of Y at X point
	 */
	public double f(double x) {
		return (this._coefficient * (Math.pow(x, this._power)));
	}

	/**
	 * This function initializes the values of coefficient and power
	 * @param a the coefficient
	 * @param b the power
	 */
	public Monom(double a, int b){
		this.set_coefficient(a);
		this.set_power(b);
	}

	/**
	 * Copy constructor
	 * @param ot new Monom which received the values of the default Monom 
	 */
	public Monom(Monom ot) {
		this(ot.get_coefficient(), ot.get_power());
	}

	/**
	 * This function received a String and change it to Monom
	 * @param str any string which received from the user
	 */
	
	public Monom (String str) {
		if (str.equals("")) 
			throw new RuntimeException("The Monom is valid");
		String s = str.toLowerCase();
		int vairable = s.indexOf("x");
		int power = s.indexOf("^");
		int operator = s.indexOf("*");
		double a = 0;
		int b = 0;
		if (vairable==-1) {    //אם אין איקס
			a = Double.parseDouble(s);
		}

		else {                     // אם יש איקס
			if (power==-1) {      //אם אין חזקה
				b = 1;
				String s2=s.substring(vairable+1,s.length());
				if(!s2.equals(""))
				{
					throw new RuntimeException("The Monom is invalid");
				}
				if (operator == -1) {     // אם אין כפל
					String s1=s.substring(0,vairable);
					if (s1.equals(""))              //אם אין לי כלום לפני האיקס, כלומר המקדם אחד
						a=1;
					else
						a = Double.parseDouble(s1);
				}

				else {                         // אם יש כפל
					String s1=s.substring(0,operator);
					if (s.equals(""))
						a=1;
					else
						a = Double.parseDouble(s1);			
				}
			}

			else {    //אם יש חזקה
				if (operator == -1) {     // אם אין כפל
					String snew=s;
					String s1=s.substring(0,vairable);
					String s2=snew.substring(power+1,snew.length());
					if (s1.equals("")) {            //אם אין לי כלום לפני האיקס, כלומר המקדם אחד
						a=1;
					}
					else {                                 //אם יש מקדם לאיקס
						a = Double.parseDouble(s1);
					}

					if (s2.equals("")|| s2.contains("-")) {
						try {
							throw new Exception("The Monom is invalid");
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
					else {
						b = Integer.parseInt(s2);
					}
				}

				else {                         // אם יש כפל
					String snew=s;
					String s1=s.substring(0,operator);
					String s2=snew.substring(power+1,snew.length());
					if (s1.equals("")) {                 //אם אין לי כלום לפני האיקס, כלומר המקדם אחד
						a=1;
					}
					else {                                   //אם יש מקדם לאיקס
						a = Double.parseDouble(s1);
					}
					if (s2.equals("")||Integer.parseInt(s2)<0) {
						throw new RuntimeException("The Monom is invalid");
					}
					else {
						b = Integer.parseInt(s2);
					}
				}
			}
		}
		this._coefficient=a;
		this._power=b;
	}

	/**
	 * This function calculates the derivative of the Monom
	 * @return derivative of Monom
	 */

	public Monom derivative() {
		int p  = _power;
		double c = _coefficient;

		if (this._power == 0) { 
			this._coefficient = 0;
		}
		else if (this._power < 0) {
			try {
				throw new Exception("Error, power cannot be negative");
			}
			catch (Exception e) {
				e.printStackTrace();
			}

		}
		if (this._coefficient==0) {
			this._power=0;
		}

		else {

			this._coefficient= this._power*this._coefficient;
			this._power= this._power-1;
		}

		Monom m = new Monom(c,p);
		return m;

	}

	/**
	 * This function adds any Monom to another Monom
	 * @param m any Monom which received from the user
	 */
	public void add(Monom m) {
		if (m.get_power()==this.get_power()) {
			set_coefficient(this._coefficient+m._coefficient);
		} else
			try {
				throw new Exception("Error, the power are not the same");
			} catch (Exception e) {
				e.printStackTrace();
			}

	}

	/**
	 * This function subtracts any Monom to another Monom
	 * @param m any Monom which received from the user
	 */
	public void sub(Monom m) {
		if (m.get_power()==this.get_power()) {
			set_coefficient(this._coefficient-m._coefficient);
		} else
			try {
				throw new Exception("Error, the power are not the same");
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	/**
	 * This function multiplies any Monom with another Monom
	 * @param m any Monom which received from the user
	 */
	public void multiply(Monom m) {

		set_coefficient(this._coefficient*m._coefficient);
		set_power(this._power+m._power);

	}

	/**
	 * This function returns string of Monom
	 * @return string of Monom
	 */
	public String toString() {

		if (this._power==1)
			return Double.toString(_coefficient) + "x";

		else if (this._power==0)
			return Double.toString(_coefficient) ;

		else if (this._coefficient==0)
			return Double.toString(_coefficient);
		else
			return Double.toString(_coefficient)+ "x" + "^"+ Integer.toString(_power);

	}

	/**
	 * This function gets the value of the coefficient
	 * @return the value of the coefficient
	 */

	public double get_coefficient() {
		return this._coefficient;
	}

	/**
	 * This function gets the value of the power
	 * @return value of the power
	 */
	public int get_power() {
		return this._power;
	}

	/**
	 *  This function sets the value of the coefficient
	 * @param a any coefficient which received from the user
	 */
	private void set_coefficient(double a){
		this._coefficient = a;
	}

	/**
	 * This function sets the value of the power
	 * @param p any power which received from the user
	 */
	private void set_power(int p) {
		if (p<0) {
			
			throw new RuntimeException("The Monom is not valid");
	
		}
		else
			this._power = p;
	}

	/**
	 * The variables of the this class
	 */
	private double _coefficient; 
	private int _power; 
}
