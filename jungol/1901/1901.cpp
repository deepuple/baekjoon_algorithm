#include <iostream>

using namespace std;

int T, num;

bool isPrime(int num){
    for(int i = 2 ; i * i <= num ; i++){
        if(num % i == 0)
            return false;
    }
    return true;
}

int main(){

    cin >> T;
    
    while(T--){
        cin >> num;
        bool flag = true;
        int diff = 0;
        while(flag){
            if(num-diff > 1)
                if(isPrime(num-diff)){ cout << num-diff << " "; flag = false; }
            if(num+diff < 1000000)
                if(isPrime(num+diff)){ cout << num+diff; flag = false; }

            diff++;
        }
        cout << endl;
    }
}