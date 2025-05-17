package Util;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class FontLoader {

    public Font importFont(String filePath, float size){
        try {
            InputStream is = getClass().getResourceAsStream(filePath);
            if(is != null){
                return Font.createFont(Font.TRUETYPE_FONT, is).deriveFont(size);
            } else{
                System.err.println("Error loading font file: " + filePath);
            }
        }  catch (IOException | FontFormatException e){
            System.err.println("Error loading font: " + e.getMessage());
        }
        return null;
    }

}