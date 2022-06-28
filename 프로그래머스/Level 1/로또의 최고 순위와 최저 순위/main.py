#처음 풀이
def solution(lottos, win_nums):
    answer = [0, 0]
    zero_count = lottos.count(0)
    win_count = 0
    for i in win_nums:
        if i in lottos:
            win_count += 1
    answer[0] = 7 - (win_count + zero_count)
    answer[1] = 7 - win_count
    if answer[1] == 7 :
        answer[1] = 6
    if answer[0] == 7 :
        answer[0] = 6
    return answer

#정답
def solution(lottos, win_nums):

    rank=[6,6,5,4,3,2,1]

    cnt_0 = lottos.count(0)
    ans = 0
    for x in win_nums:
        if x in lottos:
            ans += 1
    return rank[cnt_0 + ans],rank[ans]