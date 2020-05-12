import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Scanner;

public class PhotoMagicDeluxe {
    public static void main(String[] args)throws IOException {
        String password = "OPENSESAME";

        String binary = "001110001111000100001101010010000100010010000000001100000100";


        LFSR lfsr = new LFSR(binary, 58);
        Picture picture = new Picture(new File("mystery.png"));
        picture.show();
        Scanner scanner = new Scanner(System.in);
        scanner.next();

        Picture decrypted = PhotoMagic.transform(picture, lfsr);
        decrypted.show();

    }
}
