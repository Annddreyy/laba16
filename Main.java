import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String text = "";
        try (FileReader fr = new FileReader("C:\\Users\\Andre\\IdeaProjects\\regEx\\src\\TestProgram.java")) {
            int code = -1;
            while ((code = fr.read()) != -1){
                sb.append(Character.toChars(code));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        text = sb.toString();

        Pattern pattern1 = Pattern.compile("\n(\\s*?)/\\*(.*?)\\*/", Pattern.DOTALL);
        Matcher matcher = pattern1.matcher(text);

        while (matcher.find()){
            String comm = matcher.group(0);
            sb.replace(sb.indexOf(comm), sb.indexOf(comm) + comm.length(), "");
            text = sb.toString();
        }

        Pattern pattern2 = Pattern.compile("\n(.*)//(.*)");
        matcher = pattern2.matcher(text);

        while (matcher.find()){
            String comm = matcher.group(0);
            sb.replace(sb.indexOf(comm), sb.indexOf(comm) + comm.length(), "");
            text = sb.toString();
        }

        try (FileWriter fw = new FileWriter("C:\\Users\\Andre\\IdeaProjects\\regEx\\src\\NewTestProgram.java")) {
            for (int i = 0; i < text.length(); i++){
                fw.write(text.charAt(i));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //System.out.println(text);
    }
}
