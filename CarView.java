import javax.swing.*;
import java.awt.*;

public class CarView extends JFrame{
    private final int X;
    private final int Y;

    // The controller member
    CarController carC;

    CarMovementHandler movementHandler;

    DrawPanel drawPanel;

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int spinnerValue = 0;
    JLabel gasLabel = new JLabel("Amount");
    JLabel vehicleLabel = new JLabel("Vehicle choice");

    VehicleType[] vehicleTypes = {VehicleType.VOLVO,
                                  VehicleType.SAAB,
                                  VehicleType.SCANIA,
                                  VehicleType.MERCEDES,
                                  VehicleType.RANDOM};
    JComboBox<VehicleType> vehicleChoices = new JComboBox<>(vehicleTypes);
    VehicleType selected = vehicleTypes[0];

    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Scania Lift Bed");
    JButton lowerBedButton = new JButton("Lower Lift Bed");
    JButton addCarButton = new JButton("Add Car");
    JButton removeCarButton = new JButton("Remove Car");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");


    // Constructor
    public CarView(String framename, CarController cc, int X, int Y, CarMovementHandler movementHandler){
        this.X = X;
        this.Y = Y;
        this.carC = cc;
        this.movementHandler = movementHandler;
        initComponents(framename);
    }

    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        drawPanel = new DrawPanel(X, Y-240, carC.vehicles, movementHandler);
        this.add(drawPanel);

        SpinnerModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(e -> spinnerValue = (int) ((JSpinner)e.getSource()).getValue());

        // Set layout for value panel
        gasPanel.setLayout(new BoxLayout(gasPanel, BoxLayout.Y_AXIS)); // Stack elements vertically
        gasLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        gasSpinner.setAlignmentX(Component.CENTER_ALIGNMENT);
        vehicleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        vehicleChoices.setAlignmentX(Component.CENTER_ALIGNMENT);

        gasPanel.add(gasLabel);       // Label on top
        gasPanel.add(gasSpinner);     // Spinner below label
        gasPanel.add(vehicleLabel);   // Label on top
        gasPanel.add(vehicleChoices); // ComboBox at the bottom

        this.add(gasPanel);

        // Set layout for button panel
        controlPanel.setLayout(new GridLayout(2, 5));

        // Row 1
        controlPanel.add(gasButton);
        controlPanel.add(turboOnButton);
        controlPanel.add(liftBedButton);
        controlPanel.add(startButton);
        controlPanel.add(addCarButton);

        // Row 2
        controlPanel.add(brakeButton);
        controlPanel.add(turboOffButton);
        controlPanel.add(lowerBedButton);
        controlPanel.add(stopButton);
        controlPanel.add(removeCarButton);

        controlPanel.setPreferredSize(new Dimension(X-150, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        // Action listeners
        gasButton.addActionListener(e -> carC.inputHandler.gas(spinnerValue));

        brakeButton.addActionListener(e -> carC.inputHandler.brake(spinnerValue));

        turboOnButton.addActionListener(e -> carC.inputHandler.setTurboOn());

        turboOffButton.addActionListener(e -> carC.inputHandler.setTurboOff());

        liftBedButton.addActionListener(e -> carC.inputHandler.raiseRamp(spinnerValue));

        lowerBedButton.addActionListener(e -> carC.inputHandler.lowerRamp(spinnerValue));

        startButton.addActionListener(e -> carC.inputHandler.startAllCars());

        stopButton.addActionListener(e -> carC.inputHandler.stopAllCars());

        vehicleChoices.addActionListener(e -> selected = (VehicleType) vehicleChoices.getSelectedItem());

        addCarButton.addActionListener(e -> carC.inputHandler.addVehicle(selected));

        removeCarButton.addActionListener(e -> carC.inputHandler.removeVehicle());

        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}