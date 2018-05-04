#include <bits/stdc++.h>

using namespace std;

int n,k;

int mapa[1002][1002];

int barridoGusano(int x,int y){
    int ans = 0;
    int acum = 0;
    int i = x, j = y;
    while(i <= n && j <=n && x <= i && y <= j){
        acum = mapa[i][j] - mapa[i][y-1] - mapa[x-1][j] + mapa[x-1][j-1];
        if(acum >= k){
            ans += n-j+1;
            x++;
            y++;
        }else{
            i++;
            j++;
        }
    }
    return ans;
}

int main(){
    int tot = 0;
    cin >> n >> k;    
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= n; j++){
            cin >> mapa[i][j];
            mapa[i][j] += mapa[i-1][j] + mapa[i][j-1] - mapa[i-1][j-1];///barrido suma
        }    
    }
    tot+=barridoGusano(1,1);
    for(int i = 2; i <= n;i++){
        tot += barridoGusano(i,1);
        tot += barridoGusano(1,i);
    }
    cout << tot << "\n";
    
    ///nota hay 3 tipos de barridos el tercero es BIT(binary index tree)
    return 0;  
}
