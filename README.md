# Topological Sorting using Depth-First Search (DFS)

This Java program implements the "Topological Sorting" algorithm on a directed acyclic graph (DAG) using Depth-First Search (DFS). Topological Sorting is a linear ordering of the vertices such that for every directed edge (u, v), vertex u comes before v in the ordering. It helps identify dependencies and precedence among tasks represented as vertices in a DAG.

## How to Use

1. Make sure you have Java installed on your machine.
2. Clone this repository to your local machine.
3. Create a text file representing the directed acyclic graph (DAG). Each line of the file should start with the vertex number followed by a colon (:) and a comma-separated list of its adjacent vertices. For example:

  0: 1, 2
  
  1: 2
  
  2: 3
  
  3:

4. Run the program with the input text file as a command-line argument
5. The program will read the DAG from the input file, perform Topological Sorting using Depth-First Search (DFS), and print the topologically sorted order of vertices.

## About Topological Sorting using DFS
Topological Sorting is a crucial algorithm in tasks scheduling and job sequencing, where dependencies need to be managed. The Depth-First Search (DFS) approach helps explore the graph and construct the linear ordering based on the precedence among vertices. The resulting order provides valuable insights into the workflow and task dependencies.




