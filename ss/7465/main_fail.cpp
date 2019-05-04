#include <iostream>
#include <queue>
#include <string.h>

using namespace std;

int groups(bool map[][101], int n);

int main(){
    int tc;
    
    cin >> tc;
    
    for(int i=1; i<=tc; i++){
        int n, m, out;
        
        bool idx[100][101]; //정점 마다 해당 목적지의 간선이 있는지 체크한다
        
        cin >> n >> m;
        
        for(int j = 0; j < m; j++){
            int a, b;
            cin >> a >> b;
            
            idx[a][b] = true; //a-b, b-a 양방향 간선 
            idx[b][a] = true;

            idx[a][0] = true; //정점 체크
            idx[b][0] = true;
            
                
        }
        out  = groups(idx, n);
        cout << "#" << i << " " << out << endl;
        
        for(int k = 0 ; k < 100 ; ++k){
            memset(idx[k], false, sizeof(bool)*101);
        }
        
    }
}

int groups(bool map[][101], int n){
    int cnt = 0;
    queue<int> q;
    for(int i=1 ; i<=n ; i++){
        if(map[i][0]){                  //정점이 있다면
            cnt++;                      //정점이 있다면 최소 하나의 그룹을 이룬다.
            q.push(i);                  //queue에 정점을 삽입하고
            map[i][0] = false;          //정점을 지운다
            
            while(q.empty()==0){        //queue에 정점이 없을때 까지
                int item;
                item = q.front();       //정점을 꺼낸다.
                q.pop();
                for(int j=1 ; j<=n ; j++){
                    if(map[item][j] && map[j][0]){ //정점에 연결된 또 다른 정점이고, 아직 방문하지 않은 정점이라면
                        q.push(j);               //이 정점을 삽입한다
                        map[j][0] = false;       //삽입된 정점은 지운다
                    }
                }
            }
        }

    }
    return cnt;
}
