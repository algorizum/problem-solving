import java.util.Arrays;

public class MinimumSwapsToMakeSequencesIncreasing {
    public int minSwap(int[] A, int[] B) {
    	int[] prevMinSwap = new int[2];
    	prevMinSwap[0] = 0;
    	prevMinSwap[1] = 1;
    	for(int i = 1; i < A.length; i++) {
    		int[] currentMinSwap = new int[2];
    		Arrays.fill(currentMinSwap, 1000);
    		if(A[i-1] < A[i] && B[i-1] < B[i]) {
    			currentMinSwap[0] = prevMinSwap[0];
    			currentMinSwap[1] = prevMinSwap[1]+1;
    		}
    		if(B[i-1] < A[i] && A[i-1] < B[i]) {
    			currentMinSwap[0] = Math.min(currentMinSwap[0], prevMinSwap[1]);
    			currentMinSwap[1] = Math.min(currentMinSwap[1], prevMinSwap[0]+1);
    		}
    		prevMinSwap = currentMinSwap;
    	}
    	return Math.min(prevMinSwap[0], prevMinSwap[1]);
    }
    
	public static void main(String[] args) {
		MinimumSwapsToMakeSequencesIncreasing solution = new MinimumSwapsToMakeSequencesIncreasing();
		System.out.println(solution.minSwap(new int[] {3,5,6,9,14,15,15,18,17,20}, new int[] {3,4,5,8,10,14,17,16,19,19})); //2
		System.out.println(solution.minSwap(new int[] {3,3,8,9,10}, new int[] {1,7,4,6,8})); //1
		System.out.println(solution.minSwap(new int[] {1,3,5,4}, new int[] {1,2,3,7})); //1
		System.out.println(solution.minSwap(new int[] {4,10,13,14,17,19,21,24,26,27,28,29,34,37,38,42,44,46,48,51,52,53,54,57,58,59,64,65,66,67,71,73,75,76,80,81,82,83,86,88,89,90,95,97,98,99,101,105,106,108,109,110,111,112,115,119,121,122,123,124,125,126,127,128,129,130,131,133,136,138,143,145,147,149,150,153,158,160,163,164,165,167,168,169,172,173,174,176,178,179,183,184,186,188,189,192,193,194,198,200}, new int[] {0,1,3,5,6,7,11,13,15,16,17,21,37,39,41,42,43,45,47,50,53,55,56,57,64,66,67,68,69,70,71,72,74,75,76,77,79,80,87,88,89,95,96,97,98,100,101,105,106,107,108,112,113,115,116,118,119,122,124,125,126,127,128,131,135,136,137,138,139,140,144,145,148,150,151,154,159,160,161,162,163,167,168,170,171,174,176,178,179,180,181,185,187,189,190,191,192,198,199,200})); //0
	}
}
