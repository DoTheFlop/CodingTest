from collections import deque

N = int(input())
shop = []
for i in range(N):
	shop.append(int(input()))
print(2*(max(shop) - min(shop)))

def solution(worldmap):
    answer = 0
    map = [[0 for j in range(len(worldmap[0]))] for i in range(len(worldmap))]
    for i in range(len(worldmap)):
        for j in range(len(worldmap[i])):
            map[i][j] = worldmap[i][j]

    visited = [[0 for j in range(len(worldmap[0]))] for i in range(len(worldmap))]
    w, h = len(map[0]), len(map)
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    def bfs(x, y):
        queue = deque()
        queue.append([x, y])
        visited[y][x] = 1
        while queue:
            while queue:
                point = queue.popleft()

                for i in range(4):
                    px = point[0] + dx[i]
                    py = point[1] + dy[i]
                    if w > px > -1 and -1 < py < h and [px, py] and visited[py][px] == 0 and map[py][px] == '.':
                        queue.append([px, py])
                        visited[py][px] = 1
                        if map[py][px] > 1:
                            map[py][px] = min(map[py][px], map[py][px] + map[point[1]][point[0]])
                        else:
                            map[py][px] += map[point[1]][point[0]]

    return answer

print(solution(["..XXX", "..XXX", "...XX", "X..X.", "XX..."]))