//# You are given a 2D integer array logs where each logs[i] = [birthi, deathi] indicates the birth and death years of the ith person.
//The population of some year x is the number of people alive during that year. The ith person is counted in year x's population if x is in the inclusive range [birthi, deathi - 1]. Note that the person is not counted in the year that they die.
//Return the earliest year with the maximum population.

public class maxPopulation {
    public static void main(String[] args){
        int logs[][]={{1950,1961},{1960,1971},{1970,1981}};
        System.out.println(maximumPopulation(logs));

    }
    public static int maximumPopulation(int[][] logs) {

        int pop[] = new int[2051], res = 0;

        for (var l : logs) {
            ++pop[l[0]];
            --pop[l[1]];
        }
        //creating prefix sum
        for (int i = 1950; i < 2050; ++i) {
            pop[i] += pop[i - 1];
            res = pop[i] > pop[res] ? i : res;//since we need earliest year
        }
        return res;
    }
}
