from collections import deque

def solution(prices):
    que = deque(prices)
    answer = []
    
    while que:
        pivot = que.popleft()
        cnt = 0
        for i in que:
            if pivot <= i:
                cnt += 1
            else:
                cnt += 1
                break
        answer.append(cnt)            
    return answer

print(solution([1, 2, 3, 2, 3]))