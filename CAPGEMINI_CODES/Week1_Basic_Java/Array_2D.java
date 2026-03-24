package capgemeini_training;

public class Assignment_24Jan_Array_2D {
    public static void main(String[] args) {
        char ch[][]={{'a','b','c','d'},{'e','f','g','h'},{'i','j','k','l'}};
        for(int i=0;i<ch.length;i++) {
            for(int j=0;j<ch[i].length;j++) {
                System.out.print(ch[i][j]+" ");
            }
            System.out.println();
        }
    }
}
