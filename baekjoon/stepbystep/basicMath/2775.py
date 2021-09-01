T=int(input())


for i in range(T):
	k=int(input()) # 층
	n=int(input()) # 호수
	people=[n for n in range(1,n+1)] # people은 0층의 인원
	# 1호부터 n호까지. n이 증가하며 값으로 들어간다.

	for j in range(k): # 층이 2층이라면 2번 반복, 1번 반복하면 people에는 1층의 인원
	# 2번 반복하면 people에는 2층의 인원.
		for u in range(1,len(people)): # 0번 인덱스 접근해야 하니까 범위 1부터
			people[u]+=people[u-1] 
		#print(people)

	print(people[-1])

		
# 따로 규칙이 있는 문제는 아니라서 그냥 리스트 사용해서 풀면 된다.
# 만약 층마다 증가하는 인원이었다면 규칙을 찾아야겠지?