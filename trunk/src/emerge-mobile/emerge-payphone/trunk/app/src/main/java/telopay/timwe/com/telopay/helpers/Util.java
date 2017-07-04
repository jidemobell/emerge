package telopay.timwe.com.telopay.helpers;

import java.io.IOException;

import okhttp3.RequestBody;
import okio.Buffer;

/**
 * Created by timwe.tunji on 11/2/2016.
 */
public class Util {

    public static String getRequestString(final RequestBody request) {
        try {
            final RequestBody copy = request;
            final Buffer buffer = new Buffer();
            if (copy != null)
                copy.writeTo(buffer);
            else
                return "";
            return buffer.readUtf8();
        } catch (final IOException e) {
            return "did not work";
        }
    }
}
