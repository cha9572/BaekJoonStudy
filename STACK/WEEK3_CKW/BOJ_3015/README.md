# 오아시스 재결합 (플레 5)
## 코드 설명

1. 2차원 배열 stack 생성 [0]:키, [1]:볼수있는 쌍의 수
2. 만약 stack이 비워져있으면 push
3. stack이 비워져있지 않고 peek[0]<num[i] : cnt+=pop[1]
4. stack이 비워져있지 않고 peek[0]>num[i] : push, cnt++
5. peek[0]==num[i] : cnt+=peek[1], peek[1]++, 만약 stack.size>1 이면 cnt++ 왜냐하면 size가 1보다 크다는건 num[i]보다 큰 키의 마주 볼 수 있는 사람이 존재한다는 것이기 때문
6. 그리고 답이 겁나커서 int에 저장하면 안됨(1부터 5십만 까지 더하면 int 자료형(-21억 ~ 21억) 넘어감)

## stack 배열 안쓰고 풀기
- 우선 이 방법은 시간 초과가 발생함 하지만 나의 노력한 시간이 너무 아까워서 씀
- 조건만 쓰겠음

### peek == num[i]
- peek가 num[i]와 같은 동안 계속 반복 얘도 pop 계속 해줘야함 그리고 pop한 만큼 다시 push
- cnt++

### peek < num[i]
- peek가 num[i] 보다 작거나 같은 동안 계속 반복
- if(peek < num[i]) -> pop , cnt++
- if(peek == num[i]) -> cnt++ 근데 여기서 pop을 계속 해줘야 무한 루프에 안빠짐 대신 pop 한만큼 다시 push 해줘야함

### peek > num[i]
- cnt++, push