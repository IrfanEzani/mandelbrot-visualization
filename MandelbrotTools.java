import java.awt.Color;

public class MandelbrotTools {
	
	/* 
	 * STATIC METHOD
	 *
	 * The method computes a^2 + b^2 and compares this to 
	 * Controller.DIVERGENCE_BOUNDARY. Returns true if its bigger than the
	 * DIVERGENCE_BOUNDARY variable and false otherwise.
	 * 
	 * a is the real value while b is the imag value.
	 * The calculation result is then stored into MyDouble object named ans.
	 * This is then compared to the DIVERGENCE_BOUNDARY variable.
	 * 
	 * Method uses MyDouble's multiply, add, compareTo method.
	 * 
	 * Method takes a ComplexNumber object parameter.
	 * Returns a boolean condition.
	 */
	public static boolean isBig(ComplexNumber c) {
		MyDouble ans = (c.getReal().multiply(c.getReal())).
		add(c.getImag().multiply(c.getImag()));

		return (ans.compareTo(Controller.DIVERGENCE_BOUNDARY) > 0);
	}

    
	/* 
	 * STATIC METHOD
	 *
	 * This method calculates a sequence of complex numbers z1, z2, z3,etc.
	 *  as follows:
	 *	z1 = (z0)^2 + z0           
	 *	z2 = (z1)^2 + z0
	 *	z3 = (z2)^2 + z0
	 *	z4 = (z3)^2 + z0
	 *	etc.
	 *
	 * Hence, a ComplexNumber object named original stores the z0 value
	 * (which is the starting value). A counter named zCounter is also
	 * created to count numbers of iteration.
	 * 
	 * while the value of z in isBig is still false,
	 * the calculation will continue running.
	 * if the value of z is big enough, and isBig(z) returns true, 
	 * the last zCounter value is returned.
	 * 
	 * However, if no value of z reaches can break the loop guard 
	 * (isBig(z) stays false), then check if the counter of iteration
	 * is bigger than the Controller.LIMIT. If it's bigger,then set
	 * the value of zCounter is set to -1 and the the loop is broken by break.
	 * Then the value of current zCounter is returned.
	 * 
	 */
	public static int divergence(ComplexNumber z) {
		ComplexNumber original = z;
		int zCounter = 0; 
		while (isBig(z) != true) {
			z = (z.multiply(z)).add(original);
			zCounter++;

			if(zCounter > Controller.LIMIT) {
				zCounter = -1;
				break;
			}
		}
		return zCounter;
	}

	
	
	
	/* This method selects a non-black color for a point which DIVERGED when 
	 * tested with the Mandelbrot recurrence, based on how many terms in the 
	 * sequence were computed before the terms got "too big".
	 * 
	 * The parameter represents the index of the term in the sequence 
	 * which was first to be "too big". This value could be anything from 0 
	 * to Controller.LIMIT.  The return value is the Color to be used 
	 * to color in the point.
	 * 
	 * STUDENTS:  IF you want to have some fun, write code for the else-if 
	 * clause below which says "modify this block to create your own color 
	 * scheme".  When someone runs the program and selects 
	 * "Student Color Scheme", the code you have written below will determine
	 *  the colors.
	 */
	public static Color getColor(int divergence) {
		Color returnValue;
		
		if (Controller.colorScheme == Controller.RED_AND_WHITE_BANDS) {
			returnValue = (divergence  % 2 == 0)? Color.WHITE : Color.RED;
		}
		
		else if (Controller.colorScheme == Controller.CRAZY_COLORS) {
			int value = divergence * 2;
			int redAmount = (value % 5) * (255/5);
			int greenAmount = (value % 7) * (255/7);
			int blueAmount = (value % 9) * (255/9);
			returnValue = new Color(redAmount, greenAmount, blueAmount); 
		}
		
		else if (Controller.colorScheme == Controller.STUDENT_DEFINED){
			returnValue = Color.WHITE;  
		}
		else
			throw new RuntimeException("Unknown color scheme selected!");
		return returnValue;
	}
	

}
