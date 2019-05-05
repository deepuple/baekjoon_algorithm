#include <iostream>

using namespace std;

int N;
int W[16][16];
int dp[16][1<<16];
int TSP(int curr, int history);

int main(){
    
    cin >> N;
    
    for(int i = 0 ; i < N ; i++){
        for(int j = 0 ; j < N ; j++){
            cin >> W[i][j];
        }
    }
    
    cout << TSP(0, 1) << endl;
}

int TSP(int curr, int history){
    
    int ret = 999999999;
    int v;
    
    if(dp[curr][history]!=0){
        return dp[curr][history];
    }
    
    if(history == (1<<N)-1){
        if(W[curr][0]!=0){
            return W[curr][0];
        }
        return ret;
    }
    
    for(int i = 0 ; i < N ; ++i){
        if((history & (1<<i)) || W[curr][i] == 0){
            continue;
        }
        
        if(W[curr][i]!=0){
            v = TSP(i, history | (1<<i))+W[curr][i];
        }
        
        if(ret > v){
            ret = v;
        }
        
    }
    
    dp[curr][history] = ret;
    
    return ret;
}