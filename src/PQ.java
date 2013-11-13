public class PQ {
	
	private Node[] heap;
	private int size;           
	private int count;       
	
	public PQ(int max){            
	      
		size = max;
		count = 0;
		heap = new Node[size];  
	}
	
	public boolean isEmpty(){
		return count==0;
	}
	
	public boolean add(Node a){
		if (count == size)
			return false;
		else{
			
			heap[count]=a;
			//System.out.println("heap["+count+"]="+a.getName());
			if (count>0)
				siftup(count);
			count++; 
			return true;
		}
	}
	public Node poll(){
		if (!isEmpty()){
			Node r=heap[0];
			count=count-1;
			heap[0]=heap[count];
			siftdown(0);
			return r;
		}
		else
			return null;
	}
	public void clear(){
		while(!isEmpty())
			poll();
		
	}
	
	public int size(){
		return size;
	}
	public boolean decreaseKey(int i, int newValue){
		if(i<0 || i>=count)
			return false;
   
		heap[i].setDist(newValue);  
		siftup(i);              
		return true;
    }
	
	public void siftup(int i){
    
		int parent = (i-1) / 2;
		Node last = heap[i];
		//System.out.println(i+" lll"); 
		//System.out.println(parent+" lll"); 
		//System.out.println(heap[0]+" lll"); 
		while( i > 0 && heap[parent].getDist() > last.getDist() ){
			heap[i] = heap[parent];
			//System.out.println(i+"lala"); 
			i = parent;
			//System.out.println(i+"l");
			parent = (parent-1) / 2; } 
		
		heap[i] = last;
    
		}
	
	public void siftdown(int i){
	    
		int bigger;
		Node root = heap[i];      
		while(i < count/2){                           
			int left = 2*i+1;
			int right = left+1;
	                                         
			if(right < count &&  heap[left].getDist() < heap[right].getDist())
				bigger = right;
			else
				bigger = left;
	                                         
			if( root.getDist() >= heap[bigger].getDist() )
				break;
	                                         
			heap[i] = heap[bigger];
			i = bigger;           
		}  
		
		heap[i] = root;            
	}
	
	/*
	public static void main(String[] args) {
		
		
		int[] Arr = {77, 4, 1, 3, 2,7,5,18};
		PQ h=new PQ(Arr.length);
		
        for (int kk = 0; kk <= Arr.length - 1; kk++) {
            h.add(0, Arr[kk]);
        }
        for (int i=0; i<h.size; i++) {
        	System.out.println(h.heap[i].getValue());
        }
      
	}*/
    
}