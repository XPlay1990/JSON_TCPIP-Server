/*
 *  Copyright (C) Jan Adamczyk (j_adamczyk@hotmail.com) 2017
 */
package Socket;

import JSON_Generation.File_Reader;
import JSON_Generation.PASSAT_DATA_FRAME.DataArray;
import JSON_Generation.PASSAT_DATA_FRAME.DataDescr;
import JSON_Generation.PASSAT_DATA_FRAME.Passat_Data_Frame;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jan.adamczyk
 */
public class SocketHandler {

    private String hw_ResponseFile = "PASSAT_AQ_Join_GUI_Request.json";
    private String AQ_Join_ResponseFile = "PASSAT_AQ_join.json";
    private String data_File = "PASSAT_Data.json";

    private Passat_Data_Frame fromJson;
    private List<DataArray> dataArrays;
    private String json;
    private Gson gson;

    private int i;

    public SocketHandler() {
        int port = 1337;
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server is listening on port " + port);

            File_Reader fileReader = new File_Reader();
            String read_File = fileReader.read_File(data_File);
            gson = new GsonBuilder().create();
            fromJson = gson.fromJson(read_File, Passat_Data_Frame.class);
            dataArrays = fromJson.getData().getTargets().get(0).getTargetElement().getDataset().getDataArray();

            while (true) {
                Socket socket = serverSocket.accept();

                System.out.println("New client connected");

                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

//                String input;
//                while ((input = reader.readLine()) != null) {
////                    startFrameHandler(input);
//                    System.out.println(input);
//                }
                Runnable r1 = () -> {
                    while (true) {
                        randomizeData();
                        String trimmedString = json.replace("\n", "").replace("\r", "");
                        writer.println(trimmedString); //new Date().toString()
                        try {
                            Thread.sleep(30);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SocketHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                Thread th1 = new Thread(r1);
                th1.start();
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
        }
    }

    public void startSending() {

    }

    private synchronized void randomizeData() {
        dataArrays.clear();
        Random rand = new Random();

        for (int count = 0; count < 60; count++) {
            DataArray dataArray = new DataArray();
            DataDescr dataDescr = new DataDescr();
//            int n = i;
            int n = (rand.nextInt(80)) - 40;
            dataDescr.setDataValue(n);
            dataArray.setDataDescr(dataDescr);
            dataArrays.add(dataArray);
            i++;
        }

        json = gson.toJson(fromJson);
//        System.out.println(dataArrays);
    }
}
