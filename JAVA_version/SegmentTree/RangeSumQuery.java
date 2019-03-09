// 307. Range Sum Query - Mutable

class NumArray {
    
    class SegmentTreeNode {
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;
        
        SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    private SegmentTreeNode buildTree(int start, int end, int[] nums) {
        if (start > end)
            return null;
        
        SegmentTreeNode n = new SegmentTreeNode(start, end);
        if (start == end) {
            n.sum = nums[start];
            return n;
        } else {
            int mid = (start + end) / 2;
            n.left = buildTree(start, mid, nums);
            n.right = buildTree(mid + 1, end, nums);
            n.sum = n.left.sum + n.right.sum;
            return n;
        }
    }
    
    private void updateTree(SegmentTreeNode root, int pos, int val) {
        if (root.start == root.end) {
            root.sum = val;
            return;
        }
        
        int mid = (root.start + root.end) / 2;
        if (pos <= mid) {
            updateTree(root.left, pos, val);
        } else {
            updateTree(root.right, pos, val);
        }
        root.sum = root.left.sum + root.right.sum;
    }
    
    private int queryTree(SegmentTreeNode root, int start, int end) {
        if (root.start == start && root.end == end)
            return root.sum;
        
        int mid = (root.start + root.end) / 2;
        if (end <= mid) {
            return queryTree(root.left, start, end);
        } else if (start >= mid + 1) {
            return queryTree(root.right, start, end);
        } else {
            return queryTree(root.right, mid + 1, end) + queryTree(root.left, start, mid);
        }
    }
    
    SegmentTreeNode root;

    public NumArray(int[] nums) {
        root = buildTree(0, nums.length - 1, nums);
    }
    
    public void update(int i, int val) {
        updateTree(root, i, val);
    }
    
    public int sumRange(int i, int j) {
        return queryTree(root, i, j);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */