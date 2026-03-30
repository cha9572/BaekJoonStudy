#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int N, M;
vector<int> num;
vector<int> arr;

void backtracking(int a, int b){
    if(a == M){
        for(int i=0; i<M; i++){
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    }

    int pre = -1;

    for(int i=b; i<N; i++){
        if(pre!=num[i]){
            arr[a] = num[i];
            pre=num[i];
            backtracking(a+1, i);
        }
    }

}

int main(){

    cin >> N >> M;

    num.resize(N);
    arr.resize(M);

    for(int i=0; i<N; i++){
        cin >> num[i];
    }

    sort(num.begin(), num.end());

    backtracking(0, 0);

}