// 345. Reverse Vowels of a String

class Solution {
    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        if (s == null || s.isEmpty())
            return s;
        
        char[] arr = s.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            while (left < right && vowels.indexOf(arr[left]) == -1) {
                left++;
            }
            while (left < right && vowels.indexOf(arr[right]) == -1) {
                right--;
            }
            
            if (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
            
            left++;
            right--;
        }
        
        return new String(arr);
    }
}