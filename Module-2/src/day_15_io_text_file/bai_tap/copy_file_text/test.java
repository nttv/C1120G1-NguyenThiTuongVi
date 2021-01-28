//package day_15_io_text_file.bai_tap;
//
//import java.io.*;
//import java.util.Scanner;
//
//public class test {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter the name of Input File : ");
//        String nameInputFile = scanner.nextLine();
//        System.out.print("Enter the name of Output File : ");
//        String nameOutputFile = scanner.nextLine();
//​
//        FileReader fileReader;
//        BufferedReader bufferedReader;
//        try {
//            File file = new File(PATH + nameInputFile);
//            if (!file.exists()) {
//                System.out.println("File not found");
//            } else {
//                fileReader = new FileReader(file);
//                bufferedReader = new BufferedReader(fileReader);
//                StringBuffer result = new StringBuffer();
//                String line;
//​
//                while ((line = bufferedReader.readLine()) != null) {
//                    result.append(line);
//                }
//                bufferedReader.close();
//                fileReader.close();
//​
//                FileWriter fileWriter = null;
//                try {
//                    File outputFile = new File(PATH + nameOutputFile);
//                    if (outputFile.exists()) {
//                        System.out.println("File already Exist!");
//                    } else {
//                        fileWriter = new FileWriter(outputFile);
//​
//                        for (int i = 0; i < result.length(); i++) {
//                            fileWriter.write(result.charAt(i));
//                        }
//                        System.out.println("Done");
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                } finally {
//                    if (fileWriter != null) {
//                        try {
//                            fileWriter.close();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                    }
//                }
//            }
//​
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}
