#include <iostream>

using namespace std;

int N;
int dp[46];

int main(){

    dp[1] = 1;
    dp[2] = 1;
    
    cin >> N;
    
    for(int j = 3 ; j <= N ; ++j){
        dp[j] = dp[j-1] + dp[j-2];
    }
    
    cout << dp[N] << endl;
   
}