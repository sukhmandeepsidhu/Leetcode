import java.util.PriorityQueue;
public class Leetcode295 {

	public static void main(String[] args) {
		
		MedianFinder medFinder = new MedianFinder(); 
		medFinder.addNum(2);
		medFinder.addNum(4);
		medFinder.addNum(3);
		
		System.out.println(medFinder.findMedian());

	}

}

class MedianFinder {
    PriorityQueue<Integer>mins;
    PriorityQueue<Integer>maxs;

    public MedianFinder() {
        mins =new PriorityQueue<Integer>((a,b)->(a-b));
        maxs = new PriorityQueue<Integer>((a,b)->(b-a)); 
    }
    
    public void addNum(int num) {
        mins.add(num); 
        maxs.add(mins.remove()); 
        if(maxs.size()>mins.size()){mins.add(maxs.remove());}
        
    }
    
    public double findMedian() {
        if(mins.size()>maxs.size()){
            return mins.peek();
        }
        else{
            int total = maxs.peek()+mins.peek(); 
            return (total/2.0);

        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */