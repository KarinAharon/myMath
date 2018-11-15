package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PolynomTest {

	@Test
	/**
	 * checking f function
	 */
	void testFunction() {
		Polynom p = new Polynom ("4*x^2+3*x");
		double result= p.f(2);
		assertEquals(22,result);		
	}
	@Test
	/**
	 * checking copy function
	 */
	void testPolynom_ableCopy() {
		Polynom p1 = new Polynom("2x^3+3*x^5");
		Polynom_able p2 = p1.copy();

		if(!(p1.equals(p2)))
			fail("error: the polynomial are not the same");	
	}

	@Test
	/**
	 * checking add function
	 */
	void testAdd(){
		Polynom p1 = new Polynom ("2x^2+3x^3+5");
		Polynom p2 = new Polynom ("8x^2+3x^9+5");
		p1.add(p2);
		Polynom result=new Polynom ("10+10x^2+3x^3+3x^9");
		if((!result.equals(p1)))
			fail("error:the polynomial are not the same ");
	}
	@Test
	/**
	 * checking substract function
	 */
	void testSubstract() {
		Polynom p1 = new Polynom ("2x^2+3x^3+5");
		Polynom p2 = new Polynom ("8x^2+3x^9+5");
		p2.substract(p1);
		Polynom result=new Polynom ("6x^2+-3x^3+3x^9");
		if((!result.equals(p1)))
			fail("error:the polynomial are not the same ");
	}
	@Test
	/**
	 * checking multiply function
	 */
	void testMultiply() {
		Polynom p1 = new Polynom ("2x^2+3x^3");
		Polynom p2 = new Polynom ("5+3x^9");
		p2.multiply(p1);
		Polynom result=new Polynom ("6x^11+9x^12+10x^2+15x^3");
		if((!result.equals(p2)))
			fail("error:the polynomial are not the same ");
	}
	@Test
	/**
	 * checking equal function
	 */
	void testEquals() {
		Polynom p1 = new Polynom ("2x^2+3x^3");
		Polynom p2 = new Polynom ("2X^2+3X^3");
		boolean eq=p2.equals(p1);
		assertTrue(eq);
	}
	@Test
	/**
	 * checking iszero function
	 */
	void testIsZero() {
		Polynom zero= new Polynom ("0+0x^2");
		boolean flag=zero.isZero();
		assertTrue(flag);
	}
	@Test
	/**
	 * checking root function
	 */
	void testRoot() {
		double x0 = 2;
		double x1 = 8;
		double eps = 0.01;
		Polynom p =new Polynom ("x+-5");
		double result = p.root(x0, x1, eps);
		assertEquals(5.0, result);
	}

	@Test
	/**
	 * checking derivative function
	 */
	void testDerivative() {
		Polynom p = new Polynom("3x^3+5x^6+-2x");
		Polynom_able der = p.derivative();
		Polynom result = new Polynom("9x^2+30x^5+-2");
		if(!der.equals(result))
			fail("error:the polynomial are not the same ");
	}

	@Test
	/**
	 * checking area function
	 */
	void testArea() {
		double x0 = 3;
		double x1 = 4;
		double eps = 0.02;
		
		Polynom p = new Polynom("3*x^5+4*x^7");
		double result = p.area(x0, x1, eps);
		
		assertEquals(30582.92000038682, result);
		
	}

}
