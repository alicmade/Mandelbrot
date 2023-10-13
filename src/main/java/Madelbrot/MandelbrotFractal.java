package Madelbrot;

import java.awt.Color;

public class MandelbrotFractal {
    private int[] colorscheme;
    private int[] fractal;
    private int height;

    public MandelbrotFractal(int height) {
        this.height = height;
        this.colorscheme = createColorScheme();
        this.fractal = new int[height * height];
    }

    public int getHeight() {
        return height;
    }

    private int[] createColorScheme() {
        int[] colors = new int[256];

        // Generar una paleta de colores desde rojo a azul
        for (int i = 0; i < 256; i++) {
            int red = i;
            int green = 0;
            int blue = 255 - i;
            colors[i] = new Color(red, green, blue).getRGB();
        }

        return colors;
    }

    public void calculateMandelbrot(int srcX, int srcY, int size) {
        // Iterar a través de los píxeles y calcular los valores del fractal
        for (int px = srcX; px < srcX + size; px++) {
            for (int py = srcY; py < srcY + size; py++) {
                double x = 0;
                double y = 0;
                double cx = (px * 4.0) / height - 2;
                double cy = 2 - (py * 4.0) / height;
                int k = 0;

                while (k < 255) {
                    double xTemp = x * x - y * y + cx;
                    y = 2 * x * y + cy;
                    x = xTemp;

                    if (x * x + y * y > 4) {
                        break;
                    }
                    k++;
                }

                fractal[px + height * py] = colorscheme[k];
            }
        }
    }

    public void drawGrid(int srcX, int srcY, int size, int color) {
        // Dibujar una cuadrícula en los bordes del área
        for (int i = 0; i < size; i++) {
            fractal[srcX + i + height * srcY] = color;
            fractal[srcX + i + height * (srcY + size - 1)] = color;
        }
        for (int j = 0; j < size; j++) {
            fractal[srcX + height * (srcY + j)] = color;
            fractal[srcX + size - 1 + height * (srcY + j)] = color;
        }
    }

    public int[] getFractal() {
        return fractal;
    }
}

