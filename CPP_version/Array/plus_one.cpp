// watch out for carry
class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        bool carry = false;
        for (int i = digits.size() - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            carry = digits[i] == 0;
            
            if (!carry)
                return digits;
        }
        
        if (carry) {
            digits[0] = 1;
            digits.push_back(0);
        }
        
        return digits;
    }
};