package myMath;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;

import javax.swing.plaf.synth.SynthSpinnerUI;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * 
 * @author Mor Danino and Karin Aharon
 *
 */
public class Polynom implements Polynom_able{
	private ArrayList<Monom> list=new ArrayList<Monom>();

	@Override

	/** 
	 * This function calculates the value of Y at the point X
	 * @param x the point at which the Y value is calculated
	 * @return the function returns the value of Y at X point
	 */
	public double f(double x) {

		Iterator<Monom> it = this.list.iterator();
		double sum = 0;
		while (it.hasNext()) {
			Monom m = it.next();
			sum = sum + m.f(x);
		}
		return sum;
	}

	/** 
	 * The Polynom constructor
	 */
	public Polynom () {

		this.list=new ArrayList<Monom> ();

	}

	/**
	 * The copy constructor
	 * @return new Polynom which received the values of the default Polynom
	 */
	@Override
	public Polynom_able copy() {

		Polynom other = new Polynom();
		Iterator<Monom> it = this.list.iterator();
		while (it.hasNext()) {
			other.add(it.next());
		}	
		return other;
	}
	/**
	 * This function received a String and change it to Polynom
	 * @param p any string which received from the user
	 */

	public Polynom(String p) {
		Polynom pol=new Polynom();
		String[] str=p.split("\\+");
		for (int i = 0; i < str.length; i++) {
			Monom m=new Monom (str[i]);
			this.list.add(m);
		}
		for (int i =0 ;i<list.size();i++) {
			for (int j=i+1;j<list.size();j++) {
				if (list.get(i).get_power()==list.get(j).get_power()) {
					list.get(i).add(list.get(j));
					list.remove(j);
				}
			}
			Monom_Comperator M = new Monom_Comperator();
			this.list.sort(M);
		}
		pol.copy();
	}

	/**
	 * This function adds any Polynom_able to another Polynom
	 * @param p1 any Polynom which received from the user
	 */
	@Override
	public void add(Polynom_able p1) {

		Iterator<Monom> it = p1.iteretor();

		while (it.hasNext()) {
			Monom m = it.next();
			add(m);
		}
		for(int i = 0 ; i<list.size(); i++) {
			if (list.get(i).get_coefficient()==0)
				list.remove(i);
		}
	}

	/**
	 * This function adds any Monom to Polynom
	 * @param m1 any Monom which received from the user
	 */
	@Override
	public void add(Monom m1) {

		boolean flag=true;

		for (int i = 0 ; i < list.size() ; i++ ) {

			if ( m1.get_power()==list.get(i).get_power()) {
				list.get(i).add(m1);
				flag= false;
			}

		}

		if (flag) 
			list.add(m1);
		Monom_Comperator mc = new Monom_Comperator();

		for(int i = 0 ; i<list.size(); i++) {
			if (list.get(i).get_coefficient()==0)
				list.remove(i);
		}

		this.list.sort(mc);

	}

	/**
	 *  * This function subtracts any Monom from Polynom
	 * @param m1 any Monom which received from the user
	 */
	public void sub(Monom m1) {

		boolean flag=true;

		for (int i = 0 ; i < list.size() ; i++ ) {

			if ( m1.get_power()==list.get(i).get_power()) {
				list.get(i).sub(m1);
				flag= false;
			}
		}

		if (flag) 

			list.add(m1);

		Monom_Comperator mc = new Monom_Comperator();

		for(int i = 0 ; i<list.size(); i++) {
			if (list.get(i).get_coefficient()==0)
				list.remove(i);
		}

		this.list.sort(mc);

	}

	/**
	 * This function subtracts any Polynom_able from Polynom
	 * @param p1 any Polynom which received from the user
	 */
	@Override
	public void substract(Polynom_able p1) {

		Iterator<Monom> it = p1.iteretor();

		while (it.hasNext()) {
			Monom m = it.next();
			sub(m);
		}
		for(int i = 0 ; i<list.size(); i++) {
			if (list.get(i).get_coefficient()==0)
				list.remove(i);
		}
	}

	/**
	 * This function multiplies any Polynom_able with another Polynom
	 * @param p1 any Polynom_able which received from the user
	 */
	@Override

