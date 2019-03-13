#include <iostream>
// #include <vector>
#include <map>

using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> result;
        map<int, int> map;
        
        for (int i = 0; i < nums.size(); i++) {
            if (map.count(target - nums[i]) != 0) {
                result.push_back(map.at(target - nums[i]));
                result.push_back(i);
                return result;
            }
            
            map.insert(pair<int,int>(nums[i],i));
        }
        
        return result;
    }
};