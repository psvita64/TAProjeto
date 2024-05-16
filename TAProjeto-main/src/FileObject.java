import java.io.*;
import java.util.ArrayList;
public class FileObject<T extends Serializable> implements Serializable {

    public ArrayList<T> reader(String filePathName) {
        ArrayList<T> result = new ArrayList<>();

        try {

            File f = new File(filePathName);
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);

            while (fis.available() > 0) {

                try {

                    T obj;
                    obj = (T) ois.readObject();
                    result.add(obj);

                } catch (ClassNotFoundException error) {

                    System.out.println("Error Message (ClassNotFoundException): " + error.getMessage());
                    error.printStackTrace();

                }

            }

            fis.close();
            ois.close();

        } catch (IOException error) {

            System.out.println("Error Message (IOException): " + error.getMessage());
            error.printStackTrace();

        }

        return result;
    }

    public void writer(String filePathName, ArrayList<T> list) {

        try {

            File f = new File(filePathName);
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            for (T obj: list) {
                oos.writeObject(obj);
            }

            fos.close();
            oos.close();

        } catch (IOException error) {

            System.out.println("Error Message: " + error.getMessage());
            error.printStackTrace();

        }
    }
}
