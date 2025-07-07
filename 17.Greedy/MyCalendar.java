/*You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.

A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).

The event can be represented as a pair of integers startTime and endTime that represents a booking on the half-open interval [startTime, endTime), the range of real numbers x such that startTime <= x < endTime.

Implement the MyCalendar class:

MyCalendar() Initializes the calendar object.
boolean book(int startTime, int endTime) Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
 

Example 1:

Input
["MyCalendar", "book", "book", "book"]
[[], [10, 20], [15, 25], [20, 30]]
Output
[null, true, false, true]

Explanation
MyCalendar myCalendar = new MyCalendar();
myCalendar.book(10, 20); // return True
myCalendar.book(15, 25); // return False, It can not be booked because time 15 is already booked by another event.
myCalendar.book(20, 30); // return True, The event can be booked, as the first event takes every time less than 20, but not including 20. */

import java.util.HashMap;

class MyCalendar {
    HashMap<Integer, Integer> map;

    public MyCalendar() {
        map = new HashMap<>();
    }

    public boolean book(int start, int end) {
        for (Integer val : map.keySet()) {
            if (val < end && map.get(val) > start) {
                return false;
            }
        }
        map.put(start, end);
        return true;
    }

    // Main function to test the MyCalendar class
    public static void main(String[] args) {
        MyCalendar calendar = new MyCalendar();

        // Test cases
        System.out.println(calendar.book(10, 20)); // Output: true
        System.out.println(calendar.book(15, 25)); // Output: false (overlaps with previous booking)
        System.out.println(calendar.book(20, 30)); // Output: true (does not overlap)
        System.out.println(calendar.book(5, 10));  // Output: true
        System.out.println(calendar.book(25, 35)); // Output: false
    }
}
