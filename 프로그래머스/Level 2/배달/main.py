def solution(N, road, K):
    graph = [[float('inf')] * (N+1) for _ in range(N+1)]

    for a in range(N+1):
        graph[a][a] = 0

    for r in road:
        graph[r[0]][r[1]] = min(graph[r[0]][r[1]], r[2])
        graph[r[1]][r[0]] = min(graph[r[1]][r[0]], r[2])

    for x in range(1,N+1):
        for a in range(1,N+1):
            for b in range(1,N+1):
                graph[a][b] = min(graph[a][x]+graph[b][x], graph[a][b])

    return len([d for d in graph[1] if d <= K])

print(solution(5, [[1,2,1],[2,3,3],[5,2,2],[1,4,2],[5,3,1],[5,4,2]], 3))