package day_15_io_text_file.thuc_hanh;

import java.io.File;
import java.io.IOException;

public class CreateFile {
    private static final String PATH = "src/day_15_io_text_file/thuc_hanh";

    public static void main(String[] args) {
        File file1 = new File(PATH, "file1.txt");
//        File file2 = new File(PATH, "file2.txt");
        try {
            if (file1.createNewFile()) {
                System.out.println("File created..");
            } else {
                System.out.println("File already exists..");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
