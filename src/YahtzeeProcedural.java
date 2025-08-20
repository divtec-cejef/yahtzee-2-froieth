public class YahtzeeProcedural {

    public static void main(String[] args) {


        int[] mesDes = new int[5];

        for (int i = 0; i < mesDes.length; i++) {
            int des = (int) (Math.random() * 6 + 1);
            mesDes[i] = des;
        }



        for (int i = 0; i < mesDes.length; i++) {
            System.out.println(i + 1 + "\t" + mesDes[i]);
        }


    }
}
