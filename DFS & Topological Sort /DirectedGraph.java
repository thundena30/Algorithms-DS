import java.io.BufferedReader;
import java.io.IOException;


public class DirectedGraph extends Graph {
	
	public DirectedGraph(BufferedReader reader) throws IOException
    {
		super(reader);
    }
	
	public void addEdge(int v, int w)
	{
		E++;
        adj[v].add(w);
	}
}
