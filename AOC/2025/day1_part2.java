import java.io.*;

public class day1_part2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("day1.txt"));

        long answer = 0;
        long dial = 1_000_000_000L + 50; // keep dial positive

        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.isEmpty()) continue;

            int rotateBy = Integer.parseInt(line.substring(1));
            char dir = line.charAt(0);

            for (int i = 0; i < rotateBy; i++) {
                if (dir == 'L') {	
                    dial -= 1;
                } else {
                    dial += 1;
                }

                if (dial % 100 == 0) {
                    answer++;
                }
            }
        }

        br.close();
        System.out.println("Answer: " + answer);
    }
}
