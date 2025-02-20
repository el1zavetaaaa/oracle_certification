package sandbox;

public class Sandbox {
    public static void main(String[] args) {
        int c  =0;
        for(var i=0; i<2; i++){
            for (var j =0; j<2; j++){
                for (var k=0; k<3; k++){
                    c++;
                    if(k>j) break;
                }
            }
        }


        System.out.println(c);

    }
}
