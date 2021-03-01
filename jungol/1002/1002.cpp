#include <iostream>

using namespace std;

int input[10], gcd_n, lcm_n;

int gcd(int a, int b){
/*    
    int big, small, mod;
    big = a > b ? a : b;
    small = a < b ? a : b;

    mod = big % small;

    if(mod == 0)
        return small;
    else
        gcd(small, mod);
*/
    if(b == 0)
        return a;
    return gcd(b, a % b);
}

int lcm(int a, int b){
    return (a * b) / gcd_n;
}

int main(){
    int T;

    cin >> T;
    cin >> input[0];
    gcd_n = lcm_n = input[0];

    for(int i = 1 ; i < T ; i++){
        cin >> input[i];
        gcd_n = gcd(gcd_n, input[i]);
        lcm_n = lcm(lcm_n, input[i]);
    }
    cout << gcd_n << " " << lcm_n << endl;

    return 0;
}
