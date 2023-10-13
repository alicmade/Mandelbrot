package Madelbrot;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.Raster;
import java.awt.image.SampleModel;
import java.awt.image.WritableRaster;

public class MandelbrotCanvas extends Canvas {

    private final MandelbrotFractal fractal;
    private Image img;
    private String msg;

    public MandelbrotCanvas(MandelbrotFractal fractal) {
        this.fractal = fractal;
        this.img = getImageFromArray(fractal.getFractal(), fractal.getHeight(), fractal.getHeight());
        // Otras inicializaciones
    }

    @Override
    public void paint(Graphics g) {
        // Dibuja el fractal desde la imagen almacenada
        g.drawImage(this.img, 0, 0, null);

        // Dibuja el mensaje de texto en la esquina inferior derecha
        byte[] data = this.msg.getBytes();
        g.drawBytes(data, 0, data.length, getWidth() - (data.length * 8), getHeight() - 20);
    }

    private Image getImageFromArray(int[] pixels, int width, int height) {
        // Crea una imagen a partir de un array de píxeles
        ColorModel cm = DirectColorModel.getRGBdefault();
        SampleModel sampleModel = cm.createCompatibleSampleModel(width, height);
        DataBuffer db = new DataBufferInt(pixels, height, 0);
        WritableRaster raster = Raster.createWritableRaster(sampleModel, db, null);
        BufferedImage image = new BufferedImage(cm, raster, false, null);
        return image;
    }


}
