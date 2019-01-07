import java.io.BufferedReader;
import java.io.IOException;

public class UndirectedGraph extends Graph {
	
	public UndirectedGraph(BufferedReader reader) throws IOException
    {
		super(reader);
    }
	
	public void addEdge(int v, int w)
	{
        E++;
        adj[v].add(w);
        adj[w].add(v);
	}
}
