package com.inmobi.market.research;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.OutputBinding;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.BlobOutput;
import com.microsoft.azure.functions.annotation.Cardinality;
import com.microsoft.azure.functions.annotation.EventHubOutput;
import com.microsoft.azure.functions.annotation.EventHubTrigger;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import java.util.Optional;

/**
 * Azure Functions with HTTP Trigger.
 */
public class Function {

    //    @FunctionName("eventHubListener")
//    @CosmosDBOutput(name = "cosmosDatabaseOutput", databaseName = "ankitCache",
//            collectionName = "cache", connectionStringSetting = "COSMOS_DB_CONNECTION")
//    public String eventHubProcessor(
//            @EventHubTrigger(name = "event",
//                    eventHubName = "event-hub-poc",
//                    cardinality = Cardinality.ONE,
//                    connection = "EVENT_HUB_CONNECTION") Survey survey,
//            @CosmosDBInput(name = "cosmosDatabaseInput",
//                    databaseName = "ankitCache",
//                    collectionName = "cache",
//                    partitionKey = "surveyGuid",
//                    sqlQuery = "select * from cache rc where rc.id = {id}",
//                    connectionStringSetting = "COSMOS_DB_CONNECTION") Survey[] item,
//            final ExecutionContext context) {
//        context.getLogger().info("Message: " + survey.toString());
//
//        context.getLogger().info("Item: " + item);
//
//        if (item != null && item.length > 0) {
//            context.getLogger().info("Message Present: " + item[0].toString());
//            item[0].setCount(item[0].getCount() + 1);
//            return new Gson().toJson(item[0]);
//        } else {
//            context.getLogger().info("Message Not Present: ");
//            survey.setCount(1);
//            return new Gson().toJson(survey);
//        }
//    }
//
//    @FunctionName("eventHubSender")
//    @EventHubOutput(name = "event", eventHubName = "event-hub-recv", connection = "EVENT_HUB_CONNECTION")
//    public Survey[] eventHubSender(
//            @EventHubTrigger(name = "event",
//                    eventHubName = "event-hub-poc",
//                    cardinality = Cardinality.MANY,
//                    connection = "EVENT_HUB_CONNECTION") Survey[] survey,
//            final ExecutionContext context) {
//        context.getLogger().info("Message: " + survey.toString());
//
//        return survey;
//    }
//
//    private static final AtomicInteger ones = new AtomicInteger();
//
//    @FunctionName("cosmosDBHttpTrigger")
//    @CosmosDBOutput(name = "cosmosDatabaseOutput", databaseName = "ankitCache",
//            collectionName = "cache", connectionStringSetting = "COSMOS_DB_CONNECTION")
//    public String cosmosDBHttpTriggerFunc(@HttpTrigger(name = "req", methods = {HttpMethod.POST},
//            authLevel = AuthorizationLevel.ANONYMOUS) final HttpRequestMessage<Optional<Survey>> req,
//                                          @CosmosDBInput(name = "cosmosDatabaseInput",
//                                                  databaseName = "ankitCache",
//                                                  collectionName = "cache",
//                                                  partitionKey = "surveyGuid",
//                                                  sqlQuery = "select * from cache rc where rc.id = {id}",
//                                                  connectionStringSetting = "COSMOS_DB_CONNECTION") Survey[] item,
//                                          final ExecutionContext context) {
//
//        Survey survey = req.getBody().get();
//        context.getLogger().info("Message: " + survey.toString());
//
//        context.getLogger().info("Item: " + item);
//
//        ones.addAndGet(1);
//        context.getLogger().info("Counter: " + ones.toString() + " Thread: " + Thread.currentThread().getName());
//
//        if (item != null && item.length > 0) {
//            context.getLogger().info("Message Present: " + item[0].toString());
//            item[0].setCount(item[0].getCount() + 1);
//            return new Gson().toJson(item[0]);
//        } else {
//            context.getLogger().info("Message Not Present: ");
//            survey.setCount(1);
//            return new Gson().toJson(survey);
//        }
//
//    }
//
//    @FunctionName("eventHubListenerAPIM")
//    public void eventHubProcessor(
//            @EventHubTrigger(name = "event",
//                    eventHubName = "event-hub-recv",
//                    cardinality = Cardinality.ONE,
//                    connection = "EVENT_HUB_CONNECTION") Survey survey,
//            final ExecutionContext context) {
//        context.getLogger().info("Message: " + survey.toString());
//    }

//    @FunctionName("eventHubListenerAPIMHeaders")
//    public void eventHubProcessorHeaders(
//            @EventHubTrigger(name = "event",
//                    eventHubName = "event-hub-recv",
//                    cardinality = Cardinality.ONE,
//                    connection = "EVENT_HUB_CONNECTION") String string,
//            final ExecutionContext context) {
//        context.getLogger().info("Message: " + string);
//    }
//
//    @FunctionName("eventHubSenderBlobSender")
//    public void eventHubSender(
//            @HttpTrigger(name = "req", methods = {HttpMethod.POST},
//                    authLevel = AuthorizationLevel.ANONYMOUS) final HttpRequestMessage<Optional<Survey>> req,
//            @EventHubOutput(name = "eventHubSend", eventHubName = "event-hub-recv", connection = "EVENT_HUB_CONNECTION") OutputBinding<Survey> eventHubSurvey,
//            @BlobOutput(name = "copyToBlobName", path = "ankitblob/{datetime:yyyy}/{datetime:MM}/{datetime:dd}/{datetime:HH}/{datetime:mm}/{datetime:ss}/{id}/{datetime:fffffff}", connection = "STORAGE_CONN_STRING") OutputBinding<Survey> blobSurvey,
//            final ExecutionContext context) {
//        Survey survey = req.getBody().get();
//        context.getLogger().info("Message: " + survey.toString());
//
//        blobSurvey.setValue(survey);
//
//        eventHubSurvey.setValue(survey);
//    }
//
//    @FunctionName("eventHubListenerPulseAPIM")
//    public void eventHubProcessorPulse(
//            @EventHubTrigger(name = "eventPulse",
//                    eventHubName = "pulse-event-recv",
//                    cardinality = Cardinality.ONE,
//                    connection = "EVENT_HUB_CONNECTION") Survey survey,
//            final ExecutionContext context) {
//        context.getLogger().info("Pulse Message: " + survey.toString());
//    }

    @FunctionName("eventHubListenerCXAPIM")
    public void eventHubProcessorCX(
            @EventHubTrigger(name = "eventCX",
                    eventHubName = "cx-event-recv",
                    cardinality = Cardinality.ONE,
                    connection = "EVENT_HUB_CONNECTION") Survey survey,
            final ExecutionContext context) {
        context.getLogger().info("CX Message: " + survey.toString());
    }
}