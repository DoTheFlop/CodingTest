def solution(board, moves):
    answer = 0
    answer_list = []

    for i in moves:
        for j in board:
            if j[i-1] != 0:
                answer_list.append(j[i-1])
                j[i-1] = 0
                break
        if len(answer_list) >=2 and answer_list[-1] == answer_list[-2]:
            answer += 2
            answer_list = answer_list[:-2]

    print(answer)
    return answer



solution([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]], [1,5,3,5,1,2,1,4])