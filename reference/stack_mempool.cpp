#include <iostream>

using namespace std;

const int SIZE = 100;
const char* empty = "empty";
int N, stSize;

struct Node{
    int value;
    Node* np;
    Node* push(int nv, Node* t){
        value = nv;
        np = t;
        return this;
    }
}buf[SIZE], *top;

int pop(){
    int ret = -1;
    if(top){
        ret = top->value;
        top = top->np; 
        stSize--;
    }
    return ret;
}

int main(){
    cin >> N;
    
    for(int i = 0 ; i < N ; i++){
        char CMD;
        cin >> CMD;

        if(CMD == 'i'){
            int value;
            cin >> value;
            top = buf[stSize++].push(value, top);
        }

        if(CMD == 'o'){
            int value = pop();
            if(value == -1)
                cout << empty << endl;
            else
                cout << value << endl;
        }   
        
        if(CMD == 'c'){
            cout << stSize << endl;
        }
    }
}
