import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class isFileExist {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter file path: ");
        String path = input.nextLine();
        doesFileExist(path);
    }

    public static boolean doesFileExist(String path) throws FileNotFoundException{
        File fileObj = new File(path);
        if (fileObj.isFile()){
            System.out.println("File exist!");

            //read every line of file
            FileReader fileReader = new FileReader(fileObj);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuffer stringBuffer = new StringBuffer();

            String line;
            try {
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuffer.append(line);

                    //System.out.println(line);
                    String[] phrases = line.split("-");
                    System.out.println(phrases[0].trim());

                    if (phrases.length > 1){
                        String[] meanings = phrases[1].split(",");
                        for (int i = 0; i < meanings.length; i++){
                            System.out.println(meanings[i].trim());
                        }
                    }

                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                fileReader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            return true;
        } else {
            System.out.println("File does not exist!");
            return false;
        }
    }

}
