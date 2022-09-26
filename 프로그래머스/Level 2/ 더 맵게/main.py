import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    answer = 0
    while True:
        low = heapq.heappop(scoville)
        if( low >= K ):
            heapq.heappush(scoville, low)
            break
        else:
            if len(scoville) == 0:
                answer = -1
                break
        high = heapq.heappop(scoville)
        heapq.heappush(scoville, low + (high * 2))
        answer += 1
        
    return answer



print(solution([1, 2, 3, 9, 10, 12], 7))