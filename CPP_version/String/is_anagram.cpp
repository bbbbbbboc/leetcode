class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.length() != t.length())
            return false;
        
        map<char, int> map;
        for (char c : s) {
            map[c]++;
        }
        
        for (char c : t) {
            if (map[c] == 0)
                return false;
            map[c]--;
        }
        
        return true;
    }
};