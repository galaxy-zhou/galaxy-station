package org.galaxy.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JSONUtils {
    @Autowired
    private ObjectMapper objectMapper;

    /**
     * 返回T对象
     * @param json
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T json2Bean(String json,Class<T> clazz){
        try {
            return objectMapper.readValue(json,clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 返回JSON类型的String
     * @param obj
     * @return
     */
    public String toJSONString(Object obj){
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
