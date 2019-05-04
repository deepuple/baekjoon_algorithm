#include <iostream>

using namespace std;
int getGCD(int n , int k);

int main(){
    int tc;
    
    cin >> tc;
    
    for(int i = 1 ; i <= tc; i++){
        int n, k, out;
        cin >> n >> k;
        out = getGCD(n,k);
        cout << "#" << i << " " << out << endl;
    }
}

int getGCD(int n , int k){
    int ret = 1;
    
    if(n>=k){
        return k;
    }else{
        for(int i = n ; i>=1 ; i--){
            if(k%i==0){
                ret *= i;
                k = k/i;
            }
        }
    }
    return ret;
}