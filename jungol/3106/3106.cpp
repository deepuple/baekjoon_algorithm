#include <iostream>

using namespace std;

int A = 1, B;
char N[64];

int charToDec(char in){
    if(in >= 'A')
        return in-'A'+10;
    else
        return in-'0';
}

char decToChar(int in){
    if(in >= 10)
        return in-10+'A';
    else
        return in+'0';
}

long long dec(char* in, int A){
    long long ret = 0;
    for(int i = 0 ; in[i] ; i++){
        ret = ret * A + charToDec(in[i]);
    }
    return ret;
}

void tran(long long dig, int B){
    if(dig == 0) return;
    tran(dig/B, B);
    cout << decToChar(dig % B);
}

int main(){
    while(true){
        cin >> A; 
        if(A == 0)
            break;
        cin >> N >> B;
        long long dig = 0;
        dig = dec(N, A);
        if (dig == 0) { cout << 0 << endl; return 0; }
        else tran (dig, B); 
        cout << endl; 
    }
    return 0;
}