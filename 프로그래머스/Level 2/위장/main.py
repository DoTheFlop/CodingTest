def solution(clothes):
    answer = 1
    dic = {}
    for clothes, type in clothes:
        dic[type] = dic.get(type, 0) + 1
        
    for type in dic:
        answer *= dic[type] + 1
        
    return answer -1

print(solution([["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]))