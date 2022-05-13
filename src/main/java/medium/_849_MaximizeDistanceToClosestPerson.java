package main.java.medium;

/*
    You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).
    There is at least one empty seat, and at least one person sitting.
    Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
    Return that maximum distance to the closest person.

    Example 1:
    Input: seats = [1,0,0,0,1,0,1]
    Output: 2
    Explanation:
    If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
    If Alex sits in any other open seat, the closest person has distance 1.
    Thus, the maximum distance to the closest person is 2.

    Example 2:
    Input: seats = [1,0,0,0]
    Output: 3
    Explanation:
    If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
    This is the maximum distance possible, so the answer is 3.

    Example 3:
    Input: seats = [0,1]
    Output: 1

    Constraints:
    2 <= seats.length <= 2 * 104
    seats[i] is 0 or 1.
    At least one seat is empty.
    At least one seat is occupied.
*/

public class _849_MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int maxCount = 0;
        int currentCount = 0;
        int leftSeatIndex = -1;
        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 0) {
                currentCount++;
                if(i == seats.length - 1 && maxCount < currentCount) {
                    maxCount = currentCount;
                }
            } else {
                if(leftSeatIndex == -1) {
                    maxCount = currentCount;
                } else {
                    int count = currentCount%2 == 0 ? currentCount / 2 : (currentCount + 1) / 2;
                    if(maxCount < count) {
                        maxCount = count;
                    }
                }
                leftSeatIndex = i;
                currentCount = 0;
            }
        }
        return maxCount;
    }
}

/*
    Runtime: 2 ms, faster than 92.19% of Java online submissions for Maximize Distance to Closest Person.
    Memory Usage: 44.1 MB, less than 93.14% of Java online submissions for Maximize Distance to Closest Person.
*/
