public class test {
    public static void main(String[] args) {
        int[] list ={3, 2, 6, 4, 5, 1};
        int[] lis = new int[6];
        int[] prev = new int[6];

        int len = 1;
        int last = 0;

        for (int i = 0; i < list.length; i++) {
            lis[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (list[j] > list[i]) {
                    continue;
                }

                if (lis[i] < lis[j] + 1) {
                    lis[i] = lis[j] + 1;
                    prev[i] = j;
                    if (len < lis[i]) {
                        last = i;
                        len = lis[i];
                    }
                }
            }
        }

        System.out.println("lis = " + lis);
        System.out.println("lis = " + lis);
    }
}
