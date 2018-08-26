package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;

/*
 * Author: Allen Bates
 * Description: Unit test cases created for CoffeeMaker.java
 * Initial recipes and coffee maker instance were provided by Sarah Heckman
 * Date: 26 March 2017
 * */

public class CoffeeMakerTest {

	private CoffeeMaker cm;
	private static RecipeBook recipeBook;
    private static Inventory inventory;
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;
	
	@Before
	public void setUp() throws Exception {
		
		recipeBook = new RecipeBook();
		inventory = new Inventory();
		
		//Following code to initialize recipes is provided by Sarah Heckman
		
		//Set up for r1
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setAmtChocolate("0");
		r1.setAmtCoffee("3");
		r1.setAmtMilk("1");
		r1.setAmtSugar("1");
		r1.setPrice("50");
		
		//Set up for r2
		r2 = new Recipe();
		r2.setName("Mocha");
		r2.setAmtChocolate("120");
		r2.setAmtCoffee("3");
		r2.setAmtMilk("1");
		r2.setAmtSugar("1");
		r2.setPrice("75");
		
		//Set up for r3
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
	public void testAddRecipe() {
		cm = new CoffeeMaker();
		assertTrue(cm.addRecipe(r1));
	}
	
	@Test
	public void testDeleteRecipe() {
		cm = new CoffeeMaker();
		cm.addRecipe(r2);
		assertEquals("Mocha",cm.deleteRecipe(0));
	}
	
	@Test
	public void testEditRecipe() {
		cm = new CoffeeMaker();
		cm.addRecipe(r3);
		assertEquals("Latte", cm.editRecipe(0, r4));
	}
	
	@Test
	public void testAddInventory() throws InventoryException {
	//This test will initially fail due to the addSugar(String) function 
	//in the Inventory class. The function checks to see if the argument
	//is less than or equal to zero, not greater than or equal to zero
		cm = new CoffeeMaker();
		cm.addInventory("42", "81", "45", "55");
		
		StringBuffer buf = new StringBuffer();
    	buf.append("Coffee: ");
    	buf.append("57");
    	buf.append("\n");
    	buf.append("Milk: ");
    	buf.append("96");
    	buf.append("\n");
    	buf.append("Sugar: ");
    	buf.append("60");
    	buf.append("\n");
    	buf.append("Chocolate: ");
    	buf.append("70");
    	buf.append("\n");
    	
    	assertEquals(buf.toString(), cm.checkInventory());
	}
	
	@Test
	public void testCheckInventory(){
		
		cm = new CoffeeMaker();
		
		StringBuffer buf = new StringBuffer();
    	buf.append("Coffee: ");
    	buf.append("15");
    	buf.append("\n");
    	buf.append("Milk: ");
    	buf.append("15");
    	buf.append("\n");
    	buf.append("Sugar: ");
    	buf.append("15");
    	buf.append("\n");
    	buf.append("Chocolate: ");
    	buf.append("15");
    	buf.append("\n");
    	
    	assertEquals(buf.toString(), cm.checkInventory());
	}
	
	@Test
	public void testMakeCoffeeNoRecipe(){
		
		cm = new CoffeeMaker();
	
		assertEquals(45, cm.makeCoffee(0, 45));
	}
	
	@Test
	public void testMakeCoffeeEnoughIngredients(){
		
		cm = new CoffeeMaker();
		
		cm.addRecipe(r1);
		assertEquals(40, cm.makeCoffee(0, 90));
	}
	
	@Test
	public void testMakeCoffeeNotEnoughIngredients(){
		
		cm = new CoffeeMaker();
		
		cm.addRecipe(r2);
		assertEquals(60, cm.makeCoffee(0, 60));
	}
	
	@Test
	public void testMakeCoffeeNotEnoughCash(){
		
		cm = new CoffeeMaker();
		
		cm.addRecipe(r4);
		assertEquals(2, cm.makeCoffee(0, 2));
	}
	
	@Test
	public void testGetRecipes(){
		Recipe[] expectedRecipes = {r1, r2, r3};
		
		cm = new CoffeeMaker();
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		
		assertArrayEquals(expectedRecipes, cm.getRecipes());
	}

}
