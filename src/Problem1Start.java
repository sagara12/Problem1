import java.util.List;
import java.util.Scanner;



public class Problem1Start {

    public static void main(String[] args) {

        ReadCSVFile readCSVFile = new ReadCSVFile();
        //CSV 파일 가져오기
        List<List<String>> CSVLists = readCSVFile.readCSV();
        ErrorCheck errorCheck = new ErrorCheck();

        //에러가 제거 된 값 가져오기( 0:에러가 난 라인 수, 1:에러가 나지 않은 라인 수, 2:총 라인 수, 3:에러가 제거된 리스트(스트링))
        List<Object> checkList = errorCheck.errorChecking(CSVLists);

        List<List<String>> CheckList = (List<List<String>>) checkList.get(3);
        CalculateValue cv = new CalculateValue();
        List<List<Object>> lists = cv.calculateValue(CheckList);
        //배열 프린트
        for (int i = 0; i < lists.size(); i++) {
            List<Object> valueList = lists.get(i);
            for (int j = 0; j < valueList.size(); j++) {
                System.out.print(" " + valueList.get(j));
            }
            System.out.println(" ");
        }

        System.out.println(" -------------------------------------------------- ");
        //라인 토탈값 출력
        System.out.println("The total number of lines: " + checkList.get(2));
        System.out.println("The calculated lines: " + checkList.get(1));
        System.out.println("The error values: " + checkList.get(0));



        System.out.println("  ");
        System.out.println("  ");
        System.out.println("종료하려면 exit를 입력 하세요");
        Scanner input = new Scanner(System.in);
        String esc = String.valueOf(input.hasNextLine());




        if (esc.equals("exit")) {
            System.exit(0);
        }

    }
}
