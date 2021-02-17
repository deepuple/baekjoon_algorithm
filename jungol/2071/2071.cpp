#include <iostream>

using namespace std;

int i, j, m, n;
int arr[31][31] = {0};

int main(){
    cin >> m >> n;

    arr[i][j] = 1; // 1,1에 1을 넣고...

    for(i = 1; i <= m; i++)
        for(j = 1; j <= m; j++)
            arr[i][j] = arr[i-1][j-1]+arr[i-1][j]; //파스칼 배열 생성
    
    if(n == 1){
        for(i = 1; i <= m; i++){
            for(j = 1; j <= i; j++)
                cout << arr[i][j];
            cout << endl;
        }
    }
    else if(n == 2){
        for(i = m; i >= 1; i--){
            for(j = 1; j <= m-i ; j++)
                cout << " ";
            for(j = 1; j <= i; j++)
                cout << arr[i][j];
            cout << endl;
        }
    }else if(n == 3){
        for(j = m ; j >= 1 ; j--){
            for(i = m ; i >= j ; i--)
                cout << arr[i][j];
            cout << endl;
        }
    }

    return 0;
}
