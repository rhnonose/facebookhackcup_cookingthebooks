package facebookHackCup.problems;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CookingTheBooksTest {

private CookingTheBooks cookingTheBooks;
	
    @Before
    public void setUp() throws Exception {
        cookingTheBooks = new CookingTheBooks();
    }
    
    @Test
    public void happyDay(){
		testSmaller("0", "0");
		testBigger("0", "0");
	}
    
    @Test
    public void threeDigitsSmaller(){
		testSmaller("123", "123");
		testSmaller("897", "798");
	}
    
    @Test
    public void threeDigitsBigger(){
    	testBigger("123", "321");
		testBigger("897", "987");
	}
	
    @Test
	public void fiveDigits(){
		testSmaller("31524","13524");
		testBigger("31524", "51324");
	}
    
    @Test
    public void cloudyDaySmaller(){
    	testSmaller("19919119", "11919199");
    }
    
    @Test
    public void cloudyDayBigger(){
    	testBigger("19919119", "99919111");
    }
    
    @Test
    public void numberWithZeroTwoSmaller(){
    	testSmaller("10", "10");
    }
    
    @Test
    public void numberWithZeroFiveSmaller(){
    	testSmaller("12220", "10222");
    }
    
    @Test
    public void numberWithZeroSixSmaller(){
    	testSmaller("211100", "111200");
    }
    
    @Test
    public void numberWithZeroTwoBigger(){
    	testBigger("10", "10");
    }
    
    @Test
    public void numberWithZeroFiveBigger(){
    	testBigger("12220", "21220");
    }
    
    @Test
    public void numberWithZeroSixBigger(){
    	testBigger("211100", "211100");
    }

	private void testSmaller(String in, String out) {
		String result = cookingTheBooks.solveSmaller(in);
		assertEquals(out, result);
	}

	private void testBigger(String in, String out) {
		String result = cookingTheBooks.solveBigger(in);
		assertEquals(out, result);
	}

}
