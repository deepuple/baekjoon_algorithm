# 문제
- input
n = 5

- output
1  3  4  10 11 
2  5  9  12 19
6  8  13 18 20
7  14 17 21 24
15 16 22 23 25

# 풀이

↗, ↙ 반복, arr[i--][j++], arr[i++][j--]    
한줄 출력이 끝나고 다음 좌표는?    
범위를 벗어나면 ↓, →   
```
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
```
