def solution(answers):
    answer=[]
    fakeAnswer1 = [1, 2, 3, 4, 5]
    fakeAnswer2 = [2, 1, 2, 3, 2, 4, 2, 5]
    fakeAnswer3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    score = [0, 0, 0]

    for i in range(len(answers)):
        if(answers[i] == fakeAnswer1[i%5]):
            score[0] += 1
        if(answers[i] == fakeAnswer2[i%8]):
            score[1] += 1
        if(answers[i] == fakeAnswer3[i%10]):
            score[2] += 1

    winner = max(score)

    for i in range(len(score)):
        if score[i] == winner:
            answer.append(i+1)
    return answer

print(solution([1,2,3,4,5]))