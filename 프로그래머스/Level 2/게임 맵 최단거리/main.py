from collections import deque

def solution(maps):
    w, h = len(maps[0]), len(maps)
    dx = [0,0,1,-1]
    dy = [1,-1,0,0]
    visited = [[0] * w for _ in range(h)]


    def bfs(x, y):
        queue = deque([])
        queue.append([x, y])
        visited[y][x] = 1
        while queue:
            point = queue.popleft()
            
            for i in range(4):
                px = point[0] + dx[i]
                py = point[1] + dy[i]
                if w> px > -1 and -1 < py < h and [px, py] and visited[py][px] == 0 and maps[py][px] == 1:
                        queue.append([px, py])
                        visited[py][px] = 1
                        if maps[py][px] > 1:
                            maps[py][px] = min(maps[py][px], maps[py][px] + maps[point[1]][point[0]])
                        else:
                            maps[py][px] += maps[point[1]][point[0]]
    bfs(0, 0)
    if maps[h-1][w-1] == 1:
        return -1
    else:
        return maps[h-1][w-1]

print(solution([[1,0,1,1,1],[1,0,1,0,1],[1,0,1,1,1],[1,1,1,0,1],[0,0,0,0,1]]))