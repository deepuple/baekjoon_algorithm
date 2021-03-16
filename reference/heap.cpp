#include <iostream>

using namespace std;

int N, hn = 0;
const int SIZE = 100;
int heap[SIZE];

void myswap(int& a, int& b){
    int z = a;
    a = b;
    b = z;
}

void push(int index){
    while(index > 1 && (heap[index] > heap[index/2])){ // max-heap
        myswap(heap[index], heap[index/2]);
        index /= 2;
    }
}

int pop(){
    if(hn == 0) return -1;
    if(hn == 1) return heap[1];

    int ret = heap[1];
    myswap(heap[1], heap[hn]);
    hn--;

    int index = 1;
    while(index * 2 <= hn){    
        int leap = index * 2;
        if( leap < hn && heap[leap] < heap[leap+1] ) leap++; //leap < hn - hn이 홀수개인 경우에만, 이 조건에 들어온다. 짝수개인 경우에는 안들어옴. 
        if( heap[index] > heap[leap]) break; //max - heap
        myswap(heap[index], heap[leap]);
        index = leap;
    }

    return ret;
}

int main(){
    cin >> N;

    for(int i = 1 ; i <= N ; i++){
        cin >> heap[i];
        push(i);
        hn++;
    }

    for(int i = 1 ; i <= N ; i++){
        cout << pop() << endl;
    }

    return 0;
}
