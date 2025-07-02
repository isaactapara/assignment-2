import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class RadioButtonDemo extends JFrame implements ActionListener {

    private final JRadioButton birdBtn;
    private final JRadioButton catBtn;
    private final JRadioButton dogBtn;
    private final JRadioButton rabbitBtn;
    private final JRadioButton pigBtn;
    private final JLabel imageLabel;
    private final ButtonGroup group;

    public RadioButtonDemo() {
        setTitle("RadioButtonDemo");
        setSize(500, 350);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up radio buttons
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));

        birdBtn = new JRadioButton("Bird");
        catBtn = new JRadioButton("Cat");
        dogBtn = new JRadioButton("Dog");
        rabbitBtn = new JRadioButton("Rabbit");
        pigBtn = new JRadioButton("Pig");

        group = new ButtonGroup();
        group.add(birdBtn);
        group.add(catBtn);
        group.add(dogBtn);
        group.add(rabbitBtn);
        group.add(pigBtn);

        radioPanel.add(birdBtn);
        radioPanel.add(catBtn);
        radioPanel.add(dogBtn);
        radioPanel.add(rabbitBtn);
        radioPanel.add(pigBtn);

        birdBtn.addActionListener(this);
        catBtn.addActionListener(this);
        dogBtn.addActionListener(this);
        rabbitBtn.addActionListener(this);
        pigBtn.addActionListener(this);

        // Label to show image
        imageLabel = new JLabel("Select a pet", SwingConstants.CENTER);
        imageLabel.setVerticalAlignment(SwingConstants.CENTER);
        imageLabel.setPreferredSize(new Dimension(200, 200));

        add(radioPanel, BorderLayout.WEST);
        add(imageLabel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String pet = "";
        String imagePath = "images/";

        if (e.getSource() == birdBtn) {
            pet = "Bird";
            imagePath += "bird.jpeg";
        } else if (e.getSource() == catBtn) {
            pet = "Cat";
            imagePath += "cat.jpeg";
        } else if (e.getSource() == dogBtn) {
            pet = "Dog";
            imagePath += "dog.jpeg";
        } else if (e.getSource() == rabbitBtn) {
            pet = "Rabbit";
            imagePath += "rabbit.jpeg";
        } else if (e.getSource() == pigBtn) {
            pet = "Pig";
            imagePath += "pig.jpeg";
        }

        File imgFile = new File(imagePath);
        if (imgFile.exists()) {
            ImageIcon icon = new ImageIcon(imagePath);
            Image scaledImage = icon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            imageLabel.setIcon(new ImageIcon(scaledImage));
            imageLabel.setText("");
        } else {
            imageLabel.setIcon(null);
            imageLabel.setText("Image not found!");
        }

        JOptionPane.showMessageDialog(this, "You selected: " + pet);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RadioButtonDemo::new);
    }
}
