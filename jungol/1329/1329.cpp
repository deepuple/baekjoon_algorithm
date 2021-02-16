#include <iostream>

using namespace std;

int n, i, j;
int main(){

    cin >> n;

    for(i = 1; i<=(n/2)+1; i++){
        for(j = 1; j <= i-1 ; j++)
            cout << " ";
        for(j = 1; j <=(2*i)-1 ; j++)
            cout << "*";
        cout << endl;
    }

    for(i = (n/2); i>=1; i--){
        for(j = 1; j <= i-1 ; j++)
            cout << " ";
        for(j = 1; j <=(2*i)-1 ; j++)
            cout << "*";
        cout << endl;
    }
    
    return 0;
}
