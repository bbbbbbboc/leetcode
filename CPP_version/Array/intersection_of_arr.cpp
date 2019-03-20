class Solution {
public:
    vector<int> intersect(vector<int>& nums1, vector<int>& nums2) {
        map<int, int> map;
        vector<int> result;
        
        for (int i = 0; i < nums1.size(); i++) {
            map[nums1[i]]++;
        }
        for (int i = 0; i < nums2.size(); i++) {
            map[nums2[i]]--;
            if (map[nums2[i]] >= 0) {
                result.push_back(nums2[i]);
            }
        }
        
        return result;
    }
};