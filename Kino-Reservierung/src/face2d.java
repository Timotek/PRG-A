import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;

import javax.swing.*;

public class face2d extends JPanel {


	public static void main(String[] args) {

		
		JFrame frame = new JFrame();
		frame.add(new face2d());
		frame.setSize(700, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
	
	
	
	public void paintComponent(Graphics g){
		
		Graphics2D g2d = (Graphics2D) g;
		//g2d.drawString("Hallo", 150, 50);
		Ellipse2D.Double kreis = new Ellipse2D.Double(10, 10, 600, 600);
		Line2D horizontal = new Line2D.Double(200, 200, 590,200);
		Line2D vertikal = new Line2D.Double(200, 200, 200, 590);
		QuadCurve2D qc = new QuadCurve2D.Double(480, 558, 400, 530, 400, 440);
		
		
		
		Ellipse2D.Double auge = new Ellipse2D.Double(450, 350, 40, 40);
		g2d.fill(auge);
		
		
		
		
		
		
		g2d.draw(kreis);
		g2d.draw(auge);
		g2d.draw(horizontal);
		g2d.draw(vertikal);
		g2d.draw(qc);
		g2d.drawString("Sie haben sich erfolgreich registriert!!!", 100, 700);
		
	}

}