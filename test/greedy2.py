n, m, k = map(int, input().split())    # 공백으로 구분하여 입력받기 

# n 은 배열의 크기
# m 은 숫자가 더해지는 횟수
# k 는 해당하는 수가 연속으로 더해질 수 있는 횟수 제한

nlist = list(map(int, input().split())) # n개의 자연수

nlist.sort()  # n개의 자연수 정렬

first_big = nlist[n-1] # 가장 큰 수
second_big = nlist[n-2] # 두번째로 큰 수

result = 0  # 정답을 넘겨줄 변수

while True:
    
    for i in range(k):
        if m == 0: # m번 더했으면 반복문 탈출
            break
        result += first_big
        m-=1  

    if m == 0: # m번 더했으면 반복문 탈출
        break    
    
    result += second_big
    m-=1


print("큰 수의 법칙에 따라 더해진 결과 : ", result)
