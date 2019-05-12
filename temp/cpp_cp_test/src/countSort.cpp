#include <iostream>
#define MAX 1000000

using namespace std;

int N;
int cnt[(MAX*2)+1];

//0, -1, 1,-2, 2,-3, 3....-1000000, 1000000
//0, 1, 2, 3, 4, 5, 6....1999999, 2000000

int main(){

    int tc;
    cin >> tc;
    
    for(int i = 0; i < tc; ++i){
    
        cin >> N;
        
        if(N < 0)
            cnt[(N*(-1)*2)-1]++;
        else if(N > 0)
            cnt[N*2]++;
        else
            cnt[N]++;
    }
    
    for(int j = (MAX*2)-1 ; j > 0; j = j-2){
        if(cnt[j]!=0)
            cout << ((j+1)/2)*(-1) << '\n';
    }
    for(int k = 0 ; k <= MAX*2; k = k+2){
        if(cnt[k]!=0)
            cout << k/2 << '\n';
    }
   
}