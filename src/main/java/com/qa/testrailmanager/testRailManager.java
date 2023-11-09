package com.qa.testrailmanager;

import com.gurock.testrail.APIClient;
import com.gurock.testrail.APIException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class testRailManager {

    public static String Test_Run_ID = "12";
    public static String Testrail_Username = "enter username";
    public static String Testrail_Password = "enter password";
    public static String Testrail_Engine_URL = "https://btechlabs.testrail.io";
    public static int Testrail_Pass_Status = 1;
    public static int Testrail_Fail_Status = 5;
    public static void addResultForTestCase(String testCaseID, int status, String error){

    String testRunID = Test_Run_ID;
        APIClient client = new APIClient(Testrail_Engine_URL);
        client.setUser(Testrail_Username);
        client.setPassword(Testrail_Password);

        Map<String, Object> data = new HashMap<String, Object>();
        data.put("status_id",status);
        data.put("comment", "This test case executed via test automation code" + error);

        try {
            client.sendPost("add_result_for_case/"+ testRunID+"/"+testCaseID,data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (APIException e) {
            throw new RuntimeException(e);
        }

    }
}
