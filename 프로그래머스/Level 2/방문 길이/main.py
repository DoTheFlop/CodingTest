def solution(dirs):
    answer = 0
    visited = []
    x, y = 0, 0
    px, py = 0, 0
    for i in dirs:
        px, py = x, y
        if i == 'U':
            if y + 1 > 5:
                continue
            y += 1
        elif i == 'D':
            if y - 1 < -5:
                continue
            y -= 1
        elif i == 'R':
            if x + 1 > 5 :
                continue
            x += 1
        elif i == 'L':
            if x - 1 < -5:
                continue
            x -= 1
        if [(px, py), (x, y)] not in visited and [(x, y), (px, py)] not in visited:
            visited.append([(px, py),(x, y)])
            answer += 1
            
    return answer

print(solution("LULLLLLLU"))