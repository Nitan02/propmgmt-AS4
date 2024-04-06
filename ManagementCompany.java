
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

public class ManagementCompany extends Object {
    // Attributes
    private String name;
    private String taxID;
    private double mgmFeePer;
    static final int MAX_PROPERTY = 5;
    static final int MGMT_WIDTH = 10;
    static final int MGMT_DEPTH = 10;
    private Property[] properties;
    private Plot plot;
    private int numberOfProperties;

    // Constructors
    public ManagementCompany() {
        this.name = "";
        this.taxID = "";
        this.mgmFeePer = 0.0;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmFee) {
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFee;
        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        this(name, taxID, mgmFee);
        this.plot = new Plot(x, y, width, depth);
    }

    public ManagementCompany(ManagementCompany otherCompany) {
        this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFeePer);
    }

    // Methods
    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    public int addProperty(Property property) {
        if (isPropertiesFull())
            return -1;
        else if (property == null)
            return -2;
        else if (!plot.encompasses(property.getPlot()))
            return -3;
        else {
            for (int i = 0; i < properties.length; i++) {
                if (properties[i] == null) {
                    properties[i] = property;
                    numberOfProperties++;
                    return i;
                }
            }
        }
        return -4; // Should not reach here
    }

    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    public boolean isPropertiesFull() {
        return numberOfProperties == MAX_PROPERTY;
    }

    public int getPropertiesCount() {
        return numberOfProperties;
    }

    public double getTotalRent() {
        double totalRent = 0;
        for (Property property : properties) {
            if (property != null)
                totalRent += property.getRentAmount();
        }
        return totalRent;
    }

    public Property getHighestRentProperty() {
        if (numberOfProperties == 0)
            return null;

        Property highestRentProperty = properties[0];
        for (int i = 1; i < numberOfProperties; i++) {
            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
                highestRentProperty = properties[i];
            }
        }
        return highestRentProperty;
    }

    public boolean isMangementFeeValid() {
        return mgmFeePer >= 0 && mgmFeePer <= 100;
    }

    public String getName() {
        return name;
    }

    public String getTaxID() {
        return taxID;
    }

    public double getMgmFeePer() {
        return mgmFeePer;
    }

    public Plot getPlot() {
        return plot;
    }

    public Property[] getProperties() {
        return properties;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("List of the properties for ").append(name).append(", taxID: ").append(taxID).append("\n");
        sb.append("______________________________________________________\n");
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i] != null) {
                sb.append(properties[i].getPropertyName()).append(",").append(properties[i].getCity()).append(",").append(properties[i].getOwner()).append(",").append(properties[i].getRentAmount()).append("\n");
            }
        }
        sb.append("______________________________________________________\n");
        sb.append("\nTotal management Fee: ").append(String.format("%.2f", getTotalManagementFee()));
        return sb.toString();
    }

	double getTotalManagementFee() {
		return getTotalRent() * mgmFeePer / 100;
	}
}