from itertools import combinations

def solution(numbers):
    answer = []
    cmb = list(combinations(numbers,2))
    for a, b in cmb: answer.append(a+ b)
    answer = list(set(answer))
    answer.sort()
    return answer
            
print(solution([2,1,3,4,1]))