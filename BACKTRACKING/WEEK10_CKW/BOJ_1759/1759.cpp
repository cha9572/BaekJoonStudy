#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int L, C;
vector<char> letter;
vector<char> arr;

bool check(){
    int vowel = 0;
    int consonant = 0;
    for(int i=0; i<L; i++){
        char tmp = arr[i];
        if(tmp == 'a' || tmp == 'e' || tmp == 'i' || tmp == 'o' || tmp == 'u'){
            vowel++;
        }
    }
    consonant = L-vowel;
    if(vowel>0 && consonant>=2)
        return true;
    else
        return false;

}

void backtracking(int a, int b){

    if(a==L){
        if(check()){
            for(int i=0; i<L; i++){
                cout << arr[i];
            }
            cout << "\n";
            return;
        }
    }

    for(int i=b; i<C; i++){
        arr[a] = letter[i];
        backtracking(a+1, i+1);
    }


}

int main() {


    cin >> L >> C;

    letter.resize(C);
    arr.resize(L);

    for(int i=0; i<C; i++){
        cin >> letter[i];
    }

    sort(letter.begin(), letter.end());

    backtracking(0,0);

}