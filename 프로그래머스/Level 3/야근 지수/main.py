import heapq

def solution(n, works):
    answer = 0
    max_works = []
    for i in works:
        heapq.heappush(max_works, (-i, i))
        
    for i in range(n):
        if not max_works:
            break
        
        temp = heapq.heappop(max_works)
        temp = ( -(temp[1] - 1), temp[1] - 1 )
        if temp[1] < 1:
            continue
        else:
            heapq.heappush(max_works, temp)
            
    while max_works:
        a = heapq.heappop(max_works)
        answer += a[1]*a[1]
    return answer

print(solution(4, [4, 3, 3]))