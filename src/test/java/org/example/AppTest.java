package org.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /*
        1: We(App) manage the names array
        2: Only Unique names in the array
        3: Add and remove names
        4: Sort the array
        5: Find by name and return index from list

        Test that we follow the rules above!
     */

    @Before
    public void reset() {
        App.resetNames();//clean out the names so we always start with no names in our Array.
    }

    @Test
    public void addNameToArray()
    {
        //Arrange
        String testName = "Foo Boo";

        //Act
        boolean resultOfAdd = App.addName(testName);
        String[] namesInArray = App.getNames();

        //Assert
        assertTrue( resultOfAdd );
        assertTrue(namesInArray != null);
        assertTrue(namesInArray.length == 1);
        assertEquals(testName , namesInArray[0]);
    }

    @Test
    public void addTwoNamesToArray() {

        //Arrange
        String testName1 = "Foo Boo";
        String testName2 = "Test Testsson";

        //Act
        boolean resultOfAdd1 = App.addName(testName1);
        boolean resultOfAdd2 = App.addName(testName2);
        String[] namesInArray = App.getNames();

        //Assert
        assertTrue( resultOfAdd1);
        assertTrue( resultOfAdd2);
        assertTrue(namesInArray != null);
        assertTrue(namesInArray.length == 2);
        assertEquals(testName1 , namesInArray[0]);
        assertEquals(testName2 , namesInArray[1]);
    }

    @Test
    public void addSameNameTwoTimesToArray() {

        //Arrange
        String testName = "Foo Boo";

        //Act
        boolean resultOfAdd1 = App.addName(testName);
        boolean resultOfAdd2 = App.addName(testName);
        String[] namesInArray = App.getNames();

        //Assert
        assertTrue(  resultOfAdd1);
        assertFalse( resultOfAdd2);
        assertTrue(namesInArray != null);
        assertTrue(namesInArray.length == 1);
        assertEquals(testName , namesInArray[0]);
    }

    @Test
    public void addArrayOfNamesToOurArrayOfNames() {
        //Arrange
        String[] testNames = new String[] {"Jonas","Kent","Ulf"};

        //Act
        boolean[] resultsAdded = App.addName(testNames);
        String[] resultNames = App.getNames();

        //Assert
        assertTrue(resultsAdded.length == testNames.length);
        assertArrayEquals(testNames, resultNames);
    }

    @Test
    public void sortWithNoNames() {
        //Arrange

        //Act
        App.sortNames();
        String[] result = App.getNames();

        //Assert
        assertTrue(result != null);
        assertTrue(result.length == 0);
    }

    @Test
    public void sortTwoNames() {
        //Arrange
        String testName1 = "Beta";
        String testName2 = "Adam";
        App.addName(testName1);
        App.addName(testName2);

        //Act
        App.sortNames();
        String[] namesResult = App.getNames();

        //Assert
        assertEquals(testName2, namesResult[0]);
        assertEquals(testName1, namesResult[1]);
    }

    @Test
    public void sortTwoNamesNoChange() {
        //Arrange
        String testName1 = "Adam";
        String testName2 = "Beta";
        App.addName(testName1);
        App.addName(testName2);

        //Act
        //App.sortNames();//Sort is now automatically called when we add.
        String[] namesResult = App.getNames();

        //Assert
        assertEquals(testName1, namesResult[0]);
        assertEquals(testName2, namesResult[1]);
    }

    @Test
    public void findByNameTrue() {
        //Arrange
        String name = "Ulf";
        App.addName(name);

        //Act
        int result = App.findByName(name);

        //Assert
        assertEquals(0, result);
    }

    @Test
    public void findByNameFalse() {
        //Arrange
        String name = "Ulf";

        //Act
        int result = App.findByName(name);

        //Assert
        assertEquals(-1, result);
    }

    @Test
    public void findByNameSmallLetters() {
        //Arrange
        String name = "Ulf";
        String noneCapitalName = "ulf";
        App.addName(name);

        //Act
        int result = App.findByName(noneCapitalName);

        //Assert
        assertEquals(0, result);
    }

    @Test
    public void findByNameWithinManyNames() {
        //Arrange
        String[] names = new String[] { "Erik", "Jonas", "Kent", "Simon", "Ulf"};
        String noneCapitalName = "kent";
        App.addName(names);

        //Act
        int result = App.findByName(noneCapitalName);

        //Assert
        assertEquals(2, result);
    }

    @Test
    public void removeAName() {
        //Arrange
        String[] names = new String[] { "Erik", "Jonas", "Kent", "Simon", "Ulf"};
        String noneCapitalName = "kent";
        App.addName(names);

        //Act
        boolean result = App.removeName(noneCapitalName);

        //Assert
        assertTrue(result);
    }

    @Test
    public void NoNamesTryRemoveOne() {
        //Arrange
        String name = "kent";

        //Act
        boolean result = App.removeName(name);

        //Assert
        assertFalse(result);
    }
}
