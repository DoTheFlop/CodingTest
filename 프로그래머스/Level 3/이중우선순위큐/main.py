from collections import deque
import heapq

def solution(operations):
    max_q = []
    min_q = []
    for i in operations:
        oper = i.split(' ')
        if oper[0] == 'I':
            heapq.heappush(max_q, (-int(oper[1]), int(oper[1])))
            heapq.heappush(min_q, int(oper[1]))
        elif not max_q:
            continue
        elif oper[0] == 'D' and oper[1] == '-1':
            temp = heapq.heappop(min_q)
            max_q.remove((-temp,temp))
        elif oper[0] == 'D' and oper[1] == '1':
            temp = heapq.heappop(max_q)[1]
            min_q.remove(temp)
    if max_q and min_q :
        return [max_q[0][1], min_q[0]]
    else :
        return [0, 0]

def solution2(operations):
    q = deque([])
    for i in operations:
        oper = i.split(' ')
        if oper[0] == 'I':
            q.append(int(oper[1]))
            q = deque(sorted(q))
        elif not q:
            continue
        elif oper[0] == 'D' and oper[1] == '-1':
            q.popleft()
        elif oper[0] == 'D' and oper[1] == '1':
            q.pop()
    if len(q) < 2:
        return [0, 0]
    else:
        return [q.pop(), q.popleft()]

print(solution2(["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]))