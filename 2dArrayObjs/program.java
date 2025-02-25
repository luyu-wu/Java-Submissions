public class program {

    public static void main(String[] args) {
        Student[][] stuObjs = new Student[10][10];

        for (int i = 0; i < stuObjs.length; i++) {
            for (int j = 0; j < stuObjs[i].length; j++) {
                stuObjs[i][j] = new Student(
                    "Luyu",
                    (int) (Math.random() * 100 + 1)
                );
            }
        }

        for (int i = 0; i < stuObjs.length; i++) {
            for (int j = 0; j < stuObjs[i].length; j++) {
                Student local = stuObjs[i][j];

                System.out.println(local.getName() + " " + local.getMark());
            }
        }
    }
}
