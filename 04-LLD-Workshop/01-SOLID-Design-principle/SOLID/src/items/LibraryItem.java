package items;

public interface LibraryItem {

    String getTitle();

    String getUniqueId();

    int calculateFee(int days);

    double getValue();
}
