import java.io.*;
import java.util.*;
public class graph
{
private LinkedList<Integer> adj[];


public  graph(int v)
{
adj = new LinkedList[v];
for(int i=0;i<v;i++)
{
    adj[i]=new LinkedList<Integer>();
}
}

public void addedge(int source,int destination)
{
adj[source].add(destination);
adj[destination].add(source);

}


    public int bfs(int source,int destination)
    {
boolean visit[]=new boolean[adj.length];
int parent[]=new int[adj.length];
Queue<Integer> q=new LinkedList<Integer>();
q.add(source);
parent[source]=-1;
visit[source]=true;




while(!q.isEmpty())
{
int c=q.poll();
if(c==destination)
{
    break;
}
for(int neigbour:adj[c])
{
    if(!visit[neigbour])
    {
        visit[neigbour]=true;
        q.add(neigbour);
        parent[neigbour]=c;
    }
}

} 
int c=destination;
int distance=0;
while(parent[c]!=-1)
{
    System.out.println(c+"-->");
    c=parent[c];
    distance++;
}


return distance;
    }


public static void main(String[]args) {
    
Scanner sc=new Scanner(System.in);
System.out.println("ENTER THE NUMBER OF EDGES AND VERTICES");
int v=sc.nextInt();
int e=sc.nextInt();
graph gh=new graph(v);
System.out.println("enter"+e+"edges");
for(int i=0; i<e;i++)
{
int source=sc.nextInt();
int destination=sc.nextInt();
gh.addedge(source, destination);


}
int source=sc.nextInt();
int destination=sc.nextInt();
int distance=gh.bfs(source, destination);
System.out.println("min distance is"+distance);



sc.close();


}


}