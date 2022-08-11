import java.util.ArrayList;
import java.util.List;

public class ErrorCheck {

    int total_value = 0;
    int error_value = 0;
    int success_value = 0;
    int List_size = 0;

    public List<Object> errorChecking ( List<List<String>> CSVLists){

        List_size = CSVLists.size();

        List<List<String>> CSVLists2 = CSVLists;

        //리턴을 할 때 필요한 리스트
        List<Object> returnList = new ArrayList<>();

        // String으로 받아온 에러값 걸러내기
        for (int i = 0; i < CSVLists2.size(); i ++){
            List<String> lawValue = CSVLists.get(i);

            try {

                for (String s : lawValue) {
                    int int_value = Integer.parseInt(s);
                }

            }catch (NumberFormatException e) {
                error_value ++;
                CSVLists2.remove(i);
            }

            }
        error_value = (error_value -1);
        total_value = (List_size-1);
        success_value = CSVLists2.size();

        //오브젝트 리스트에 넣기 (0:에러 라인 총 수, 1:에러가 아닌 라인 총 수, 2:전체 라인 수, 3:에러가 제거된 리스트)
        returnList.add(error_value);
        returnList.add(success_value);
        returnList.add(total_value);
        returnList.add(CSVLists2);

        return returnList;

    }

    }

