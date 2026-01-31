#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

vector<int> num;
vector<int> arr;
vector<int> visited;
int N, M;

void dfs(int a, int b){
    if(b==M){
        for(int i=0; i<M; i++){
            cout << arr[i] << " ";
        }    
        cout << "\n";
        return;
    }

    for(int i=a; i<N; i++){
        if(!visited[i]){
            arr[b]=num[i];
            visited[i]=1;
            dfs(a,b+1);
            visited[i]=0;
        }
    }

}

int main() {


    cin >> N >> M;
    
    num.resize(N);
    visited.resize(N);
    arr.resize(M);
    
    for(int i=0; i<N; i++){
        cin >> num[i];
    }

    sort(num.begin(), num.end());

    dfs(0,0);



    return 0;
}