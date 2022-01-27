n, m, k = map(int, input().split())  

# n 은 배열의 크기
# m 은 숫자가 더해지는 횟수
# k 는 해당하는 수가 연속으로 더해질 수 있는 횟수 제한

nlist = list(map(int, input().split())) # n개의 자연수

nlist.sort()  

first_big = nlist[n-1] 
second_big = nlist[n-2] 

result = 0 

# m이 100억이상이 된다면 시간 초과가 날 수 있음 
# 다른 방식으로 풀이하자.

# 가장 큰 수가 나오는 횟수를 구하자
# 반복되는 수열의 길이는 k+1이다. (k가 3이면 5+5+5+4, 5+5+5+4 이니까 반복되는 수열의 길이는 4)
# 수열이 반복되는 횟수는 m//k+1 
# 수열이 반복되는 횟수에서 k를 곱하면 가장 큰 수가 더해지는 횟수
# 만약, m이 k+1로 나누어 떨어지지 않는 경우는 k%(m+1) 만큼 큰 수가 추가로 더해질 것

count = (m//(k+1))*k
count += m%(k+1)

result = count * first_big
result += (m-count) * second_big

print(result)