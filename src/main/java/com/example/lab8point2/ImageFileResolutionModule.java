package com.example.lab8point2;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.PrintStream;
import java.util.Arrays;

@Component
public class ImageFileResolutionModule implements IModuleFile {
    @Override
    public boolean isSupported(String path) {
        return path != null && Arrays.asList(new String[] {"png", "jpg"}).contains(FilenameUtils.getExtension(path));
    }

    @Override
    public String getDescription() {
        return "Считает разрешение изображения";
    }

    @Override
    public void execute(String path, PrintStream stream) {
        try {
            if(!isSupported(path)) {
                throw new UnsupportedOperationException();
            }
            BufferedImage image = ImageIO.read(new File(path));
            stream.println("Ширина изображения:" + image.getWidth() + ", высота:" + image.getHeight());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}