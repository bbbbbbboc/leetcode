// 406. Queue Reconstruction by Height

/*We first sort the people to make them stand from the highest to shortest. 
For people with same height, sort them according to the count of people before them from small to big.

Then, we use the way similar to insert sorting to reorder the people. 
For a given person to insert, all the people already sorted are higher, 
so we just insert him in the "right" place to make the people 
before him as his "count" indicates. 
Since he is shorter than all the people in the sorted list, 
the "count" of the "existing" people does not be broken by the insertion.
*/

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int len = people.length;
        int[][] ans = new int[len][2];
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0])
                    return a[1] - b[1];
                return b[0] - a[0];
            }
        });
        
        List<int[]> temp = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            temp.add(people[i][1], new int[]{people[i][0], people[i][1]});
        }
        
        for (int i = 0; i < len; i++) {
            ans[i][0] = temp.get(i)[0];
            ans[i][1] = temp.get(i)[1];
        }
        
        return ans;
    }
}