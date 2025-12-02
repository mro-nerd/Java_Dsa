/*You are given a stream of records about a particular stock. Each record contains a timestamp and the corresponding price of the stock at that timestamp.

Unfortunately due to the volatile nature of the stock market, the records do not come in order. Even worse, some records may be incorrect. Another record with the same timestamp may appear later in the stream correcting the price of the previous wrong record.

Design an algorithm that:

(i)Updates the price of the stock at a particular timestamp, correcting the price from any previous records at the timestamp.
(ii)Finds the latest price of the stock based on the current records. The latest price is the price at the latest timestamp recorded.
(iii)Finds the maximum price the stock has been based on the current records.
(iv)Finds the minimum price the stock has been based on the current records.

Implement the StockPrice class:

(i)StockPrice() Initializes the object with no price records.
(ii)void update(int timestamp, int price) Updates the price of the stock at the given timestamp.
(iii)int current() Returns the latest price of the stock.
(iv)int maximum() Returns the maximum price of the stock.
(v)int minimum() Returns the minimum price of the stock.
 
Example 1:

Input:
["StockPrice", "update", "update", "current", "maximum", "update", "maximum", "update", "minimum"]
[[], [1, 10], [2, 5], [], [], [1, 3], [], [4, 2], []]

Output:
[null, null, null, 5, 10, null, 5, null, 2]

Explanation:

StockPrice stockPrice = new StockPrice();
stockPrice.update(1, 10); // Timestamps are [1] with corresponding prices [10].
stockPrice.update(2, 5);  // Timestamps are [1,2] with corresponding prices [10,5].
stockPrice.current();     // return 5, the latest timestamp is 2 with the price being 5.
stockPrice.maximum();     // return 10, the maximum price is 10 at timestamp 1.
stockPrice.update(1, 3);  // The previous timestamp 1 had the wrong price, so it is updated to 3.
                          // Timestamps are [1,2] with corresponding prices [3,5].
stockPrice.maximum();     // return 5, the maximum price is 5 after the correction.
stockPrice.update(4, 2);  // Timestamps are [1,2,4] with corresponding prices [3,5,2].
stockPrice.minimum();     // return 2, the minimum price is 2 at timestamp 4. 
*/

import java.util.*;

class StockPrice {
    HashMap<Integer, Integer> timeToPrice;
    TreeMap<Integer, Integer> priceToFreq;
    int latestTime;

    public StockPrice() {
        latestTime = 0;
        timeToPrice = new HashMap<>();
        priceToFreq = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        latestTime = Math.max(latestTime, timestamp);

        // Decrement the frequency of oldPrice (if exists)
        if (timeToPrice.containsKey(timestamp)) {
            int oldPrice = timeToPrice.get(timestamp);
            int freqOfOldPrice = priceToFreq.get(oldPrice);

            if (freqOfOldPrice == 1)
                priceToFreq.remove(oldPrice);
            else
                priceToFreq.put(oldPrice, freqOfOldPrice - 1);
        }

        // Increment the frequency of the new price
        int curFreqOfNewPrice = priceToFreq.getOrDefault(price, 0);
        priceToFreq.put(price, curFreqOfNewPrice + 1);

        // Update price of timestamp to 'price' in timeToPrice
        timeToPrice.put(timestamp, price);
    }

    public int current() { // O(1)
        return timeToPrice.get(latestTime);
    }

    public int maximum() { // O(logN)
        return priceToFreq.lastKey();
    }

    public int minimum() { // O(logN)
        return priceToFreq.firstKey();
    }
}

public class stockPrices {
    public static void main(String[] args) {
        // Create a StockPrice object
        StockPrice stockPrice = new StockPrice();

        // Sample updates
        stockPrice.update(1, 10);
        stockPrice.update(2, 5);
        stockPrice.update(3, 12);
        stockPrice.update(4, 5); // Updating an existing timestamp

        // Test methods
        System.out.println("Current price: " + stockPrice.current()); // Should output 5
        System.out.println("Maximum price: " + stockPrice.maximum()); // Should output 12
        System.out.println("Minimum price: " + stockPrice.minimum()); // Should output 5
        stockPrice.update(3, 1);
        System.out.println("Maximum price: " + stockPrice.maximum()); // Should output 10
        System.out.println("Minimum price: " + stockPrice.minimum()); // Should output 1 
    }
}
