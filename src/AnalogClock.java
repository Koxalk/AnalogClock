import javax.swing.*;
import java.awt.*;

public class AnalogClock extends JFrame{

    public AnalogClock(String title){
        super(title);
        initComp();
    }

    private void initComp() {
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ClockPanel clock = new ClockPanel();

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(clock, BorderLayout.CENTER);

        ButtonPanel bp = new ButtonPanel(clock);

        mainPanel.add(bp, BorderLayout.SOUTH); // Προσθέστε το panel με το κουμπί στο SOUTH

        this.setContentPane(mainPanel);

        Timer timer = new Timer(1000, e -> clock.repaint());
        timer.start();
    }
}
