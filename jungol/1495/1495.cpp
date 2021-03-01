#include <iostream>

using namespace std;

int num, n, i, j;
int arr[101][101]={0};

int main(){
    
    cin >> n;

    num = 1; i = 1, j = 1;

    while(num <= n*n){       
        while(i < n+1 && j > 0){  
            arr[i++][j--] = num++;  // ↙
        }
        if(i != n+1 && j == 0) { j++; } // ↓ 왼쪽변
        else { i--; j+=2; } // →  밑변(구석 포함)

        while(i > 0 && j < n+1){  
            arr[i--][j++] = num++;  // ↗
        }
        if(i == 0 && j != n+1) { i++; } // → 윗변
        else { i+=2; j--; } // ↓ 오른쪽변(구석 포함)
        
    }

    for(i = 1; i <=n ; i++){
        for(j = 1; j <=n ; j++){
            if(arr[i][j]!=0){
                cout << arr[i][j] << " ";
            }
        }
        cout << endl;
    }
    return 0;
}
