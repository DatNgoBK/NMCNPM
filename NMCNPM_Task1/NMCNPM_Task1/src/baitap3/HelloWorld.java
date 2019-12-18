package baitap3;
import javax.swing.JOptionPane;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class HelloWorld {

	public static void main(String[] args) {
		String result;
		result =JOptionPane.showInputDialog("Hãy nhập tên bạn");
		JOptionPane.showMessageDialog(null,"Xin chào "+ result+ "!");
		result =JOptionPane.showInputDialog("Hãy nhập ngày sinh của bạn: ");
        
        try {
            
            int age = 0;
            int factor = 0;

            Calendar cal1 = new GregorianCalendar();
            Calendar cal2 = new GregorianCalendar();
            
            Date date1 = new SimpleDateFormat("MM-dd-yyyy").parse(result);
            Date date2 = new Date();
            
            cal1.setTime(date1);
            cal2.setTime(date2);
            
            if (cal2.get(Calendar.DAY_OF_YEAR) < cal1.get(Calendar.DAY_OF_YEAR)) {
                factor = -1;
            }
            
            age = cal2.get(Calendar.YEAR) - cal1.get(Calendar.YEAR) + factor;
            
            JOptionPane.showMessageDialog(null,"Tuổi của bạn là: "+ age+ "!");
            
        } catch (ParseException e) {
            System.out.println(e);
            
        }

	}

}
