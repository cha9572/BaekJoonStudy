#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N, M;
vector<int> num;
vector<int> arr;

void backtracking(int a){
    if(a==M){
        for(int i=0; i<M; i++){
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    }

    int pre=-1;

    for(int i=0; i<N; i++){
        if(pre!=num[i]){
            arr[a] = num[i];
            pre = num[i];
            backtracking(a+1);
        }
    } 
}

int main(){

    cin >> N >> M;

    num.resize(N);
    arr.resize(M);

    for(int i = 0; i<N; i++){
        cin >> num[i];
    }

    sort(num.begin(), num.end());

    backtracking(0);


}