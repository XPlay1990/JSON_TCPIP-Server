/*
 *  Copyright (C) Jan Adamczyk (j_adamczyk@hotmail.com) 2017
 */
package Socket;

import JSON_Generation.File_Reader;
import JSON_Generation.DATA_FRAME.DataArray;
import JSON_Generation.DATA_FRAME.DataDescr;
import JSON_Generation.DATA_FRAME.Data_Frame;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
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

    private String hw_ResponseFile = "AQ_Join_GUI_Request.json";
    private String AQ_Join_ResponseFile = "AQ_join.json";
    private String data_File = "Data.json";

    private Data_Frame fromJson;
    private List<DataArray> dataArrays;
    private String json;
    private Gson gson;

//    private int i;
    private Boolean plusOrMinus = true;
    private int counter;

    private int NumberOfData = 1000;
    private int sendTimeMS = 20;

    Thread th1;

    public SocketHandler() {
        int port = 1337;
        try (ServerSocket serverSocket = new ServerSocket(port)) {

            System.out.println("Server is listening on port " + port);

            File_Reader fileReader = new File_Reader();
//            String read_File = fileReader.read_File(data_File);
//            gson = new GsonBuilder().create();
//            fromJson = gson.fromJson(read_File, Data_Frame.class);
//            dataArrays = fromJson.getData().getTargets().get(0).getTargetElement().getDataset().getDataArray();

            while (true) {
                Socket socket = serverSocket.accept();

                if (th1 != null) {
                    th1.interrupt();
                }
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
                        ArrayList<Integer> randomizeData = randomizeData();
//                       String trimmedString = json.replace("\n", "").replace("\r", "");
                        writer.println(randomizeData); //new Date().toString()
//                        System.out.println(randomizeData);
                        try {
                            Thread.sleep(sendTimeMS);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(SocketHandler.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                th1 = new Thread(r1);
                th1.start();
            }

        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
        }
    }

    public void startSending() {

    }

    private synchronized ArrayList<Integer> randomizeData() {
        Random rand = new Random();
        ArrayList<Integer> rndList = new ArrayList<>();

        for (int count = 0; count < NumberOfData; count++) {
            int n = (rand.nextInt(80)) - 40;
//            int n = (rand.nextInt(5));
//            int n = count + counter;
            rndList.add(n);
//            i++;
        }

        if (plusOrMinus) {
            counter++;
        } else {
            counter--;
        }

        if (counter == 100 || counter == -100) {
            plusOrMinus = !plusOrMinus;
        }

        return rndList;
    }
}
