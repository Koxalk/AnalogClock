import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;

public class ClockPanel extends JPanel {

    private boolean isDarkMode = false;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();
        int clockRadius = (int) (Math.min(width, height) * 0.4);
        int centerX = width / 2;
        int centerY = height / 2;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Define colors based on dark or light mode
        Color clockColor = isDarkMode ? new Color(18, 19, 26) : Color.WHITE;
        Color textColor = isDarkMode ? Color.WHITE : Color.BLACK;
        Color indicatorColor = new Color(231, 76, 60);

        // Draw clock face
        g2.setColor(clockColor);
        g2.fill(new Ellipse2D.Double(centerX - clockRadius, centerY - clockRadius, 2 * clockRadius, 2 * clockRadius));
        g2.setColor(textColor);
        g2.setFont(new Font("Poppins", Font.BOLD, 22));

        // Draw hour markings
        for (int i = 1; i <= 12; i++) {
            double angle = Math.toRadians(30 * i - 90);
            int x = (int) (centerX + Math.cos(angle) * clockRadius * 0.85);
            int y = (int) (centerY + Math.sin(angle) * clockRadius * 0.85);
            g2.drawString(Integer.toString(i), x - 10, y + 10);
        }

        // Get current time
        int hour = java.time.LocalTime.now().getHour() % 12;
        int minute = java.time.LocalTime.now().getMinute();
        int second = java.time.LocalTime.now().getSecond();

        // Draw hour hand
        int hourHandLength = (int) (clockRadius * 0.5);
        double hourAngle = Math.toRadians((hour * 30) - 90 + (0.5 * minute));
        g2.setColor(textColor);
        g2.setStroke(new BasicStroke(8));
        g2.draw(new Line2D.Double(centerX, centerY, centerX + Math.cos(hourAngle) * hourHandLength, centerY + Math.sin(hourAngle) * hourHandLength));

        // Draw minute hand
        int minuteHandLength = (int) (clockRadius * 0.7);
        double minuteAngle = Math.toRadians((minute * 6) - 90 + (0.1 * second));
        g2.setStroke(new BasicStroke(5));
        g2.draw(new Line2D.Double(centerX, centerY, centerX + Math.cos(minuteAngle) * minuteHandLength, centerY + Math.sin(minuteAngle) * minuteHandLength));

        // Draw second hand
        int secondHandLength = (int) (clockRadius * 0.8);
        double secondAngle = Math.toRadians((second * 6) - 90);
        g2.setColor(indicatorColor);
        g2.setStroke(new BasicStroke(2));
        g2.draw(new Line2D.Double(centerX, centerY, centerX + Math.cos(secondAngle) * secondHandLength, centerY + Math.sin(secondAngle) * secondHandLength));
    }

    public boolean isDarkMode() {
        return isDarkMode;
    }

    public void setDarkMode(boolean darkMode) {
        isDarkMode = darkMode;
    }
}
