package day_15_io_text_file.thuc_hanh;

import java.io.FileWriter;
import java.io.IOException;

public class WriteContent {
    //    private static final String PATH = "src/day_15_io_text_file/thuc_hanh/file1.txt";
    private static final String PATH = "src/day_15_io_text_file/thuc_hanh/file2.txt";

    public static void main(String[] args) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(PATH);
//            fileWriter.write("5\n3\n6\n1\n8");
            fileWriter.write("5\n6\n7\nAbc");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
