class Solution {
public:
    bool isPalindrome(string s) {
        int left = 0;
        int right = s.length() - 1;
        
        while (left < right) {
            while (left < right && !isValid(s, left)) {
                left++;
            }
            while (left < right && !isValid(s, right)) {
                right--;
            }
            
            char c1 = tolower(s[left]);
            char c2 = tolower(s[right]);
            
            if (c1 != c2) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
private:
    bool isValid(string s, int idx) {
        return (s[idx] >= '0' && s[idx] <= '9') || (s[idx] >= 'a' && s[idx] <= 'z' || (s[idx] >= 'A' && s[idx] <= 'Z'));
    }
};