def solution(N, stages):
    answer = []
    people = len(stages)
    fail_cnt = {}
    for i in range(1, N+1):
        if people != 0:
            cnt = stages.count(i)
            fail = cnt / people
            fail_cnt[i] = fail
            people -= cnt
        else :
            fail_cnt[i] = 0

    return sorted(fail_cnt, key=lambda x : fail_cnt[x], reverse=True)

solution(5, [2, 1, 2, 6, 2, 4, 3, 3])