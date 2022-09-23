import math

def solution(progresses, speeds):
    answer = []
     
    progress = [0] * len(progresses)
    for i in range(len(progresses)) :
        progress[i] = math.ceil((100 - progresses[i]) / speeds[i])
    
    pivot = progress[0]
    cnt = 0
    
    while progress:
        v = progress.pop(0)
        if v > pivot:
            answer.append(cnt)
            cnt = 1
        else:
            cnt += 1
        pivot = max(pivot, v)

    answer.append(cnt)
    return answer


print(solution([93, 30, 55], [1, 30, 5]))