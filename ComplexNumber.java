
public class ComplexNumber {

	private final MyDouble real;
	private final MyDouble imag;

	// standard constructor, initialize real and imag value from parameter
	public ComplexNumber(MyDouble real, MyDouble imag) {
		this.real = real;
		this.imag = imag;
	}

	// constructor, initialize real value from parameter and set imag to 0.0
	public ComplexNumber(MyDouble real) {
		this.real = real;
		this.imag = new MyDouble(0.0);
	}

	// copy constructor
	public ComplexNumber(ComplexNumber complexNum) {
		this.real = complexNum.real;
		this.imag = complexNum.imag;
	}

	// getter for MyDouble real object, return MyDouble real.
	public MyDouble getReal() {
		return real;
	}

	// getter for MyDouble imag object, return MyDouble imag.
	public MyDouble getImag() {
		return imag;
	}

	/*
	 * Calculates sum of current object real and imag value with parameters' 
	 * real and image value. 
	 * 
	 * Calculates by adding the current object real value 
	 * with the parameters real value and adding the current object imag 
	 * value with the parameters imag value. 
	 * 
	 * Uses MyDouble add method
	 * 
	 * Method takes a ComplexNumber object as parameter
	 * Returns a ComplexNumber object.
	 */
	public ComplexNumber add(ComplexNumber compNum) {
		return new ComplexNumber(real.add(compNum.real), 
		imag.add(compNum.imag));
	}

	/*
	 * Calculates difference of current object real and imag 
	 * value with parameters' real and image value. 
	 * 
	 * Calculates by subtracting the current object real value with the 
	 * parameters imag value and subtracting the current object imag value
	 * with the parameters imag value. 
	 * 
	 * Uses MyDouble subtract method.
	 * 
	 * Method takes a ComplexNumber object as parameter
	 * Returns a ComplexNumber object.
	 */
	public ComplexNumber subtract(ComplexNumber compNum) {
		return new ComplexNumber(real.subtract(compNum.real), 
		imag.subtract(compNum.imag));
	}

	/*
	 * Calculates product of current object real and imag 
	 * value with parameters' real and image value. Uses the formula of:
	 * 
	 * Current Object:   (a+bi)
	 * Parameter Object: (c+di)
	 * Product: (ac-bd) + (ad+bc)i
	 * 
	 * Whereas a and c are real values, b and d are imag values. 
	 * realSection calculates (ac-bd)
	 * imagSection calculates (ad+bc)
	 * This then return a new Complex Number object of realSection and 
	 * imagSection.
	 * 
	 * Uses MyDouble add, subtract and multiply method to do calculations.
	 * 
	 * Method takes a ComplexNumber object as parameter
	 * Returns a ComplexNumber object.
	 */
	public ComplexNumber multiply(ComplexNumber compNum) {
		MyDouble realSection = (real.multiply(compNum.real)).
		subtract(imag.multiply(compNum.imag));

		MyDouble imagSection = (real.multiply(compNum.imag)).
		add(imag.multiply(compNum.real));

		return new ComplexNumber(realSection, imagSection);
	}

	/*
	 * Calculates quotient of current object real and imag 
	 * value with parameters' real and image value. Uses the formula of:
	 * 
	 * Current Object:   (a+bi)
	 * Parameter Object: (c+di)
	 * Quotient of both: (ac + bd)  +  (bc-ad)
	 * 					 ---------     ------- i
	 * 					(c^2 + d^2)	  (c^2 + d^2)
	 * 
	 * Whereas a and c are real values, b and d are imag values. 
	 * Divisor calculates (c^2 + d^2) 
	 * realSection calculates (ac+bd)/(c^2+d^2), uses divisor object.
	 * imagSection calculates (bc-ad)/(c^2+d^2), uses divisor object.
	 * 
	 * Uses MyDouble add, subtract, divide, multiply method to do calculations.
	 * 
	 * This then return a new Complex Number object of realSection and 
	 * imagSection.
	 * 
	 * Method takes a ComplexNumber object as parameter
	 * Returns a ComplexNumber object.
	 */
	public ComplexNumber divide(ComplexNumber compNum) {
		MyDouble divisor = (compNum.real.multiply(compNum.real)).
		add(compNum.imag.multiply(compNum.imag));

		MyDouble realSection = ((real.multiply(compNum.real)).
		add(imag.multiply(compNum.imag))).divide(divisor);
		MyDouble imagSection = ((imag.multiply(compNum.real)).
		subtract(real.multiply(compNum.imag))).divide(divisor);

		return new ComplexNumber(realSection, imagSection);
	}

	/*
	 * Checks if current object's real and imag values is equal to 
	 * the parameter's real and imag values. Returns true if all comparison
	 * is equal and return false otherwise.
	 * 
	 * Method takes a ComplexNumber object as parameter
	 * Returns a boolean value.
	 */
	public boolean equals(ComplexNumber compNum) {
		return (real.equals(compNum.real) && imag.equals(compNum.imag));
	}

