def solution(sizes):
    w = 0
    h = 0

    for i in range(len(sizes)):
        sizes[i].sort()

        if w < sizes[i][0]:
            w = sizes[i][0]

        if h < sizes[i][1]:
            h = sizes[i][1]

    answer = w * h
    return answer

print(solution([[60, 50], [30, 70], [60, 30], [80, 40]]))