import javax.swing.*;
import java.awt.*;

public class ButtonPanel extends JPanel {

    private ClockPanel clockPanel;
    public ButtonPanel(ClockPanel clockPanel) {
        this.clockPanel = clockPanel;
        initComp();
    }

    private void initComp() {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton button = new JButton("Dark Mode");
        button.setBackground(Color.BLACK);

        Font buttonFont = button.getFont();
        button.setFont(new Font(buttonFont.getFontName(), Font.PLAIN, 14));
        button.setFocusPainted(false);
        button.addActionListener(e -> {
            clockPanel.setDarkMode(!clockPanel.isDarkMode());
            clockPanel.repaint();
            updateButtonColor(button,clockPanel.isDarkMode());
        });

        this.add(button);
    }

    private void updateButtonColor(JButton button,boolean isDarkMode) {
        if (isDarkMode) {
            button.setBackground(Color.WHITE);
            button.setForeground(Color.BLACK); // Set text color for visibility
            button.setText("Light Mode");
        } else {
            button.setBackground(Color.BLACK);
            button.setForeground(Color.WHITE); // Set text color for visibility
            button.setText("Dark Mode");
        }
    }
}
