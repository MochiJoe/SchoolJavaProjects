import java.awt.Color;
import java.awt.Graphics;
/*
 * Nolaundron 'Ray' Harris
 * Animation "Motion Graphics"
 * CSC 142 Winter 2018
 * 
 * I am in the starting process of a personal 
 * project to recreate motion graphics used
 * by my favorite music group Perfume.
 * 
 */

public class Animation2 {

	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(1921, 1081);
		panel.setBackground(Color.BLACK);
		Graphics g = panel.getGraphics();
		shipDoors(panel,g);
		//shipDoors(panel,g);
		//shipDoors(panel,g);
		//splitScreen(panel, g, -25, 540, 5, 5);
		//splitScreen2(panel, g, -25, 540, 5, 5);
		//splitScreen3(panel, g, 1920, 0, -5, 5);
		//panel.clear();
		drawTri(panel,g);
	}
	public static void shipDoors(DrawingPanel panel, Graphics g) {
		
		for (int xini = 0; xini <= 10; xini++){
			if(xini != 5) {
				int xi = xini * 160;
				drawingLine(panel, g, xi, 190, xi * 2, 190);
				drawFilled(panel, g, xi, 190, xi * 2, 190);
				panel.clear();
			}
			
		}
		//I just kept all of this to show how I condensed it up above
		
		/*drawingLine(panel, g, 0, 190, 160, 190);
		drawFilled(panel, g, 0, 190, 160, 190);
		drawingLine(panel, g, 160, 190, 320, 190);
		drawFilled(panel, g, 160, 190, 320, 190);
		drawingLine(panel, g, 320, 190, 480, 190);
		drawFilled(panel, g, 320, 190, 480, 190);
		drawingLine(panel, g, 640, 190, 800, 190);
		drawFilled(panel, g, 640, 190, 800, 190);
		//drawingLine(panel, g, 800, 190, 960, 190);
		//drawFilled(panel, g, 800, 190, 960, 190);
		drawingLine(panel, g, 960, 190, 1120, 190);
		drawFilled(panel, g, 960, 190, 1120, 190);
		drawingLine(panel, g, 1120, 190, 1280, 190);
		drawFilled(panel, g, 1120, 190, 1280, 190);
		drawingLine(panel, g, 1280, 190, 1440, 190);
		drawFilled(panel, g, 1280, 190, 1440, 190);
		drawingLine(panel, g, 1440, 190, 1600, 190);
		drawFilled(panel, g, 1440, 190, 1600, 190);
		drawingLine(panel, g, 1600, 190, 1760, 190);
		drawFilled(panel, g, 1600, 190, 1760, 190);
		//drawingLine(panel, g, 1760, 190, 1920, 190);
		//drawFilled(panel, g, 1760, 190, 1920, 190);
		panel.clear();
		//drawingLine(panel, g, 1920, 270, 1940, 270);
		*/
	}
	public static void drawingLine(DrawingPanel panel, Graphics g, int xi, int yi, int xf, int yf) {
		for (int i = 0; i <= 2; i++) {
			panel.clear();
			g.setColor(Color.CYAN);
			g.drawRect(xi, yi, 315, 640);
			panel.sleep(10);
			g.setColor(Color.CYAN);
			g.drawRect(1600 - xi, yi, 315, 640);
			panel.sleep(5);
		}
		}
	public static void drawFilled(DrawingPanel panel, Graphics g, int xi, int yi, int xf, int yf) {
		for (int i = 0; i <= 2; i++) {
			panel.clear();
			g.setColor(Color.WHITE);
			g.fillRect(xi, yi, 315, 640);
			panel.sleep(10);
			g.setColor(Color.WHITE);
			g.fillRect(1600 - xi, yi, 320, 640);
			panel.sleep(5);
		
	}
	}
	public static void splitScreen(DrawingPanel panel, Graphics g, int x0, 
			int y0, int dx, int dy) {
			
		for (int i = 0; i <= 384; i++){
						
			g.setColor(Color.CYAN);
			
			g.fillOval(dx * i + x0, y0, 50, 15);
			panel.sleep(1);
			
		}
		panel.clear();
	}
		public static void splitScreen2(DrawingPanel panel, Graphics g, int x0,
				int y0,	int dx, int dy) {
			for (int i = 0; i <= 384; i++){
							
				g.setColor(Color.WHITE);
				
				g.fillOval(dx * i + x0, y0, 50, 540);
				panel.sleep(1);
		}
			//panel.clear();
	}
		public static void splitScreen3(DrawingPanel panel, Graphics g, int x0,
				int y0,	int dx, int dy) {
			for (int i = 0; i <= 390; i++){
				//panel.clear();
				
				g.setColor(Color.GRAY);
				
				g.fillOval(dx * i + x0, y0, 50, 540);
				panel.sleep(1);				
			}			
		}
		
		
		public static void drawTri(DrawingPanel panel, Graphics g) {
			int x1[] = {0,190};
			int y1[] = {0,20};
			g.setColor(Color.CYAN);
			g.drawPolygon(x1,y1,20);
			//panel.clear();
			
		}
}

