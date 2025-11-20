/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project_vocabulary;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

/**
 *
 * @author chara
 */
public class CBtn extends JButton {

    private Color borderColor = new Color(22, 184, 231);   // default border color
    private Color hoverColor = new Color(22, 184, 231);    // hover color
    private Color textColor1 = new Color(0, 0, 0);
    private Color textColor = new Color(255, 255, 255);
    private int arc = 30;
    private boolean hover = false;

    public CBtn(String text) {
        super(text);
        setContentAreaFilled(false);
        setFocusPainted(false);

        // mouse hover effect
        addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent e) {
                hover = true;
                setForeground(textColor);

                repaint();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent e) {
                hover = false;
                setForeground(textColor1);

                repaint();
            }
        });
    }

    public void setBorderColor(Color c) {
        this.borderColor = c;
        repaint();
    }

    public void setHoverColor(Color c) {
        this.hoverColor = c;
        repaint();
    }

    public void setArc(int arc) {
        this.arc = arc;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fill background on hover
        if (hover) {
            g2.setColor(hoverColor);
            g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc));
            g2.setColor(Color.WHITE); // text white on hover
        } else {
            g2.setColor(Color.WHITE);
            g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc));
            g2.setColor(textColor);
        }

        super.paintComponent(g);

        g2.dispose();
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2.setStroke(new BasicStroke(3));
        g2.setColor(borderColor);
        g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, arc, arc);

        g2.dispose();
    }
}
