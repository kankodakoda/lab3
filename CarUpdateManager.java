import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CarUpdateManager {
    private final Timer timer;
    private final CarMovementHandler movementHandler;
    private final CollisionHandler collisionHandler;
    private final DrawPanel drawPanel; // Interface for DrawPanel
    private final LoadingHandler loadingHandler;

    public CarUpdateManager(CarMovementHandler movementHandler, DrawPanel drawPanel, LoadingHandler loadingHandler) {
        this.movementHandler = movementHandler;
        this.drawPanel = drawPanel;
        this.timer = new Timer(5, new TimerListener());
        this.loadingHandler = loadingHandler;
        this.collisionHandler = collisionHandler;
    }

    public void start() {
        timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            movementHandler.moveCars();
            collisionHandler.handleFrameCollision();
            loadingHandler.handleLoading();
            //drawPanel.updateGraphics();
        }
    }
}
