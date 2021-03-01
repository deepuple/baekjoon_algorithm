#include <iostream>

using namespace std;

char in[10001];

int main(){
    cin >> in;

    int kcnt = 0,icnt = 0;
    for(int i = 0 ; in[i+2] ; i++ ){
        if(in[i]=='K')
            if(in[i+1]=='O' && in[i+2]=='I' ) { kcnt++; }
        if(in[i]=='I')
            if(in[i+1]=='O' && in[i+2]=='I' ) { icnt++; }   
    }
    cout << kcnt << endl << icnt << endl;
    return 0;
}