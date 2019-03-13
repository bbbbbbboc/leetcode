#include <iostream>
#include <vector> 

using namespace std;

// remove dup in an array
class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int i = 0;
        int j = 0;
        
        while (j < nums.size()) {
            while (j + 1 < nums.size() && nums[j] == nums[j + 1]) {
                j++;
            }
            nums[i] = nums[j];
            i++;
            j++;
        }
        
        return i;
    }
};