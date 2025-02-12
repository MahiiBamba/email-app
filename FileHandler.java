import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    public static final String USERS_FILE = "users.txt";
    public static final String EMAILS_FILE = "emails.txt";

    public static void writeIntoFile(String fileName, String data){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))){
            writer.write(data);
            writer.newLine();
        } catch (IOException e){
            System.out.println("Error while writing the data: "+e.getMessage()+" into the file: "+fileName);
        }
    }

    public static List<String> readFromFile(String fileName){
        List<String> lines = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = reader.readLine())!=null){
                lines.add(line);
            }
        }catch (IOException e){
            System.out.println("Error while reading from file: "+fileName);
        }
        return lines;
    }

    public static void updateFile(String fileName, List<String> data){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e){
            System.out.println("Error while writing into file: "+ fileName);
        }
    }
}
