package tiku.Tools;

public class 打印508条uuid {

    public static void main(String[] args) {

        for(int i=0;i<508;i++){

            System.out.println(" UNION all ");
            System.out.println("select UUID() as idd");

        }

    }

}
