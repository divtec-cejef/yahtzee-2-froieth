import java.util.Collections;

public class YahtzeeProcedural {

    public class lancerDes  {

        public int lancerDe (){
            return (int) (Math.random() * 6 + 1);
        }

        public int[] lancer5Des(int[] mesDes){
            for (int i = 0; i < mesDes.length; i++) {
                int des = lancerDe();
                mesDes[i] = des;
            }
            return mesDes;
        }

        public void afficherDes(int[] mesDes){
            for (int i = 0; i < mesDes.length; i++) {
                System.out.println("[" + (i + 1) + "]" + mesDes[i] + "\t");
            }
        }

    }

    public static void main(String[] args) {



    }

}
