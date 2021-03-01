# 문제
진법 변환
## 입력
```
입력은 100개 이하의 테스트 케이스가 행으로 구분하여 주어진다.
테스트 케이스의 끝에는 0이 주어진다. 
각 테스트 케이스에는 세 수 A, N, B가 공백으로 구분되어 주어진다.

2 11010 8
2 10110 10
10 2543 16
16 ABC 8
0
```
## 출력
```
각 테스트 케이스에 대하여 A진법수 N을 B진법 수로 변환한 결과를 행으로 구분하여 출력한다.

32
22
9EF
5274
```

# 풀이
```
int charToDec(char in){
    if(in >= 'A')
        return in-'A'+10;
    else
        return in-'0'
}

char N[64]

long long dec(char * in, int A){
    int ret = 0;
    for(int i = 0 ; in[i] ; i++){
        ret = ret * A + charToDec(in[i]);
    }
}
```