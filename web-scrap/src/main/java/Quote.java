import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Quote {
    private String author;
    private String text;
    private List<String> tags;
}
