def solution(A, B):
    answer = 0
    A.sort(reverse = True)
    B.sort(reverse = True)
    for i in A:
        if i < B[0]:
            B.pop(0)
            answer += 1
    return answer

print(solution([5,1,3,7], [2,2,6,8]))