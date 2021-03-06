def solution(array, commands):
    answer = []
    cut = []

    for i in commands:
        cut = array[(i[0]-1) : i[1]]
        cut.sort()
        answer.append(cut[i[2]-1])
    print(answer)
    return answer

#풀이
def solution(array, commands):
    return list(map(lambda x:sorted(array[x[0]-1:x[1]])[x[2]-1], commands))

solution([1, 5, 2, 6, 3, 7, 4], [[2, 5, 3], [4, 4, 1], [1, 7, 3]])