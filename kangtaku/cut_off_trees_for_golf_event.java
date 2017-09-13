class Solution {
        int n, m;
        public int cutOffTree(List<List<Integer>> forest) {
            n = forest.size();
            m = forest.get(0).size();
            int i, j;
            int[][] cache = new int[n][m];

            int[][] arrow = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
            List<Integer> trees = new ArrayList<>();
            for (i = 0; i < n; i++) {
                for (j = 0; j < m; j++) {
                    cache[i][j] = -1;
                    if (forest.get(i).get(j) > 1) {
                        trees.add(forest.get(i).get(j));
                    }
                }
            }
            trees.sort(Comparator.comparingInt(x -> x));
            PriorityQueue<Status> q = new PriorityQueue<Status>();
            q.add(new Status(0, 0, forest, 0, 0));

            while (q.size() != 0) {
                Status now = q.poll();

                if (now.x == -1 || now.x == n || now.y == -1 || now.y == m) continue;
                if (now.curVal() == 0) continue;
                if (cache[now.x][now.y] == -1) {
                    cache[now.x][now.y] = now.count;
                } else if (now.curVal() == 1 && forest.get(now.x).get(now.y) > 1 && cache[now.x][now.y] <= now.count) {
                    continue;
                }

                if (trees.get(now.left) == now.curVal()) {
                    now.cut();
                }

                if (now.left == trees.size()) {
                    return now.count;
                }

                for(i = 0; i < 4; i++) {
                    q.add(new Status(arrow[i], now));
                }
            }
            return -1;
        }

        class Status implements Comparable<Status> {
            List<List<Integer>> forest;
            int x, y;
            int left;
            int count;

            public Status(int x, int y, List<List<Integer>> forest, int left, int count) {
                this.forest = newForest(forest);
                this.x = x;
                this.y = y;
                this.left = left;
                this.count = count;
            }

            public Status(int[] arrow, Status curStatus) {
                this.x = curStatus.x + arrow[0];
                this.y = curStatus.y + arrow[1];
                this.forest = newForest(curStatus.forest);
                this.left = curStatus.left;
                this.count = curStatus.count + 1;
            }

            public List<List<Integer>> newForest(List<List<Integer>> forest) {
                List<List<Integer>> copiedForest = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    List<Integer> row = new ArrayList<>();
                    for (int j = 0; j < m; j++) {
                        row.add(forest.get(i).get(j));
                    }
                    copiedForest.add(row);
                }
                return copiedForest;
            }

            public int curVal() {
                return this.forest.get(x).get(y);
            }

            public void cut() {
                forest.get(x).set(y, 1);
                left++;
            }

            @Override
            public int compareTo(Status o) {
                return o.left - this.left;
            }
        }
    }