	/*
	 * Compares the norm of the current object with the norm of the parameter.
	 * Norm method is from static method written below.
	 * 
	 * If both values is equal, return 0.
	 * If current object norm is less than parameter norm, return -1.
	 * If current object norm is more than parameter norm, return 1.
	 * 
	 * Uses MyDouble compareTo method.
	 * 
	 * Method takes a ComplexNumber object as parameter
	 * Returns an int value.
	 */
	public int compareTo(ComplexNumber compNum) {
		int ans = norm(this).compareTo(norm(compNum));
		if (ans == 0) {
			return 0;
		} else if (ans < 0) {
			return -1;
		} else {
			return 1;
		}
	}

	/*
	 * Overrides Java toString method. Always return the value of real
	 * and imag value with the letter i. 
	 * 
	 * First, a MyDouble object initialized as zero is created.
	 * A String for real value is created.
	 * A String for imag value is created,  a '+' sign is added to imag with 
	 * 'i' at the end of the string as default value.
	 * 
	 * If the value of imag is less than zero, the String for imag is 
	 * overidden. The new String would not contain the '+' sign, instead, 
	 * it contains the original value of imag and letter 'i'.  
	 * 
	 * Uses MyDouble compareTo method.
	 * 
	 * 
	 * Method does not take any parameter.
	 * Returns a String value.
	 */
	public String toString() {
		//initialize object to be compared later.
		MyDouble zero = new MyDouble(0.0);

		//set default values of String.
		String realStr = real.toString();
		String imagStr = ("+" + imag.toString() + "i");

		//if imag is less than zero, remove '+' sign.
		if (imag.compareTo(zero) < 0) {
			imagStr = (imag.toString() + "i");
		}
		return (realStr + imagStr);
	}

	
    /* 
	 * STATIC METHOD
	 * 
	 * Norm is calculated using this formula:
	 * 
	 * sqrt(a^2+b^2) 
	 * 
	 * a is the real value, b is the imag value.
	 *  
	 * realSection calculates a^2 using multiple method.
	 * imagSection calculates b^2 using multiple method.
	 * The value of these object is then added together and squared.
	 * Then it is returned.
	 * 
	 * Uses MyDouble multiply, add, sqrt method.
	 * 
	 * 
	 * Method takes ComplexNumber parameter.
	 * Returns a MyDouble object.
	 */
	public static MyDouble norm(ComplexNumber compNum) {
		MyDouble realSection = (compNum.real.multiply(compNum.real));
		MyDouble imagSection = (compNum.imag.multiply(compNum.imag));
		return (realSection.add(imagSection)).sqrt();
	}

    /* 
	 * STATIC METHOD
	 * 
	 * The method parses a String into a complexNumber object. 
	 * 
	 * First, any spaces is removed using removeAll method.
	 * Then, a temporary real and imag string, and a counter is created.
	 * 
	 * A loop goes through the whole String and adds the consecutive char
	 * to the realTemp string. When the loop finds a '+' or '-' symbol, the 
	 * loop is terminated. Hence, the realTemp string now contains the
	 * real value.
	 * 
	 * Then a for-loop runs starting from the counter value throughout
	 * the remainingString length-1 as the value of char 'i' is unwanted.
	 * If the next character is a '+' sign, the loop skips that iteration
	 * and continues. All the remaining strings is added to imagTemp string.
	 * 
	 * The realTemp and imagTemp string is then parsed into a double.
	 * The value of these double is made to initialized a MyDouble object.
	 * 
	 * realSection object contains the real values 
	 * imagSection object contains the imag values
	 * 
	 * ComplexNumber object is then returned with realSection and imagSection
	 * as parameters.
	 * 
	 * Method uses charAt, replaceAll, parseDouble method.
	 * 
	 * Method takes a String parameter.
	 * Returns a ComplexNumber object.
	 */
	public static ComplexNumber parseComplexNumber(String compNumStr) {
		compNumStr = compNumStr.replaceAll("\\s", "");
		String realTemp = "", imagTemp = "";
		int counter = 0;
		while (counter < compNumStr.length()) {
			realTemp += compNumStr.charAt(counter);
			counter++;
			if (compNumStr.charAt(counter) == '+' || 
			    compNumStr.charAt(counter) == '-') {
				break;
			}
		}
		for (int remaining = counter; remaining < compNumStr.length() - 1; 
		remaining++) {
			if (compNumStr.charAt(remaining) == '+') {
				continue;
			}
			;
			imagTemp += compNumStr.charAt(remaining);
		}

		MyDouble realSection = new MyDouble(Double.parseDouble(realTemp));
		MyDouble imagSection = new MyDouble(Double.parseDouble(imagTemp));

		return new ComplexNumber(realSection, imagSection);
	}
}
