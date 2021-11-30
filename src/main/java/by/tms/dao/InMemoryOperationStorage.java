package by.tms.dao;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class InMemoryOperationStorage {
    private final Map<String, List<String>> historyList;

    public InMemoryOperationStorage(Map<String, List<String>> historyList) {
        this.historyList = historyList;
    }

    public void addOperation(String k, String operation){
        List<String> temp = historyList.get(k);
        if(temp==null){
            temp=new ArrayList<>();
            temp.add(operation);
            historyList.put(k,temp);
        }else {
            historyList.get(k).add(operation);
        }
    }

    public List<String>getAllHistory(String k){
        return historyList.get(k);
    }

    public void deleteHistory(String k){
        historyList.remove(k);
    }
}
