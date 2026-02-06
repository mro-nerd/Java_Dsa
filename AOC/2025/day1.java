import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class day1 {
    public static void main(String[] args) {
        int position = 50; // starting point
        int countZero = 0;

        // Adjust the file path to your input file
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                char direction = line.charAt(0);
                int steps = Integer.parseInt(line.substring(1));

                if (direction == 'L') {
                    position = (position - steps)%100;
                } else if (direction == 'R') {
                    position = (position + steps) % 100;
                }

                // Handle negative values properly
                if (position < 0) {
                    position += 100;
                }

                if (position == 0) {
                    countZero++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Password: " + countZero);
    }
}