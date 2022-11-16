from itertools import permutations

def solution(k, dungeons):
    cnt = len(dungeons)
    answer = []
    
    for i in permutations(dungeons, cnt):
        temp = k
        a = 0
        for j in i:
            if temp >= j[0]:
                temp -= j[1]
                a += 1
        answer.append(a)
        
    return max(answer)

print(solution(80, [[80,20],[50,40],[30,10]]))