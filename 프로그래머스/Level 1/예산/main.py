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

#더 간단한 풀이
def solution2(d, budget):
    d.sort()
    while budget < sum(d):
        d.pop()
    return len(d)

print(solution2([1, 3, 2, 5, 4], 9))
