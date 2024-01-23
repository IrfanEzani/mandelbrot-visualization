import java.awt.geom.Rectangle2D;


public class Controller  {
	
	public final static int RED_AND_WHITE_BANDS = 0;
	public final static int CRAZY_COLORS = 1;
	public final static int STUDENT_DEFINED = 2;
	
	public static int colorScheme;   
	
	public static int LIMIT = 255; 
	
	public final static MyDouble DIVERGENCE_BOUNDARY = new MyDouble(4.0); 
	// If the norm of a term in the Mandelbrot recurrence exceeds the square root of this value
	// we conclude that the sequence diverges.
	
	public static void main(String[] args) {
		new MyDialogBox();
		Rectangle2D.Double drawingZone = new Rectangle2D.Double(-2, 1, 3, 2);
		
		MyMouseListener mouseListener = new MyMouseListener(drawingZone); // Responds to mouse events
		View view = new View(drawingZone);                                // Frame that does the drawing
		MyComponentListener resizeListnr = new MyComponentListener(view); // Responds to resize requests
		view.registerMouseListener(mouseListener);                        // Register for callbacks
		view.registerComponentListener(resizeListnr);                     // Register for callbacks
	}
}
