import static org.junit.Assert.*;

import org.junit.Test;


public class PublicTests {

	@Test
	public void testBasicConstructorsAndGetters() {

		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);
		MyDouble d = new MyDouble(555.729);

		ComplexNumber x = new ComplexNumber(a, b);
		assertTrue(x.getReal().compareTo(a) == 0 && x.getImag().compareTo(b) == 0);

		ComplexNumber z = new ComplexNumber(d);
		assertTrue(z.getReal().compareTo(d) == 0 && z.getImag().compareTo(new MyDouble(0)) == 0);
	}

	@Test
	public void testCopyConstructor() {

		MyDouble a = new MyDouble(5.7), b = new MyDouble(-3.7);

		ComplexNumber x = new ComplexNumber(a, b);
		ComplexNumber y = new ComplexNumber(x);
		assertTrue(x != y);     // Check to be sure they are not aliased!
		assertTrue(y.getReal().compareTo(a) == 0 && y.getImag().compareTo(b) == 0);
	}

	@Test
	public void testAdd() {
		//test numbers
		ComplexNumber compNum1 = new ComplexNumber
				(new MyDouble(1.0), new MyDouble(2.0)); 
		ComplexNumber compNum2 = new ComplexNumber
				(new MyDouble(1.0), new MyDouble(-3.0));
		ComplexNumber compNum3 = new ComplexNumber
				(new MyDouble(-3.0), new MyDouble(1.0)); 
		ComplexNumber compNum4 = new ComplexNumber
				(new MyDouble(-3.0), new MyDouble(-4.0)); 

		//test addition
		ComplexNumber testAdd1 = compNum1.add(compNum2); 
		ComplexNumber testAdd2 = compNum2.add(compNum3); 
		ComplexNumber testAdd3 = compNum3.add(compNum4); 
		ComplexNumber testAdd4 = compNum4.add(compNum1); 


		//test answers
		ComplexNumber testAns1 = new ComplexNumber
				(new MyDouble(2.0), new MyDouble (-1.0));

		ComplexNumber testAns2 = new ComplexNumber
				(new MyDouble(-2.0), new MyDouble (-2.0));

		ComplexNumber testAns3 = new ComplexNumber
				(new MyDouble(-6.0), new MyDouble (-3.0));

		ComplexNumber testAns4 = new ComplexNumber
				(new MyDouble(-2.0), new MyDouble  (-2.0));
		
		//assertion check if testAns similar to testAdd
		assertTrue(testAdd1.compareTo(testAns1) == 0);
		assertTrue(testAdd2.compareTo(testAns2) == 0);
		assertTrue(testAdd3.compareTo(testAns3) == 0);
		assertTrue(testAdd4.compareTo(testAns4) == 0);



	}

	@Test
	public void testSubstract() {
		ComplexNumber compNum1 = new ComplexNumber
				(new MyDouble(4.0), new MyDouble(2.0)); 
		ComplexNumber compNum2 = new ComplexNumber
				(new MyDouble(3.0), new MyDouble(-3.0)); 
		ComplexNumber compNum3 = new ComplexNumber
				(new MyDouble(-2.0), new MyDouble(1.0)); 
		ComplexNumber compNum4 = new ComplexNumber
				(new MyDouble(-1.0), new MyDouble(-4.0)); 

		//test subtraction
		ComplexNumber testSubtract1 = compNum1.subtract(compNum2); 
		ComplexNumber testSubtract2 = compNum2.subtract(compNum3); 
		ComplexNumber testSubtract3 = compNum3.subtract(compNum4); 
		ComplexNumber testSubtract4 = compNum4.subtract(compNum1); 

		//test answers
		ComplexNumber testAns1 = new ComplexNumber
				(new MyDouble(1.0), new MyDouble(5.0)); 
		ComplexNumber testAns2 = new ComplexNumber
				(new MyDouble(5.0), new MyDouble(-4.0)); 
		ComplexNumber testAns3 = new ComplexNumber
				(new MyDouble(-1.0), new MyDouble(5.0)); 
		ComplexNumber testAns4 = new ComplexNumber
				(new MyDouble(-5.0), new MyDouble(-6.0)); 
		
		//assertion check if testAns similar to testSubtract
		assertTrue(testSubtract1.compareTo(testAns1) == 0);
		assertTrue(testSubtract2.compareTo(testAns2) == 0);
		assertTrue(testSubtract3.compareTo(testAns3) == 0);
		assertTrue(testSubtract4.compareTo(testAns4) == 0);		
	}

	@Test
	public void testMult() {
		ComplexNumber compNum1 = new ComplexNumber
				(new MyDouble(4.0), new MyDouble(2.0)); 
		ComplexNumber compNum2 = new ComplexNumber
				(new MyDouble(3.0), new MyDouble(-3.0)); 
		ComplexNumber compNum3 = new ComplexNumber
				(new MyDouble(-2.0), new MyDouble(1.0)); 
		ComplexNumber compNum4 = new ComplexNumber
				(new MyDouble(-1.0), new MyDouble(-4.0)); 

		//test multiplication
		ComplexNumber testMultiply1 = compNum1.multiply(compNum2); 
		ComplexNumber testMultiply2 = compNum2.multiply(compNum3); 
		ComplexNumber testMultiply3 = compNum3.multiply(compNum4); 
		ComplexNumber testMultiply4 = compNum4.multiply(compNum1); 

		//test answers
		ComplexNumber testAns1 = new ComplexNumber
				(new MyDouble(18.0), new MyDouble(-6.0)); 
		ComplexNumber testAns2 = new ComplexNumber
				(new MyDouble(-3.0), new MyDouble(9.0)); 
		ComplexNumber testAns3 = new ComplexNumber
				(new MyDouble(6.0), new MyDouble(7.0)); 
		ComplexNumber testAns4 = new ComplexNumber
				(new MyDouble(4.0), new MyDouble(-18.0)); 
		
		//assertion check if testAns similar to testMultiply
		assertTrue(testMultiply1.compareTo(testAns1) == 0);
		assertTrue(testMultiply2.compareTo(testAns2) == 0);
		assertTrue(testMultiply3.compareTo(testAns3) == 0);
		assertTrue(testMultiply4.compareTo(testAns4) == 0);
	}

	@Test
	public void testDiv() {
		ComplexNumber compNum1 = new ComplexNumber
				(new MyDouble(16.0), new MyDouble(-2.0)); 
		ComplexNumber compNum2 = new ComplexNumber
				(new MyDouble(3.0), new MyDouble(-2.0)); 
		ComplexNumber compNum3 = new ComplexNumber
				(new MyDouble(-8.0), new MyDouble(27.0)); 
		ComplexNumber compNum4 = new ComplexNumber
				(new MyDouble(2.0), new MyDouble(3.0)); 
		ComplexNumber compNum5 = new ComplexNumber
				(new MyDouble(1.0), new MyDouble(-3.0)); 
		ComplexNumber compNum6 = new ComplexNumber
				(new MyDouble(1.0), new MyDouble(2.0));
		ComplexNumber compNum7 = new ComplexNumber
				(new MyDouble(4.0), new MyDouble(2.0)); 
		ComplexNumber compNum8 = new ComplexNumber
				(new MyDouble(3.0), new MyDouble(-1.0)); 
 

		//test division
		ComplexNumber testDiv1 = compNum1.divide(compNum2); 
		ComplexNumber testDiv2 = compNum3.divide(compNum4); 
		ComplexNumber testDiv3 = compNum5.divide(compNum6); 
		ComplexNumber testDiv4 = compNum7.divide(compNum8); 

		//test answers
		ComplexNumber testAns1 = new ComplexNumber
				(new MyDouble(4.0), new MyDouble(2.0)); 
		ComplexNumber testAns2 = new ComplexNumber
				(new MyDouble(5.0), new MyDouble(6.0));
		ComplexNumber testAns3 = new ComplexNumber
				(new MyDouble(-1.0), new MyDouble(-1.0)); 
		ComplexNumber testAns4 = new ComplexNumber
				(new MyDouble(1.0), new MyDouble(1.0)); 

		//assertion check if testAns similar to testDiv
		assertTrue(testDiv1.compareTo(testAns1) == 0);
		assertTrue(testDiv2.compareTo(testAns2) == 0);
		assertTrue(testDiv3.compareTo(testAns3) == 0);
		assertTrue(testDiv4.compareTo(testAns4) == 0);

	}

	@Test
	public void testEqComp() {
		ComplexNumber compNum1 = new ComplexNumber
				(new MyDouble(16.0), new MyDouble(-2.0)); 
		ComplexNumber compNum2 = new ComplexNumber
				(new MyDouble(16.0), new MyDouble(-2.0)); 
		ComplexNumber compNum3 = new ComplexNumber
				(new MyDouble(-8.0), new MyDouble(27.0)); 
		ComplexNumber compNum4 = new ComplexNumber
				(new MyDouble(-8.0), new MyDouble(27.0));

		ComplexNumber compNum5 = new ComplexNumber
				(new MyDouble(1.0), new MyDouble(1.0)); 
		ComplexNumber compNum6 = new ComplexNumber
				(new MyDouble(1.0), new MyDouble(1.0));
		ComplexNumber compNum7 = new ComplexNumber
				(new MyDouble(-4.0), new MyDouble(-4.0)); 
		ComplexNumber compNum8 = new ComplexNumber
				(new MyDouble(-4.0), new MyDouble(-4.0)); 

		//equals method check
		assertTrue(compNum1.equals(compNum2));
		assertTrue(compNum3.equals(compNum4));
		assertTrue(compNum5.equals(compNum6));
		assertTrue(compNum7.equals(compNum8));

		//compareTo method check
		assertTrue(compNum1.compareTo(compNum2) == 0);
		assertTrue(compNum3.compareTo(compNum4) == 0);
		assertTrue(compNum5.compareTo(compNum6) == 0);
		assertTrue(compNum7.compareTo(compNum8) == 0);

	}


	@Test
	public void testNorm() {
		ComplexNumber compNum1 = new ComplexNumber
				(new MyDouble(3.0), new MyDouble(4.0)); 
		ComplexNumber compNum2 = new ComplexNumber
				(new MyDouble(-3.0), new MyDouble(4.0)); 
		ComplexNumber compNum3 = new ComplexNumber
				(new MyDouble(3.0), new MyDouble(-4.0)); 
		ComplexNumber compNum4 = new ComplexNumber
				(new MyDouble(3.0), new MyDouble(-4.0)); 
		ComplexNumber compNum5 = new ComplexNumber
				(new MyDouble(5.0), new MyDouble (12.0));
		ComplexNumber compNum6 = new ComplexNumber
				(new MyDouble(8.0), new MyDouble (15.0));

		//test norm
		MyDouble testNorm1 = ComplexNumber.norm(compNum1); 
		MyDouble testNorm2 = ComplexNumber.norm(compNum2); 
		MyDouble testNorm3 = ComplexNumber.norm(compNum3); 
		MyDouble testNorm4 = ComplexNumber.norm(compNum4); 
		MyDouble testNorm5 = ComplexNumber.norm(compNum5); 
		MyDouble testNorm6 = ComplexNumber.norm(compNum6);

		ComplexNumber testAns1 = new ComplexNumber(testNorm1);
		ComplexNumber testAns2 = new ComplexNumber(testNorm2);
		ComplexNumber testAns3 = new ComplexNumber(testNorm3);
		ComplexNumber testAns4 = new ComplexNumber(testNorm4);
		ComplexNumber testAns5 = new ComplexNumber(testNorm5);
		ComplexNumber testAns6 = new ComplexNumber(testNorm6);

		/* 
		 * assertion check if testAns similar to compNum after 
		 * norm method invokation
		 */
		assertTrue(compNum1.compareTo(testAns1) == 0);
		assertTrue(compNum2.compareTo(testAns2) == 0);
		assertTrue(compNum3.compareTo(testAns3) == 0);
		assertTrue(compNum4.compareTo(testAns4) == 0);
		assertTrue(compNum5.compareTo(testAns5) == 0);
		assertTrue(compNum6.compareTo(testAns6) == 0);
	}

	@Test
	public void testParse() {
		//test no space
		String testParse1 = "1+1i";
		ComplexNumber parsedString1 = ComplexNumber.
				parseComplexNumber(testParse1);
		
		ComplexNumber testAns1 = new ComplexNumber(
				new MyDouble(1.0), new MyDouble(1.0));
		
		assertTrue(parsedString1.compareTo(testAns1) == 0);

		//test space infront real number
		String testParse2 = "  1+1i";
		ComplexNumber parsedString2 = ComplexNumber.
				parseComplexNumber(testParse2);
		
		ComplexNumber testAns2 = new ComplexNumber(
				new MyDouble(1.0), new MyDouble(1.0));
		
		assertTrue(parsedString2.compareTo(testAns2) == 0);

		//test space behind imag number
		String testParse3 = " 1+1i ";
		ComplexNumber parsedString3 = ComplexNumber.
				parseComplexNumber(testParse3);
		
		ComplexNumber testAns3 = new ComplexNumber(
				new MyDouble(1.0), new MyDouble(1.0));
		
		assertTrue(parsedString3.compareTo(testAns3) == 0);
		//test space between symbol
		String testParse4 = "1 + 1i";
		ComplexNumber parsedString4 = ComplexNumber.
				parseComplexNumber(testParse4);
		
		ComplexNumber testAns4 = new ComplexNumber(
				new MyDouble(1.0), new MyDouble(1.0));
		
		assertTrue(parsedString4.compareTo(testAns4) == 0);

		//test all space
		String testParse5 = " 1  +   1i   ";
		ComplexNumber parsedString5 = ComplexNumber.
				parseComplexNumber(testParse5);
		
		ComplexNumber testAns5= new ComplexNumber(
				new MyDouble(1.0), new MyDouble(1.0));
		
		assertTrue(parsedString5.compareTo(testAns5) == 0);

		//test with negative symbol
		String testParse6 = "1 - 1i";
		ComplexNumber parsedString6 = ComplexNumber.
				parseComplexNumber(testParse6);
		
		ComplexNumber testAns6 = new ComplexNumber(
				new MyDouble(1.0), new MyDouble(-1.0));
		
		assertTrue(parsedString6.compareTo(testAns6) == 0);

		//test with multiple symbol
		String testParse7 = "-1 + 1i";
		ComplexNumber parsedString7 = ComplexNumber.
				parseComplexNumber(testParse7);
		
		ComplexNumber testAns7 = new ComplexNumber(
				new MyDouble(-1.0), new MyDouble(1.0));
		
		assertTrue(parsedString7.compareTo(testAns7) == 0);

		//test with both negative symbol
		String testParse8 = "-1 - 1i";
		ComplexNumber parsedString8 = ComplexNumber.
				parseComplexNumber(testParse8);
		
		ComplexNumber testAns8 = new ComplexNumber(
				new MyDouble(-1.0), new MyDouble(-1.0));
		
		assertTrue(parsedString8.compareTo(testAns8) == 0);

		//test with many space and negative symbol
		String testParse9 = "       -1        -  1i      ";
		ComplexNumber parsedString9 = ComplexNumber.
				parseComplexNumber(testParse9);
		
		ComplexNumber testAns9 = new ComplexNumber(
				new MyDouble(-1.0), new MyDouble(-1.0));
		
		assertTrue(parsedString9.compareTo(testAns9) == 0);
	}
}
