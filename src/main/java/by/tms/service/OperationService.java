package by.tms.service;

import by.tms.dao.InMemoryOperationStorage;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OperationService {
    private final InMemoryOperationStorage operationStorage;

    public OperationService(InMemoryOperationStorage operationStorage) {
        this.operationStorage = operationStorage;
    }

    public void addOperation(String k, String operation){
        operationStorage.addOperation(k, operation);
    }

    public List<String> getAllHistory(String k){
        return operationStorage.getAllHistory(k);
    }

    public void deleteHistory(String k) {
        operationStorage.deleteHistory(k);
    }
}
