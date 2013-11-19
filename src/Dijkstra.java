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
                Node s=adj.get("1");
                //System.out.println(s.getprovisionalDist()+" is source with dir towards "+s.getDir());
                Dijkstra(s);
               // printDj();
        }
        
        public static void printDj(){
        	Node toPrint = adj.get("1");
            System.out.println("Source was " + toPrint);
            for (int i =2; i<adj.size(); i++) {
          		toPrint = adj.get(""+i);
                System.out.println("Node " + toPrint + " best dist: " + toPrint.getDist());
                
                }
        	
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
        
       
        public static void Dijkstra(Node source){
        
                source.setDist(0);
                PQ queue = new PQ(adj.size());
                queue.add(source);
                source.setStatus("enqueued");
                while (!queue.isEmpty()) {
                    Node v = queue.poll();
                    LinkedList<Edge> edges=v.getEdges();
                    System.out.println("current v is: "+v+", because min dist" + v.getDist());
                    for (int i=0; i<edges.size(); i++){
                    	Edge e = edges.get(i);
                    	Node w=e.getDir();
                    	System.out.println("checking "+w+" from "+v);
                    	//System.out.println("bro of "+v+" is "+w);
                        if (w.getStatus().equals("unvisited")){
                        	w.setStatus("enqueued");
                    		w.setDist(v.getDist() + e.getprovisionalDist());
                    		System.out.println("now in queue, set dist at "+w.getDist());
                          	w.setVia(v.getName());
                            queue.add(w);
                          //  System.out.println("added "+w);
                          
                        }
                       	else if (w.getStatus().equals("enqueued")) {
                       		int newDist=v.getDist() + e.getprovisionalDist();
                       		System.out.println("working on "+w+"; current dist="+w.getDist()+"; potential dist ="+newDist);
                       		if(newDist<w.getDist()){
                       			System.out.println("updating current dist");
                       			w.setDist(newDist);
                       			System.out.println("set dist at "+w.getDist());
                              	w.setVia(v.getName());
                       			System.out.println("newdist is: "+newDist);
                       			w.setVia(v.getName());
                       			queue.decreaseKey(w, w.getDist());
                       		}
                       		else
                       			System.out.println("no dist update");
                       	}
                       	else if (w.getStatus().equals("done")) {
                       		System.out.println("tried to check " + w+ ", but it was done");
                       	}
                       	
                       	
                    
                    }
                    v.setStatus("done");
                    System.out.println("done with " + v + "; final dist is "+v.getDist());
                    
                        
                    
                    
                    }

                Node toPrint = adj.get("1");
                for (int i =2; i<adj.size(); i++) {
              		toPrint = adj.get(""+i);
                    System.out.println("Node " + toPrint + " best dist: " + toPrint.getDist());
                    
                    }
         }
        
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
                                else{
                                	nd=adj.get(line[1]);
                                }
                                LinkedList<Edge> edg=adj.get(line[1]).getEdges();
                               // System.out.println("edglist is "+edg+"; node is "+nd);
                                Node nd2=new Node(line[2]);
                                if (!adj.containsKey(line[2])){
                                    
                                    adj.put(line[2], nd2);
                                    
                            }
                                else{
                                	nd2=adj.get(line[2]);
                                }
                                edg.add(new Edge( line[1], nd2, Integer.parseInt(line[3])));
                               // System.out.println("adding new edge to node "+nd+"; the edge is "+nd2);
                        }

                        sc.close();

                } catch (FileNotFoundException e) {
                        System.out.println("File wasn't found! ");
                        System.exit(0);
                }
                
        }
        
        
        
        
        
}