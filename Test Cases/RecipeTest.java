package edu.ncsu.csc326.coffeemaker;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by edwar on 3/21/2017.
 */
public class RecipeTest {
    private Recipe r1 = new Recipe();
    private Recipe r2 = new Recipe();

    @Test
    public void getAmtChocolateTest() throws Exception {
        assertEquals(0,r1.getAmtChocolate());
    }

    @Test
    public void setAmtChocolateTest() throws Exception {
        r1.setAmtChocolate("1");
        assertEquals(1,r1.getAmtChocolate());
        r1.setAmtChocolate("0");
        assertEquals(0,r1.getAmtChocolate());
        try{r1.setAmtChocolate("-1");
            fail("RecipeException wasn't thrown");
        }
        catch(RecipeException RE){
            assertEquals("Units of chocolate must be a positive integer",RE.getMessage());
        }
        try{r1.setAmtChocolate("a");
            fail("RecipeException wasn't thrown");
        }
        catch(RecipeException RE){
            assertEquals("Units of chocolate must be a positive integer",RE.getMessage());
        }
    }
    @Test
    public void getAmtCoffeeTest() throws Exception {
        assertEquals(0,r1.getAmtCoffee());
    }

    @Test
    public void setAmtCoffeeTest() throws RecipeException {
        r1.setAmtCoffee("1");
        assertEquals(1,r1.getAmtCoffee());
        r1.setAmtCoffee("0");
        assertEquals(0,r1.getAmtCoffee());
        try{r1.setAmtCoffee("-1");
            fail("RecipeException wasn't thrown");
        }
        catch(RecipeException RE){
           assertEquals("Units of coffee must be a positive integer",RE.getMessage());
        }
        try{r1.setAmtCoffee("a");
            fail("RecipeException wasn't thrown");
        }
        catch(RecipeException RE){
            assertEquals("Units of coffee must be a positive integer",RE.getMessage());
        }
    }

    @Test
    public void getAmtMilkTest() throws Exception {
        assertEquals(0,r1.getAmtMilk());
    }

    @Test
    public void setAmtMilkTest() throws Exception {
        r1.setAmtMilk("1");
        assertEquals(1,r1.getAmtMilk());
        r1.setAmtMilk("0");
        assertEquals(0,r1.getAmtMilk());
        try{r1.setAmtMilk("-1");
            fail("RecipeException wasn't thrown");
        }
        catch(RecipeException RE){
            assertEquals("Units of milk must be a positive integer",RE.getMessage());
        }
        try{r1.setAmtMilk("a");
            fail("RecipeException wasn't thrown");
        }
        catch(RecipeException RE){
            assertEquals("Units of milk must be a positive integer",RE.getMessage());
        }
    }

    @Test
    public void getAmtSugarTest() throws Exception {
        assertEquals(0,r1.getAmtSugar());
    }

    @Test
    public void setAmtSugarTest() throws Exception {
        r1.setAmtSugar("1");
        assertEquals(1,r1.getAmtSugar());
        r1.setAmtSugar("0");
        assertEquals(0,r1.getAmtSugar());
        try{r1.setAmtSugar("-1");
            fail("RecipeException wasn't thrown");
        }
        catch(RecipeException RE){
            assertEquals("Units of sugar must be a positive integer",RE.getMessage());
        }
        try{r1.setAmtSugar("a");
            fail("RecipeException wasn't thrown");
        }
        catch(RecipeException RE){
            assertEquals("Units of sugar must be a positive integer",RE.getMessage());
        }
    }

    @Test
    public void getNameTest() throws Exception {
        assertEquals("",r1.getName());
    }

    @Test
    public void setNameTest() throws Exception {
        r1.setName(null); //?name would never be null
        assertEquals("",r1.getName());
        r1.setName("2333");
        assertEquals("2333",r1.getName());
    }

    @Test
    public void getPriceTest() throws Exception {
        assertEquals(0,r1.getPrice());

    }

    @Test
    public void setPriceTest() throws Exception {
        r1.setPrice("1");
        assertEquals(1,r1.getPrice());
        r1.setPrice("0");
        assertEquals(0,r1.getPrice());
        try{r1.setPrice("-1");
            fail("RecipeException wasn't thrown");
        }
        catch(RecipeException RE){
            assertEquals("Price must be a positive integer",RE.getMessage());
        }
        try{r1.setPrice("a");
            fail("RecipeException wasn't thrown");
        }
        catch(RecipeException RE){
            assertEquals("Price must be a positive integer",RE.getMessage());
        }
    }

   @Test
    public void toStringTest() throws Exception {
        r1.setName("1");
        assertEquals("1",r1.toString());
    }

    @Test
    public void hashCodeTest() throws Exception {
//interesting
        assertEquals(r1.hashCode(),r2.hashCode());
    }

    @Test
    public void equalsTest() throws Exception {
        assertTrue(r1.equals(r1));
        assertFalse(r1.equals(null));
        assertFalse(r1.equals(r1.getAmtChocolate()));
        //can't cover. name won't be null
        assertTrue(r1.equals(r2));
        r2.setName("2");
        assertFalse(r1.equals(r2));
    }

}