package storage;

import java.util.List;

public interface GenerateData<T> {
    List<T> readFile();
    void writeFile(List<T> list);
}
