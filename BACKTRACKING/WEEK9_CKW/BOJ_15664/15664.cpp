#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N,M;
vector<int> num;
vector<int> arr;
vector<bool> visited;

void dfs(int a, int b){

    if(b==M){
        for(int i=0; i<M; i++){
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    }

    int pre_num=-1;

    for(int i=a; i<N; i++){
        if(!visited[i] && pre_num != num[i]){
            visited[i] = true;
            pre_num = num[i];
            arr[b]=num[i];
            dfs(i+1, b+1);
            visited[i] = false;
        }
        
    }

}

int main() {

    cin >> N >> M;

    num.resize(N);
    arr.resize(M);
    visited.resize(N);

    for(int i=0; i<N; i++){
        cin >> num[i];
    }    

    sort(num.begin(), num.end());

    dfs(0,0);

    return 0;

}