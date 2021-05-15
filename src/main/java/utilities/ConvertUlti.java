package utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ConvertUlti {

    private ConvertUlti (){}

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T convertJsonFileToObject(String filePath, Class<T> clazz) throws IOException {
        return mapper.readValue(new File(filePath), clazz);
    }
}

