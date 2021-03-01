# 문제
```
임의의 문장을 입력받아 각 단어별로 나눈 후에 단어들의 중복되는 개수를 구하는 프로그램을 작성하시오. 

<처리조건>

(1) 입력된 스트링은 글자의 제한은 없다. 즉, 알파벳 대.소문자, 공백, ', ' 등도 입력으로 들어 올 수 있다. 

(2) 입력된 문장에서 각 단어사이의 구분은 공백으로 한다. 

(3) 단어에는 공백을 제외한 모든 문자들이 포함된다.​ 
```
## 입력
```
I AM DOG DOG DOG DOG A AM I
I AM OLYMPIAD JUNGOL JUNGOL OLYMPIAD
END
```
## 출력
```
A : 1
AM : 2
DOG : 4
I : 2
AM : 1
I : 1
JUNGOL : 2
OLYMPIAD : 2
```
# 풀이
```
문장을 분리하고
정렬하여
카운팅 하면서 출력

cin.getline(in,200);

void divide(in){
    int word_cnt = 1, word_len = 0;
    for(int i = 0 ; in[i]; i++){
        if(in[i]=' '){
            word_len = 0;
            word_cnt++;
        }else{
            word[word_cnt][word_len] = in[i];
            word_len++;
        }
    }
}

int _strlen(char* a){
    int len = 0;
    while(a[len]) len++;
    return len;
}


int _strcmp(char* a, char* b){
    int i;
    for(i = 0 ; a[i] && b[i] && a[i]==b[i] ; i++);  //단어가 모두 같을때 까지...
    return a[i]-b[i];                               //한글자라도 다르면 차이를 출력, 단어가 다른 단어의 일부일 경우에도 차이를 출력
}

void swap(char *a, char* b){
    bool isSwap = false;
    for(int i = 0 ; a[i]&&b[i] ; i++){
        if(a[i]>b[i]) {isSwap = true; break;}
    }

    if((isSwap==false)&&(_strlen(a)>_strlen(b)))
        isSwap = true;
    
    if(isSwap){
        for(int i = 0 ; i<200 ; i++){
            char tmp = a[i];
            a[i] = b[i];
            b[i] = tmp;
        }
    }
}

void sort(word_cnt){                                    //버블소트
    for(int i = 0 ; i < word_cnt ; i++){
        for(int j = i ; j < word_cnt-(i+1) ; j++){
            if(_strcmp(word[j],word[j+1]))
                swap(word[j], word[j+1]);
        }
    }
}

void disp(word_cnt){
    int cnt = 1;                                        //카운트는 1부터, 
    for(int i = 0 ; i < word_cnt; i++){                 //0번부터 단어 수 만큼
        if(_strcmp(word[i], word[i+1])!=0){             //다음 것과 비교해서 다르면
            cout << word[i] <<": " << cnt; << endl;     //현재 단어 수를 출력한다. 
            cnt = 1;                                    //카운트는 1로 한다
        }
        else                                            //같으면
            cnt++;                                      //단어수를 증가한다
    }
}
```