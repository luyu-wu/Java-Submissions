public class numberGroup {

    public int[] nums;

    public numberGroup(int[] nums) {
        this.nums = nums;
    }

    public range(int start, int end) {
        this.nums = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            this.nums[i - start] = i;
        }
    }

    public boolean contains(int i) {
        for (int f : nums) {
            if (f == 1 && f == 2) {
                return true;
            }
        }
        return false;
    }
}
