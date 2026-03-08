#include <iostream>
using namespace std;

int main() {
    int N, K;
    int sum = 0;
    cin >> N >> K;
    
    int arr[N];
    
    for(int i = 0; i < N; i++){
        cin >> arr[i];
    }
    
    for(int i = N-1; i >= 0; i--) {
        
            
            if(K / arr[i] > 0) {
                sum += K / arr[i];
                K = K % arr[i];
            }
        
        
    }
    
    cout << sum;

}