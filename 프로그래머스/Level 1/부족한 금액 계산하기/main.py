def solution(price, money, count):
    answer = 0
    for i in range(1, count):
        print(i)
        answer += i * price
    print(answer)
    return answer

solution(3, 20, 4)