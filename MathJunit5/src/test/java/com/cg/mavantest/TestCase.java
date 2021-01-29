package com.cg.mavantest;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.cg.mathjunit5.Demo;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class TestCase {
	  //Demo d=new Demo();
	  Demo d;
	  TestInfo testInfo;
	  TestReporter testReporter;
	  @BeforeAll //BeforeAll And AfterAll method should be public static
	  
	  public  static void beforeTest()
	  {
	  System.out.println("before the all test");
	  }
  @BeforeEach
 public void init(TestInfo testInfo, TestReporter testReporter) {
	  this.testInfo=testInfo;
	  this.testReporter=testReporter;
	 d = new Demo();
	 System.out.println("this is before each method");
  }
  
  @AfterEach
  public void afterTest() //public static method is not  needed 
  {
  	  System.out.println("after the each test");
  }

	 
//@Test
@RepeatedTest(2)
@Tag("Math")
@DisplayName("Tset for div no")
	  void testDivide() {
	System.out.println(testInfo.getTags());
	testReporter.publishEntry("thsi is to divide"+testInfo.getTags());
	d= new Demo();
		 assumeTrue(true);
		  assertThrows(ArithmeticException.class, () -> d.div(1, 0), "Divide by zero should be thrown");

		   }


@ParameterizedTest
@ValueSource(ints = {1, 3, 5, -3, 15, Integer.MAX_VALUE}) // six numbers
//@NullSource //we can pass a single null value to a parameterized test method using @NullSource
void isOdd_ShouldReturnTrueForOddNumbers(int number) {
	d=new Demo();
assertTrue(d.isOdd(number));
}


@Test
//@Disabled
@EnabledOnOs(OS.WINDOWS)

@DisplayName("Tset for Asswrt all")
	  void testAll() {
	d=new Demo();
	      assertAll(() -> assertEquals(4, d.add(2, 2)), () -> assertEquals(8, d.mul(4, 2)));
		   }

@AfterAll
public static void afterTest1() //public static method is not  needed 
{
	  System.out.println("after the all test");
}


@Nested
@DisplayName("nested")
//@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class A
{
	
   Demo d = new Demo();
  
@BeforeEach
 public void nested()
 {
	System.out.println("Before each nested method");
 }
   @Test // marks the method as Test and informs the Junit engine what methods need to
   @DisplayName("Testing add for +") // run
   void testAdd() {
   assertEquals(2, d.add(1, 1), "The add method should add two nos");
   }

    @Test // marks the method as Test and informs the Junit engine what methods need to
   @DisplayName("Testing add for -") // run
   void testAddNegative() {
   assertEquals(-2, d.add(-1, -1), "The add method should add two nos");
   }
    @AfterEach
    public void afterEachNested()
    {
    	System.out.println("After the nested method");
    }
    
}




	  
}

