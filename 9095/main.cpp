#include <iostream>

using namespace std;

int N;
int dp[11];

int main(){
    int tc;

    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    
    cin >> tc;
    
    for(int i = 0 ; i<tc; ++i){
        cin >> N;
        
        for(int j = 4 ; j <= N ; ++j){
            dp[j] = dp[j-1] + dp[j-2] + dp[j-3];    
        }
        
        cout << dp[N] << endl;
    }    
}