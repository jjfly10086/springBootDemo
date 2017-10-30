import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2017/6/9 0009.
 *
 */
public class Test {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.submit(()->{
          connect(1);
        });
        executorService.submit(()->{
            connect(2);
        });
        executorService.submit(()->{
            connect(3);
        });
    }
    public static void connect(int name){
        try{
            while (true){
                System.out.print("Thread---"+name);
                URL url = new URL("http://192.168.17.148:8081/rest/2");
                URLConnection connection = url.openConnection();
                InputStream inputStream = connection.getInputStream();
                byte[] bytes = new byte[1024];
                int length = 0;
                if((length = inputStream.read(bytes)) > 0){
                    System.out.print(new String(bytes));
                }
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
