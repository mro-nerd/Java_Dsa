/*Theodore implements a new strategy game “Defense of a Kingdom”. On each level a player defends the Kingdom that is represented by a rectangular grid of cells. The player builds crossbow towers in some cells of the grid. The tower defends all the cells in the same row and the same column. No two towers share a row or a column.

The penalty of the position is the number of cells in the largest undefended rectangle.

Input
The first line of the input file contains the number of test cases.

Each test case consists of a line with three integer numbers: w — width of the grid, h — height of the grid and n — number of crossbow towers (1 ≤ w, h ≤ 40 000; 0 ≤ n ≤ min(w, h)).

Each of the following n lines contains two integer numbers xi and yi — the coordinates of the cell occupied by a tower (1 ≤ xi ≤ w; 1 ≤ yi ≤ h).

Output
For each test case, output a single integer number — the number of cells in the largest rectangle that is not defended by the towers.

Example
Input:
1
15 8 3
3 8
11 2
8 6

Output:
12*/

import java.io.*;
import java.util.*;

public class defenceKingdom {
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
		int t = Integer.parseInt(r.readLine());

		while(t-- > 0) {
			String line[] = r.readLine().split(" ");
			int w = Integer.parseInt(line[0]);
			int h = Integer.parseInt(line[1]);
			int n = Integer.parseInt(line[2]);

			if(n == 0) { // Needs to be handled separately
				wr.print(h*w);
				wr.print('\n');
				continue;
			}

			ArrayList<Integer> x = new ArrayList<>();
			ArrayList<Integer> y = new ArrayList<>();

			for(int i = 0; i < n; ++i) {
				String xy[] = r.readLine().split(" ");
				x.add(Integer.parseInt(xy[0]));
				y.add(Integer.parseInt(xy[1]));
			}

			Collections.sort(x);
			Collections.sort(y);

			int width = Math.max(x.get(0) - 1, w - x.get(n-1));
			int height = Math.max(y.get(0) - 1, h - y.get(n-1));

			for(int i = 1; i < n; ++i) {
				width = Math.max(width, x.get(i) - x.get(i-1) - 1);
				height = Math.max(height, y.get(i) - y.get(i-1) - 1);
			}

			wr.print(height*width);
			wr.print('\n');
		}
		r.close();
        wr.close();
    }
}
