public class Edge{
                 
        private String dir;   
           private String Name;             // data item (Name)
           private int provisionalDist;
          
           
           public Edge(String n, String d, int v){           // constructor
                   dir=d;
                	Name=n;
                   provisionalDist=v;
                   
           }
        
           public String getName(){
              return Name; }
           
           public int getprovisionalDist(){
                      return provisionalDist; }
        
         
           public void setprovisionalDist(int v){ 
                  provisionalDist=v; }
        
          
        

           public String getDir(){
                      return dir; }
                      
           public void printString() {
           			System.out.println("to " + dir+", distance " + provisionalDist);
           
           }
        
         
           
}  