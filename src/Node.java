public class Node{
	 	
	
	   private int dist;
	   private String status;
	   private String via;
	   
	   public Node(String n){           // constructor
		  
		   dist=900000000;
		   status="univisited";
		   via=null;
	   }
	
	  
	
	   public int getDist(){
		      return dist; }
	
	   public void setDist(int k){ 
		   dist = k; }
	   public String getStatus(){
		      return status; }
	
	   public void setStatus(String k){ 
		   status = k; }
	   public String getVia(){
		      return via; }
	  
	
	   public void setVia(String k){ 
		   via= k; }
	   
}  