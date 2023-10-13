package Madelbrot;

import java.util.concurrent.RecursiveAction;

public class FractalTask extends RecursiveAction {
    private final MandelbrotFractal fractal;
    private final int srcX;
    private final int srcY;
    private final int size;
    private static final int SEQ_CUTOFF = 64; // Valor de SEQ_CUTOFF

    public FractalTask(MandelbrotFractal fractal, int srcX, int srcY, int size) {
        this.fractal = fractal;
        this.srcX = srcX;
        this.srcY = srcY;
        this.size = size;
    }

    @Override
    protected void compute() {
        if (size < SEQ_CUTOFF) {
            fractal.calculateMandelbrot(srcX, srcY, size);
        } else {
            int halfSize = size / 2;

            FractalTask upperLeftTask = new FractalTask(fractal, srcX, srcY, halfSize);
            FractalTask upperRightTask = new FractalTask(fractal, srcX + halfSize, srcY, halfSize);
            FractalTask lowerLeftTask = new FractalTask(fractal, srcX, srcY + halfSize, halfSize);
            FractalTask lowerRightTask = new FractalTask(fractal, srcX + halfSize, srcY + halfSize, halfSize);

            invokeAll(upperLeftTask, upperRightTask, lowerLeftTask, lowerRightTask);
        }
    }
}

