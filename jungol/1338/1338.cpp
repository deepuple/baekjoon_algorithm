#include <iostream>

using namespace std;

int N;
char arr[101][101] = {0};

int main(){
    cin >> N;

    char ch = 'A';

    for(int k = 1 ; k <= N ; k++ )
        for(int i = k, j = N ; i <= N ; i++, j--)
            arr[i][j] = ch++;
    
    for(int i = 1 ; i <= N ; i++){
        for(int j = 1 ; j <= N ; j++){
            if(arr[i][j]==0) printf(" ");
            else printf("%c", arr[i][j]);
        }
        printf("\n");
    }
    
    return 0;
}
