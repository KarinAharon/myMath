package myMath;
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * checking Monom function	
		 */
		Monom m1 = new Monom(4,2);         
		System.out.println("The Monom m1 is: "+m1);

		Monom m2 = new Monom(-3,2);
		System.out.println("The Monom m2 is: "+m2);

		/**
		 * checking F function
		 */
		System.out.println("The result supposed to be 36.0: "+m1.f(3));

		/**
		 * checking add function
		 */
		Monom m3 = new Monom(m1);
		m3.add(m1);
		System.out.println("The Monom m3 is: "+m3);

		/**
		 * checking Monom function which get string
		 */
		Monom m4=new Monom("-4*x^4");
		System.out.println("The Monom m4 is: "+m4);

		Monom m5=new Monom("5x^-6");
		System.out.println("The Monom m5 is: "+m5);

		/**
		 * checking the derivative function
		 */

		m4.derivative();
		System.out.println("The derivative of Monom m4 is: "+m4);

		Monom m6 = new Monom(0,2);
		System.out.println("The result supposed to be 0.0: "+m6);
		m6.derivative();
		System.out.println("The result supposed to be 0.0: "+m6);

		/**
		 * checking sub function
		 */
		Monom m7 = new Monom (5,2);
		m1.add(m7);
		System.out.println("The result supposed to be 9x^2: "+m1);

		Monom m8 = new Monom(-4,2);
		m1.sub(m8);
		System.out.println("The result supposed to be 13.0x^2: "+m1);

		Monom m9 = new Monom (3,3);
		m1.sub(m9);
		System.out.println(m1);

		/**
		 * checking multiply function
		 */
		m9.multiply(m6);
		System.out.println("The result supposed to be 0.0: "+m9);

		m8.multiply(m7);
		System.out.println("The result supposed to be -20.0x^4: "+m8);

		Monom m10 = new Monom (3,5);
		Monom m11 = new Monom (-3,5);
		m10.multiply(m11);
		System.out.println("The result supposed to be -9.0x^10: "+m10);

		/**
		 * checking "get coefficient" function
		 */
		System.out.println("The coffieent supposed to be -3.0: " + m11.get_coefficient());

		/**
		 * checking "get power" function
		 */

		System.out.println("The power supposed to be 5.0: " +m11.get_power());

		/**
		 * checking Polinom constructor
		 */
		Polynom_able p2 = new Polynom();
		System.out.println("The polynom supposed to be empty polynom: " +p2);

		/**
		 * checking add function which received Monom 
		 */
		Monom m = new Monom(2,3);
		p2.add(m);
		System.out.println("The polynom supposed to be [2.0x^3]: " +p2);

		/**
		 * checking F function
		 */
		System.out.println("The result supposed to be 16.0: "+p2.f(2));

		/**
		 * checking copy constructor
		 */
		Polynom_able p3 = new Polynom();
		System.out.println("The polynom supposed to be empty Polynom: "+p3.copy());
		
		Polynom_able p20 = new Polynom("x^4+8");
		System.out.println("The copy is: "+p20.copy());
		

		/**
		 * checking sub function which received Monom
		 */
		Monom m12 = new Monom(3,4);
		Polynom p4 = new Polynom();
		p4.add(m12);
		Monom m13 = new Monom(4,5);
		p4.sub(m13);
		System.out.println("The polynom supposed to be [3.0x^4,4.0x^5]: "+p4);

		/**
		 * checking isZero function
		 */
		Polynom p5 = new Polynom();
		p5.add(m12);
		p5.add(m13);
		System.out.println("The answer supposed to be false: "+ p5.isZero());

		Polynom p6 = new Polynom();
		System.out.println("The answer supposed to be true: "+p6.isZero());

		/**
		 * checking area function
		 */
		Polynom p7 = new Polynom("3*x^5+4*x^7");
		System.out.println("The area supposed to be 30582.92000038682: "+p7.area(3, 4, 0.02));

		Polynom p8 = new Polynom("3*x^4+8x+2");
		System.out.println("The area supposed to be 34410.49451658029: "+p8.area(4, 9.0, 0.03));

		System.out.println("The answer supposed to be true: "+p7.equals(p8));

		/**
		 * checking equal function
		 */

		Polynom p9 = new Polynom("3*x^4+8x+2");
		Polynom p10 = new Polynom ("3*x^5+4*x^7");
		Polynom p11 = new Polynom ("3*x^5+4*x^7");
		System.out.println("The answer supposed to be true: "+ p10.equals(p11));
		System.out.println("The answer supposed to be false: "+ p9.equals(p11));

		/**
		 * checking add function which received Polynom
		 */
		p9.add(p10);
		System.out.println("The result supposed to [2.0,8.0x,3.0x^4,3.0x^5,4.0x^7]: " +p9);

		Polynom p12 = new Polynom("3*x^4+8x+2");
		Polynom p13 = new Polynom ("2*x^4+4*x^7");
		p12.add(p13);
		System.out.println("The result of add supposed to be [2.0,8.0x,5.0x^4,4.0x^7]: "+p12);

		/**
		 * checking substract function which received Polynom
		 * 
		 */
		Polynom p14 = new Polynom("3*x^4+8x^7+8");
		Polynom p15 = new Polynom ("2*x^4+4*x^7");
		p14.substract(p15);
		System.out.println("The result of substract supposed to be [2.0,8.0x,5.0x^4,4.0x^7] : "+p14);

		/**
		 * checking substract function which received Monom
		 * 
		 */
		Monom m14 = new Monom (2,7);
		p15.sub(m14);
		System.out.println("The result of substract supposed to be [2.0x^4,2.0x^7] : "+ p15);

		/**
		 * checking multiply function which received Polynom
		 * 
		 */
		Polynom p16=new Polynom("x^3+-5");
		Polynom p17=new Polynom("x+5+x^4");
		p16.multiply(p17);
		System.out.println("The result of multiply supposed to be [-25.0,-5.0x,5.0x^3,-4.0x^4,1.0x^7]: "+p16);


		/**
		 * checking derivative function on Polynom
		 */
		Polynom p18 = new Polynom("2*x^4+X+1");
		p18.derivative();
		System.out.println("The result of derivative supposed to be [1.0,1.0x,2.0x^4]: "+p18);
		
		
		/** 
		 * checking root function
		 */
		Polynom p19=new Polynom ("x+-5");
		System.out.println("The root supposed to be 5.0: "+p19.root(2, 8, 0.01));
		
		/**
		 * checking Graph function
		 */
		Polynom p21 = new Polynom ("0.2x^4+-1.5X^3+3x^2+-x+-5");
		p21.Graph(-2,6,0.01);
	


	}

}
