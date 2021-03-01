#include <iostream>

using namespace std;

char key[26];
char out[80];

int main(){
    cin >> key;
    getchar();
    cin.getline(out,80);

    for(int i = 0 ; out[i] ; i++){
        if(out[i] >= 'A' && out[i] <= 'Z'){
            char value = key[(out[i]-'A')];
            out[i] = value -'a' + 'A';
        }
        else if(out[i] >= 'a' && out[i] <= 'z'){
            out[i] = key[(out[i]-'a')];
        }
    }

    cout << out << endl;
}
