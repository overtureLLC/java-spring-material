package com.unit.test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.test.WordsCounting;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class WordsCountingTestCase {
	private static List<String> excludedWords1 = Arrays.asList("is", "a", "an");
	private static List<String> excludedWords2 = Arrays.asList("is", "a", "an", "and");
	private static List<String> excludedWords3 = Arrays.asList("is", "a", "an", "are");
	private static List<String> excludedWords4 = Arrays.asList("is", "a", "an", "and", "the");
	private static String text1 = "..,,9Apple, ,aAAAAAAAAAA,9Orange55, Kivi, xx, ww,Peach, iiiiiiiiiiiiiiiiiii,Kivi, kiVi, ,abc ,Abc, Apple, Apple, 9,9, 9 9,bbbbbbbbbbbbbbb, Peach, Orange is, apple, apple, orange, orange, orange,,,   is, A, an,  ";
	private static String text2 = "9Apple, 9Orange55, Kivi, Peach, Kivi,xx, ww,tt, kiVi, ,abc ,aaa ,Abc, Apple, Apple, 9,9, 9 9,bbbbbbbbbbbbbbb, Peach, Orange is, apple, apple, orange, orange, orange,,,   is, A, an,  ";
	private static String text3 = "aAAAAAAAAAA,9Orange55, Kivi, xx, ww,Peach, iiiiiiiiiiiiiiiiiii,Kivi, kiVi, ,abc ,Abc, Apple, Apple, 9,9, 9 9,bbbbbbbbbbbbbbb, Peach, Orange is, apple, apple, orange, orange, orange,,,   is, A, an,  ";
	private static String text4 = "ange55, Kivi, Peach, Kivi,xx, ww,tt, kiVi, ,abc ,aaa ,Abc, Apple, Apple, 9,9, 9 9,bbbbbbbbbbbbbbb, Peach, Orange is, apple, apple, orange, orange, orange,,,   is, A, an,  ";
	private static List<String> expectedResult1 = Arrays.asList("a", "i");
	private static List<String> expectedResult2 = Arrays.asList("a", "b");
	private static List<String> expectedResult3 = Arrays.asList("i");
	private static List<String> expectedResult4 = Arrays.asList("b");
	private static int testCount = 0;
	
	@Parameter(0)
	public String text;
	@Parameter(1)
	public List<String> excludedWords;
	@Parameter(2)
	public List<String> expectedWords;

	@Parameters
	public static Collection<Object[]> texts() {
		List<Object[]> list = Arrays.asList(new Object[][]{ {text1, excludedWords1, expectedResult1}, 
															{text2, excludedWords2, expectedResult2},
															{text3, excludedWords3, expectedResult3}, 
															{text4, excludedWords4, expectedResult4}
										   				  }
										   );	
		return list;
	}
	
	@BeforeClass
	public static void initAllTest() {
		System.out.println("********** BeforeClass: start testing... **********\n");
	}
	
	@AfterClass
	public static void endAllTest() {
		System.out.println("********** AfterClass: total " + testCount + " tests are done! **********\n");
	}
	
	@Before
	public void initTest() {
		testCount++;
		System.out.println(">>>>>>>>>> Before: start unit testing...[" + testCount + "] <<<<<<<<<<");
	}
	
	@After
	public void endTest() {
		System.out.println(">>>>>>>>>> After: unite test [" + testCount + "] is done. <<<<<<<<<<<\n");
	}
		
	@Test
	public void test1() {
		List<String> mostUsedWords = WordsCounting.mostUsedWords(text, excludedWords);
		assertEquals(expectedWords, mostUsedWords);
	}
	
	@Ignore
	@Test
	public void test2() {
		String str = "Test2 is working fine";
		assertEquals("Test2 is working fine155",str);
	}
}
