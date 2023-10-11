package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MandelbrotUI extends JFrame {
    private final int width = 800;
    private final int height = 800;
    private int numWorkers = 4; // Número de trabajadores predeterminado

    public MandelbrotUI() {
        // Configura la interfaz de usuario aquí (JFrame, JPanel, JSpinner, etc.)
    }

    public void pintaMandelbrot() {
        // Actualiza este método para dividir el trabajo y coordinar la concurrencia
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MandelbrotUI mandelbrotUI = new MandelbrotUI();
            mandelbrotUI.setVisible(true);
        });
    }
}
