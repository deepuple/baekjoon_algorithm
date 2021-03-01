# 문제
주어진 문자열에서 연속 3개의 문자가 IOI 이거나 KOI인 문자열이 각각 몇 개 있는지 찾는 프로그램을 작성하라.

## 입력
```
KOIOIOI
```
## 출력
```
1
2
```
# 풀이
한글자씩 탐색해 가면서...
K나 I로 시작해서 OI로 끝나면 카운팅 한다

for(int i = 0 ; i < in.len-2 ; i++ ){
    if(in[i]=='K')
        if(in[i+1]=='O' && in[i+1]=='I' ) { kcnt++ }
    if(in[i]=='I')
        if(in[i+1]=='O' && in[i+1]=='I' ) { icnt++ }   
}
cout << kcnt << endl << icnt << endl;