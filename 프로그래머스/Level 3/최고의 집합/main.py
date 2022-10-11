from itertools import product

def solution2(n, s):
    answer = [-1]
    max = 0
    for i in product(range(10), repeat = n):
        if i[0] + i[1] == s and max < i[0] * i[1]:
            answer = [i[0], i[1]]
            max = i[0] * i[1]
    return answer

def solution(n, s):
    if n > s:
        return [-1]
    
    p, q = divmod(s, n)
    answer = [p] * n
    
    for i in range(q):
        answer[i] += 1
        
    return sorted(answer)

print(solution(2, 9))