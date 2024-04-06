
/*
 * Class: CMSC203 
 * Instructor:Ashique Tanveer
 * Description: (property management)
 * Due: 04/05/2024
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Nitan
*/

import static org.junit.Assert.*;
import org.junit.Test;

public class PlotTestStudent {

    @Test
    public void testDefaultConstructor() {
        Plot plot = new Plot();
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());
    }

    @Test
    public void testParameterizedConstructor() {
        Plot plot = new Plot(1, 2, 3, 4);
        assertEquals(1, plot.getX());
        assertEquals(2, plot.getY());
        assertEquals(3, plot.getWidth());
        assertEquals(4, plot.getDepth());
    }

    @Test
    public void testCopyConstructor() {
        Plot originalPlot = new Plot(1, 2, 3, 4);
        Plot plot = new Plot(originalPlot);
        assertEquals(1, plot.getX());
        assertEquals(2, plot.getY());
        assertEquals(3, plot.getWidth());
        assertEquals(4, plot.getDepth());
    }

    @Test
    public void testSetterMethods() {
        Plot plot = new Plot();
        plot.setX(1);
        plot.setY(2);
        plot.setWidth(3);
        plot.setDepth(4);
        assertEquals(1, plot.getX());
        assertEquals(2, plot.getY());
        assertEquals(3, plot.getWidth());
        assertEquals(4, plot.getDepth());
    }

    @Test
    public void testOverlapsMethod() {
        Plot plot1 = new Plot(1, 1, 3, 3);
        Plot plot2 = new Plot(2, 2, 2, 2);
        assertTrue(plot1.overlaps(plot2));
    }

    @Test
    public void testDoesNotOverlapMethod() {
        Plot plot1 = new Plot(1, 1, 2, 2);
        Plot plot2 = new Plot(4, 4, 2, 2);
        assertFalse(plot1.overlaps(plot2));
    }

    @Test
    public void testEncompassesMethod() {
        Plot plot1 = new Plot(1, 1, 5, 5);
        Plot plot2 = new Plot(2, 2, 3, 3);
        assertTrue(plot1.encompasses(plot2));
    }

    @Test
    public void testDoesNotEncompassMethod() {
        Plot plot1 = new Plot(1, 1, 3, 3);
        Plot plot2 = new Plot(2, 2, 4, 4);
        assertFalse(plot1.encompasses(plot2));
    }

    @Test
    public void testToString() {
        Plot plot = new Plot(1, 2, 3, 4);
        assertEquals("1,2,3,4", plot.toString());
    }
}