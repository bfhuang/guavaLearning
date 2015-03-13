package cache;


import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class CacheTest {

    public static final String KEY = "key";
    public static int i = 1;
    public static LoadingCache<String, String> cacheBuilder;
    private static String s;

    public static void main(String[] args) throws InterruptedException {

        cacheBuilder = CacheBuilder.newBuilder()
                .expireAfterWrite(2, TimeUnit.SECONDS)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key){
                        if (i > 1) {

                            throw new NullPointerException();
                        }
                        i++;
                        return "value";
                    }

                });

        try {
            test();
            sleep(3*1000);
            test();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static void test() throws ExecutionException {
        String s;
        try {
            s = cacheBuilder.get(KEY);
            System.out.println(s);
        }catch (Exception e){
            System.out.println("dkjf");
        }
    }


}
