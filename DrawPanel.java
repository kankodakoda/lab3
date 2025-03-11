import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

public class DrawPanel extends JPanel implements VehicleObserver {

    ArrayList<Vehicle> vehicles;
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;
    BufferedImage mercedesImage;
    BufferedImage volvoWorkshopImage;

    // Ny konstruktor som tar in listan med bilar
    public DrawPanel(int width, int height, ArrayList<Vehicle> vehicles, CarMovementHandler movementHandler) {
        this.vehicles = vehicles;
        movementHandler.addObserver(this);
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(Color.green);
        loadImages();
    }

    private void loadImages() {
        try {
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            mercedesImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Mercedes.jpg"));
            volvoWorkshopImage=ImageIO.read(DrawPanel.class.getResourceAsStream("pics/VolvoBrand.jpg"));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Vehicle vehicle : vehicles) {
            BufferedImage vehicleImage = getVehicleImage(vehicle);
            int x = (int) vehicle.getXPosition();
            int y = (int) vehicle.getYPosition();
            g.drawImage(vehicleImage, x, y, null);
        }
        g.drawImage(volvoWorkshopImage, 400, 0, null);
    }

    private BufferedImage getVehicleImage(Vehicle vehicle) {
        if (vehicle instanceof Volvo240) return volvoImage;
        if (vehicle instanceof Saab95) return saabImage;
        if (vehicle instanceof Scania) return scaniaImage;
        if (vehicle instanceof Mercedes) return mercedesImage;
        return null;
    }

    @Override
    public void update() {
        repaint();
    }
}
