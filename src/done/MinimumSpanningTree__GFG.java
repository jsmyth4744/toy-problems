package done;// A Java program for Prim's Minimum Spanning Tree (MST) algorithm.
// The program is for adjacency matrix representation of the graph

import java.util.OptionalInt;
import java.util.stream.IntStream;

class MinimumSpanningTree__GFG {
    // Number of vertices in the graph
    private static final int V = 5;

    // A utility function to find the vertex with minimum key
    // value, from the set of vertices not yet included in done.MinimumSpanningTree__GFG
    int minKey(int key[], boolean mstSet[]) {
        // Initialize min value
        int min = key[0];

        OptionalInt res = IntStream
                .range(0, key.length)
                .filter(v -> !mstSet[v] && key[v] <= min)
                .min();

        return res.isPresent() ? res.getAsInt() : min;
    }

    // A utility function to print the constructed done.MinimumSpanningTree__GFG stored in
    // parent[]
    void printMST(int parent[], int n, int graph[][]) {
        System.out.println("Edge\tWeight");
        IntStream.range(1, V).forEach((i) ->
                System.out.println(
                        parent[i] + " -> " + i + "\t" + graph[i][parent[i]]));
    }

    // Function to construct and print done.MinimumSpanningTree__GFG for a graph
    // represented causing adjacency matrix representation
    void primMST(int graph[][]) {
        // Array to store constructed done.MinimumSpanningTree__GFG
        int parent[] = new int[V];
        // Key values used to pick minimum weight edge in cut
        int key[] = new int[V];
        // To represent set of vertices not yet included in done.MinimumSpanningTree__GFG
        boolean mstSet[] = new boolean[V];

        // Initialize all keys as INFINITE
        IntStream.range(0, key.length).forEach((i) -> key[i] = Integer.MAX_VALUE);
        // Always include first 1st vertex in done.MinimumSpanningTree__GFG.
        key[0] = 0;     // Make key 0 so that this vertex is picked as first vertex
        parent[0] = -1; // First node is always root of done.MinimumSpanningTree__GFG

        // The done.MinimumSpanningTree__GFG will have V vertices
        IntStream.range(0, V - 1).forEach((i) -> {
            // Pick thd minimum key vertex from the set of vertices
            // not yet included in done.MinimumSpanningTree__GFG
            int u = minKey(key, mstSet);

            // Add the picked vertex to the done.MinimumSpanningTree__GFG Set
            mstSet[u] = true;

            // Update key value and parent index of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in done.MinimumSpanningTree__GFG
            IntStream.range(0, V).forEach(v -> {
                // graph[u][v] is non zero only for adjacent vertices of m
                // mstSet[v] is F for vertices not yet in done.MinimumSpanningTree__GFG
                // Update the key only if graph[u][v] is smaller than key[v]
                if (0 != graph[u][v] && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            });
        });

        // print the constructed done.MinimumSpanningTree__GFG
        printMST(parent, V, graph);
    }

    public static void main(String[] args) {
        /* Let us create the following graph
           2    3
        (0)--(1)--(2)
        |    / \   |
        6| 8/   \5 |7
        | /      \ |
        (3)-------(4)
             9          */
        MinimumSpanningTree__GFG t = new MinimumSpanningTree__GFG();
        int graph[][] = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
        };

        // Print the solution
        t.primMST(graph);
    }
}