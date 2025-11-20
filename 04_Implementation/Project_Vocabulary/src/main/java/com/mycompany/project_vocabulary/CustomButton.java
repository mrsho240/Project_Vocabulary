/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_vocabulary;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author chara
 */
public class CustomButton extends JButton {

    private Color backgroundColor = new Color(240, 240, 240);
    private Color hoverBackgroundColor = new Color(220, 220, 220);
    private Color borderColor = new Color(200, 200, 200);
    private boolean hover = false;

    public void setBackgroundColor(Color bg) {
        this.backgroundColor = bg;
        repaint();
    }

    public void setHoverBackgroundColor(Color bg) {
        this.hoverBackgroundColor = bg;
        repaint();
    }

    public void setBorderColor(Color c) {
        this.borderColor = c;
        repaint();
    }

    public CustomButton(String text) {
        super(text);

        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setForeground(new Color(30, 100, 255));
        setFont(new Font("SansSerif", Font.PLAIN, 20));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setOpaque(false);

        // Hover Effect
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                hover = true;
                repaint();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                hover = false;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int arc = 40;

        if (hover) {
            g2.setColor(new Color(220, 235, 255));
        } else {
            g2.setColor(Color.WHITE);
        }
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), arc, arc);

        g2.setStroke(new BasicStroke(5));
        g2.setColor(new Color(30, 100, 255));
        g2.drawRoundRect(2, 2, getWidth() - 4, getHeight() - 4, arc, arc);

        super.paintComponent(g);
        g2.dispose();
    }

    @Override
    public boolean isContentAreaFilled() {
        return false;
    }
}
