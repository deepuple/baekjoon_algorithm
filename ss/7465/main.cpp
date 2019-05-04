#include <iostream>
#include <vector>
#include <string.h>

using namespace std;

void dfs(int idx);

vector<int> a[101];
bool chk[101];
int ans;

int main(){
    int tc;
    
    cin >> tc;
    
    for(int i=1; i<=tc; i++){
        int n, m, out;
        
        cin >> n >> m;
        
        for(int j=0; j<m; ++j){
            int x, y;
            cin >> x >> y;
            a[x].push_back(y);
            a[y].push_back(x);
        }
        for (int k=1; k<=n; k++){
            if (!chk[k]){
                dfs(k); ans++;
            }
        }
        
        cout << "#" << i << " " << ans << endl;
        
        for (int l=1; l<=n; l++){
            fill(a[l].begin(), a[l].end(), 0);
        }

        fill_n(chk, 101, false);
        ans = 0;
    
    }
}

void dfs(int idx){
    chk[idx] = true;
    for(int i=0; i<a[idx].size(); ++i){
        int next = a[idx][i];
        if(!chk[next])
            dfs(next);
    }
}
