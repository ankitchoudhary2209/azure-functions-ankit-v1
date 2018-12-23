package com.inmobi.market.research;

import com.google.gson.Gson;
import com.microsoft.azure.eventhubs.ConnectionStringBuilder;
import com.microsoft.azure.eventhubs.EventData;
import com.microsoft.azure.eventhubs.EventHubClient;
import com.microsoft.azure.eventhubs.EventHubException;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created By Ankit Choudhary on 05/12/18
 */
public class EventHubSender {

    public static void main(String[] args) throws IOException, EventHubException {

        final ExecutorService executorService = Executors.newFixedThreadPool(10);

        ExecutorService executorServiceSurvey1 = Executors.newFixedThreadPool(50);

        ExecutorService executorServiceSurveySender = Executors.newFixedThreadPool(7);

        final ConnectionStringBuilder connStr = new ConnectionStringBuilder()
                .setNamespaceName("event-hub-ankit-standard")
                .setEventHubName("event-hub-poc")
                .setSasKeyName("RootManageSharedAccessKey")
                .setSasKey("hKOsLud6iKRuULONrCKpK0hoNCzLs1oNu32XLjVHqU4=");

//        List<EventData> eventDataList = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            Survey survey = new Survey();
//            survey.setId("survey1");
//            survey.setDeviceId("device" + String.valueOf(i));
//            byte[] payloadBytes = new Gson().toJson(survey).getBytes(Charset.defaultCharset());
//            EventData sendEvent = EventData.create(payloadBytes);
//            eventDataList.add(sendEvent);
//        }

//        ehClient.sendSync(eventDataList, "survey1");

        for (int i = 1; i <= 20; i++) {
            executorServiceSurvey1.submit(() -> {
                System.out.println("Outside Thread: " + Thread.currentThread().getName());
//                Survey survey = new Survey();
//                survey.setId("survey1");
//                survey.setDeviceId("device1");

                for (int j = 1; j <= 10; j++) {
                    Survey survey = new Survey();
                    survey.setId("survey" + String.valueOf(j));
                    survey.setDeviceId("device" + String.valueOf(j));
                    byte[] payloadBytes = new Gson().toJson(survey).getBytes(Charset.defaultCharset());
                    EventData sendEvent = EventData.create(payloadBytes);

                    executorServiceSurveySender.submit(() -> {
                        System.out.println("Inside Thread: " + Thread.currentThread().getName());
                        try {
                            final EventHubClient ehClient = EventHubClient.createSync(connStr.toString(), executorService);
                            ehClient.sendSync(sendEvent, survey.getId());

                            ehClient.closeSync();
                        } catch (EventHubException | IOException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Sent/......");
                    });
                }

//                System.out.println("Sending:: " + survey1.toString());
//                byte[] payloadBytes = new Gson().toJson(survey).getBytes(Charset.defaultCharset());
//                EventData sendEvent = EventData.create(payloadBytes);
            });
        }
    }
}
