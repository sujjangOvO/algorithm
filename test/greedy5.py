# 모험가 길드 

n = map(int, input()) # 모험가의 수
fears = list(map(int,input().split())) # 공포도,  n 이하의 자연수

fears.sort() # 공포도를 오름차순으로 정렬
people = 0 # 파티원 수
party_num = 0 # 파티 갯수

for i in fears:
    people += 1
    if people >= i : # 파티원 수가 공포도와 같다면
        party_num += 1 # 파티 1개 추가 
        people = 0 # 새로운 파티원을 구하기 위해 초기화 

print(party_num)




