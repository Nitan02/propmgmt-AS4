
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

public class Property extends Object {
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    // Constructors
    public Property() {
        this("", "", 0, "");
    }

    public Property(String propertyName, String city, double rentAmount, String owner) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot();
    }

    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    public Property(Property otherProperty) {
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rentAmount = otherProperty.rentAmount;
        this.owner = otherProperty.owner;
        this.plot = new Plot(otherProperty.plot);
    }

    // Getter methods
    public String getCity() {
        return city;
    }

    public String getOwner() {
        return owner;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public Plot getPlot() {
        return plot;
    }

    // Setter methods
    public void setCity(String city) {
        this.city = city;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public void setPlot(int x, int y, int width, int depth) {
        this.plot = new Plot(x, y, width, depth);
    }

    // toString method
    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}