package myMath;

import java.awt.Color;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JFrame;

import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.ui.InteractivePanel;


public class Graph_Polynom extends JFrame{         

	private static final long serialVersionUID = 1L;

	/* In order to create a graph as accurately as possible we need: extreme points. 
	 * This function calculates the extreme points and builds a graph.
	 * In addition, this function computes space according to the required instructions.
	 * The function received String of polynom, start x, end x, and epsilon.
	 * if start x bigger or equal end x the user will get an error */

	
	public Graph_Polynom(Polynom pol, double x0, double x1, double eps) {   
          
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(600,600);

			DataTable data = new DataTable(Double.class, Double.class);
			DataTable data_extremum= new DataTable(Double.class, Double.class);

			Polynom p = (Polynom) pol.copy();  // Copy the polynom to a new polynom
			Iterator<Monom> it = p.iteretor();
			Polynom copy = new Polynom();
			while (it.hasNext()) {
				Monom m = it.next();
				copy.add(m);
			}

			for(double x=x0; x<=x1; x=x+eps) {      
				double y= p.f(x);
				data.add(x,y);
			}

			Polynom_able der = p.derivative();  // derivative Polynom

			for(double x = x0; x <= x1; x = x+eps) { //finding the extreme points

				Double fx1=der.f(x);
				Double fx2 = der.f(x+eps);

				if(fx1*fx2<0) {
					double X_point = der.root(x, x+eps,eps);
					double Y_point = p.f(X_point);

					data_extremum.add( X_point,Y_point);					
					System.out.println("the kitzon point: "+"("+X_point+" , " +Y_point+")");	
				}

			}

			double areaup = p.area2(x0, x1,eps);  //finding the area		

			System.out.println("the area is: "+ areaup);

			XYPlot plot= new XYPlot(data,data_extremum);

			Color color= new Color(0.7f,0.0f,0.9f);  //painting the extreme points and the graph
			plot.getPointRenderers(data_extremum).get(0).setColor(Color.green);
			plot.getPointRenderers(data).get(0).setColor(Color.black);

			getContentPane().add(new InteractivePanel(plot));
			LineRenderer lines= new DefaultLineRenderer2D();
			plot.setLineRenderers(data, lines);
		
	}
}
