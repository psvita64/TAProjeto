import java.io.*;
import java.util.ArrayList;

public class FileText {
    public static ArrayList<String> reader(String filePathName) {
        ArrayList<String> result = new ArrayList<>();
        boolean EOF = false;
        try {
            File f = new File(filePathName);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);

            while (!EOF) {
                try {
                    String line = br.readLine();
                    if (line != null) {
                        result.add(line);
                    } else {
                        EOF = true;
                    }
                } catch (NullPointerException error) {
                    System.out.println("Error Message: " + error.getMessage());
                    error.printStackTrace();
                }
            }
            br.close();
            fr.close();

        } catch (IOException error) {
            System.out.println("Error Message: " + error.getMessage());
            error.printStackTrace();
        }
        return result;
    }
    public static void writer(String filePathName, ArrayList<String> list) {

        try {
            File f = new File(filePathName);
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);

            for (String str : list) {
                bw.write(str + "\n", 0, str.length() + 1);
                //or
                //bw.write(str, 0, str.length() );
                //bw.newLine();
            }

            bw.close();
            fw.close();

        } catch (Exception error) {
            System.out.println("Error Message: " + error.getMessage());
            error.printStackTrace();
        }
    }
}

