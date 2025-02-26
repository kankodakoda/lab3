import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawPanel extends JPanel {

    private static class GraphicsObject {
        private final BufferedImage bufferedImage;
        private final Vehicle vehicle;
        private final Point position;

        public GraphicsObject(BufferedImage bufferedImage, Point position, Vehicle vehicle) {
            this.bufferedImage = bufferedImage;
            this.position = position;
            this.vehicle = vehicle;
        }

        public BufferedImage getBufferedImage() {
            return bufferedImage;
        }

        public Point getPosition() {
            return position;
        }

        public void setPosition(Point newPosition) {
            position.x = newPosition.x;
            position.y = newPosition.y;
        }

        public Vehicle getVehicle() {
            return vehicle;
        }
    }

    private ArrayList<GraphicsObject> graphicsObjects;
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    BufferedImage volvoWorkshopImage;

    // Ny konstruktor som tar in listan med bilar
    public DrawPanel(int width, int height, ArrayList<Vehicle> vehicles) {
        graphicsObjects = new ArrayList<>();
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.green);
        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            volvoWorkshopImage=ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        // Använd samma bilinstanser som finns i modellen
        for (Vehicle vehicle : vehicles) {
            Point pos = new Point((int) vehicle.getXPosition(), (int) vehicle.getYPosition());
            BufferedImage image = null;
            if (vehicle instanceof Volvo240) {
                image = volvoImage;
            } else if (vehicle instanceof Saab95) {
                image = saabImage;
            } else if (vehicle instanceof Scania) {
                image = scaniaImage;
            }
            graphicsObjects.add(new GraphicsObject(image, pos, vehicle));
        }
    }

    public void moveit(int x, int y, Vehicle vehicle) {
        for (GraphicsObject gObject : graphicsObjects) {
            // Nu jämförs referenserna korrekt eftersom vi använder samma instanser
            if (gObject.getVehicle().equals(vehicle)) {
                gObject.setPosition(new Point(x, y));
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (GraphicsObject graObj : graphicsObjects) {
            g.drawImage(graObj.getBufferedImage(), graObj.getPosition().x, graObj.getPosition().y, null);
            g.drawImage(volvoWorkshopImage, 300, 0, null);
        }
    }
}
