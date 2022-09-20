def solution(n, words):
    answer = []
    people = [0] * n
    stop = True
    already_spoken = []
    while stop:
        for i in range(n):
            people[i] += 1
            if words[0] in already_spoken:
                answer = i
                stop = False
                break
            if len(already_spoken) > 0:
                if already_spoken[-1].strip()[-1] != words[0].strip()[0]:
                    answer = i
                    stop = False
                    break
            already_spoken.append(words.pop(0))
            if(words == []):
                stop = False
                break

    if words == []:
        return [0, 0]
    else:
        return [answer + 1, people[answer]]


#print(solution(3, ["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]))

print(solution(2, ["hello", "one", "even", "never", "now", "world", "draw"]))