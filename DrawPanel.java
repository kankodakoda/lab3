import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawPanel extends JPanel {

    private class GraphicsObject {
        private final BufferedImage bufferedImage;
        private final Vehicle car;
        private Point position;

        public GraphicsObject(BufferedImage bufferedImage, Point position, Vehicle car) {
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

        public void setPosition(Point newPosition) {
            position.x = newPosition.x;
            position.y = newPosition.y;
        }

        public Vehicle getCar() {
            return car;
        }
    }

    private ArrayList<GraphicsObject> graphicsObjects;
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    BufferedImage volvoWorkshopImage;

    // Ny konstruktor som tar in listan med bilar
    public DrawPanel(int width, int height, ArrayList<Vehicle> cars) {
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
        for (Vehicle car : cars) {
            Point pos = new Point((int) car.getXPosition(), (int) car.getYPosition());
            BufferedImage image = null;
            if (car instanceof Volvo240) {
                image = volvoImage;
            } else if (car instanceof Saab95) {
                image = saabImage;
            } else if (car instanceof Scania) {
                image = scaniaImage;
            }
            graphicsObjects.add(new GraphicsObject(image, pos, car));
        }
    }

    public void moveit(int x, int y, Vehicle car) {
        for (GraphicsObject gObject : graphicsObjects) {
            // Nu jämförs referenserna korrekt eftersom vi använder samma instanser
            if (gObject.getCar().equals(car)) {
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
