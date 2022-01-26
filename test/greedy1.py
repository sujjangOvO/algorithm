n = 1260 # 거스름돈
count = 0 # 거슬러줄 동전의 최소 갯수

coin_types = [500, 100, 50, 10] # 거스름돈 종류

for coin in coin_types:
    count += (n//coin) # 해당 coin으로 거슬러 줄 수 있는 동전의 갯수
    n %= coin 

print(count,"개")

# 시간복잡도는 n에 영향을 받지 않고 오로지 거스름돈 종류에 영향을 받는다. 