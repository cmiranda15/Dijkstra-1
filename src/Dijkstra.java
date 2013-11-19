import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


public class Dijkstra {
//264346 Edges
        
        
        private static HashMap<String, Node> adj;
        
        public static void main(String[] args) {
                
                readGraph(args[0]);
                Node s=new Node("1");
                //System.out.println(s.getprovisionalDist()+" is source with dir towards "+s.getDir());
                //Dijkstra(s);
                printG();
        }
        
        
        
        public static void printG(){
                int n=adj.size();
                for (int j=1; j<n; j++){
                      Node toPrint = adj.get(Integer.toString(j));
                      System.out.println("Node is "+toPrint.getName());
                      LinkedList<Edge> edges=toPrint.getEdges();
                      System.out.print("Edges are the following: ");
                      for (int i=0; i<edges.size(); i++){
                    	  edges.get(i).printString();
                      
                      }
                      
                      
                        }
        }
        
       /* 
        public static void Dijkstra(Node source){
        
                source.setDist(0);
                PQ queue = new PQ(adj.size());
                queue.add(source);
                source.setStatus("enqueued");
                while (!queue.isEmpty()) {
                    Node v = queue.poll();


                    
                    
                    
                    //algorithm
                    
                    
                    
                    
                        v.setStatus("done");
                        
                }
        }
        */
        public static void readGraph(String filename){
                
                adj = new HashMap<String, Node>();
                
                try {
                        Scanner sc = new Scanner(new FileReader(filename));
                        while (sc.hasNextLine()) {
                                String [] line = sc.nextLine().split(" ");
                               // System.out.println(line[1]);
                                Node nd=new Node(line[1]);
                                if (!adj.containsKey(line[1])){
                                        
                                        adj.put(line[1], nd);
                                        //System.out.println("putting in adj list : "+line[1]+" and its node is "+adj.get(line[1]));
                                }
                                LinkedList<Edge> edg=adj.get(line[1]).getEdges();
                                //System.out.println(edg);
                                edg.add(new Edge( line[1], line[2], Integer.parseInt(line[3])));
                                
                        }

                        sc.close();

                } catch (FileNotFoundException e) {
                        System.out.println("File wasn't found! ");
                        System.exit(0);
                }
                
        }
        
        
        
        
        
}