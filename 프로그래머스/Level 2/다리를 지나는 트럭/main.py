from collections import deque

def solution(bridge_length, weight, truck_weights):
    queue = deque([0]*bridge_length)
    truck_weights = deque(truck_weights)
    time, total = 0, 0
    while truck_weights:
        time += 1
        total -= queue.popleft()
    
        if total + truck_weights[0] > weight:
            queue.append(0)
        else:
            w = truck_weights.popleft()
            total += w
            queue.append(w)

    return time + bridge_length

print(solution(2, 10, [7,4,5,6]))