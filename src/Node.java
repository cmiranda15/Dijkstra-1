import java.util.LinkedList;

public class Node{
                 
        	private String name;
           private int dist;
           private String status;
           private String via;
           private LinkedList<Edge> edges;
           
           public Node(String n){           // constructor
                  name=n;
                   dist=900000000;
                   status="univisited";
                   via=null;
                   edges=new LinkedList<Edge>();
           }
        
          
           public String getName(){
               return name; }       
           public int getDist(){
                      return dist; }
                      
         public LinkedList<Edge> getEdges(){
                      return edges; }
        
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