#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int k;
vector<int> arr;
vector<int> num;

void backtracking(int a, int b){

    if(a==6){
        for(int i=0; i<6; i++){
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    }

    for(int i=b; i<k; i++){
        arr[a] = num[i];
        backtracking(a+1, i+1);
    }

}


int main() {

    while(1){
        cin >> k;

        if(k==0)
            break;

        num.resize(k);

        for(int i=0; i<k; i++){
            cin >> num[i];
        }

        arr.resize(6);
        backtracking(0,0);


        cout << "\n";
    }

}