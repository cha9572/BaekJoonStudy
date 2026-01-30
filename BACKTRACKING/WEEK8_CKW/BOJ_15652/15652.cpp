#include <iostream>
using namespace std;

int N,M;
int arr[9] = {0,};

void dfs(int num, int count)
{
    if(count == M)
    {
        for(int i = 0; i < M; i++)
            cout << arr[i] << ' ';
        cout << '\n';
        return;
    }
    for(int i = num; i <= N; i++)
    {
            arr[count] = i;
            dfs(i,count+1);
    }
}

int main() {
    cin >> N >> M;
    dfs(1,0);
}