def solution(n, lost, reserve):
    
    reserve_unique = set(reserve) - set(lost)
    lost_unique = set(lost) - set(reserve)

    for i in reserve_unique:
        if i-1 in lost_unique:
            lost_unique.remove(i-1)
        elif i+1 in lost_unique:
            lost_unique.remove(i+1)
    print(n - len(lost_unique))
    return n - len(lost_unique)

solution(5, [2, 4], [1, 3, 5])