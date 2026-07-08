# STEP 1 — Same graph as BFS lab
graph = {
    'A': ['B', 'C', 'D'],
    'B': ['E'],
    'C': ['F'],
    'D': ['E'],
    'E': ['F'],
    'F': []
}

# STEP 2 — DFS using an explicit Stack
def dfs_stack(graph, start):
    visited = set()          
    stack   = [start]        
    order   = []

    while stack:
        node = stack.pop()   
        if node not in visited:
            visited.add(node)
            order.append(node)

            for neighbour in graph[node]:
                if neighbour not in visited:
                    stack.append(neighbour)   
    return order


# STEP 3 — DFS using Recursion
# Exercise 2 (Medium): Add depth parameter and print depth at each node.
def dfs_recursive(graph, node, visited=None, order=None, depth=0):
    if visited is None:
        visited = set()
    if order is None:
        order = []

    visited.add(node)
    order.append(node)
    
    # Print the depth of the current node
    print(f"    Visiting {node} at depth {depth}")

    for neighbour in graph[node]:
        if neighbour not in visited:
            # Increment depth by 1 on each recursive call
            dfs_recursive(graph, neighbour, visited, order, depth + 1)

    return order


# STEP 4 — Verbose DFS
def dfs_verbose(graph, start):
    visited = set()
    stack   = [start]
    order   = []

    print(f"\n{'='*50}")
    print(f"  DFS (stack) starting from node '{start}'")
    print(f"{'='*50}")

    step = 1
    while stack:
        print(f"\n  Step {step} | Stack (top→bottom): {list(reversed(stack))}")
        node = stack.pop()                         

        if node not in visited:
            visited.add(node)
            order.append(node)
            print(f"  ✓ Visiting '{node}' | Path so far: {order}")

            added = []
            for neighbour in graph[node]:
                if neighbour not in visited:
                    stack.append(neighbour)
                    added.append(neighbour)

            if added:
                print(f"    → Pushed onto stack: {added}")
            else:
                print(f"    → Dead end — will backtrack")
        step += 1

    print(f"\n{'='*50}")
    print(f"  DFS complete! Final order: {order}")
    print(f"{'='*50}\n")
    return order


# STEP 5 — Cycle detection using DFS
def dfs_has_cycle(graph):
    visited    = set()
    rec_stack  = set()

    def dfs_visit(node):
        visited.add(node)
        rec_stack.add(node)

        for neighbour in graph[node]:
            if neighbour not in visited:
                if dfs_visit(neighbour):
                    return True
            elif neighbour in rec_stack:
                return True

        rec_stack.remove(node)
        return False

    for node in graph:
        if node not in visited:
            if dfs_visit(node):
                return True

    return False


# STEP 6 — Topological sort using DFS
# Exercise 3 (Challenge): Combine with cycle check and abort if cycle found.
def topological_sort(graph):
    # Check for cycles first
    if dfs_has_cycle(graph):
        print("    ERROR: cycle detected — cannot sort")
        return None

    visited = set()
    result  = []

    def dfs_visit(node):
        visited.add(node)
        for neighbour in graph[node]:
            if neighbour not in visited:
                dfs_visit(neighbour)
        result.append(node)

    for node in graph:
        if node not in visited:
            dfs_visit(node)

    return list(reversed(result))


# RUN EVERYTHING
if __name__ == "__main__":
    print("\n" + "="*50)
    print("  ICS 1201 — DFS Lab (Completed Exercises)")
    print("="*50)

    # Recursive DFS (Exercise 2)
    print("\n[2] DFS (recursive) from A with Depths:")
    result_rec = dfs_recursive(graph, 'A')
    print(f"    Final Order: {result_rec}")

    # Topological sort (Exercise 3)
    print("\n[6] Topological sort (Robust check):")
    
    # Test 1: Original DAG (No Cycle)
    print("  Test 1: Original Graph (DAG)")
    topo = topological_sort(graph)
    if topo:
        print(f"    Result: {topo}")
        
    # Test 2: Graph WITH Cycle
    print("\n  Test 2: Graph with a cycle (F -> A added)")
    graph_has_cycle = {
        'A': ['B', 'C', 'D'],
        'B': ['E'],
        'C': ['F'],
        'D': ['E'],
        'E': ['F'],
        'F': ['A']            # Creates a cycle F -> A -> ...
    }
    topo_cycle = topological_sort(graph_has_cycle)