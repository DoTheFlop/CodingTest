import math

def solution(n):
    answer = 0
    if (math.sqrt(n) + 1).is_integer() :
        answer = math.pow((math.sqrt(n) + 1), 2)
    else:
        answer = -1
    return answer

print(solution(121))