from collections import deque

# STEP 1 — Define the graph as an adjacency list
# Exercise 1 (Warm up): Add node G with an edge from F to G.
graph = {
    'A': ['B', 'C', 'D'],
    'B': ['E'],
    'C': ['F'],
    'D': ['E'],
    'E': ['F'],
    'F': ['G'],              # Added edge F -> G
    'G': []                  # G is the new sink
}

# STEP 2 — The BFS function
def bfs(graph, start):
    visited = set()
    queue = deque([start])
    order = []

    while queue:
        node = queue.popleft()
        if node not in visited:
            visited.add(node)
            order.append(node)

            for neighbour in graph[node]:
                if neighbour not in visited:
                    queue.append(neighbour)
    return order

# STEP 3 — Verbose BFS
def bfs_verbose(graph, start):
    visited = set()
    queue = deque([start])
    order = []

    print(f" \n BFS starting from node '{start}'\n")


    step = 1
    while queue:
        print(f"\n  Step {step} | Queue contents: {list(queue)}")
        node = queue.popleft()

        if node not in visited:
            visited.add(node)
            order.append(node)
            print(f"  ✓ Visiting '{node}' | Path so far: {order}")

            added = []
            for neighbour in graph[node]:
                if neighbour not in visited:
                    queue.append(neighbour)
                    added.append(neighbour)

            if added:
                print(f"    → Added to queue: {added}")
            else:
                print(f"    → No new neighbours to add")
        step += 1

    print(f" \n BFS complete! Final order: {order} \n")
    return order


# STEP 4 — BFS with distance levels
# Exercise 3 (Challenge): Print nodes grouped by level.
def bfs_with_distance(graph, start):
    visited = set()
    queue = deque([(start, 0)])
    distances = {}
    grouped_levels = {} # Dictionary to store grouped levels

    while queue:
        node, dist = queue.popleft()

        if node not in visited:
            visited.add(node)
            distances[node] = dist
            
            # Grouping the node by its distance level
            if dist not in grouped_levels:
                grouped_levels[dist] = []
            grouped_levels[dist].append(node)

            for neighbour in graph[node]:
                if neighbour not in visited:
                    queue.append((neighbour, dist + 1))

    # Print nodes grouped by level as required by the exercise
    for level, nodes in sorted(grouped_levels.items()):
        print(f"      Level {level}: {nodes}")

    return distances


# STEP 5 — Path existence check
# Exercise 2 (Medium): Return the actual path instead of just True/False
def bfs_path_exists(graph, start, target):
    visited = set()
    queue = deque([start])
    parent_map = {start: None} # Store {node: parent} to trace back

    while queue:
        node = queue.popleft()

        if node == target:
            # Reconstruct path by tracing back from target to start
            path = []
            curr = target
            while curr is not None:
                path.append(curr)
                curr = parent_map[curr]
            return path[::-1] # Reverse the path to get start -> target

        if node not in visited:
            visited.add(node)
            for neighbour in graph[node]:
                # Only add if we haven't visited AND haven't queued it as a neighbour yet
                if neighbour not in visited and neighbour not in parent_map:
                    parent_map[neighbour] = node
                    queue.append(neighbour)

    return False


# RUN EVERYTHING
if __name__ == "__main__":

    print("\n[1] Basic BFS from A (With Node G):")
    result = bfs(graph, 'A')
    print(f"    Order: {result}")
    print(f"    (Notice 'G' is at the very end because it is distance 3)")

    print("\n[3] BFS with distances from A (Grouped by Level):")
    bfs_with_distance(graph, 'A')

    print("\n[4] Path existence checks (Returning the actual path):")
    pairs = [('A', 'G'), ('A', 'E'), ('G', 'A'), ('C', 'B')]
    for src, tgt in pairs:
        result = bfs_path_exists(graph, src, tgt)
        if result:
            print(f"    {src} → {tgt}: ✓ Path EXISTS -> {result}")
        else:
            print(f"    {src} → {tgt}: ✗ No path")