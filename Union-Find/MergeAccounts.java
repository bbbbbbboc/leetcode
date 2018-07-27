// 721. Accounts Merge

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> owners = new HashMap<>();    // email-user
        Map<String, String> fathers = new HashMap<>();  // email-rootEmail
        Map<String, TreeSet<String>> unions = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                fathers.put(account.get(i), account.get(i));
                owners.put(account.get(i), account.get(0));
            }
        }
        
        for (List<String> account : accounts) {
            String root = findRoot(account.get(1), fathers);
            for (int i = 2; i < account.size(); i++) {
                fathers.put(findRoot(account.get(i), fathers), root);
            }
        }
        
        for (List<String> account : accounts) {
            String root = findRoot(account.get(1), fathers);
            if (!unions.containsKey(root))
                unions.put(root, new TreeSet<>());
            for (int i = 1; i < account.size(); i++) {
                unions.get(root).add(account.get(i));
            }
        }
        
        for (String root : unions.keySet()) {
            List<String> emails = new ArrayList<>(unions.get(root));
            emails.add(0, owners.get(root));
            ans.add(emails);
        }
        
        return ans;
    }
    
    private String findRoot(String s, Map<String, String> fathers) {
        if (fathers.get(s).equals(s))
            return s;
        return findRoot(fathers.get(s), fathers);
    }
}