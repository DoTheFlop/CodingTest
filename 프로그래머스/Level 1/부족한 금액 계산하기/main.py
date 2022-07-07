def solution(price, money, count):
    answer = 0
    for i in range(1, count+1):
        print(i)
        answer += i * price
    if answer > money: return answer - money
    else: return 0

solution(3, 20, 4)