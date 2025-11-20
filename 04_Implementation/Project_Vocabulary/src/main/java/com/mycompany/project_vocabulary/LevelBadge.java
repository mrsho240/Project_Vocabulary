package com.mycompany.project_vocabulary;


import java.awt.*;
import javax.swing.*;

public class LevelBadge extends JPanel {

    private JLabel label;

    public LevelBadge() {
        setOpaque(false);
        setLayout(new BorderLayout());
        label = new JLabel("Badge", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 14));
        label.setForeground(Color.BLACK);
        add(label, BorderLayout.CENTER);

        setPreferredSize(new Dimension(100, 30));
        setBackground(new Color(180, 220, 250)); // default
    }

    public void setText(String text) {
        label.setText(text);
        repaint();
    }

    public void setBadgeColor(Color c) {
        setBackground(c);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g);
    }
}