import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    int[] input = {8, 3, 20, 1, 9, 15, 18, 6, 2, 13, 11, 8, 16};
    // {0,3,4,31,4,6,30}
    //{ 8, 3, 20, 1, 9, 15, 18, 6, 2, 13, 11, 8, 16 }
    print(input);
    input = mergeSort(input);
    print(input);

  }

  static void print(int[] arr) {
    System.out.print("[");
    for (int i = 0; i < arr.length; i++) {
      System.out.print(" " + arr[i]);
    }
    System.out.print("]\n");
  }

  static int[] mergeSort(int[] a) {
    //System.out.println("MergeSort on: ");
    //print(a);
    int len = a.length;
    //System.out.println("Length: " + len);
    if (len > 2) {
      int pivot = a.length / 2;

      int[] left = Arrays.copyOfRange(a, 0, pivot);

      int[] right = Arrays.copyOfRange(a, pivot, len);
      left = mergeSort(left);
      right = mergeSort(right);
      a = merge(left, right);
    } else if (len == 2) {
      if (a[0] > a[1]) {
        int tmp = a[0];
        a[0] = a[1];
        a[1] = tmp;
      }
    }
    return a;
  }

  static int[] merge(int[] a, int[] b) {
    int[] merged = new int[a.length + b.length];
    // System.out.print("a: ");
    // print(a);
    // System.out.print("b: ");
    // print(b);

    int i = 0;
    int j = 0;
    for (int z = 0; z < merged.length; z++) {
      if (i < a.length) {
        if (j < b.length) {
          if (a[i] <= b[j]) {
            merged[z] = a[i];
            i++;
          } else {
            merged[z] = b[j];
            j++;
          }
        } else {
          merged[z] = a[i];
          i++;
        }
      } else {
        if (j < b.length) {
          merged[z] = b[j];
          j++;
        }
      }
    }
    // System.out.print("merged: ");
    // print(merged);
    return merged;
  }

}