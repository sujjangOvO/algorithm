# n이 100억 이상의 큰 수가 되는 경우는 n이 최대한 k의 배수가 되도록 해서 한 번에 빼야한다.
# n이 100억 이상인 경우의 1이 될 때까지 풀이

n, k = map(int, input().split())
count = 0 
goal = 0 # n이 k의 배수가 되도록 하기 위한 수

while True:
    goal = (n//k)*k
    count += (n-goal) # n이 goal이 될 때 까지 1을 뺴는 횟수
    n = goal
    
    if n < k:
        break 

    n = n//k
    count += 1

count += (n-1) # k보다 작을 때 n이 1이 될 때 까지 1을 빼는 횟수
print(count)