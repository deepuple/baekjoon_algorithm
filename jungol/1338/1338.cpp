#include <iostream>

using namespace std;

int i, j, k, n;
char arr[101][101] = {0};

int main(){
    cin >> n;

    char ch = 'A';

    for(k = 1 ; k <= n ; k++ )
        for(i = k, j = n ; i <= n ; i++, j--)
            arr[i][j] = ch++;
    
    for(i = 1 ; i <= n ; i++){
        for(j = 1 ; j <= n ; j++){
            if(arr[i][j]==0) cout << " ";
            else cout << arr[i][j] ;
        }
        cout << endl;
    }
    
    return 0;
}
