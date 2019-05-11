#include <iostream>
#include <vector>
#include <algorithm> 

using namespace std;

int N; // 노드 개수
int node_time[1001]; // 노드의 건설 시간
vector<int> v[1001]; // 노드 별 필요 건물 저장
int dp[1001]; // 노드 별 소요되는 최소 시간

int build_time(int target);

int main(){
    
    ios_base::sync_with_stdio(false); cin.tie(NULL);cout.tie(NULL);
    
    int tc;
    
    cin >> tc;
    
    for(int i = 0 ; i < tc ; ++i){
        
        int build_rule_num, target;
        
        fill_n(dp, 1001, -1);
        
        cin >> N >> build_rule_num;
        
        for(int j = 0 ; j < N ; j++){
            cin >> node_time[j+1];
        }
        
        for(int k = 0 ; k < build_rule_num; ++k){
            int from, to;
            cin >> from >> to;
            v[to].push_back(from);
        }
        
        cin >> target;
        
        cout << build_time(target) << endl;
        
        for(int l = 1 ; l <= N ; l++){
            if(v[l].size()!=0){
                v[l].clear();
            }
            dp[l] = -1;
        }
        
    }
}

int build_time(int target){
    
    if(v[target].size()==0)
        return node_time[target];
    
    if(dp[target]!=-1)
        return dp[target];
    
    int prev = 0;
    
    for(int j = 0 ; j < v[target].size() ; ++j){
        prev = max(prev, build_time(v[target][j]));
    }
    dp[target] = prev + node_time[target];
    
    /* 상향식...실패
    for(int i = 1 ; i <= target ; ++i){
        
        int prev = 0;
        
        for(int j = 0 ; j < v[i].size() ; ++j){
            prev = max(prev, dp[v[i][j]]);
        }
        
        dp[i] = node_time[i] + prev;
    }
    */
    return dp[target];
}