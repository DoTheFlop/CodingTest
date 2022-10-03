import heapq

def solution(jobs):
    heap = []
    start, now, answer, cnt = -1, 0, 0, 0

    while cnt < len(jobs):
        for i in jobs:
            if start < i[0] <= now:
                heapq.heappush(heap, [i[1], i[0]])
        if heap:
            cnt += 1
            temp = heapq.heappop(heap)
            start = now
            now += temp[0]
            answer += (now - temp[1])
        else:
            now += 1

    return answer // len(jobs)

print(solution([[0, 3], [1, 9], [2, 6]]))