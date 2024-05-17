import java.io.*;
import java.util.ArrayList;

public class FileText<T extends Serializable> implements Serializable {
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
    public void writer(String fileName, ArrayList<T> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (T obj : list) {
                bw.write(obj.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

