import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    private class GraphicsObject {
        private final BufferedImage bufferedImage;
        private final Vehicle car;
        private Point position;


        public GraphicsObject(BufferedImage bufferedImage, Point position, Car car) {
            this.bufferedImage = bufferedImage;
            this.position = position;
            this.car = car;
        }

        public BufferedImage getBufferedImage() {
            return bufferedImage;
        }

        public Point getPosition() {
            return position;
        }

        public void setPoint(Point newPosition) {
            position.x = newPosition.x;
            position.y = newPosition.y;
        }

        public Vehicle getCar() {
            return car;
        }
    }
    ArrayList<GraphicsObject> graphicsObjects;
    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    // To keep track of a single car's position
    Point volvoPoint = new Point();
    Point saabPoint = new Point();
    Point scaniaPoint = new Point();

    BufferedImage volvoWorkshopImage;
    Point volvoWorkshopPoint = new Point(300,300);

    // TODO: Make this general for all cars

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        graphicsObjects = new ArrayList<>();
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {

            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")); // 100 x 60
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            volvoWorkshopImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg")); // 101 x 96
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));

        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        graphicsObjects.add(new GraphicsObject(volvoImage, new Point(), new Volvo240(0,0)));
        graphicsObjects.add(new GraphicsObject(saabImage, new Point(), new Saab95(0,0)));
        graphicsObjects.add(new GraphicsObject(scaniaImage, new Point(), new Scania(0,0)));

    }

    void moveit(int x, int y, Vehicle car){
        volvoPoint.x = x;
        volvoPoint.y = y;
        // Trying to make move function general
        for (GraphicsObject gObject : graphicsObjects) {
            if (gObject.getCar() == carGetType??)
                //update position
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(volvoWorkshopImage, volvoWorkshopPoint.x, volvoWorkshopPoint.y, null);
        g.drawImage(saabImage, saabPoint.x, saabPoint.y, null);
        g.drawImage(scaniaImage, scaniaPoint.x, scaniaPoint.y, null);
    }
}
