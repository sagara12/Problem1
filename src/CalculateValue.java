import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

public class CalculateValue {

    public List<List<Object>> calculateValue (List<List<String>> checkList) {

        List<List<Object>> resultList = new ArrayList<>();
        
        for (int i = 0; i < checkList.size(); i ++) {

            IntSummaryStatistics statistics = checkList.get(i)
                    .stream()
                    .mapToInt(num -> Integer.parseInt(num))
                    .summaryStatistics();

            //최소값
            int min = statistics.getMin();
            //최대값
            int max = statistics.getMax();
            //합계
            Long sumNum = statistics.getSum();
            //평균
            double average = statistics.getAverage();
            //분산(x)
            double var = (double)sumNum / checkList.get(i).size();
            //표준편차
            double sd = Math.sqrt(var);
            //중간 값
            int mid = (max-min)/2;

            List<Object> calList = new ArrayList<>();
            calList.add(min);
            calList.add(max);
            calList.add(sumNum);
            calList.add(average);
            calList.add(sd);
            calList.add(mid);
            resultList.add(calList);
        }
        return resultList;
    }
}
