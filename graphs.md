# Graph Algorithms

## Breadth First Search (BFS)
- Start at a particular vertex
- Explore all of its neighbors at the current level before moving on to the next level
- Keep track of visited vertices when using BFS on a graph instead of a tree
- Implement a BFS using a Queue

```python
procedure BFS(G, root) is
    let Q be a queue
    label root as visited
    Q.enqueue(root)
    while Q is not empty do
        v := Q.dequeue()
        if v is the goal then
            return v
        for all edges from v to w in G.adjacentEdges(v) do
            if w is not labeled as visited then
                label w as visited
                Q.enqueue(w)
```

## Depth First Search (DFS)
- Start at a particular vertex
- Explore as far as possible along each branch before backtracking
- Keep track of visited vertices
```python
procedure DFS(G, v) is
    label v as discovered
    for all directed edges from v to w that are in G.adjacentEdges(v) do
        if vertex w is not labeled as discovered then
            recursively call DFS(G, w)
```
- Implement a DFS using a Stack to support backtracking iteratively
```python
procedure DFS_iterative(G, v) is
    let S be a stack
    S.push(v)
    while S is not empty do
        v = S.pop()
        if v is not labeled as discovered then
            label v as discovered
            for all edges from v to w in G.adjacentEdges(v) do 
                S.push(w)
```

## Topological Sort
- The canonical application of topological sorting is in scheduling a sequence of jobs or tasks based on their dependencies.
- Topologically sorted directed graph is a linear ordering of its vertices such that for every directed edge uv from vertex u to vertex v, u comes before v in the ordering.
- A topological ordering is possible if and only if the graph has no directed cycles
  
- Kahn's Algorithm
```python
L ← Empty list that will contain the sorted elements
S ← Set of all nodes with no incoming edge

while S is not empty do
    remove a node n from S
    add n to L
    for each node m with an edge e from n to m do
        remove edge e from the graph
        if m has no other incoming edges then
            insert m into S

if graph has edges then
    return error   (graph has at least one cycle)
else 
    return L   (a topologically sorted order)
```

- DFS Version
```python
L ← Empty list that will contain the sorted nodes
while exists nodes without a permanent mark do
    select an unmarked node n
    visit(n)

function visit(node n)
    if n has a permanent mark then
        return
    if n has a temporary mark then
        stop   (not a DAG)

    mark n with a temporary mark

    for each node m with an edge from n to m do
        visit(m)

    remove temporary mark from n
    mark n with a permanent mark
    add n to head of L
```

## Union Find
- union(x, y): unions the groups containing X and Y
- find(x): find the group/parent x belongs to
- elements belong to the same group if they have the same root
- initialize Array Parent where `Parent[i] = i`
```python
find(x):
    if Parent(x) != x:
        return find(Parent[x])
    else:
        return x
```

```python
union(x, y):
    Parent[find(y)] = find(x)
```
n elements
Height of trees O(logn)
therefore find and union are O(logn)
space complexity = O(n)


## Shortest Path from Source to All Vertices (Dijkstra)

## Shortest Path from Every Vertex to Every Other Vertex (Floyd Warshall)

## Minimum Spanning Tree (Prim)

## Minimum Spanning Tree (Kruskal)

