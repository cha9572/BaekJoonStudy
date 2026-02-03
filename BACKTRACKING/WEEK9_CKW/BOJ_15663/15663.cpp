#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <cmath>

using namespace std;

int N, M;

vector<int> num;
vector<int> arr;
vector<int> visited;


void dfs(int a, int b){

    if(b==M){
        for(int i=0; i<M; i++){
            cout << arr[i] << " ";
        }
        cout << "\n";
        
        return;
    }

    int num_visit = -1;

    for(int i=0; i<N; i++){
        if(!visited[i] && num_visit != num[i]){
            visited[i] = 1;
            arr[b]=num[i];
            num_visit = num[i];
            dfs(i, b+1);
            visited[i] = 0;
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