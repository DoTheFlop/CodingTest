def solution(numbers, target):
    node = [0]
    
    for i in numbers:
        sub = []
        for j in node:
            sub.append(j+i)
            sub.append(j-i)
        node = sub
    answer = node.count(target)
    return answer

print(solution([1, 1, 1, 1, 1],	3))