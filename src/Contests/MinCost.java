package Contests;

import java.util.PriorityQueue;

public class MinCost {

    class Pair implements Comparable<Pair> {
        int row, col, time, cost;

        public Pair(int row, int col, int time, int cost) {
            this.row = row;
            this.col = col;
            this.time = time;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    int[] dr = {1, 0};
    int[] dc = {0, 1};

    public int minCost(int m, int n, int[][] waitCost) {
        int[][][] dist = new int[m][n][2]; // 0 = even second, 1 = odd second

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                dist[i][j][0] = dist[i][j][1] = Integer.MAX_VALUE;

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, 1, 0));
        dist[0][0][1] = 0;

        int answer = Integer.MAX_VALUE;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            int r = cur.row, c = cur.col, t = cur.time, cost = cur.cost;
            int parity = t % 2;

            if (cost > dist[r][c][parity]) continue;

            if (r == m - 1 && c == n - 1) {
                int finalCost = cost + (parity == 0 ? waitCost[r][c] : (r + 1) * (c + 1));
                answer = Math.min(answer, finalCost);
                continue;
            }

            if (parity == 0) { // wait
                int newCost = cost + waitCost[r][c];
                if (newCost < dist[r][c][1]) {
                    dist[r][c][1] = newCost;
                    pq.add(new Pair(r, c, t + 1, newCost));
                }
            } else { // move
                for (int i = 0; i < 2; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];
                    if (nr < m && nc < n) {
                        int moveCost = (nr + 1) * (nc + 1);
                        int newCost = cost + moveCost;
                        if (newCost < dist[nr][nc][0]) {
                            dist[nr][nc][0] = newCost;
                            pq.add(new Pair(nr, nc, t + 1, newCost));
                        }
                    }
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        MinCost solver = new MinCost();
        int[][] waitCost = {{6, 1, 4}, {3, 2, 5}};
        System.out.println(solver.minCost(2, 3, waitCost));  // ✅ Expected: 16
    }
    
}




