#include <iostream>

using namespace std;

char in[200];
char word[100][200];

int divide(char* in){
    int word_cnt=0, word_len=0;
    for(int i = 0 ; in[i]; i++){
        if(in[i]==' '){
            word_len = 0;
            word_cnt++;
        }else{
            word[word_cnt][word_len] = in[i];
            word_len++;
        }
    }
    return word_cnt+1;
}

int _strlen(char* a){
    int len = 0;
    while(a[len]) len++;
    return len;
}

int _strcmp(char* a, char* b){
    int i;
    for(i = 0 ; a[i] && b[i] && a[i]==b[i] ; i++);
    return a[i]-b[i];
}

void swap(char *a, char* b){
    for(int i = 0 ; i<200 ; i++){
        char tmp = a[i];
        a[i] = b[i];
        b[i] = tmp;
    }
}

void sort(int word_cnt){
    for(int i = 0 ; i < word_cnt ; i++){
        for(int j = 0 ; j < word_cnt-(i+1) ; j++){
            if(_strcmp(word[j],word[j+1])>0)
                swap(word[j], word[j+1]);
        }
    }
}
void cnt_disp(int word_cnt){
    int cnt = 1;
    for(int i = 0 ; i < word_cnt; i++){
        if(_strcmp(word[i], word[i+1])!=0){
            cout << word[i] <<" : " << cnt << endl;
            cnt = 1;
        }
        else
            cnt++;
    }
}

int main(){
    char end_str[] = "END";
    while(true){
        
        cin.getline(in,200);
        
        if(_strcmp(in, end_str)==0)
            break;

        for(int i = 0 ; i<100 ; i++)
            for(int j = 0 ; j<200 ; j++)
                word[i][j] = 0;

        int word_cnt = divide(in);
        sort(word_cnt);
        cnt_disp(word_cnt);
    }
    return 0;
}