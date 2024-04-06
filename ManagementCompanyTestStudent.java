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
import org.junit.Before;
import org.junit.Test;

public class ManagementCompanyTestStudent {
    private ManagementCompany company;

    @Before
    public void setUp() {
        company = new ManagementCompany("TestCompany", "12345", 10.0);
    }

    @Test
    public void testAddPropertyStringStringDoubleString() {
        int result = company.addProperty("Property1", "City1", 1000.0, "Owner1");
        assertEquals(0, result);
        assertEquals(1, company.getPropertiesCount());
    }

    @Test
    public void testAddPropertyStringStringDoubleStringIntIntIntInt() {
        int result = company.addProperty("Property2", "City2", 2000.0, "Owner2", 0, 0, 1, 1);
        assertEquals(0, result);
        assertEquals(1, company.getPropertiesCount());
    }

    @Test
    public void testAddPropertyProperty() {
        Property property = new Property("Property3", "City3", 3000.0, "Owner3");
        int result = company.addProperty(property);
        assertEquals(0, result);
        assertEquals(1, company.getPropertiesCount());
    }

    @Test
    public void testRemoveLastProperty() {
        company.addProperty("Property4", "City4", 4000.0, "Owner4");
        company.removeLastProperty();
        assertEquals(0, company.getPropertiesCount());
    }

    @Test
    public void testIsPropertiesFull() {
        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            company.addProperty("Property" + i, "City" + i, 1000.0 * (i + 1), "Owner" + i);
        }
        assertTrue(company.isPropertiesFull());
    }

    @Test
    public void testGetPropertiesCount() {
        assertEquals(0, company.getPropertiesCount());
        company.addProperty("Property", "City", 1000.0, "Owner");
        assertEquals(1, company.getPropertiesCount());
    }

    @Test
    public void testGetTotalRent() {
        company.addProperty("Property1", "City1", 1000.0, "Owner1");
        company.addProperty("Property2", "City2", 2000.0, "Owner2");
        assertEquals(3000.0, company.getTotalRent(), 0.001);
    }

    @Test
    public void testGetHighestRentProperty() {
        company.addProperty("Property1", "City1", 1000.0, "Owner1");
        company.addProperty("Property2", "City2", 2000.0, "Owner2");
        Property highestRentProperty = company.getHighestRentProperty();
        assertEquals("Property2", highestRentProperty.getPropertyName());
    }

    @Test
    public void testGetName() {
        assertEquals("TestCompany", company.getName());
    }

    @Test
    public void testGetTaxID() {
        assertEquals("12345", company.getTaxID());
    }

    @Test
    public void testGetMgmFeePer() {
        assertEquals(10.0, company.getMgmFeePer(), 0.001);
    }

    @Test
    public void testGetPlot() {
        Plot plot = company.getPlot();
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(ManagementCompany.MGMT_WIDTH, plot.getWidth());
        assertEquals(ManagementCompany.MGMT_DEPTH, plot.getDepth());
    }

    @Test
    public void testGetProperties() {
        assertNull(company.getProperties()[0]);
    }

    @Test
    public void testGetTotalManagementFee() {
        // Create a ManagementCompany object
        ManagementCompany company = new ManagementCompany("TestCompany", "12345", 10.0);
        
        // Add some properties to the company
        company.addProperty("Property1", "City1", 1000.0, "Owner1");
        company.addProperty("Property2", "City2", 1500.0, "Owner2");
        
        // Calculate the expected total management fee
        double expectedFee = (1000.0 + 1500.0) * 10.0 / 100.0; // Total rent * management fee percentage
        
        // Call the getTotalManagementFee method
        double actualFee = company.getTotalManagementFee();
        
        // Assert that the actual fee matches the expected fee
        assertEquals(expectedFee, actualFee, 0.01); // Using delta for double comparison
    }
}