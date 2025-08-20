import java.util.Collections;

public class YahtzeeProcedural {

    public static int lancerDe (){
        return (int) (Math.random() * 6 + 1);
    }

    public static int[] lancer5Des(int[] mesDes){
        for (int i = 0; i < mesDes.length; i++) {
            int des = lancerDe();
            mesDes[i] = des;
        }
        return mesDes;
    }

    public static void afficherDes(int[] mesDes){
        for (int i = 0; i < mesDes.length; i++) {
            System.out.print("[" + (i + 1) + "]" + mesDes[i] + "\t");
        }
    }

    public static void main(String[] args) {
        int[] mesDes = new int[5];
        lancer5Des(mesDes);
        afficherDes(mesDes);
    }
}
