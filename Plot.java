
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

public class Plot extends Object {
	private int x;
    private int y;
    private int width;
    private int depth;

    // Constructors
    public Plot() {
        this(0, 0, 1, 1);
    }
    
	public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot otherPlot) {
        this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
    }

    // Getter methods
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    // Setter methods
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    // Method to check if the current plot overlaps with another plot
    public boolean overlaps(Plot plot) {
        return (x < plot.x + plot.width && x + width > plot.x &&
                y < plot.y + plot.depth && y + depth > plot.y);
    }

    // Method to check if the current plot encompasses another plot
    public boolean encompasses(Plot plot) {
        return (x <= plot.x && y <= plot.y &&
                x + width >= plot.x + plot.width && y + depth >= plot.y + plot.depth);
    }

    @Override
    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Plot plot = (Plot) obj;
        return x == plot.x && y == plot.y && width == plot.width && depth == plot.depth;
    }
}