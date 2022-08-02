import sys

sys.stdin = open("input2.txt", "r")

T = int(input())

for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    nums = list(map(int, input().split()))
    min_value = 1
    max_value = max(nums)
    while min_value <= max_value:
        mid = (min_value + max_value) // 2      ## 가방의 갯수!!!! 가방의 갯수를 이분 탐색을 통해 줄여나가는 것
        cnt = 0                                 ## 가방 하나에 들어가는 사탕의 개수
        for num in nums:    
            cnt += num // mid

        if cnt < M:     
            max_value = mid - 1                 ## 최대값을 줄이기
        else:  
            min_value = mid + 1     
    print('#{} {}'.format(test_case, max_value))