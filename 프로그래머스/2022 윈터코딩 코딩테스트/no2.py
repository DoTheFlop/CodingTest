import collections

def solution(n, student, point):
    answer = 0
    best = []
    score_board = {}
    for i in range(n):
        score_board[i+1] = 0
    for j in range(0, n // 2):
        best.append(j+1)
    for i in range(len(student)):
        best2 = []
        score_board[student[i]] += point[i]
        score_board = dict(sorted(score_board.items(), key=lambda x: (-x[1], x[0])))
        temp = list(score_board)
        for j in range(0, n//2):
            best2.append(temp[j])
        if collections.Counter(best) != collections.Counter(best2):
            answer += 1
        best = best2.copy()
        best2.clear()
    return answer

print(solution(10, [3, 2, 10, 2, 8, 3, 9, 6, 1, 2], [3, 2, 2, 5, 4, 1, 2, 1, 3, 3]))