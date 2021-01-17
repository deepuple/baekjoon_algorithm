#include <iostream>
#include <string>
#include <queue>

using namespace std;

int N, M;
bool MAP[1000][1000];
bool V[1000][1000][2];

int bfs();

int main(){
    
    cin >> N >> M;
    
    for(int i = 0; i < N ; ++i){
        string in;
        cin >> in;
        for(int j = 0 ; j < M ; ++j){
            if(in[j]-'0' == 1){
                MAP[i][j] = true;
            }
        }
    }
    
    cout << bfs() << endl;
}

int bfs(){
    
    int depth = 0;
    
    queue<pair<pair<int, int>,int>> q;
    
    int dx[4] = {0,1,0,-1};
    int dy[4] = {1,0,-1,0};
    
    q.push(make_pair(make_pair(0, 0),0));
    
    while(!q.empty()){
        int sz = q.size();
        for(int i = 0 ; i < sz ; ++i){
            pair<pair<int, int>,int> n = q.front();
            q.pop();
            
            pair<int, int> node = n.first;
            int crashed = n.second; //0:uncrashed, 1:crashed

            V[node.first][node.second][crashed] = true;
            
            if(node.first == N-1 && node.second == M-1)
                return depth+1;
            
            for(int j = 0; j < 4 ; ++j){//4방향 체크...
                
                int nx = node.first+dx[j]; 
                int ny = node.second+dy[j];
                
                if( nx < 0 || nx >= N || ny < 0 || ny >= M ) continue;
                
                if(MAP[nx][ny] == false && V[nx][ny][crashed] == false){ //방문 가능한 곳이면 queue에 추가
                    q.push(make_pair(make_pair(nx, ny),crashed));
                    V[nx][ny][crashed] = true;
                }
                
                if(MAP[nx][ny] == true){ //벽 뚫자..
                    if(crashed==0){
                        q.push(make_pair(make_pair(nx, ny),1)); //벽 뚫은 좌표 및 여부가 트리에 추가 된다
                        V[nx][ny][1] = true;
                    }
                }
            }
        }
        depth++;
    }
    return -1;
}