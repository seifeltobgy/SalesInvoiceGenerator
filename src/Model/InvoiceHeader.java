package Model;
import java.util.ArrayList;
import java.util.Date;
public class InvoiceHeader {
    int InvoiceNum;
    Date InvoiceDate;
    String CustomerName;
    ArrayList<InvoiceLine> line = new ArrayList<InvoiceLine>();
}
