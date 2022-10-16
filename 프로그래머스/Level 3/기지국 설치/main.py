import math

def solution(n, stations, w):
    answer = 0

    # 전파가 안 통하는 구간의 (시작점, 끝점) 의 모음
    segments = []

    # 좌표1 ~ 첫번째 안테나 사이의 전파가 안 통하는 구간
    if stations[0] - w - 1 >= 1:
        segments.append([1, stations[0]-w-1])

    # 첫번째 안테나 ~ 마지막 안테나 사이의 전파가 안 통하는 구간
    for i in range(len(stations) - 1):
        start = stations[i] + w + 1
        end = stations[i+1] - w - 1

        if start <= end:
            segments.append([start, end])

    # 마지막 안테나 ~ 좌표n 까지 전파가 안 통하는 구간
    if stations[-1] + w + 1 <= n:
        segments.append([stations[-1] + w + 1, n])

    # 전파가 안 통하는 구간 마다
    for segment in segments:
        # 구간의 길이
        length = segment[1] - segment[0] + 1
        answer += math.ceil(length / (w * 2 + 1))
    return answer

print(solution(11, [4, 11], 1))