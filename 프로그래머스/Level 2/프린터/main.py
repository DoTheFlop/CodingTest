from collections import deque

def solution(priorities, location):
    answer = 0

    priorities = deque([(v,i) for i,v in enumerate(priorities)])

    while len(priorities):
        item = priorities.popleft()
        if priorities and item[0] < max(priorities)[0]:
            priorities.append(item)
        else:
            answer += 1
            if(location == item[1]):
                break
    return answer

print(solution([2, 1, 3, 2], 2))