def solution(n, stations, w):
    answer = 0
    apartment = [0] * n
    no_signal = []
    for i in range(n):
        if i+1 in stations:
            apartment[i] = 1
        else:
            no_signal.append(i)

    pivot = no_signal.pop(0)
    cnt = 0
    for i in range(len(apartment)):
        if apartment[i] == 1:
            continue
        if cnt == w:
            if apartment[i] == 0:
                if i+w > len(apartment):
                    answer += 1
                    break
                for j in range(i-w, i+1 + w):
                    apartment[j] = 1
                    if j in no_signal:
                        no_signal.remove(j)
                answer += 1
                if no_signal:
                    pivot = no_signal.pop(0)
                cnt = 0
                continue
            else:
                apartment[pivot] = 1
        cnt += 1
    return answer

print(solution(11, [4, 11], 1))