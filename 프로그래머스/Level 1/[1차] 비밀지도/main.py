def solution(n, arr1, arr2):
    answer = []
    arr1_binary = [0] * n
    arr2_binary = [0] * n
    for i in range(n):
        k = ''
        arr1_binary[i] = format(arr1[i], 'b')
        arr2_binary[i] = format(arr2[i], 'b')
        a = str(int(arr1_binary[i]) + int(arr2_binary[i]))
        if len(a) < n:
            a = '0'*(n-len(a)) + a
        for j in a:
            if int(j) > 0:
                k = k + '#'
            else:
                k = k + ' '
        answer.append(k)
    return answer


solution(5, [9, 20, 28, 18, 11], [30, 1, 21, 17, 28])

