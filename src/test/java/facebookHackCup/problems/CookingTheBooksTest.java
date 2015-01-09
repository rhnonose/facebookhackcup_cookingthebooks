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
		testSmall("0", "0");
		testBigger("0", "0");
	}
    
    @Test
    public void threeDigitsSmaller(){
		testSmall("123", "123");
		testSmall("897", "798");
	}
    
    @Test
    public void threeDigitsBigger(){
    	testBigger("123", "321");
		testBigger("897", "987");
	}
	
    @Test
	public void fiveDigits(){
		testSmall("31524","13524");
		testBigger("31524", "51324");
	}
    
    @Test
    public void cloudyDaySmaller(){
    	testSmall("19919119", "11919199");
    }
    
    @Test
    public void cloudyDayBigger(){
    	testBigger("19919119", "99919111");
    }

	private void testSmall(String in, String out) {
		String result = cookingTheBooks.solveSmaller(in);
		assertEquals(out, result);
	}

	private void testBigger(String in, String out) {
		String result = cookingTheBooks.solveBigger(in);
		assertEquals(out, result);
	}

}
