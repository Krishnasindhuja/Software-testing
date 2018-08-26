package edu.ncsu.csc326.coffeemaker;

import org.junit.*;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import static org.junit.Assert.*;

public class InventoryTest {
	private Inventory inventory;

	@Before
	public void setUp() {
		inventory = new Inventory();
	}

	@Test
	public void getChocolateTest() {
		assertEquals(15, inventory.getChocolate());

	}

	@Test
	public void getChocolateErrorTest() {
		inventory.setChocolate(15);
		assertEquals(16, inventory.getChocolate());

	}

	@Test
	public void setChocolateTest() {
		inventory.setChocolate(10);
		assertEquals(10, inventory.getChocolate());
	}

	@Test
	public void setChocolateErrorTest() {
		inventory.setChocolate(10);
		//assertEquals(11, inventory.getChocolate());
	}

	@Test
	public void addChocolateTest() {
		String qty = "5";
		try {
			int before = inventory.getChocolate();
			inventory.addChocolate(qty);
			assertEquals(inventory.getChocolate(), before + new Integer(qty));
		} catch (InventoryException e) {

		}
	}

	@Test
	public void addChocolateErrorTest() {
		String qty = "a";
		try {
			// int before = inventory.getChocolate();
			inventory.addChocolate(qty);
			fail("Exception must be thrown");
			// assertEquals(inventory.getChocolate(), before + new
			// Integer(qty));
		} catch (InventoryException e) {

		}

	}

	@Test
	public void getCoffeeTest() {
		assertEquals(15, inventory.getCoffee());
	}

	@Test
	public void getCoffeeErrorTest() {
		inventory.setCoffee(19);
		assertNotEquals(25, inventory.getCoffee());
	}

	@Test
	public void setCoffeeTest() {
		inventory.setChocolate(10);
		assertEquals(10, inventory.getChocolate());
	}

	@Test
	public void setCoffeeErrorTest() {
		inventory.setCoffee(11);
		assertNotEquals(10, inventory.getCoffee());
	}

	@Test
	public void addCoffeeTest() {
		String qty = "5";
		try {
			int before = inventory.getCoffee();
			inventory.addCoffee(qty);
			assertEquals(inventory.getCoffee(), before + new Integer(qty));
		} catch (InventoryException e) {
			fail("Exception must not be thrown");
		}
	}

	@Test
	public void addCoffeeErrorTest() {
		String qty = "w242s";
		try {
			inventory.addCoffee(qty);
			fail("Exception must be thrown");
		} catch (InventoryException e) {

		}
	}

	@Test
	public void getMilkTest() {
		assertEquals(15, inventory.getMilk());

	}

	@Test
	public void getMilkErrorTest() {
		inventory.setMilk(10);
		assertNotEquals(332, inventory.getMilk());

	}

	@Test
	public void setMilkTest() {
		inventory.setMilk(10);
		assertEquals(10, inventory.getMilk());
	}

	@Test
	public void setMilkErrorTest() {
		inventory.setMilk(-99);
		assertNotEquals(10, inventory.getMilk());

	}

	@Test
	public void addMilkTest() {
		String qty = "5";
		try {
			int before = inventory.getMilk();
			inventory.addMilk(qty);
			assertEquals(inventory.getMilk(), before + new Integer(qty));
		} catch (InventoryException e) {
			fail("Exception must not be thrown");
		}
	}

	@Test
	public void addMilkErrorTest() {
		String qty = "X";
		try {
			inventory.addMilk(qty);
			fail("Exception must be thrown");
		} catch (InventoryException e) {

		}
	}

	@Test
	public void getSugarTest() {
		assertEquals(15, inventory.getSugar());

	}

	@Test
	public void getSugarErrorTest() {
		inventory.setSugar(19);
		assertNotEquals(25, inventory.getSugar());

	}

	@Test
	public void setSugarTest() {
		inventory.setSugar(10);
		assertEquals(10, inventory.getSugar());

	}

	@Test
	public void setSugarErrorTest() {
		inventory.setSugar(99);
		assertNotEquals(10, inventory.getSugar());
	}

	@Test
	public void addSugarTest() {
		String qty = "2";
		try {
			int before = inventory.getSugar();
			inventory.addSugar(qty);
			assertEquals(inventory.getSugar(), before + new Integer(qty));
		} catch (InventoryException e) {
			fail("Exception must not be thrown");
		}
	}

	@Test
	public void addSugarErrorTest() {
		String qty = "12s";
		try {

			inventory.addSugar(qty);
			fail("Exception must be thrown");
		} catch (InventoryException e) {

		}
	}

	@Test
	public void enoughIngredientsTest() {
		Recipe r = new Recipe();
		try {
			r.setAmtCoffee("1");
			r.setAmtMilk("1");
			r.setAmtSugar("1");
			r.setAmtChocolate("1");
			assertTrue(inventory.enoughIngredients(r));
		} catch (RecipeException e) {
		
		}
	}

	@Test
	public void enoughIngredientsErrorTest() {
		Recipe r = new Recipe();
		try {
			r.setAmtCoffee("0");
			r.setAmtMilk("1");
			r.setAmtSugar("16");
			r.setAmtChocolate("99");
			assertFalse(inventory.enoughIngredients(r));
			fail("Exception must not be thrown");
		} catch (RecipeException e) {
			
		}
	}

	@Test
	public void useIngredientsTest() {
		Recipe r = new Recipe();
		try {
			r.setAmtCoffee("1");
			r.setAmtMilk("1");
			r.setAmtSugar("1");
			r.setAmtChocolate("1");
			assertTrue(inventory.useIngredients(r));
		} catch (RecipeException e) {
			
		}
	}

	@Test
	public void useIngredientsErrorTest() {
		Recipe r = new Recipe();
		try {
			r.setAmtCoffee("4");
			r.setAmtMilk("1");
			r.setAmtSugar("1");
			r.setAmtChocolate("-1");
			assertFalse(inventory.useIngredients(r));
//			fail("Exception must be thrown");
		} catch (RecipeException e) {
			
		}

	}

	@Test
	public void toStringTest() {
		assertNotNull(inventory.toString());
	}

}
