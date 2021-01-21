최대공약수, 최소공배수

### input
3
2 8 10

### output
2 40

### 구현
최대공약수, 최소공배수 구하는 알고리즘을 알고 있느냐 모르고 있느냐에 대한 문제

#### 최대공약수
1. 큰수 A 를 작은수 B 로 %로 나눈다.
2. 나머지 C 가 0이면 작은수가 최대공약수
3. 0이 아니면 B를 C로 나눈다 (나머지가 0이 될 때 까지 1~2 반복)

```
int gcd(int a, int b){
    int big, small, mod;
    big = a > b ? a : b;
    small = a < b ? a : b;

    mod = big % small;

    if(mod == 0)
        return small;
    else
        gcd(small, mod);
}
```

#### 최소공배수
1. 두 수를 곱해 최대공약수로 나눈다

```
int lcm(int a, int b){
    return (a * b) / gcd_n;
}
```
