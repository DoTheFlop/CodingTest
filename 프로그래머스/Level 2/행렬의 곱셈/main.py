import numpy as np

def solution(arr1, arr2):
    arr1 = np.array(arr1)
    arr2 = np.array(arr2)
    answer = arr1 @ arr2
    return answer.tolist()

print(solution([[1, 4], [3, 2], [4, 1]], [[3, 3], [3, 3]]))

#numpy 안쓰고 다시 풀기