import numpy as np

def solution(arr1, arr2):
    arr1 = np.array(arr1)
    arr2 = np.array(arr2)
    answer = arr1 @ arr2
    return answer.tolist()

print(solution([[1, 4], [3, 2], [4, 1]], [[3, 3], [3, 3]]))

#numpy 안쓰고 다시 풀기

def solution2(arr1, arr2):
    answer = [[0]*len(arr2[0]) for _ in range(len(arr1))]
    
    for i in range(len(arr1)): 
        lists = []
        for j in range(len(arr2[0])): 
            for k in range(len(arr1[0])): 
                answer[i][j] += arr1[i][k] * arr2[k][j]
    return answer