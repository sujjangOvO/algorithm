n, m = map(int,input().split())
# n은 행, m은 열

#card_list = [[0]*m for _ in range(n)]  # 2차원 리스트 만들 필요 없음!!
min_list = []

for i in range(n):
    row_list = list(map(int,input().split()))
    val_min = min(row_list)
    min_list.append(val_min)

# 문제 해결 : 각 행에서 가장 숫자가 낮은 카드를 뽑아서 그 중에서 가장 큰 값을 출력한다.
# 각 행의 가장 낮은 숫자가 들어있는 리스트 min_list

min_list.sort() # 배열을 정렬
result = min_list[n-1]
print(result)

# 굳이 min_list를 만들어 정렬하지 않고도 max 함수를 이용해 가장 큰 값을 찾을 수 있다.
# val_min을 구한다음 10번째 라인에 result = max(result, val_min) 을 작성해주면 result에 result와 val_min중 큰 값이 result가 될 것이다. 