	public void multiply(Polynom_able p1) {

		ArrayList<Monom> temp = new ArrayList<>(); 
		Iterator<Monom> it = p1.iteretor();
		while (it.hasNext()) {
			Monom m1 = it.next();
			for (int i = 0 ; i < list.size() ; i++ ) {
				Monom m2 = new Monom(list.get(i));
				m2.multiply(m1);
				temp.add(m2);
			}
		}	
		for(int i = 0 ; i<temp.size(); i++) {
			if (temp.get(i).get_coefficient()==0)
				temp.remove(i);
		}
		ArrayList<Monom> temp2 = new ArrayList<>();
		for(int i = 0 ; i<temp.size(); i++) {
			Monom m3 = temp.get(i);
			temp2.add(m3);
			Monom_Comperator mc = new Monom_Comperator();
			temp2.sort(mc);
		}

		Polynom p = new Polynom();
		for(int i = 0; i<temp2.size(); i ++) {
			p.add(temp2.get(i));
		}

		ArrayList<Monom> temp3 = new ArrayList<>(); 
		Iterator<Monom> it2 = p.iteretor();
		while (it2.hasNext()) {
			Monom m = it2.next();
			temp3.add(m);
		}
		this.list = temp3;
	}

	/**
	 * This function checks if the Polynom_able which received from the user equal to another Polynom_able
	 * @param p1 Polynom_able which received from the user
	 * @return if those Polynoms are equal
	 */

	@Override
	public boolean equals(Polynom_able p1) {

		Iterator<Monom> it = p1.iteretor();
		int counter = 0;

		while (it.hasNext()) {
			Monom m = it.next();
			counter++;

			boolean flag=false;

			for (int i = 0 ; i < list.size() ; i++ ) {
				if ( list.get(i).get_power()== m.get_power() && list.get(i).get_coefficient()== m.get_coefficient()) 
					flag = true;
			}

		}

		if (counter == list.size())
			return true;
		else
			return false;
	}

	/**
	 * This function checks if the Polynom contains just zero
	 * @return if its true or not
	 */
	@Override
	public boolean isZero() {

		Iterator <Monom> it = list.iterator();
		while (it.hasNext()) {
			if (it.next().get_coefficient()!=0) {
				return false;		
			}
		}
		return true;
	}

	/**
	 * This function finds the point of intersection with the x axis
	 * @param x0 the first point which received from the user
	 * @param x1 the second point which received from the user
	 * @param eps the point range which received from the user
	 * @return the point of intersection with the x axis
	 */
	@Override
	public double root(double x0, double x1, double eps) {

		if (f(x0)*f(x1)>0) {
			throw new RuntimeException("Error, there is no root in root function in class Polynom");	
		}
		double temp=0;

		if(x0>x1) {
			temp=x0;
			x0=x1;
			x1=temp;
		}
		double x2 = (x1+x0)/2;

		if (Math.abs(f(x2))<=eps)
			return x2;

		while (Math.abs(f(x2))>eps) {

			if (f(x2)>0) 
				x1 = x2;

			else
				x0 = x2;

			x2=(x1+x0)/2;
		}
		return x2;	
	}

	/**
	 * This function returns string of Polynom
	 * @return string of Polynom
	 */
	public String toString (){
		String s="[";
		Iterator<Monom> it = list.iterator();
		while(it.hasNext())
		{
			s=s+it.next().toString() + ",";
		}
		s+="]";
		return s;
	}

	/**
	 * This function calculates the derivative of the Polynom
	 * @return the derivative of the Polynom
	 */
	@Override
	public Polynom_able derivative() {

		Polynom p = new Polynom();

		Iterator<Monom> it = this.list.iterator();
		while (it.hasNext()) {
			Monom m = it.next();
			p.add(m.derivative());
		}	
		
		return p.copy();

	}


	/**
	 * This function assuming (f(x0)*f(x1) smaller or equal 0
	 * @param x0 the first point which received from the user
	 * @param x1 the second point which received from the user
	 * @param eps the point range which received from the user
	 * @return f(x2) such that: (i) x0 smaller or equal x2 smaller or equal x1  (ii) f(x2) smaller than eps
	 */
	@Override
	public double area(double x0, double x1, double eps) {

		int rec = (int)((x1-x0)/eps);
		double sum = 0;
		for (int i=1; i<=rec ; i++) {
			double x = x0 + eps*(i-1);
			if (this.f(x)>0)
				sum = sum + this.f(x);
		}
		return sum*eps;
	}

	/**
	 * This function permit use with Iterator
	 * @return the Iterator
	 */
	@Override
	public Iterator<Monom> iteretor() {

		return this.list.iterator();
	}

}


