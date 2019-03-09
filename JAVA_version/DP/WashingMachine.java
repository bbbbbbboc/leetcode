// 517. Super Washing Machines

class Solution {
    public int findMinMoves(int[] machines) {
        int sum = 0;
        for (int i : machines)
            sum += i;
        
        if (sum % machines.length != 0)
            return -1;
        
        int count = 0;
        int max = 0;
        int avg = sum / machines.length;
        
        for (int load : machines) {
            count += (load - avg);
            max = Math.max(Math.max(max, Math.abs(count)), load - avg);
        }
        
        return max;
    }
}