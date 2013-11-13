import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;


public class Dijkstra {
//264346 Edges
	
	
	private static HashMap<Node, LinkedList<Edge>> adj;
	
	public static void main(String[] args) {
		
		readGraph(args[0]);
		Node s=new Node("1");
		//System.out.println(s.getprovisionalDist()+" is source with dir towards "+s.getDir());
		//Dijkstra(s);
		printG();
	}
	
	
	
	public static void printG(){
		
		for (int j=1; j<28; j++){
			Node p=new Node(Integer.toString(j)); //this creates a new node, so
			LinkedList<Edge> k=adj.get(p); 		//when trying to find a node w/ name j
			System.out.println("Node p is "+j);  //this approach does not get it to us
			for (int i=0; i<k.size(); i++){   //TODO:
				System.out.print(k.get(i).getName()+":"+k.get(i).getprovisionalDist());
			}
			System.out.println();
			}
	}
	
	
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
	
	public static void readGraph(String filename){
		
		adj = new HashMap<Node, LinkedList<Edge>>();
		
		try {
			Scanner sc = new Scanner(new FileReader(filename));
			while (sc.hasNextLine()) {
				String [] line = sc.nextLine().split(" ");
				System.out.println(line[1]);
				Node nd=new Node(line[1]);
				if (!adj.containsKey(nd)){
					LinkedList<Edge> a=new LinkedList<Edge>();
					adj.put(nd, a);
					System.out.println("putting in adj list : "+line[1]+" and its edge is "+adj.get(nd));
				}
				adj.get(nd).add(new Edge( line[1], line[2], Integer.parseInt(line[3])));
				
			}

			sc.close();

		} catch (FileNotFoundException e) {
			System.out.println("File wasn't found! ");
			System.exit(0);
		}
		
	}
	
	
	
	
	
}
