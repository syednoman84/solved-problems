package problems.MathGeometry;

/*
You are given a stream of points consisting of x-y coordinates on a 2-D plane. Points can be added and queried as follows:

    Add - new points can be added to the stream into a data structure. Duplicate points are allowed and should be treated as separate points.
    Query - Given a single query point, count the number of ways to choose three additional points from the data structure such that the three points and the query point form a square. The square must have all sides parallel to the x-axis and y-axis, i.e. no diagonal squares are allowed. Recall that a square must have four equal sides.

Implement the CountSquares class:

    CountSquares() Initializes the object.
    void add(int[] point) Adds a new point point = [x, y].
    int count(int[] point) Counts the number of ways to form valid squares with point point = [x, y] as described above.

Example 1:
Input:
["CountSquares", "add", [[1, 1]], "add", [[2, 2]], "add", [[1, 2]], "count", [[2, 1]], "count", [[3, 3]], "add", [[2, 2]], "count", [[2, 1]]]

Output:
[null, null, null, null, 1, 0, null, 2]

Explanation:
CountSquares countSquares = new CountSquares();
countSquares.add([1, 1]);
countSquares.add([2, 2]);
countSquares.add([1, 2]);

countSquares.count([2, 1]);   // return 1.
countSquares.count([3, 3]);   // return 0.
countSquares.add([2, 2]);     // Duplicate points are allowed.
countSquares.count([2, 1]);   // return 2.

Constraints:

    point.length == 2
    0 <= x, y <= 1000
 */

import java.util.HashMap;
import java.util.Map;

public class DetectSquares {
    private Map<Integer, Map<Integer, Integer>> ptsCount;

    public DetectSquares() {
        ptsCount = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        ptsCount.putIfAbsent(x, new HashMap<>());
        ptsCount.get(x).put(y, ptsCount.get(x).getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int res = 0, x1 = point[0], y1 = point[1];

        if (!ptsCount.containsKey(x1)) return res;

        for (int y2 : ptsCount.get(x1).keySet()) {
            int side = y2 - y1;
            if (side == 0) continue;

            int x3 = x1 + side, x4 = x1 - side;
            res += ptsCount.get(x1).get(y2) *
                    ptsCount.getOrDefault(x3, new HashMap<>()).getOrDefault(y1, 0) *
                    ptsCount.getOrDefault(x3, new HashMap<>()).getOrDefault(y2, 0);

            res += ptsCount.get(x1).get(y2) *
                    ptsCount.getOrDefault(x4, new HashMap<>()).getOrDefault(y1, 0) *
                    ptsCount.getOrDefault(x4, new HashMap<>()).getOrDefault(y2, 0);
        }

        return res;
    }
}