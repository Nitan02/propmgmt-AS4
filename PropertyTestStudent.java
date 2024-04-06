
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

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PropertyTestStudent {

    @Test
    public void testConstructorWithNoArguments() {
        Property property = new Property();
        assertEquals("", property.getPropertyName());
        assertEquals("", property.getCity());
        assertEquals(0.0, property.getRentAmount(), 0.01);
        assertEquals("", property.getOwner());
        assertEquals(new Plot(), property.getPlot());
    }

    @Test
    public void testConstructorWithArguments() {
        Property property = new Property("House", "City", 1000.0, "John");
        assertEquals("House", property.getPropertyName());
        assertEquals("City", property.getCity());
        assertEquals(1000.0, property.getRentAmount(), 0.01);
        assertEquals("John", property.getOwner());
        assertEquals(new Plot(), property.getPlot());
    }

    @Test
    public void testConstructorWithPlotArguments() {
        Property property = new Property("House", "City", 1000.0, "John", 1, 2, 3, 4);
        assertEquals("House", property.getPropertyName());
        assertEquals("City", property.getCity());
        assertEquals(1000.0, property.getRentAmount(), 0.01);
        assertEquals("John", property.getOwner());
        assertEquals(new Plot(1, 2, 3, 4), property.getPlot());
    }

    @Test
    public void testCopyConstructor() {
        Property originalProperty = new Property("House", "City", 1000.0, "John", 1, 2, 3, 4);
        Property property = new Property(originalProperty);
        assertEquals("House", property.getPropertyName());
        assertEquals("City", property.getCity());
        assertEquals(1000.0, property.getRentAmount(), 0.01);
        assertEquals("John", property.getOwner());
        assertEquals(new Plot(1, 2, 3, 4), property.getPlot());
    }

    @Test
    public void testSetterMethods() {
        Property property = new Property();
        property.setPropertyName("House");
        property.setCity("City");
        property.setRentAmount(1000.0);
        property.setOwner("John");
        property.setPlot(1, 2, 3, 4);
        assertEquals("House", property.getPropertyName());
        assertEquals("City", property.getCity());
        assertEquals(1000.0, property.getRentAmount(), 0.01);
        assertEquals("John", property.getOwner());
        assertEquals(new Plot(1, 2, 3, 4), property.getPlot());
    }

    @Test
    public void testToString() {
        Property property = new Property("House", "City", 1000.0, "John");
        assertEquals("House,City,John,1000.0", property.toString());
    }
}