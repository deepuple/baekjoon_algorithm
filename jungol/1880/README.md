# 문제
```
예를 들어, 복호화 키가 "eydbkmiqugjxlvtzpnwohracsf" 와 같이 주어진다고 하자, 

그러면 이는 다음과 같다 - a 문자는 e, b 문자는 y, ..., z 문자는 f로 바꿔 준다.

암호화 된 문자는 대소문자 혹은 공백이 올수 있고 대문자는 대문자로 소문자는 소문자로 치환 규칙에 맞게 출력하고, 공백문자는 그대로 출력한다.
```
## 입력
```
첫 줄에는 복호화 키가 26개의 소문자로 주어지고, 다음 줄에는 암호화 된 문자가 최대 80 문자로 입력된다.

eydbkmiqugjxlvtzpnwohracsf
Kifq oua zarxa suar bti yaagrj fa xtfgrj
```

## 출력
```
Jump the fence when you seeing me coming
```

# 풀이
```
26개의 키를 받아서...index대로 출력한다.

cin >> key;
cin >> out;

for(int i = 0 ; out[i]; i++){
    if(out[i] >= 'A' && out[i] <= 'Z'){
        char value = key[(out[i]-'A')];
        out[i] = value -'a' + 'A';
    }
    else if(out[i] >= 'a' && out[i] <= 'z'){
        out[i] = key[(out[i]-'a')];
}

cout << out << endl;
```

## 주의사항
줄 바꿔서 한줄 받기
```
    cin >> key;
    getchar();
    cin.getline(out,80);
```