def solution(d, budget):
    d.sort()
    answer = 0
    for i in d:
        budget -= i
        if budget >= 0:
            answer += 1
        else:
            break
    return answer

print(solution([1, 3, 2, 5, 4], 9))
