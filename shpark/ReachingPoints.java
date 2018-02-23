
public class ReachingPoints {
	public boolean reachingPoints(int sx, int sy, int tx, int ty) {
		if(tx==sx && ty==sy)return true;
		else if(tx<sx || ty<sy)return false;
		
		if(tx==sx &&(ty-sy)%tx==0)return true;
		else if(ty==sy &&(tx-sx)%ty==0)return true;
		return reachingPoints(sx,sy,tx%ty,ty%tx);
		
	}
}
