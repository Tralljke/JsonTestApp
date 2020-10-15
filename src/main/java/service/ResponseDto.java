package service;

import model.Customer;

import java.util.List;
import java.util.Map;

public class ResponseDto {
    private List<Customer> resultList;
    private Map<String,String> criteriars;

    public ResponseDto(){

    };
    public ResponseDto(Map<String, String> criteriars) {
        this.criteriars = criteriars;
    }

    public ResponseDto(List<Customer> resultList, Map<String, String> criteriars) {
        this.resultList = resultList;
        this.criteriars = criteriars;
    }

    public List<Customer> getResultList() {
        return resultList;
    }

    public void setResultList(List<Customer> resultList) {
        this.resultList = resultList;
    }

    @Override
    public String toString() {
        return "ResponseDto{" +
                "resultList=" + resultList +
                ", criteriars=" + criteriars +
                '}';
    }

    public Map<String, String> getCriteriars() {
        return criteriars;
    }

    public void setCriteriars(Map<String, String> criteriars) {
        this.criteriars = criteriars;
    }
}
