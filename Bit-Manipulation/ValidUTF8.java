// 138. Copy List with Random Pointer

class Solution {
    public boolean validUtf8(int[] data) {
        if (data == null || data.length == 0)
            return false;
        
        boolean res = true;
        for (int i = 0; i < data.length; i++) {
            int num = data[i];
            if (num > 255)  // 1 after 8 digit, 10000000
                return false;
            
            int numOfBytes = 0;
            
            if ((num & 128) == 0)   // 0xxxxxxx, 1 byte, 128(10000000)
                numOfBytes = 1;
            else if ((num & 224) == 192)    // 110xxxxx, 2 bytes, 224(11100000), 192(11000000)
                numOfBytes = 2;
            else if ((num & 240) == 224)    // 1110xxxx, 3 bytes, 240(11110000), 224(11100000)
                numOfBytes = 3;
            else if ((num & 248) == 240)    // 11110xxx, 4 bytes, 248(11111000), 240(11110000)
                numOfBytes = 4;
            else
                return false;
            
            for (int j = 1; j < numOfBytes; j++) {  // check next n bytes start with 10xxxxxx
                if (i + j >= data.length)
                    return false;
                if ((data[i + j] & 192) != 128)     // 192(11000000), 128(10000000)
                    return false;
            }
            
            i += numOfBytes - 1;
        }
        
        return true;
    }
}