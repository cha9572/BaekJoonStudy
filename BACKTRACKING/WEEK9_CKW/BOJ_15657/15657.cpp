#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N, M;

vector<int> num;
vector<int> arr;

void dfs(int a, int b){

    if(b==M){
        for(int i=0; i<M; i++){
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    }

    for(int i=a; i<N; i++){
        arr[b]=num[i];
        dfs(i, b+1);
    }

}

int main() {

    cin >> N >> M;

    num.resize(N);
    arr.resize(M);

    for(int i=0; i<N; i++){
        cin >> num[i];
    }

    sort(num.begin(), num.end());

    dfs(0,0);


    return 0;
}