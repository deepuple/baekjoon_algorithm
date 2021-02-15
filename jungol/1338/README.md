1338: 문자삼각형 1

            A
          B F
        C G J
      D H K M
    E I L N O

  행(i) 열(j)   
A: 1 ~ 1, 5 ~ 5    
B: 2 ~ 2, 4 ~ 4   
...   
E: 5 ~ 5, 1 ~ 1 // i: 1 ~ n, j: n ~ 1   
   
F: 2 ~ 2, 5 ~ 5   
...   
I: 5 ~ 5, 2 ~ 2 // i: 2 ~ n, j: n ~ 2   
   
J~L // i: 3 ~ n, j: n ~ 3   
```
char ch = 'A';

for( k = 1 ; k <= n ; k++ )
 for( i = k, j = n ; i <= n ; i++, j--)
    arr[i][j] = ch++;
```
