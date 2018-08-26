package edu.ncsu.csc326.coffeemaker;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CoffeeMakerTest.class, InventoryTest.class, RecipeBookTest.class, RecipeTest.class })
public class AllTests {

}
