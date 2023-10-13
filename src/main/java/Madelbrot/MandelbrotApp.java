package Madelbrot;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static java.awt.image.ImageObserver.HEIGHT;

public class MandelbrotApp {
    public static void main(String[] args) {
        boolean optParallel = false;
        boolean optDrawGrid = false;
        // Procesar las opciones de la línea de comandos

        MandelbrotFractal fractal = new MandelbrotFractal(HEIGHT);
        MandelbrotCanvas canvas = new MandelbrotCanvas(fractal);

        Frame f = new Frame();
        f.setSize(HEIGHT, HEIGHT);
        f.add(canvas);
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.setVisible(true);
    }
}
