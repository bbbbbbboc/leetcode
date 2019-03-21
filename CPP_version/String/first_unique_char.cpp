class Solution {
public:
    int firstUniqChar(string s) {
        map<char, int> map;
        for (int i = 0; i < s.length(); i++) {
            map[s[i]]++;
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (map[s[i]] == 1)
                return i;
        }
        
//         return -1;
        
//         unordered_map<char, pair<int, int>> m;
//         int idx = s.size();
//         for (int i = 0; i < s.size(); i++) {
//             m[s[i]].first++;
//             m[s[i]].second = i;
//         }
//         for (auto &p : m) {
//             if (p.second.first == 1) idx = min(idx, p.second.second);
//         }
//         return idx == s.size() ? -1 : idx;
    }
};