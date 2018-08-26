package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

/*
 * Author: Allen Bates
 * Description: Unit test cases created for CoffeeMaker.java
 * Initial recipes and coffee maker instance were provided by Sarah Heckman
 * Date: 26 March 2017
 * */

public class RecipeBookTest {

	private static RecipeBook rb;
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;

	@Before
	public void setUp() throws Exception {
		// Following code to initialize recipes is provided by Sarah Heckman

		// Set up for r1
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setAmtChocolate("0");
		r1.setAmtCoffee("3");
		r1.setAmtMilk("1");
		r1.setAmtSugar("1");
		r1.setPrice("50");

		// Set up for r2
		r2 = new Recipe();
		r2.setName("Mocha");
		r2.setAmtChocolate("20");
		r2.setAmtCoffee("3");
		r2.setAmtMilk("1");
		r2.setAmtSugar("1");
		r2.setPrice("75");

		// Set up for r3
		r3 = new Recipe();
		r3.setName("Latte");
		r3.setAmtChocolate("0");
		r3.setAmtCoffee("3");
		r3.setAmtMilk("3");
		r3.setAmtSugar("1");
		r3.setPrice("100");
		
		//Set up for r4
		r4 = new Recipe();
		r4.setName("Hot Chocolate");
		r4.setAmtChocolate("4");
		r4.setAmtCoffee("0");
		r4.setAmtMilk("1");
		r4.setAmtSugar("1");
		r4.setPrice("65");
		
	}

	@Test
	public void testGetRecipes() {
		rb = new RecipeBook();
		Recipe[] recipes = new Recipe[3];
		recipes[0] = r1;
		recipes[1] = r2;
        
		
		if(rb.getRecipes().length != 3){
			fail("Wrong Size for Array");
		}
		else{
			assertArrayEquals(recipes, rb.getRecipes());
		}
		
	}

	@Test
	public void testAddRecipeTrue() {
		rb = new RecipeBook();
		assertTrue(rb.addRecipe(r3));
	}
	
	@Test
	public void testAddRecipeFalse() {
		rb = new RecipeBook();
		rb.addRecipe(r1);
		assertFalse(rb.addRecipe(r1));
	}
	
	@Test
	public void testDeleteRecipeName() {
		rb = new RecipeBook();
		rb.addRecipe(r1);
		assertEquals("Coffee", rb.deleteRecipe(0));
	}
	
	@Test
	public void testDeleteRecipeNull() {
		rb = new RecipeBook();
		assertNull(rb.deleteRecipe(0));
		
	}
	
	@Test
	public void testEditRecipeName(){
		rb = new RecipeBook();
		rb.addRecipe(r2);
		assertEquals("Mocha",rb.editRecipe(0, r4));
	}

	@Test
	public void testEditRecipeNull(){
		rb = new RecipeBook();
		assertNull(rb.editRecipe(0, r3));
		
	}
}
