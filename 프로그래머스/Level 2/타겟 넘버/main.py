def solution(numbers, target):
    node = [0]
    for i in numbers:
        temp = []
        for j in node:
            temp.append(j + i)
            temp.append(j - i)
        node = temp
        
    return node.count(target)

print(solution([1, 1, 1, 1, 1],	3))