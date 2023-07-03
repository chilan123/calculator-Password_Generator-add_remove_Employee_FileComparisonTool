import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileComparisonTool {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java FileComparisonTool <file1> <file2>");
            return;
        }

        String file1Path = args[0];
        String file2Path = args[1];

        try {
            String file1Content = readFile(file1Path);
            String file2Content = readFile(file2Path);

            compareFiles(file1Path, file1Content, file2Path, file2Content);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the files: " + e.getMessage());
        }
    }

    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    private static void compareFiles(String file1Path, String file1Content, String file2Path, String file2Content) {
        if (file1Content.equals(file2Content)) {
            System.out.println("The files " + file1Path + " and " + file2Path + " are identical.");
        } else {
            System.out.println("Differences found between " + file1Path + " and " + file2Path + ":");
            // Perform more advanced comparison logic if needed
            // For simplicity, this implementation only prints the differing lines
            String[] file1Lines = file1Content.split("\n");
            String[] file2Lines = file2Content.split("\n");
            for (int i = 0; i < file1Lines.length; i++) {
                if (!file1Lines[i].equals(file2Lines[i])) {
                    System.out.println("Line " + (i + 1) + ":\n- " + file1Lines[i] + "\n+ " + file2Lines[i]);
                }
            }
        }
    }
}
