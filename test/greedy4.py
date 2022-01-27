# 1이 될 때 까지

n, k = map(int, input().split())
count = 0

while n >= k:
    while n%k != 0:
        n-=1
        count+=1
    n = n//k
    count+=1

while n > 1:
    n-=1
    count+=1

print(count)

# 이 문제에서는 n이 10만 이하이므로 나누어 떨어지지 않는다면 1씩 뺴는걸 반복해도 되지만
# n이 100억 이상의 큰 수가 되는 경우는 n이 최대한 k의 배수가 되도록 해서 한 번에 빼야한다.
    