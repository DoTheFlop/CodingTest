import operator

def solution(genres, plays):
    answer = []
    dic = {x : 0 for x in genres}
    
    for i in range(len(plays)):
        dic[genres[i]] += plays[i]
    
    dic = dict(sorted(dic.items(), key=operator.itemgetter(1), reverse = True))
        
    for genre in list(dic.keys()):
        temp = []
        for idx in range(len(plays)):
            if genre == genres[idx]:
                temp.append((idx, plays[idx]))
                
        temp.sort(key=operator.itemgetter(1), reverse = True)
        
        if len(temp) == 1 :
            answer.append(temp[0][0])
        else :
            for i in range(0, 2):
                answer.append(temp[i][0])
    return answer


print(solution(["classic", "pop", "classic", "classic", "pop"], [500, 600, 150, 800, 2500]))