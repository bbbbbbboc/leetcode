// 158. Read N Characters Given Read4 II - Call multiple times

/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    int bufferCounter = 0;
    int bufferPtr = 0;
    char[] tmp = new char[4];
    
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int ptr = 0;
        while (ptr < n) {
            if (bufferPtr == 0) 
                bufferCounter = read4(tmp);
            
            if (bufferCounter == 0) 
                break;
            
            while (ptr < n && bufferPtr < bufferCounter) {
                buf[ptr] = tmp[bufferPtr];
                ptr++;
                bufferPtr++;
            }
            
            if (bufferPtr >= bufferCounter)
                bufferPtr = 0;
        }
        
        return ptr;
    }
}

// I used buffer pointer (buffPtr) and buffer Counter (buffCnt)
//  to store the data received in previous calls. In the while loop, 
// if buffPtr reaches current buffCnt, 
// it will be set as zero to be ready to read new data.