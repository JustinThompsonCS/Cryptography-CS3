import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class PhotoMagic {
    public static Picture transform(Picture pic, LFSR lfsr){
        for (int x = 0; x < pic.width(); x++) {
            for (int y = 0; y < pic.height(); y++) {

                Color color = pic.get(x, y);
                int r = color.getRed()^lfsr.generate(8);
                int g = color.getGreen()^lfsr.generate(8);
                int b = color.getBlue()^lfsr.generate(8);
                Color color1 = new Color(r, g, b);
                pic.set(x, y, color1);


            }
        }
        return pic;
    }
    public static void main(String[] args)throws IOException {
        Picture picture = new Picture(new File("pipe.png"));
        picture.show();
        LFSR lfsr = new LFSR("01101000010100010000", 16);
        Scanner scanner = new Scanner(System.in);
        scanner.next();

        Picture encrypted = transform(picture, lfsr);
        encrypted.show();
        scanner.next();

        lfsr = new LFSR("01101000010100010000", 16);
        Picture decrypted = transform(encrypted, lfsr);
        decrypted.show();


    }
}
