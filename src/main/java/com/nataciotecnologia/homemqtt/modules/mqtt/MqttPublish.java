package com.nataciotecnologia.homemqtt.modules.mqtt;

import com.nataciotecnologia.homemqtt.modules.mqtt.device.DeviceDTO.DeviceDto;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class MqttPublish {


    private static int qos = 2;
    private static String broker = "tcp://localhost:1883";
    private static String clientId = "JavaSampleTeste";
    private static MemoryPersistence persistence = new MemoryPersistence();


    public int getQos() {
        return qos;
    }

    public void setQos(int qos) {
        this.qos = qos;
    }

    public String getBroker() {
        return broker;
    }

    public void setBroker(String broker) {
        this.broker = broker;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public MemoryPersistence getPersistence() {
        return persistence;
    }

    public void setPersistence(MemoryPersistence persistence) {
        this.persistence = persistence;
    }

    public static void publishMenssage(DeviceDto device){
        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: "+broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: "+ device.getAction());
            MqttMessage message = new MqttMessage(device.getAction().getBytes());
            message.setQos(qos);
            sampleClient.publish(device.getTopic(), message);
            System.out.println("Message published");
            sampleClient.disconnect();
            System.out.println("Disconnected");

        } catch(
                MqttException me) {
            System.out.println("reason "+me.getReasonCode());
            System.out.println("msg "+me.getMessage());
            System.out.println("loc "+me.getLocalizedMessage());
            System.out.println("cause "+me.getCause());
            System.out.println("excep "+me);
            me.printStackTrace();
        }
    }
}
