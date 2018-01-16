import android.util.Slog;
import android.os.ServiceManager;
import android.os.IBinder;


public class TestClient {

    private static final String TAG = "TestClient";

    public static void main(String args[])
    {

        if(args.length == 0) {
            System.out.println("Usage: need parameter:<hello|goodbye> [name]");
        }

        if(args[0].equals("hello")) {
            IBinder binder = ServiceManager.getService("hello");
            if(null == binder) {
                System.out.println("fail to get hello service");
                return;
            }

            IHelloService svc = IHelloService.Stub.asInterface(binder);

            if(args.length == 1) {

                try {
                    svc.sayhello();
                }catch (Exception e) {

                }
            }else {
                try{
                    int cnt = svc.sayhello_to(args[1]);
                    Slog.i(TAG, "say hello to "+args[1]+" return "+cnt);
                }catch (Exception e) {
                    Slog.e(TAG, "say hello to err"+e);
                }
            }
        }
        else if(args[0].equals("goodbye")) {
            IBinder binder = ServiceManager.getService("goodbye");
            if(null == binder) {
                System.out.println("fail to get goodbye service");
                return;
            }

            IGoodbyeService svc = IGoodbyeService.Stub.asInterface(binder);

            if(args.length == 1) {

                try {
                    svc.saygoodbye();
                }catch (Exception e) {

                }
            }else {
                try{
                    int cnt = svc.saygoodbye_to(args[1]);
                    Slog.i(TAG, "say goodbye to "+args[1]+" return "+cnt);
                }catch (Exception e) {
                    Slog.e(TAG, "say goodbye to err"+e);
                }
            }
        }
    }

}

