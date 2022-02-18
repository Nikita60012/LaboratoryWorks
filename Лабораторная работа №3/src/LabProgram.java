public class LabProgram {
        public static void  main (String[] args){
            System.out.println("Таблица умножения от 1 до 10");
            for(int i = 1; i <= 10; i++){
                for(int j = 1; j <= 10; j++){
                    System.out.println(i+" x "+j+" = "+(i*j));
                }
            }
        }
}
