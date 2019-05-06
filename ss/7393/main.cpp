#include <iostream>

using namespace std;

const int MOD = 1000000000;
int dp[101][10][1<<10];

int get_cnt(int N);

int main(){
    
    int tc;
    int n;
    
    cin >> tc;
    
    for(int i = 0 ; i < tc ; i++){
        cin >> n;   
   
        cout << "#" << i+1 << " " << get_cnt(n) << endl;
    }
}

int get_cnt(int a){

    int ret = 0;
    
    if(a < 10){ return 0; }
    
    for(int i = 1 ; i < 10 ; i++){
        dp[1][i][1<<i] = 1;
    }
    
    for(int i = 2 ; i <= a ; ++i){
        for(int j = 0 ; j < 10 ; ++j){
            for(int k = 0 ; k < 1024 ; ++k){
                
                if(j == 0 ){
                    dp[i][0][k|(1<<0)] += dp[i-1][1][k]; //10 <- 1
                }else if(j == 9){
                    dp[i][9][k|(1<<9)] += dp[i-1][8][k]; //89 <- 8
                }else{
                    dp[i][j][k|(1<<j)] += dp[i-1][j-1][k];
                    dp[i][j][k|(1<<j)] += dp[i-1][j+1][k];
                }
                
                dp[i][j][k|(1<<j)] %= MOD;
                
            }
        }
    }
    
    for(int i = 0 ; i < 10 ; ++i){
        ret += dp[a][i][(1<<10)-1];  
        ret %= MOD;
    }
    
    return ret;
}