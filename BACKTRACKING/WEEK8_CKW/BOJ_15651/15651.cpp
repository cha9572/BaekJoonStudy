#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>

using namespace std;

int main() {

    int N, M;

    cin >> N >> M;
    
    vector<int> a(M);

    for(int j=0; j<M; j++){
        a[j]=0;
    }
    

    for(int i=0; i<(int)pow(N,M); i++){
        for(int j=0; j<M; j++){
            
            //cout << (int)pow(N,(M-j-1));
            if(i % (int)pow(N,(M-j-1)) == 0)
                a[j]++;
            if(a[j]>N)
                a[j]=1;
        }


        for(int j=0; j<M; j++){
            cout << a[j] << " ";
        }
        cout << "\n";
        

    }
    
    

}