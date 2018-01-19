class Solution {
public:
    int orderOfLargestPlusSign(int N, vector<vector<int>>& mines) {
        int count_map[N][N];
        
        for(int i=0;i<N;++i)
        {
            for(int j=0;j<N;++j)
            {
                int min = i+1;
                if(min>N-i)   min = N-i;
                if(min>j+1)       min = j+1;
                if(min>N-j)   min = N-j;
                
                count_map[i][j] = min;
            }
        }
        
        for(int i=0;i<mines.size();++i)
        {
            int start = count_map[mines[i][0]][mines[i][1]];
            count_map[mines[i][0]][mines[i][1]] = 0;
            
            for(int j=1;;++j)
            {
                if(mines[i][0]-j<0)
                    break;
                    
                if(count_map[mines[i][0]-j][mines[i][1]]>j)
                    count_map[mines[i][0]-j][mines[i][1]] = j;
            }
            
            for(int j=1;;++j)
            {
                if(mines[i][1]+j>=N)
                    break;
                
                if(count_map[mines[i][0]][mines[i][1]+j]>j)
                    count_map[mines[i][0]][mines[i][1]+j] = j;
            }
            
            for(int j=1;;++j)
            {
                if(mines[i][0]+j>=N)
                    break;
                
                if(count_map[mines[i][0]+j][mines[i][1]]>j)
                    count_map[mines[i][0]+j][mines[i][1]] = j;
            }
            
            for(int j=1;;++j)
            {
                if(mines[i][1]-j<0)
                    break;
                
                if(count_map[mines[i][0]][mines[i][1]-j]>j)
                    count_map[mines[i][0]][mines[i][1]-j] = j;
            }

        }
        
        int max = 0;
        for(int i=0;i<N;++i)
        {
            for(int j=0;j<N;++j)
            {
                if(count_map[i][j]>max)
                    max = count_map[i][j];
            }
        }
        
        return max;
    }
};
