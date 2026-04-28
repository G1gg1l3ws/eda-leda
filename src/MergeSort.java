import java.io.*;
import java.util.Arrays;

class MergeSort {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            int[] v = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            mergeSort(v, 0, v.length-1);

        } catch(IOException ioe) {}
    }

    public static void mergeSort(int[] v, int l, int r) {
        // a "cópia" do array não é mantida na memória
        System.out.println(Arrays.toString(Arrays.copyOfRange(v, l, r+1)));
        
        if (l >= r) {
            return;
        }

        int m = (l+r)/2;
        mergeSort(v, l, m);
        mergeSort(v, m+1, r);
        
        merge(v, l, r);

    }

    public static void merge(int[] v, int l, int r) {
        int rightHelper = r-l;
        // esta cópia é mantida na memória
        int[] helper = Arrays.copyOfRange(v, l, r+1);

        int middleHelper = (rightHelper)/2;
        
        int i = 0;
        int j = middleHelper + 1;
        int k = l;
        while (i <= middleHelper && j <= rightHelper) {
            if (helper[i] < helper[j]) {
                v[k] = helper[i];
                i++;
            } else {
                v[k] = helper[j];
                j++;
            }
            
            k++;
        }

        //caso não itere sobre alguma das metades
        while (i <= middleHelper) {
            v[k] = helper[i];
            i++;
            k++;
        }
        while (j <= rightHelper) {
            v[k] = helper[j];
            j++;
            k++;
        }

        System.out.println(Arrays.toString(Arrays.copyOfRange(v, l, r+1)));
    }
}
