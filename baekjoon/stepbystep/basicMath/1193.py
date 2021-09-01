n=int(input())
line=0
max_num=0
# 몇번째 대각선인지 구하기
while n>max_num:
	line+=1
	max_num+=line


# line수와 그 라인의 최대수를 구함.

if line%2==0: # 짝수
	bunza=line-(max_num-n)
	bunmo=max_num-n+1
	print(f"{bunza}/{bunmo}")

else: # 홀수
	bunmo=n-(max_num-line)
	bunza=(max_num-n)+1
	print(f"{bunza}/{bunmo}")
