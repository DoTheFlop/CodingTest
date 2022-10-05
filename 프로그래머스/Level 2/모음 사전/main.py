from itertools import product

def solution(word):
    alpha = ['A', 'E', 'I', 'O', 'U']

    dict = sorted([''.join(j) for i in range(5) for j in product(alpha, repeat = i + 1) ])
    
    return dict.index(word) + 1

print(solution("AAAAE"))