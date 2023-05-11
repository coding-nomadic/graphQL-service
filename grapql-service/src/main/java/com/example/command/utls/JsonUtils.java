
package com.example.command.utls;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * 
 * Util to convert JSON string and vice versa.
 *
 */
public class JsonUtils {
    private JsonUtils() {
    }

    /**
     *
     * @param objectToConvert
     * @return
     * @throws IOException
     */
    public static String toString(Object objectToConvert) throws IOException {
        return new ObjectMapper().setSerializationInclusion(Include.NON_NULL).writeValueAsString(objectToConvert);
    }

    /**
     *
     * @param jsonString
     * @param type
     * @return
     * @param <T>
     * @throws IOException
     */
    public static <T> T convertFromObject(String jsonString, Class<T> type) throws IOException {
        return new ObjectMapper().readValue(jsonString, type);
    }
}
