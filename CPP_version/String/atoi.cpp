class Solution {
public:
    int myAtoi(string str) {
        long result = 0;
        int indicator = 1;
        int idx = 0;
        
        while (idx < str.length()) {
            if (str[idx] != ' ') {
                break;
            }
            idx++;
        }
        
        if (str[idx] == '+' || str[idx] == '-') {
            indicator = str[idx] == '+' ? 1 : -1;
            idx++;
        }
        
        while (str[idx] >= '0' && str[idx] <= '9') {
            result = result * 10 + (str[idx] - '0');
            if (result * indicator >= INT_MAX) {
                return INT_MAX;
            }
            if (result * indicator <= INT_MIN) {
                return INT_MIN;
            }
            idx++;
        }
        
        return result * indicator;
    }
};