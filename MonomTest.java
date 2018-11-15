package myMath;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MonomTest {

	@Test
	/**
	 * checking multiply function
	 */
	void testMultiply1(){
		
		double c1 = Math.random()*100+1;
		int p1 = (int)(Math.random()*100+1);
		Monom m1 = new Monom (c1,p1);
		
		double c2 = Math.random()*100+1;
		int p2 = (int)(Math.random()*100+1);
		Monom m2 = new Monom (c2,p2);
		
		m1.multiply(m2);
		
		assertEquals(c1*c2,m1.get_coefficient()); 
		assertEquals(p1+p2,m1.get_power());
		
		double c3 = Math.random()*100+1;
		int p3 = (int)(Math.random()*100+1);
		Monom m3 = new Monom (c3,p3);
		
		double c4 = Math.random()*100+1;
		int p4 = (int)(Math.random()*100+1);
		Monom m4 = new Monom (c4,p4);
		
		m3.multiply(m4);

		assertNotEquals(-(c3*c4),m3.get_coefficient()); 
		assertNotEquals(-(p1+p2),m3.get_power());
	}

	@Test
	/**
	 * checking derivative function
	 */
	void testDerivative(){

		double c = Math.random()*100+1;
		int p = (int)(Math.random()*100+1);
		Monom m = new Monom (c,p);
        m.derivative();
		assertEquals(p*c,m.get_coefficient() );
		assertEquals(p-1,m.get_power());

	}
	@Test
	/**
	 * checking the constructor of Monom
	 */
	void testMonom() {
		Monom m1 = new Monom (2,8);
		Monom m2 = new Monom(m1);
		assertEquals(2, m2.get_coefficient());
		assertEquals(8, m2.get_power());
	
	}
	@Test
	/**
	 * checking add function
	 */
	void testAddMonom() {

		Monom m1 = new Monom (3,2);
		Monom m2 = new Monom (5,2);
		m1.add(m2);

		assertEquals(8,m1.get_coefficient() );
		assertEquals(2, m1.get_power());
	}
	@Test
	/**
	 * checking f function
	 */
	void testFunction() {
		Monom m = new Monom (4,2);
		double actual= m.f(2);
		double expected = 4 * Math.pow(2, 2);
		assertEquals(expected,actual);

	}
	@Test
	/**
	 * checking sub function
	 */
	void testSub() {
		Monom m1 = new Monom(4,6);
		Monom m2 = new Monom(3,6);
		m1.sub(m2);

		assertEquals(1, m1.get_coefficient());
		assertEquals(6, m1.get_power());

		Monom m3 = new Monom(5,7);
		Monom m4 = new Monom(6,7);
		m3.sub(m4);
		assertNotEquals(1, m3.get_coefficient());
		assertNotEquals(6, m3.get_power());
	}

	@Test
	/**
	 * checking get_power function
	 */
	void testGetPower() {
		Monom m = new Monom(3,4);
		assertEquals(4, m.get_power());
	}
	@Test
	/**
	 * checking get_coffienet function
	 */
	void testGetCoffienet() {
		Monom m = new Monom(8,5);
		assertEquals(8, m.get_coefficient());
	}
	@Test
	/**
	 * checking the function Monom which received String
	 */
	void testMonomString() {
		Monom m1 =new Monom("5x^3");
	assertEquals(5, m1.get_coefficient());
	assertEquals(3, m1.get_power());
	}
	
}
