package asv.helloserv;

import spark.Request;
import spark.Response;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

import static spark.Spark.*;

public class WebServer {
    private static String getReq(Request req, Response res) {
        Map<String, String[]> queryMap = req.queryMap().toMap();
        String requestString = queryMap.keySet().stream()
                .map(key -> key + "=" + Arrays.toString(queryMap.get(key)))
                .collect(Collectors.joining("\n"));
        return String.format(
                "Successfully processed dummy request with parameters %s, \n ENV_VARS value=%s",
                requestString,
                System.getenv("SERVER_PARAMETER"));
    }

    public static void main(String[] args) {
        port(4567);
        get("/hello", (req, res) -> getReq(req, res));
    }
}

