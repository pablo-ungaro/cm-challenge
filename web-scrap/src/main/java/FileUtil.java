import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileUtil {
    static void saveJson(String path, List<? extends Object> objs) throws IOException {
       new ObjectMapper().writeValue(new File(path),objs);
    }
}
