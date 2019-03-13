#include <map>
using namespace std;

class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        map<int, int> map;
        for(int idx : nums) {
            if(map[idx] > 0)
                return true;
            map[idx]++;
        }
        return false;
    }
};