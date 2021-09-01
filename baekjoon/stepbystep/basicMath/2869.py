a,b,v=map(int,input().split())
cnt=0

total=0
today=a-b

while True:
	total=total+today
	if total>v:
		break
	cnt+=1


print(cnt)