class Solution {
    int n, m;
    int[][] arrow = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    List<List<Integer>> forest;

    public int cutOffTree(List<List<Integer>> forest) {
      int i, j, ans = 0;
      PriorityQueue<Tree> pq = new PriorityQueue<>();
      this.forest = forest;
      this.n = forest.size();
      this.m = forest.get(0).size();
      for (i = 0; i < n; i++) {
        for (j = 0; j < m; j++) {
          if (forest.get(i).get(j) < 2) {
            continue;
          }
          pq.add(new Tree(i, j, forest.get(i).get(j)));
        }
      }

      int nowX = 0, nowY = 0, count;

      while (pq.size() != 0) {
        Tree next = pq.poll();
        count = findNext(nowX, nowY, next);
        if (count == -1) {
          ans = -1;
          break;
        }
        ans += count;
        nowX = next.x;
        nowY = next.y;
      }

      return ans;
    }

    private int findNext(int nowX, int nowY, Tree next) {
      Queue<Position> pq = new LinkedList<>();
      pq.add(new Position(nowX, nowY, 0));
      int[][] visited = new int[n][m];
      int i, j;

      while (pq.size() != 0) {
        Position cur = pq.poll();
        for (i = 0; i < 4; i++) {
            int nxtX = cur.x + arrow[i][0];
            int nxtY = cur.y + arrow[i][1];
            if (nxtX == -1 || nxtX == n || nxtY == -1 || nxtY == m) continue;
            if (forest.get(nxtX).get(nxtY) == 0) continue;
            if (visited[nxtX][nxtY] != 0) continue;
            if (nxtX == next.x && nxtY == next.y) {
                return cur.count + 1;
            }
            visited[nxtX][nxtY] = 1;
            pq.add(new Position(arrow[i], cur));
        }
      }

      return -1;
    }

    class Position {
      int x;
      int y;
      int count;

      public Position(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
      }

      public Position(int[] arrow, Position cur) {
        this.x = cur.x + arrow[0];
        this.y = cur.y + arrow[1];
        this.count = cur.count + 1;
      }


      boolean isArrived(Tree tree) {
        return this.x == tree.x && this.y == tree.y;
      }
    }


    class Tree implements Comparable<Tree> {
      int x, y, treeSize;

      Tree(int x, int y, int treeSize) {
        this.x = x;
        this.y = y;
        this.treeSize = treeSize;
      }

      @Override
      public int compareTo(Tree o) {
        return this.treeSize - o.treeSize;
      }
    }
  }
