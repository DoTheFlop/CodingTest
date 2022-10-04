from collections import deque
def solution(bridge_length, weight, truck_weights):
    answer = 0
    sec = 0
    moving_que = deque
    truck_weights = deque(truck_weights)
    while truck_weights:
        sec += 1
        pivot = truck_weights.popleft()
        if pivot + truck_weights[0] <= weight and len(moving_que) + 2 < bridge_length:
            moving_que.append(pivot)
            moving_que.append(truck_weights.popleft)
        else:
            moving_que.append(pivot)
        
        
        
    return answer

print(solution(2, 10, [7,4,5,6]))